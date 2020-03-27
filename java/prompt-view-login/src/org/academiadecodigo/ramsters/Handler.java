package org.academiadecodigo.ramsters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

abstract public class Handler {

    StringInputScanner promptUsername;

    PasswordInputScanner promptPassword;

    Prompt prompt;

    UserList userList;

    public Handler(Prompt prompt, UserList userList) {

        this.prompt = prompt;

        this.userList = userList;

        promptUsername = new StringInputScanner();

    }

}
