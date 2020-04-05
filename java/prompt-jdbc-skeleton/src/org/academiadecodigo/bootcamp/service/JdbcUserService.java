package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

//TODO: WHY ARE THERE ERRORS ON QUERIES AND ASK ABOUT SECURITY CLASS

public class JdbcUserService implements UserService {

    private Connection dbConnection;

    public JdbcUserService(Connection dbConnection) {

        this.dbConnection = dbConnection;

        ScriptRunner scriptRunner = new ScriptRunner(dbConnection, false, false);

        String file = "resources/db.sql";

        try {

            scriptRunner.runScript(new BufferedReader(new FileReader(file)));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public boolean authenticate(String username, String password) {

        try {

            String query = "SELECT * FROM user WHERE username=? AND password=?;";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);

            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            boolean result = resultSet.next();

            statement.close();

            return result;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public void add(User user) {

        try {

            String query = "SELECT * FROM user WHERE username=?";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, user.getUsername());

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {

                query = "INSERT INTO user(username, password, email, firstname, lastname, phone) VALUES ('"
                        + user.getUsername() + "', '"
                        + user.getPassword() + "', '"
                        + user.getEmail() + "', '"
                        + user.getFirstName() + "', '"
                        + user.getLastName() + "', '"
                        + user.getPhone() + "');";

                int resultSet1 = statement.executeUpdate(query);

                if (resultSet1 > 0) {

                    System.out.println("Successfully added user.");

                    statement.close();

                } else {

                    System.out.println("Something went wrong");
                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    @Override
    public User findByName(String username) {

        try {

            String query = "SELECT * FROM user WHERE username=?" +
                    "ORDER BY username ASC " +
                    "LIMIT 1;";

            PreparedStatement statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public List<User> findAll() {

        try {

            Statement statement = dbConnection.createStatement();

            String query = "SELECT * FROM user;";

            ResultSet resultSet = statement.executeQuery(query);

            LinkedList<User> list = new LinkedList<>();

            while (resultSet.next()) {

                list.add(new User(
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("phone")
                ));

            }

            return list;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public int count() {

        try {

            int result = 0;

            Statement statement = dbConnection.createStatement();

            String query = "SELECT COUNT(*) FROM user";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                result = resultSet.getInt(1);

            }

            return result;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;

    }

}
