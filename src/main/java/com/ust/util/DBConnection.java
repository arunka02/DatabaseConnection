package com.ust.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// @author: Arun Anand

public class DBConnection {

    private DBConnection() {
        super();
    }

    public static Connection getConnection() {

        Connection con = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
}
