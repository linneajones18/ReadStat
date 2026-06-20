package com.readstat.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.readstat.model.DBConnection;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the genre database and translates data into an understandable java form
 * Revision Date: 6/20/2026
 */

public class GenreDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // returns all genres in the database
    public ArrayList<String> getAllGenres() {
        ArrayList<String> genres = new ArrayList<>();
        String query = "SELECT genre_name FROM genre;";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                genres.add(results.getString("genre_name"));
            }
        } catch(SQLException e) { System.out.println("Failed to get all genres"); e.printStackTrace(); }
        return genres;
    }

    // returns all genres of a given book
    public ArrayList<String> getGenresByBookID(int ID) {
        ArrayList<String> genres = new ArrayList<>();
        String query = "SELECT name FROM genre LEFT JOIN book_to_genre ON genre.id = genre_id WHERE book_id = " + ID + ";";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                genres.add(results.getString("name"));
            }
        } catch(SQLException e) { System.out.println("Failed to get genres by book ID"); }

        return genres;
    }

    // TODO: upgrade to better map the genres because GBAPI genres are extremely all over the place
    public ArrayList<String> parseGenres(ArrayList<String> genres) {
        int size = genres.size();
        ArrayList<String> valid_genres = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String cur_genre = genres.get(i).trim();

            // check if in DB
            String query = "SELECT genre_name, COUNT(*) AS count FROM genre WHERE LOWER(genre_name) = LOWER(\"" + cur_genre + "\") GROUP BY genre_name;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery(query);
                if((resultSet.next()) && (resultSet.getInt("count") == 1)) {
                    // if in DB, add to valid genres
                    valid_genres.add(resultSet.getString("genre_name"));
                }
            } catch(SQLException e) { System.out.println("Failed to parse for genre."); e.printStackTrace(); }
        }

        return valid_genres;
    }

    public ArrayList<String> getGenresByBookID(String id) {
        String query = "SELECT genre_name FROM book RIGHT JOIN book_to_genre ON book.book_id = book_to_genre.book_id WHERE book.book_id = '" + id + "'';";
        ArrayList<String> genres = new ArrayList<>();
        try(PreparedStatement preparedAuthorStatement = con.prepareStatement(query)) {
            ResultSet results = preparedAuthorStatement.executeQuery();
            while(results.next()) {
                genres.add(results.getString("genre_name"));
            }
        } catch(SQLException e) { System.out.println("Failed to access genres of book"); e.printStackTrace(); }

        return genres;
    }
}