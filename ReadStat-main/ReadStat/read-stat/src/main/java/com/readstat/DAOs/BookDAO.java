package com.readstat.DAOs;

import com.readstat.POJOs.Book;
import com.readstat.model.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the book and book_to_genre database and translates data into an understandable java form
 * Revision Date: 06/18/2026
 */

public class BookDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    public boolean addBookToDB(String title, String pages, String[] authors, String description, ArrayList<String> genres) {
        title = title.replace("\"", "''");
        String book_query = "INSERT INTO book (title, pages, description) VALUES (\"" + title + "\", " + pages + ", " + description + ");";
        try(PreparedStatement preparedStatement = con.prepareStatement(book_query)) {
            int rows_affected = preparedStatement.executeUpdate();
            if(rows_affected != 1) { return false; }
        } catch(SQLException e) { System.out.println("Failed to insert book." + book_query); e.printStackTrace(); System.exit(-1); return false; }

        // get the id of that book
        String book_id_query = "SELECT book_id FROM book ORDER BY book_id DESC LIMIT 1;";
        int book_id;
        try(PreparedStatement preparedStatement = con.prepareStatement(book_id_query)) {
            ResultSet results = preparedStatement.executeQuery();
            results.next();
            book_id = results.getInt("book_id");
        } catch(SQLException s) { System.out.println("Failed to get recently added book's id"); s.printStackTrace(); System.exit(-1); return false; }

        // add authors
        // remove duplicate authors - apparently some of the csv lines have the same author listed twice for some reason
        authors = Arrays.stream(authors).distinct().toArray(String[]::new);
        AuthorDAO authorDAO = new AuthorDAO();
        for(String author : authors) {
            int author_id = authorDAO.addAuthorToDB(author);
            authorDAO.addAuthorBookRelationship(book_id, author_id);
        }

        // TODO: add logic for genres eventually

        return true;
    }

    // imports books from CSV into DB if not already there
    public boolean importBooks() {
        // check if book DB already loaded
        String query = "SELECT COUNT(*) AS count FROM book;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            results.next();
            if(results.getInt("count") != 0) { return true; }
        } catch(SQLException e) { System.out.println("Failed to check book DB size."); e.printStackTrace(); System.exit(-1); return false;}

        System.out.println("Importing books to DB...");
        // load books from CSV into SQL DB
        // retrieved BufferedReader code from Google AI
        try (BufferedReader br = new BufferedReader(new FileReader("ReadStat-main\\ReadStat\\read-stat\\src\\main\\resources\\GoodReadsBooks.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] split_line = line.split(",");
                String[] authors = split_line[2].split("/");
                // add to db
                // TODO: add logic for getting description/genres from GBAPI
                addBookToDB(split_line[1], split_line[7], authors, null, null);
            }
        } 
        catch(FileNotFoundException f) { System.out.println("Failed to read book CSV to list"); f.printStackTrace(); System.exit(-1); return false; }
        catch(IOException i) { System.out.println("Failed to read from file"); i.printStackTrace(); System.exit(-1); return false; }

        System.out.println("Book import complete.");
        return true;
    }

    // retrieves num relatively random books from the DB
    public ArrayList<Book> getNumBooks(int num) {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT book_id, title, pages, description FROM book LIMIT " + num + ";";

        try(PreparedStatement preparedBookStatement = con.prepareStatement(query)) {
            ResultSet results = preparedBookStatement.executeQuery();
            while(results.next()) {
                int id = results.getInt("book_id");
                
                books.add(new Book(id, results.getString("title"), results.getInt("pages"), results.getString("description"), getAuthorsByBookID(id)));
            }
        } catch(SQLException e) { System.out.println("Failed to access books"); e.printStackTrace(); }

        return books;
    }

    // TODO: write functions for retrieving some of the books so users can page through them

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
        } catch(SQLException e) { System.out.println("Failed to access books"); e.printStackTrace(); }

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
        } catch(SQLException e) { System.out.println("Failed to access authors of books"); e.printStackTrace(); }

        return authors;
    }

    // gets all books by a specific genre in the database in an array
    public ArrayList<Book> getBooksByGenre(String genre) {
        ArrayList<Book> books = new ArrayList<>();
        String query = "SELECT book.book_id, title, pages, description FROM book RIGHT JOIN book_to_genre ON book.book_id = book_to_genre.book_id WHERE genre_name = '" + genre + "';";
        
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()) {
                int id = results.getInt("book_id");
                books.add(new Book(id, results.getString("title"), results.getInt("pages"), results.getString("description"), getAuthorsByBookID(id)));
            }
        } catch(SQLException e) { System.out.println("Failed to get books by genre"); e.printStackTrace(); }

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
        } catch(SQLException e) { System.out.println("Failed to get book by id"); e.printStackTrace(); }

        return null;
    }
}