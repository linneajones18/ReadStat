package com.readstat.commands;

import com.readstat.DAOs.UserDAO;
import com.readstat.POJOs.User;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to attempt to login a user
 * Revision Date: 6/20/26
 */

public abstract class LoginCommand implements Command {
    public static boolean execute(String username, String password) {
        UserDAO userDAO = new UserDAO();
        if(userDAO.verifyLogin(username, password)) { // if the user exists
            User.getUser().login(username);
            return true;
        }
        return false; // the user doesn't exist
    }
}
