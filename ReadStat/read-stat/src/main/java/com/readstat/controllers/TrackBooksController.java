package com.readstat.controllers;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.readstat.DAOs.BookDAO;
import com.readstat.commands.TrackBookCommand;
import com.readstat.views.TrackBooksView;
import com.readstat.views.ViewManager;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the operation logic for what to do when the user interacts with the book tracking page
 * Revision Date: 7/23/2025
 */

// OBSERVER PATTERN
public class TrackBooksController {
    private TrackBooksView view;

    public TrackBooksController() {
        view = new TrackBooksView();
        ViewManager.getInstance().registerView(view, view.getViewName());

        view.setGoToStatsListener(e -> handleGoToStats());
        view.setGenreSearchListener(e -> handleSearch());

        view.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                refreshButtons();
            }
        });
        refreshButtons();
    }

    public void handleGoToStats() {
        ViewManager.getInstance().showView("Stats");
    }

    public void handleTrackBook(int index) {
        TrackBookCommand.execute(view.getVisibleBooks().get(index).ID());
        view.switchButtonMode(index);
        view.refresh();
        refreshButtons();
    }

    public void handleSearch() {
        BookDAO bookDAO = new BookDAO();
        // when no genre is selected - show all books
        if(view.getSelectedGenre().equals("Select by genre")) { view.setVisibleBooks(bookDAO.getAllBooks()); }
        else { view.setVisibleBooks(bookDAO.getBooksByGenre(view.getSelectedGenre())); }
        refreshButtons();
    }

    private void refreshButtons() {
        view.setVisibleBooks(view.getVisibleBooks()); // refreshes the page and thus the buttons
        for(int i = 0; i < view.getVisibleBooks().size(); i++) { // assign listeners for new buttons
            int index = i;
            view.setTrackListener(e -> handleTrackBook(index), index);
        }
    }
}
