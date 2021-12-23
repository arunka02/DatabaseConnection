package com.ust.service;

import com.ust.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

// @author: Arun Anand

public class FetchEmployee {

    static Logger log = Logger.getLogger(FetchEmployee.class.getName());

    public static void main(String[] args) throws SQLException {

        Connection con = DBConnection.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME," +
                " EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID " +
                " FROM EMPLOYEES ORDER BY EMPLOYEE_ID")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                log.info(resultSet.getInt(1) + "  " + resultSet.getString(2)
                        + "  " + resultSet.getString(3) + "  " + resultSet.getString(4)
                        + "  " + resultSet.getString(5) + "  " + resultSet.getDate(6)
                        + "  " + resultSet.getString(7) + "  " + resultSet.getInt(8)
                        + "  " + resultSet.getInt(9) + "  " + resultSet.getInt(10)
                        + "  " + resultSet.getInt(11));
            }
        }
        con.close();

    }

}
