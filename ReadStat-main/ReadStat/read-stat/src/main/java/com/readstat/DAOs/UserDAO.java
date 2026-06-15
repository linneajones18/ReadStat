package com.readstat.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.readstat.POJOs.*;
import com.readstat.model.DBConnection;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the User and user_to_books_read databases and translates data into an understandable java form
 * Revision Date: 06/15/2026
 */

public class UserDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // verifies whether input login info matches the database records
    public boolean verifyLogin(String username, String password) {
        String query = "SELECT COUNT(*) FROM user_ WHERE username = '" + username + "'" + "AND password = '" + password + "';";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()) {
                int count = res.getInt("COUNT(*)");
                if(count == 0) { return false; }
                else if(count == 1) { return true; }
                else { throw new SQLException("Error: multiple users have identical login information."); }
            }
        } catch(SQLException e) { System.out.println("Problem creating new user."); }

        return false;
    }

    // creates a new user and writes it to the database
    public boolean createUser(String username, String password) {
        String query = "INSERT INTO user_ (username, password) VALUES ('" + username + "', '" + password + "');";

        try(PreparedStatement preparedStatement = con.prepareStatement(query);) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected == 1) { return true; }
        } catch(SQLException e) { System.out.println("Problem creating user"); }

        return false;
    }

    // checks if book is marked as currently reading and returns session id, returns -1 if not
    public int isCurReading(int id) {
        String check_Reading = "SELECT session_id FROM reading_session WHERE username = '" + User.getUser().getUsername() + "' AND book_id = " + id + " AND date_finished IS NULL;";

        try(PreparedStatement preparedStatement = con.prepareStatement(check_Reading)) {
            ResultSet results = preparedStatement.executeQuery();
            if(results.next()) {
                return results.getInt("session_id");
            }
        } catch(SQLException e) { System.out.println("Error getting read genres."); }

        return -1;
    }

    // marks a book as currently reading by creating a reading_session row with a start time but no end time in the DB
    public boolean markBookAsCurReading(int id) {

        if(isCurReading(id) != -1) { return false; }

        String query = "INSERT INTO reading_session (username, book_id, date_started) VALUES (" + User.getUser().getUsername() + ", " + id + ", CURRENT_TIMESTAMP;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected == 1) { return true; }
        } catch(SQLException e) { System.out.println("Failed to mark book as currently reading.");}

        return false;
    }

    public boolean markBookAsRead(int id) {

        int session_id = isCurReading(id);

        if(session_id != -1) {
            // update existing session record to finished reading
            String finished_reading = "UPDATE reading_session SET date_finished = CURRENT_TIMESTAMP WHERE session_id = " + session_id + ";";
            try(PreparedStatement preparedStatement = con.prepareStatement(finished_reading);) {
                int rows_affected = preparedStatement.executeUpdate();
                if(rows_affected == 1) { return true; }
            } catch(SQLException e) { System.out.println("Failed to change book status from currently reading to read.");}
        }

        else {
            // create new record marked as finished
            String mark_read = "INSERT INTO reading_session (username, book_id, date_finished) VALUES ('" + User.getUser().getUsername() + "', " + id + ", CURRENT_TIMESTAMP);";
            try(PreparedStatement preparedStatement = con.prepareStatement(mark_read);) {
                int rows_affected = preparedStatement.executeUpdate();
                if(rows_affected == 1) { return true; }
            } catch(SQLException e) { System.out.println("Failed to mark book as read.");}
        }

        return false;
    }

    // marks a book as unread by the user by removing every read record from the databse
    public boolean unTrackBookByID(int id) {
        String query = "DELETE FROM reading_session WHERE username = '" + User.getUser().getUsername() + "' AND book_id = " + id + ";";

        try(PreparedStatement preparedStatement = con.prepareStatement(query);) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected != 0) { return true; }
        } catch(SQLException e) { System.out.println("Error marking book as unread."); }

        return false;
    }

    // verifies whether a record exists in the database of the user reading a given book by id
    public boolean userHasReadBook(int book_id) {
        String query = "SELECT COUNT(*) AS count FROM reading_session WHERE username = '" + User.getUser().getUsername() + "' AND book_id = " + book_id + ";";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            results.next();
            if(results.getInt("count") != 0)  { return true; }
        } catch(SQLException e) { System.out.println("Error checking if user has read book."); }

        return false;
    }

    // gets the number of books the user has read within a given page range from the database
    public int getReadCountByPageNumber(int min, int max) {
        String query = "SELECT COUNT(*) FROM reading_session JOIN book ON book.book_id = reading_session.book_id WHERE username = '" + User.getUser().getUsername() + "' AND pages BETWEEN " + min + " AND " + max + ";";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()) { return res.getInt("COUNT(*)"); }
        } catch(SQLException e) { System.out.println("Error querying page number counts."); }

        return -1;
    }

    // definitely need to check this SQL query
    // returns the 5 authors the user has read the most of, and how many books per author
    public ArrayList<AuthorRecord> getTopAuthors() {
        ArrayList<AuthorRecord> authors = new ArrayList<>();
        String query = "SELECT COUNT(*) AS count, author.name FROM reading_session LEFT JOIN book ON reading_session.book_id = book.book_id LEFT JOIN author_to_book ON author_to_book.book_id = book.book_id LEFT JOIN author ON author_to_book.author_id = author.author_id WHERE username = '" + User.getUser().getUsername() + "' GROUP BY author.name ORDER BY count DESC LIMIT 5;";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                authors.add(new AuthorRecord(results.getString("author.name"), results.getInt("count")));
            }
        } catch(SQLException e) { System.out.println("Error querying top authors."); e.printStackTrace(); }

        return authors;
    }

    // returns the genres the user has read, and the quantity of books per genre
    public ArrayList<GenreRecord> getCommonGenres() {
        String query = "SELECT name, COUNT(*) AS count FROM reading_session LEFT JOIN book ON reading_session.book_id = book.book_id RIGHT JOIN book_to_genre ON book_to_genre.book_id = book.book_id LEFT JOIN genre ON book_to_genre.genre_id = genre.genre_id WHERE username = '" + User.getUser().getUsername() + "' GROUP BY name;";
        ArrayList<GenreRecord> genres = new ArrayList<>();
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                genres.add(new GenreRecord(results.getString("name"), results.getInt("count")));
            }
        } catch(SQLException e) { System.out.println("Error getting read genres."); }

        return genres;
    }
}