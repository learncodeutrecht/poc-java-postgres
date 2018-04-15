package io.github.learncode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresSelect extends SuperClass {
    PostgresSelect() {
        super.printMethod();
    }

    private static Connection con;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static String sql = "SELECT * FROM COMPANY;";

    public static void main(String args[]) {
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                float salary = rs.getFloat("salary");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("AGE = " + age);
                System.out.println("ADDRESS = " + address);
                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            stmt.close();
            con.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}