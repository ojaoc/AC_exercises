package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.controller.MainController;
import org.academiadecodigo.bootcamp.controller.UserDetailsController;
import org.academiadecodigo.bootcamp.controller.UserListController;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.ConnectionManager;
import org.academiadecodigo.bootcamp.service.JdbcUserService;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Security;
import org.academiadecodigo.bootcamp.view.LoginView;
import org.academiadecodigo.bootcamp.view.MainView;
import org.academiadecodigo.bootcamp.view.UserDetailsView;
import org.academiadecodigo.bootcamp.view.UserListView;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        MainController mainController = new MainController();
        UserListController userListController = new UserListController();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        UserListView userListView = new UserListView();
        UserDetailsController userDetailsController = new UserDetailsController();
        UserDetailsView userDetailsView = new UserDetailsView();
        Prompt prompt = new Prompt(System.in, System.out);

        UserService jdbcUserService = null;

        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            Connection connection = new ConnectionManager().getConnection();

            jdbcUserService = new JdbcUserService(connection);


        } catch (SQLException e) {

            e.printStackTrace();

        }

        jdbcUserService.add(new User("rui", "ferrao@academiadecodigo.org", "academiadecodigo",
                "Rui", "Ferrão", "912345678"));
        jdbcUserService.add(new User("faustino", "faustino@academiadecodigo.org", "academiadecodigo",
                "João", "Faustino", "966666666"));
        jdbcUserService.add(new User("audrey", "audrey@academiadecodigo.org", "academiadecodigo",
                "Audrey", "Lopes", "934567890"));

        // Wire login controller and view
        loginView.setPrompt(prompt);
        loginView.setController(loginController);
        loginController.setUserService(jdbcUserService);
        loginController.setView(loginView);
        loginController.setNextController(mainController);

        // Wire main controller and view
        mainView.setPrompt(prompt);
        mainView.setController(mainController);
        mainController.setView(mainView);
        mainController.setUserListController(userListController);
        mainController.setUserDetailsController(userDetailsController);

        // Wire userList controller and view
        userListView.setPrompt(prompt);
        userListView.setController(userListController);
        userListController.setUserService(jdbcUserService);
        userListController.setView(userListView);

        // Wire userDetails controller and view
        userDetailsView.setPrompt(prompt);
        userDetailsView.setController(userDetailsController);
        userDetailsController.setUserService(jdbcUserService);
        userDetailsController.setView(userDetailsView);


        // Start APP
        loginController.init();

    }
}
