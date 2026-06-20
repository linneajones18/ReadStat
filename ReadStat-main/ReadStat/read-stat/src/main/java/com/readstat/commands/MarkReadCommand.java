package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to mark a book as read
 * Revision Date: 06/20/2026
 */

public abstract class MarkReadCommand implements Command {
    public static boolean execute(String book_id) {
        UserDAO userDAO = new UserDAO();
        return userDAO.markBookAsRead(book_id);
    }
}
