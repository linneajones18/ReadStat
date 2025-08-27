package com.readstat.commands;

import com.readstat.POJOs.User;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines the logic for how to attempt to logout a user
 * Revision Date: 7/15/2025
 */

public class LogoutCommand {
    public static boolean execute() {
        if(User.getUser().getUsername() != null) {
            User.getUser().logout();
            return true;
        }
        return false;
    }
}
