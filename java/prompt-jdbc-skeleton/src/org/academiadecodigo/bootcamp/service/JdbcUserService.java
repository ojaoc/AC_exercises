package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.sql.Connection;
import java.util.List;

public class JdbcUserService implements UserService {

    private Connection dbConnection;

    public JdbcUserService(Connection dbConnection) {

        this.dbConnection = dbConnection;

    }

    @Override
    public boolean authenticate(String username, String password) {

        return false;

    }

    @Override
    public void add(User user) {

    }

    @Override
    public User findByName(String username) {

        return null;

    }

    @Override
    public List<User> findAll() {

        return null;

    }

    @Override
    public int count() {

        return 0;

    }

}
