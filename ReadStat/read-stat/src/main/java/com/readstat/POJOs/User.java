package com.readstat.POJOs;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Stores the information of the user
 * Revision Date: 7/22/2025
 */

//  SINGLETON PATTERN
public class User {
    private static final User instance = new User();
    private String username;

    private User() {
        username = null;
    }

    public void login(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
    public static User getUser() { return instance; }

    public void logout() {
        username = null;
    }
}
