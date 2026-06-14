package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the logic for how to mark/unmark a book as read
 * Revision Date: 7/21/2025
 */

public class TrackBookCommand implements Command {
    public static boolean execute(int book_id) {
        UserDAO userDAO = new UserDAO();
        if(userDAO.userHasReadBook(book_id)) { userDAO.unTrackBookByID(book_id); return true; }
        else { userDAO.trackBookByID(book_id); return false; }
    }
}
