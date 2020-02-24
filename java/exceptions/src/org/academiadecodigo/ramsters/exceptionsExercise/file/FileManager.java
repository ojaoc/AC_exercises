package org.academiadecodigo.ramsters.exceptionsExercise.file;

import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NoActiveSessionException;
import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.ramsters.exceptionsExercise.exceptions.NotEnoughSpaceException;

import java.io.FileNotFoundException;

public class FileManager {

    private File existingFile;

    private boolean foundFile; // Here goes file we are trying to get.

    private String password;

    private boolean hasPermission;

    private boolean isLoggedIn;

    private boolean hasEnoughSpace;


    public FileManager(String password) {

        this.password = password;

        hasEnoughSpace = true;

    }

    public void login(String password) throws NotEnoughPermissionsException {

        hasPermission = this.password.equals(password);

        if (!hasPermission) throw new NotEnoughPermissionsException();

        isLoggedIn = true;

    }

    public void logout() throws NoActiveSessionException {

        if (!isLoggedIn) throw new NoActiveSessionException();

        isLoggedIn = false;

    }

    public File getFile(String fileName) throws FileNotFoundException {

        foundFile = existingFile.getName().equals(fileName);

        if (!foundFile) throw new FileNotFoundException();

        return existingFile;

    }

    public void createFile(String fileName) throws NotEnoughSpaceException {

        if (!hasEnoughSpace) throw new NotEnoughSpaceException();

        existingFile = new File(fileName);

        hasEnoughSpace = false;

    }

    public void deleteFile(String fileName) throws FileNotFoundException {

        foundFile = existingFile.getName().equals(fileName);

        if (!foundFile) throw new FileNotFoundException();

        existingFile = null;

        hasEnoughSpace = true;

    }

}
