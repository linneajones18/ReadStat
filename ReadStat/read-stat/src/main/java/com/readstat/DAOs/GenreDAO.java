package com.readstat.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.readstat.model.DBConnection;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Communicates with the genre database and translates data into an understandable java form
 * Revision Date: 7/15/2025
 */

public class GenreDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // returns all genres in the database
    public ArrayList<String> getAllGenres() {
        ArrayList<String> genres = new ArrayList<>();
        String query = "SELECT name FROM genre;";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                genres.add(results.getString("name"));
            }
        } catch(SQLException e) { System.out.println("Failed to connect to MySQL database"); }

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
        } catch(SQLException e) { System.out.println("Failed to connect to MySQL database"); }

        return genres;
    }
}