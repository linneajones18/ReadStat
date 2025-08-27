package com.readstat.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Defines what the user sees when the login page is open
 * Revision Date: 7/22/2025
 */

public class LoginView extends View {
    private JButton login_button;
    private JButton signup_button;
    private JTextField login_username_field;
    private JPasswordField login_password_field;
    private JTextField signup_username_field;
    private JPasswordField signup_password_field;

    public LoginView() {
        view_name = "Login";

        login_button = new JButton("Login");
        signup_button = new JButton("Sign Up");
        login_username_field = new JTextField(15);
        login_password_field = new JPasswordField(15);
        signup_username_field = new JTextField(15);
        signup_password_field = new JPasswordField(15);

        // pieces of frame creation code came from:
        // https://www.geeksforgeeks.org/java/introduction-to-java-swing/
        // and chatgpt

        // define main viw panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 
        // define each row of the page as its own panel to be added to the main panel

        JPanel signup_user_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        signup_user_row.add(new Label("Username"));
        signup_user_row.add(signup_username_field);

        JPanel signup_pass_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        signup_pass_row.add(new Label("Password"));
        signup_pass_row.add(signup_password_field);

        JPanel signup_button_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        signup_button_row.add(signup_button);

        JPanel login_user_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        login_user_row.add(new Label("Username"));
        login_user_row.add(login_username_field);

        JPanel login_pass_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        login_pass_row.add(new Label("Password"));
        login_pass_row.add(login_password_field);

        JPanel login_button_row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        login_button_row.add(login_button);

        // login components
        Label label1 = new Label("Already have an account?");
        label1.setFont(getFont().deriveFont(Font.BOLD));
        panel.add(label1);
        panel.add(login_user_row);
        panel.add(login_pass_row);
        panel.add(login_button_row);

        panel.add(Box.createVerticalStrut(30));

        // signup components
        Label label2 = new Label("Don't have an account yet?");
        label2.setFont(getFont().deriveFont(Font.BOLD));
        panel.add(label2);
        panel.add(signup_user_row);
        panel.add(signup_pass_row);
        panel.add(signup_button_row);

        panel.add(Box.createVerticalStrut(30));

        add(panel);
    }

    public String getLoginUsername() { return login_username_field.getText(); }
    public char[] getLoginPassword() { return login_password_field.getPassword(); }
    public String getSignupUsername() { return signup_username_field.getText(); }
    public char[] getSignUpPassword() { return signup_password_field.getPassword(); }

    public void setLoginListener(ActionListener listener) { login_button.addActionListener(listener); }
    public void setSignUpListener(ActionListener listener) { signup_button.addActionListener(listener); }

    public void clearLoginFields() {
        login_username_field.setText("");
        login_password_field.setText("");
    }

    public void clearSignUpFields() {
        signup_username_field.setText("");
        signup_password_field.setText("");
    }
}
