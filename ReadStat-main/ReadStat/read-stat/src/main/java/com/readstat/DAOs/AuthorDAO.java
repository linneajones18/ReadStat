package com.readstat.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.readstat.model.DBConnection;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the author and book_to_author databases and translates data into an understandable java form
 * Revision Date: 06/18/2026
 */

public class AuthorDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // returns -1 if author does not exist in DB, otherwise returns ID of author with name
    public int getAuthorID(String name) {
        name = name.replace("\"", "''");
        String query = "SELECT author_id FROM author WHERE name = \"" + name + "\";";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            if(results.next())  { return results.getInt("author_id"); }
        } catch(SQLException e) {System.out.println("Failed to check if author exists in DB"); e.printStackTrace(); System.exit(-1); }
    
        return -1;
    }

    public int addAuthorToDB(String name) {
        //check if it's already in the DB
        int id = getAuthorID(name);

        // add it
        if(id == -1) {

            // add the author to DB
            name = name.replace("\"", "''");
            String query = "INSERT INTO author (name) VALUES (\"" + name + "\");";
            try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
                int rows_affected = preparedStatement.executeUpdate();
                if(rows_affected != 1) { return -1; }
            } catch( SQLException e ) { System.out.println("Failed to add author: " + name + " to DB."); e.printStackTrace(); System.exit(-1); return -1; }
        
            // get the new author's id
            query = "SELECT author_id FROM author ORDER BY author_id DESC LIMIT 1;";
            try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
                ResultSet results = preparedStatement.executeQuery();
                results.next();
                id = results.getInt("author_id");
            } catch( SQLException e ) { System.out.println("Failed to get author's id."); e.printStackTrace(); System.exit(-1); return -1; }
        }

        return id;
    }

    public boolean addAuthorBookRelationship(int book_id, int author_id) {
        String query = "INSERT INTO author_to_book (author_id, book_id) VALUES (" + author_id + ", " + book_id + ");";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected != 1) { return false; }
        } catch(SQLException e) { System.out.println("Failed to add author book relationship."); e.printStackTrace(); System.exit(-1); return false;}

        return true;
    }
}
