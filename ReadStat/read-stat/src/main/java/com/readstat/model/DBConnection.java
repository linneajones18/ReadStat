package com.readstat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Sets up and maintains the application's connection to the database
 * Revision Date: 7/10/2025
 */

public class DBConnection {
    private static final DBConnection instance = new DBConnection();
    private Connection con;

    // replace this info with machine specific MySQL information
    private final String url = "fill this in";
    private final String user = "root";
    private final String password = "fill this in";


    // got pieces of connection setup code from:
    // https://medium.com/@samuelcatalano/integrating-java-with-databases-a-guide-to-connecting-java-applications-with-mysql-oracle-and-feaa92cb1da8
    private DBConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() { return instance; }
    public Connection getConnection() { return con; }
}
