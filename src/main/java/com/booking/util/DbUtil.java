package com.booking.util;

import com.booking.structure.logging.Logger;


import java.sql.*;

public class DbUtil {

    private static String connectionString = "jdbc:sqlite:TestResults.db";

    private DbUtil() {
    }

    public static void connectToDb() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, "", "");
            Logger.out.debug("Connection with DB has been established!");
            Statement statement = connection.createStatement();

            /*String query = "INSERT INTO Results ('Passed/Failed') VALUES ('PASSED')";
            statement.execute(query);*/

            String dbData = "SELECT * FROM Results";
            ResultSet resultSet = statement.executeQuery(dbData);

            System.out.println("---------------BEFORE UPDATE----------------");

            System.out.println("ID: " + resultSet.getString("Id"));
            System.out.println("Passed/Failed: " + resultSet.getString("Passed/Failed"));

            String updateQuery = "UPDATE Results SET `Passed/Failed` = 'UPDATED FAILED'";
            statement.execute(updateQuery);

            System.out.println("---------------AFTER UPDATE----------------");

            String dbDataAll = "SELECT * FROM Results";
            ResultSet resultSetAll = statement.executeQuery(dbData);
            System.out.println("ID: " + resultSetAll.getString("Id"));
            System.out.println("Passed/Failed: " + resultSetAll.getString("Passed/Failed"));

        }catch (SQLException e) {
            Logger.out.error("Something has come up while connecting to DB!", e.getStackTrace());
            throw new IllegalArgumentException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.out.error("Something has come up while closing DB connection!", e.getStackTrace());
                throw new IllegalArgumentException(e);
            }
        }
    }
}
