package com.readstat.commands;

import com.readstat.POJOs.User;

/*
 * Author:        Linnea Jones
 * Purpose:       Defines the logic for how to attempt to logout a user
 * Revision Date: 6/20/26
 */

public abstract class LogoutCommand {
    public static boolean execute() {
        if(User.getUser().getUsername() != null) {
            User.getUser().logout();
            return true;
        }
        return false;
    }
}
