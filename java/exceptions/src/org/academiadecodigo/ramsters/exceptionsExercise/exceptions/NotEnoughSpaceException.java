package org.academiadecodigo.ramsters.exceptionsExercise.exceptions;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException() {

        super("You don't have enough storage for the file you want to download.");

    }

}
