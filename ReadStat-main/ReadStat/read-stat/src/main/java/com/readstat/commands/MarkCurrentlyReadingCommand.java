package com.readstat.commands;

import com.readstat.DAOs.UserDAO;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to mark a book as currently reading
 * Revision Date: 06/19/2026
 */

public class MarkCurrentlyReadingCommand {
    public static boolean execute(String id) {
        UserDAO userDAO = new UserDAO();
        return userDAO.markBookAsCurReading(id);
    }
}
