package org.academiadecodigo.ramsters.exceptionsExercise;

import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.FileException;
import org.academiadecodigo.ramsters.exceptionsExercise.file.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager("verySecurePassword");

        try {

            fileManager.login("verySecurePassword");

            fileManager.createFile("text");

            fileManager.getFile("text");

            fileManager.deleteFile("text");

            fileManager.logout();

        } catch (FileException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
