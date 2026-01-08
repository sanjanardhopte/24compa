package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/authdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change if needed

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Step 1: Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish Connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: SQLWarning demonstration
            SQLWarning warning = con.getWarnings();
            if (warning != null) {
                System.out.println("SQL Warning: " + warning.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return con;
    }
}