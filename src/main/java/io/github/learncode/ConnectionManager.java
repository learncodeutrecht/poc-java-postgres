package io.github.learncode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String urlstring = "jdbc:postgresql://localhost:5432/testdb";
    private static String driverName = "org.postgresql.Driver";
    private static String username = "manisha";
    private static String password = "123";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);

                System.out.println("Opened database successfully");
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
            ex.printStackTrace();
        }
        return con;
    }
}