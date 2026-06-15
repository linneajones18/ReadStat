package com.readstat.DAOs;

import com.readstat.POJOs.Book;
import com.readstat.model.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the book and book_to_genre database and translates data into an understandable java form
 * Revision Date: 06/14/2026
 */

public class BookDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // gets all books from the database in an array
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT id, title, author, pages, description FROM book;";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                books.add(new Book(results.getInt("id"), results.getString("title"), results.getString("author"), results.getInt("pages"), results.getString("description")));
            }
        } catch(SQLException e) { System.out.println("Failed to access books"); }

        return books;
    }

    // gets all books by a specific genre in the database in an array
    public ArrayList<Book> getBooksByGenre(String genre) {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT book.id, title, author, pages, description FROM book RIGHT JOIN book_to_genre ON book.id = book_id LEFT JOIN genre ON genre.id = genre_id WHERE name = '" + genre + "';";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                books.add(new Book(results.getInt("id"), results.getString("title"), results.getString("author"), results.getInt("pages"), results.getString("description")));
            }
        } catch(SQLException e) { System.out.println("Failed to get books by genre"); }

        return books;
    }

    // gets one book by a given id from the database
    public Book getBookByID(int id) {
        String query = "SELECT * FROM book WHERE id = " + id + ";";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            if(results.next()) {
                return new Book(results.getInt("id"), results.getString("title"), results.getString("author"), results.getInt("pages"), results.getString("description"));
            }        
        } catch(SQLException e) { System.out.println("Failed to get book by genre"); }

        return null;
    }
}