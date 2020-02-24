package org.academiadecodigo.ramsters.exceptionsExercise.exceptions;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {

        super("You don't have access to that file.");

    }

}
