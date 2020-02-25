package org.academiadecodigo.ramsters.exceptionsExercise.file;

import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NoActiveSessionException;
import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NotEnoughSpaceException;
import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.FileNotFoundException;

public class FileManager {

    private File existingFile;

    private boolean foundFile;

    private String password;

    private boolean hasPermission;

    private boolean isLoggedIn;

    private boolean hasEnoughSpace;


    public FileManager(String password) {

        this.password = password;

        hasEnoughSpace = true;

        System.out.println("File manager created.");

    }

    public void login(String password) throws NotEnoughPermissionsException {

        hasPermission = this.password.equals(password);

        if (!hasPermission) throw new NotEnoughPermissionsException();

        isLoggedIn = true;

        System.out.println("Welcome!");

    }

    public void logout() throws NoActiveSessionException {

        if (!isLoggedIn) throw new NoActiveSessionException();

        isLoggedIn = false;

        System.out.println("Logging out...");

    }

    public File getFile(String fileName) throws FileNotFoundException, NotEnoughPermissionsException {

        if (!isLoggedIn) throw new NotEnoughPermissionsException();

        foundFile = existingFile.getName().equals(fileName);

        if (!foundFile) throw new FileNotFoundException();

        System.out.println("File found!");

        return existingFile;

    }

    public void createFile(String fileName) throws NotEnoughSpaceException, NotEnoughPermissionsException {

        if (!isLoggedIn) throw new NotEnoughPermissionsException();

        if (!hasEnoughSpace) throw new NotEnoughSpaceException();

        existingFile = new File(fileName);

        hasEnoughSpace = false;

        System.out.println("You have created a file named " + fileName);

    }

    public void deleteFile(String fileName) throws FileNotFoundException, NotEnoughPermissionsException {

        if (!isLoggedIn) throw new NotEnoughPermissionsException();

        foundFile = existingFile.getName().equals(fileName);

        if (!foundFile) throw new FileNotFoundException();

        existingFile = null;

        hasEnoughSpace = true;

        System.out.println("You have deleted a file named " + fileName);

    }

}
