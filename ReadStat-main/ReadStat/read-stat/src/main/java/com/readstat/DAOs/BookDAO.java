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
 * Revision Date: 06/17/2026
 */

public class BookDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    // gets all books from the database in an array
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT book_id, title, pages, description FROM book;";

        try(PreparedStatement preparedBookStatement = con.prepareStatement(query)) {
            ResultSet results = preparedBookStatement.executeQuery();
            while(results.next()) {
                int id = results.getInt("book_id");
                
                books.add(new Book(id, results.getString("title"), results.getInt("pages"), results.getString("description"), getAuthorsByBookID(id)));
            }
        } catch(SQLException e) { System.out.println("Failed to access books"); }

        return books;
    }

    public ArrayList<String> getAuthorsByBookID(int id) {
        String author_query = "SELECT author.author_id, name FROM author RIGHT JOIN author_to_book ON author.author_id = author_to_book.author_id WHERE book_id = " + id + ";";
        ArrayList<String> authors = new ArrayList<>();
        try(PreparedStatement preparedAuthorStatement = con.prepareStatement(author_query)) {
            ResultSet results = preparedAuthorStatement.executeQuery();
            while(results.next()) {
                authors.add(results.getString("name"));
            }
        } catch(SQLException e) { System.out.println("Failed to access authors of books"); }

        return authors;
    }

    // gets all books by a specific genre in the database in an array
    public ArrayList<Book> getBooksByGenre(String genre) {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT book.book_id, title, pages, description FROM book RIGHT JOIN book_to_genre ON book.book_id = book_id LEFT JOIN genre ON genre.id = genre_id WHERE name = '" + genre + "';";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                int id = results.getInt("book_id");
                books.add(new Book(id, results.getString("title"), results.getInt("pages"), results.getString("description"), getAuthorsByBookID(id)));
            }
        } catch(SQLException e) { System.out.println("Failed to get books by genre"); }

        return books;
    }

    // gets one book by a given id from the database
    public Book getBookByID(int id) {
        String query = "SELECT * FROM book WHERE book_id = " + id + ";";

        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            if(results.next()) {
                return new Book(id, results.getString("title"), results.getInt("pages"), results.getString("description"), getAuthorsByBookID(id));
            }        
        } catch(SQLException e) { System.out.println("Failed to get book by genre"); }

        return null;
    }
}