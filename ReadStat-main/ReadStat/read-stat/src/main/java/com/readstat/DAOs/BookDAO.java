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

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the book and book_to_genre database and translates data into an understandable java form
 * Revision Date: 06/17/2026
 */

public class BookDAO {
    private Connection con = DBConnection.getInstance().getConnection();

    public boolean importBooks() {
        String query = "SELECT COUNT(*) AS count FROM book;";

        // check if book DB already loaded
        try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet results = preparedStatement.executeQuery();
            results.next();
            if(results.getInt("count") != 0) { return true; }
        } catch(SQLException e) { System.out.println("Failed to check book DB size."); e.printStackTrace(); return false;}

        // load books from CSV into SQL DB
        // retrieved pieces of this block from Google AI
        try (BufferedReader br = new BufferedReader(new FileReader("ReadStat-main\\ReadStat\\read-stat\\src\\main\\resources\\GoodReadsBooks.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] split_line = line.split(",");

                // turn into a book object
                String book_query = "INSERT INTO book (title, pages) VALUES ('" + split_line[1] + "', " + split_line[7] + ");";
                try(PreparedStatement preparedStatement = con.prepareStatement(book_query)) {
                    int rows_affected = preparedStatement.executeUpdate();
                    if(rows_affected != 1) { return false; }
                } catch(SQLException e) { System.out.println("Failed to insert book."); e.printStackTrace(); return false; }

                // get the id of that book
                String book_id_query = "SELECT book_id FROM book ORDER BY book_id DESC LIMIT 1;";
                int book_id;
                try(PreparedStatement preparedStatement = con.prepareStatement(book_id_query)) {
                    ResultSet results = preparedStatement.executeQuery();
                    results.next();
                    book_id = results.getInt("book_id");
                } catch(SQLException s) { System.out.println("Failed to get recently added book's id"); s.printStackTrace(); return false; }

                // add authors
                String[] authors = split_line[2].split("/");
                for(String author : authors) {
                    // check if author already in DB
                    System.out.println(author);
                    int author_id;
                    String authorInDBQuery = "SELECT author_id FROM author WHERE name = '" + author + "';";
                    try(PreparedStatement preparedStatement = con.prepareStatement(authorInDBQuery)) {
                        ResultSet results = preparedStatement.executeQuery();
                        if(results.next())  { author_id = results.getInt("author_id"); }
                        else                { author_id = -1; }
                    } catch(SQLException se) {System.out.println("Failed to check if author exists in DB"); se.printStackTrace(); return false; }
                
                    if(author_id == -1) {
                        //author not in DB so add them
                        System.out.println(author);
                        // NEED TO FIX THIS SO IT CAN ACCEPT TITLES WITH APOSTROPHES
                        String add_author_query = "INSERT INTO author (name) VALUES ('" + author + "');";
                        try(PreparedStatement preparedStatement = con.prepareStatement(add_author_query)) {
                            int rows_affected = preparedStatement.executeUpdate();
                            if(rows_affected != 1) { return false; }
                        } catch( SQLException sqe ) { System.out.println("Failed to add author to DB."); sqe.printStackTrace(); return false; }
                    
                        // save the new author's id
                        String get_author_query = "SELECT author_id FROM author ORDER BY author_id DESC LIMIT 1;";
                        try(PreparedStatement preparedStatement = con.prepareStatement(get_author_query)) {
                            ResultSet results = preparedStatement.executeQuery();
                            results.next();
                            author_id = results.getInt("author_id");
                        } catch( SQLException sqle ) { System.out.println("Failed to get author's id."); sqle.printStackTrace(); return false; }
                    
                        // add the books and author relationship
                        String author_book_query = "INSERT INTO author_to_book (author_id, book_id) VALUES (" + author_id + ", " + book_id + ");";
                        try(PreparedStatement preparedStatement = con.prepareStatement(author_book_query)) {
                            int rows_affected = preparedStatement.executeUpdate();
                            if(rows_affected != 1) { return false; }
                        } catch(SQLException e) { System.out.println("Failed to add author book relationship."); e.printStackTrace(); return false;}
                    }

                }
            }
        } 
        catch(FileNotFoundException f) { System.out.println("Failed to read book CSV to list"); f.printStackTrace(); return false; }
        catch(IOException i) { System.out.println("Failed to read from file"); i.printStackTrace(); return false; }


        return true;
    }

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