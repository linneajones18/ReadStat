package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to remove book as being read
 * Revision Date: 06/20/2026
 */

public abstract class MarkUnReadCommand {
    public static boolean execute(String id) {
        UserDAO userDAO = new UserDAO();
        return userDAO.unTrackBookByID(id);
    }
}
