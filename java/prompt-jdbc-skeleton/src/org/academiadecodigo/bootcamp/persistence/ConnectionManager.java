package org.academiadecodigo.bootcamp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection = null;

    private String dbURL = "jdbc:mysql://localhost/ac";

    public Connection getConnection() throws SQLException {

        if (connection == null) {

            connection = DriverManager.getConnection(dbURL, "root", "uwuIdidabooboo!");

        }

        System.out.println("Connection established...");

        return connection;

    }

    public void close() throws SQLException {

        if (connection != null) {

            connection.close();

        }

    }

}
