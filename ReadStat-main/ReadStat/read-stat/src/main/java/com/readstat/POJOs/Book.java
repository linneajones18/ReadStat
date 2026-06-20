package com.readstat.POJOs;

import java.util.ArrayList;

/*
 * Author:        Linnea Jones
 * Purpose:       Stores book information in a java understandable form
 * Revision Date: 06/19/2026
 */

public class Book {
    private String id;
    private String title;
    private int pages;
    private String description;
    private String cover_url;
    private ArrayList<String> authors;
    private ArrayList<String> genres;

    public Book(String id, String title, int pages, String description, String cover_url, ArrayList<String> authors, ArrayList<String> genres) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.description = description;
        this.cover_url = cover_url;
        this.authors = authors;
        this.genres = genres;
    }

    public String getID()                   { return id; }
    public String getTitle()                { return title; }
    public int getPages()                   { return pages; }
    public String getDescription()          { return description; }
    public String getCoverURL()             { return cover_url; }
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
}