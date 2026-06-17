package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to remove book as being read
 * Revision Date: 06/17/2026
 */

public class MarkUnReadCommand {
    public static boolean execute(int index) {
        UserDAO userDAO = new UserDAO();
        return userDAO.unTrackBookByID(index);
    }
}
