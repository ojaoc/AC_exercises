package org.academiadecodigo.ramsters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;

public class RegisterHandler extends Handler {

    public RegisterHandler(Prompt prompt, UserList userList) {

        super(prompt, userList);

        promptUsername.setMessage("Insert new username: ");

        register();

    }

    private void register() {

        String username = prompt.getUserInput(promptUsername);

        if (userList.containsUser(username)) {

            System.out.println("Username already exists.");

            new RegisterHandler(prompt, userList);

        } else {

            promptPassword = new PasswordInputScanner();

            promptPassword.setMessage("Insert your password: ");

            String password = prompt.getUserInput(promptPassword);

            userList.put(username, password);

            System.out.println("Thanks for registering, " + username + "!");

            Main.main(null);

        }

    }

}
