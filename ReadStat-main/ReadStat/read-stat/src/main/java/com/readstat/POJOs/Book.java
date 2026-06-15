package com.readstat.POJOs;

import java.util.ArrayList;

/*
 * Author:        Linnea Jones
 * Purpose:       Stores book information in a java understandable form
 * Revision Date: 06/15/2026
 */

public class Book {
    public int id;
    public String title;
    public int pages;
    public String description;
    public ArrayList<String> authors;

    public Book(int id, String title, int pages, String description, ArrayList<String> authors) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.description = description;
        this.authors = authors;
    }

    public int getID()                      { return id; }
    public String getTitle()                { return title; }
    public int getPages()                   { return pages; }
    public String getDescription()          { return description; }
    public ArrayList<String> getAuthors()   { return authors; }

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