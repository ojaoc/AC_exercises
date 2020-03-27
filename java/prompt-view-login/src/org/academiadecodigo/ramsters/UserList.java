package org.academiadecodigo.ramsters;

import java.util.HashMap;

public class UserList {

    private HashMap<String, String> hashMap;

    public UserList() {

        hashMap = new HashMap<>();

    }

    public void put(String username, String password) {

        hashMap.put(username, password);

        System.out.println("Added user: " + username);

    }

    public boolean containsUser(String username) {

        return hashMap.containsKey(username);

    }

    public boolean isPasswordCorrect(String username, String password) {

        return hashMap.get(username).equals(password);

    }

}
