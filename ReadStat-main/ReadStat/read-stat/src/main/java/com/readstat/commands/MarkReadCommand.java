package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to mark/unmark a book as read
 * Revision Date: 06/15/2026
 */

public class MarkReadCommand implements Command {
    public static boolean execute(int book_id) {
        UserDAO userDAO = new UserDAO();
        if(userDAO.userHasReadBook(book_id)) { userDAO.unTrackBookByID(book_id); return true; }
        else { userDAO.markBookAsRead(book_id); return false; }
    }
}
