package io.github.learncode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresCreate {
    private static Connection con;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static String sql = "CREATE TABLE COMPANY " +
            "(ID INT PRIMARY KEY     NOT NULL," +
            " NAME           TEXT    NOT NULL, " +
            " AGE            INT     NOT NULL, " +
            " ADDRESS        CHAR(50), " +
            " SALARY         REAL)";

    public static void main(String args[]) {
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            stmt.close();
            con.close();
            rs.close();
            System.out.println("Table created successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
