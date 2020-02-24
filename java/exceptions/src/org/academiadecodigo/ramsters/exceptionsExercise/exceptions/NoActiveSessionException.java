package org.academiadecodigo.ramsters.exceptionsExercise.exceptions;

public class NoActiveSessionException extends FileException {

    public NoActiveSessionException() {

        super("You don't have an active session.");

    }

}
