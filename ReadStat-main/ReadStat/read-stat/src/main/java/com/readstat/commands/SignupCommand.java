package com.readstat.commands;

import com.readstat.DAOs.UserDAO;
import com.readstat.POJOs.User;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to attempt to sign up a user
 * Revision Date: 6/20/26
 */

public abstract class SignupCommand implements Command {
    public static boolean execute(String username, String password) {
        UserDAO userDAO = new UserDAO();
        if(userDAO.createUser(username, password)) {
            User.getUser().login(username);
            return true;
        }
        return false;
    }
}
