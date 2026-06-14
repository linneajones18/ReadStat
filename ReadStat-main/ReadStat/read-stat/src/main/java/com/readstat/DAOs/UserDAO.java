package com.readstat.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.readstat.POJOs.*;
import com.readstat.model.DBConnection;
import com.readstat.records.*;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Communicates with the User and user_to_books_read databases and translates data into an understandable java form
 * Revision Date: 7/23/2025
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

    // marks a book as read by the user by writing it to the database
    public boolean trackBookByID(int id) {
        String query = "INSERT INTO user_to_books_read (user_id, book_id) VALUES ('" + User.getUser().getUsername() + "', " + id + ");";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query);) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected == 1) { return true; }
        } catch(SQLException e) { System.out.println("Problem marking book as read."); }

        return false;
    }

    // marks a book as unread by the user by removing the read record from the databse
    public boolean unTrackBookByID(int id) {
        String query = "DELETE FROM user_to_books_read WHERE user_id = '" + User.getUser().getUsername() + "' AND book_id = " + id + ";";

        try(PreparedStatement preparedStatement = con.prepareStatement(query);) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected != 0) { return true; }
        } catch(SQLException e) { System.out.println("Error marking book as unread."); }

        return false;
    }

    // verifies whether a record exists in the database of the user reading a given book by id
    public boolean userHasReadBook(int book_id) {
        String query = "SELECT COUNT(*) AS count FROM user_to_books_read WHERE user_id = '" + User.getUser().getUsername() + "' AND book_id = " + book_id + ";";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            results.next();
            if(results.getInt("count") != 0)  { return true; }
        } catch(SQLException e) { System.out.println("Error checking if user has read book."); }

        return false;
    }

    // gets the number of books the user has read within a given page range from the database
    public int getReadCountByPageNumber(int min, int max) {
        String query = "SELECT COUNT(*) FROM user_to_books_read JOIN book ON book_id = book.id WHERE user_id = '" + User.getUser().getUsername() + "' AND pages BETWEEN " + min + " AND " + max + ";";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()) { return res.getInt("COUNT(*)"); }
        } catch(SQLException e) { System.out.println("Error querying page number counts."); }

        return -1;
    }

    // returns the 5 authors the user has read the most of, and how many books per author
    public ArrayList<AuthorRecord> getTopAuthors() {
        ArrayList<AuthorRecord> authors = new ArrayList<>();
        String query = "SELECT COUNT(*) AS count, author FROM user_to_books_read JOIN book ON book_id = book.id WHERE user_id = '" + User.getUser().getUsername() + "' GROUP BY author ORDER BY count DESC LIMIT 5;";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                authors.add(new AuthorRecord(results.getString("author"), results.getInt("count")));
            }
        } catch(SQLException e) { System.out.println("Error querying top authors."); }

        return authors;
    }

    // returns the genres the user has read, and the quantity of books per genre
    public ArrayList<GenreRecord> getCommonGenres() {
        String query = "SELECT name, COUNT(*) AS count FROM user_to_books_read JOIN book ON user_to_books_read.book_id = book.id RIGHT JOIN book_to_genre ON book_to_genre.book_id = book.id LEFT JOIN genre ON genre_id = genre.id WHERE user_id = '" + User.getUser().getUsername() + "' GROUP BY name;";
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