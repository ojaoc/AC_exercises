package org.academiadecodigo.ramsters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Main {

    public static final UserList USER_LIST = new UserList();

    public static void main(String[] args) {

        // Login or Register

        Prompt prompt = new Prompt(System.in, System.out);

        String[] loginOrRegister = {"login", "register"};

        MenuInputScanner welcome = new MenuInputScanner(loginOrRegister);
        welcome.setMessage("Welcome. Login if you have an account, Register if you want to create one.");

        int answerIndex = prompt.getUserInput(welcome);

        // Username

        switch (answerIndex) {

            case 1:

                new LoginHandler(prompt, USER_LIST);

                break;

            case 2:

                new RegisterHandler(prompt, USER_LIST);

                break;

            default:

                System.out.println("something went wrong");

        }


    }

}
