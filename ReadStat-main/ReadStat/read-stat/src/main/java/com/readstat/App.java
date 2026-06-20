package com.readstat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.readstat.DAOs.BookDAO;
import com.readstat.DAOs.CSVDAO;
import com.readstat.POJOs.Book;
import com.readstat.controllers.*;
import com.readstat.services.GoogleBooksService;
import com.readstat.views.ViewManager;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Consolidates the controllers to start together and run the app as well as importing the DB book data
 * Revision Date: 6/19/26
 */

public class App 
{
    private LoginController loginController;
    private StatsController statsController;
    private TrackBooksController trackBooksController;

    public void start() {
        // BookDAO bookDAO = new BookDAO();
        // bookDAO.importBooks();
        loginController = new LoginController();
        statsController = new StatsController();
        trackBooksController = new TrackBooksController();
        ViewManager.getInstance().showView("Login");
    }

    // temp
    // saving this until genre mapping is implemented better
    public static void translate() {

        ArrayList<String> titles = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ReadStat-main\\ReadStat\\read-stat\\src\\main\\resources\\GoodReadsBooks.csv"))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                line = br.readLine();
                String title = line.split(",")[1];

                ArrayList<Book> possible_books = GoogleBooksService.getBookByTitle(title);

                // if GBAPI didn't find any books with that title
                if(possible_books.size() == 0) {
                    // skip it 
                    continue;
                }

                Book book = possible_books.get(0);
                CSVDAO.writeBookToCSV(book);
            }
        } 
        catch(FileNotFoundException f) { System.out.println("Failed to read book CSV to list"); f.printStackTrace(); System.exit(-1); }
        catch(IOException i) { System.out.println("Failed to read from file"); i.printStackTrace(); System.exit(-1); }

        for(int i = 0; i < titles.size(); i++ ) { System.out.println(titles.get(i)); }
    }

    public static void main( String[] args ) {
        // App app = new App();
        // app.start();
        // GoogleBooksService.getBookByTitle("Dune");
        translate();
    }
}