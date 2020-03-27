package org.academiadecodigo.ramsters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;

public class LoginHandler extends Handler {

    private String user;

    public LoginHandler(Prompt prompt, UserList userList) {

        super(prompt, userList);

        promptUsername.setMessage("Insert your username: ");

        user = prompt.getUserInput(promptUsername);

        login();

    }

    private void login() {

        if (userList.containsUser(user)) {

            promptPassword = new PasswordInputScanner();

            promptPassword.setMessage("Password? ");

            String password = prompt.getUserInput(promptPassword);

            if (userList.isPasswordCorrect(user, password)) {

                System.out.println("Welcome " + user + "!");

            } else {

                System.out.println("Incorrect password!");

                login();

            }

        } else {

            String[] yesOrNo = {"Yes, I want to create an account.", "No, I want to try again."};

            MenuInputScanner wantToRegister = new MenuInputScanner(yesOrNo);
            wantToRegister.setMessage("User doesn't exist. Do you want to Register?");

            int answerIndex = prompt.getUserInput(wantToRegister);

            switch (answerIndex) {

                case 1:

                    new RegisterHandler(prompt, userList);

                    break;

                case 2:

                    new LoginHandler(prompt, userList);

                    break;

            }

        }

    }

}
