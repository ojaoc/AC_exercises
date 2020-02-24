package org.academiadecodigo.ramsters.exceptionsExercise.exceptions;

public class NotEnoughPermissionsException extends FileException {

    public NotEnoughPermissionsException() {

        super("You don't have permission to do that.");

    }

}
