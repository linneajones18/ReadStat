package com.readstat;

import com.readstat.DAOs.BookDAO;
import com.readstat.controllers.*;
import com.readstat.views.ViewManager;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Consolidates the controllers to start together and run the app
 * Revision Date: 6/18/26
 */

public class App 
{
    private LoginController loginController;
    private StatsController statsController;
    private TrackBooksController trackBooksController;

    public void start() {
        BookDAO bookDAO = new BookDAO();
        bookDAO.importBooks();
        loginController = new LoginController();
        statsController = new StatsController();
        trackBooksController = new TrackBooksController();
        ViewManager.getInstance().showView("Login");
    }

    public static void main( String[] args ) {
        App app = new App();
        app.start();
    }
}