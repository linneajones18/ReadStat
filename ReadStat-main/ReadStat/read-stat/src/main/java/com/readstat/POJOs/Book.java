package com.readstat.POJOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.readstat.DAOs.AuthorDAO;
import com.readstat.DAOs.GenreDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Stores book information in a java understandable form
 * Revision Date: 06/20/2026
 */

public class Book {
    private String id;
    private String title;
    private int pages;
    private String description;
    private String cover_url;
    private Boolean isFiction;
    private ArrayList<String> authors;
    private ArrayList<String> genres;

    public Book(String id, String title, int pages, String description, String cover_url, Boolean isFiction, ArrayList<String> authors, ArrayList<String> genres) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.description = description;
        this.cover_url = cover_url;
        this.isFiction = isFiction;
        this.authors = authors;
        this.genres = genres;

        if(this.title != null) { this.title.replace("\"", "''"); }
        if(this.description != null) { this.description.replace("\"", "''"); }
    }

    public Book(ResultSet DB_results) throws SQLException {
        this(
            DB_results.getString("book_id"),
            DB_results.getString("title"),
            DB_results.getInt("pages"),
            DB_results.getString("description"),
            DB_results.getString("cover_url"),
            DB_results.getBoolean("isFiction"),
            null,
            null
        );

        GenreDAO genreDAO = new GenreDAO();
        AuthorDAO authorDAO = new AuthorDAO();
        authors = authorDAO.getAuthorsByBookID(id);
        genres = genreDAO.getGenresByBookID(id);
    }

    public String getID()                   { return id; }
    public String getTitle()                { return title; }
    public int getPages()                   { return pages; }
    public String getDescription()          { return description; }
    public String getCoverURL()             { return cover_url; }
    public Boolean getIsFiction()           { return isFiction; }
    public ArrayList<String> getAuthors()   { return authors; }
    public ArrayList<String> getGenres()    { return genres; }

    public String getAuthorsAsString() {
        String authors_as_string = "";
        for(int i = 0; i < authors.size(); i++) {
            authors_as_string += authors.get(i);
            if( i < authors.size() - 1) {
                authors_as_string += ", ";
            }
        }
        return authors_as_string;
    }

    public String getGenresAsString() {
        String genres_as_string = "";
        for(int i = 0; i < genres.size(); i++) {
            genres_as_string += genres.get(i);
            if( i < genres.size() - 1) {
                genres_as_string += ", ";
            }
        }
        return genres_as_string;
    }

    public void prettyPrint() {
        System.out.print(
            "Title: " + title + "\n" +
            "ID: " + id + "\n" +
            "Pages: " + pages + "\n" +
            "Description: " + description + "\n" +
            "Cover URL: " + cover_url + "\n" +
            "isFiction: " + isFiction + "\n" +
            getAuthorsAsString() + getGenresAsString()
        );
    }
}