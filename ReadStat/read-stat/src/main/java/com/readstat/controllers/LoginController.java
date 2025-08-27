package com.readstat.controllers;

import com.readstat.commands.LoginCommand;
import com.readstat.commands.SignupCommand;
import com.readstat.views.LoginView;
import com.readstat.views.ViewManager;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Define the operation logic for what to do when the user interacts with the login view
 * Revision Date: 7/15/2025
 */

//  OBSERVER PATTERN
public class LoginController {
    private LoginView view;

    public LoginController() {
        view = new LoginView();
        ViewManager.getInstance().registerView(view, view.getViewName());

        view.setLoginListener(e -> handleLogin());
        view.setSignUpListener(e -> handleSignup());
    }

    private void handleLogin() {
        String password = charToString(view.getLoginPassword());
        // successful login
        if(LoginCommand.execute(view.getLoginUsername(), password)) {
            ViewManager.getInstance().showView("Stats");
            ViewManager.getInstance().showMessage("Logged in successfully!", true);
        }
        // unsuccessful login
        else {
            ViewManager.getInstance().showMessage("Login info does not match our records. Please try again.", false);
        }
        view.clearLoginFields();
    }


    private void handleSignup() {
        String password = charToString(view.getSignUpPassword());
        if(SignupCommand.execute(view.getSignupUsername(), password)) {
            ViewManager.getInstance().showMessage("New account created successfully. Please login with your new credentials.", true);
        } 
        else {
            ViewManager.getInstance().showMessage("A user already exists with that username. Please try again.", false);
        }
        view.clearSignUpFields();
    }

    // helper function for converting passwords to strings
    private static String charToString(char[] chars) {
        String string = "";
        for(int i = 0; i < chars.length; i++) {
            string += chars[i];
        }
        return string;
    }
}
