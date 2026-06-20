package com.readstat.DAOs;

import java.io.FileWriter;
import java.io.IOException;

import com.readstat.POJOs.Book;

/*
 * Author:        Linnea Jones
 * Purpose:       Handles communication between Java and CSV book file
 * Revision Date: 06/20/2026
 */

public abstract class CSVDAO {
    private static final String csv_path = "ReadStat-main\\ReadStat\\read-stat\\src\\main\\resources\\GoogleBooks.csv";

    public static void writeBookToCSV(Book book) {
        try (FileWriter writer = new FileWriter(csv_path, true)) {
            
            // write authors as list
            String authors_as_string = "";
            for(int i = 0; i < book.getAuthors().size(); i++) {
                authors_as_string +=  book.getAuthors().get(i);
                if(i !=  book.getAuthors().size() - 1) {
                    authors_as_string += "/";
                }
            }

            String genres_as_String = "";
            for(int i = 0; i < book.getGenres().size(); i++) {
                genres_as_String += book.getGenres().get(i);
                if(i != book.getGenres().size() - 1) {
                    genres_as_String += "/";
                }
            }

            writer.append(
                book.getID() + ",\"" +
                book.getTitle() + "\"," +
                book.getPages() + ",\"" +
                book.getDescription() + "\"," + 
                book.getCoverURL() + "," +
                book.getIsFiction() + ",\"" +
                authors_as_string + "\"," +
                genres_as_String + "\n"
            );

        } catch (IOException e) { System.out.println("Failed to write book to CSV"); e.printStackTrace(); }
    }



}
