package org.academiadecodigo.ramsters.exceptionsExercise.exceptions;

public class FileNotFoundException extends FileException {

    public FileNotFoundException() {

        super("Searched file doesn't exist.");

    }

}
