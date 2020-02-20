package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Game;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;
import org.academiadecodigo.carcrash.helper.RandomGenerator;

abstract public class Car {

    private Position position;

    private CarType type;

    private Move lastMove;

    public Car(Position position, CarType type) {

        this.position = position;

        this.type = type;

        int probability = RandomGenerator.generateProbability();

        if (probability <= 25) {

            lastMove = Move.UP;

        } else if (probability <= 50) {

            lastMove = Move.DOWN;

        } else if (probability <= 75) {

            lastMove = Move.RIGHT;

        } else {

            lastMove = Move.LEFT;

        }

    }

    public Position getPos() {

        return position;

    }

    public CarType isCrashed() {

        return type;

    }

    public void crash() {

        type = CarType.CRASHED;

    }

    public String toString() {

        return type.getIdentifier();

    }

    public void update() {

        if (type == CarType.CRASHED) return;

        switch (lastMove) {

            case UP:

                moveUp();

                break;

            case DOWN:

                moveDown();

                break;

            case RIGHT:

                moveRight();

                break;

            case LEFT:

                moveLeft();

                break;

        }

        Game.lookForCrashes();

    }

    private void moveUp() {

        if (position.getRow() - 1 < 0) {

            lastMove = Move.DOWN;

            return;

        }

        position.setRow(-1);

    }

    private void moveDown() {

        if (position.getRow() + 1 >= Field.getHeight()) {

            lastMove = Move.UP;

            return;

        }

        position.setRow(1);

    }

    private void moveRight() {

        if (position.getCol() + 1 >= Field.getWidth()) {

            lastMove = Move.LEFT;

            return;

        }

        position.setCol(1);

    }

    private void moveLeft() {

        if (position.getCol() - 1 < 0) {

            lastMove = Move.RIGHT;

            return;

        }

        position.setCol(-1);

    }

    public Move getLastMove() {

        return lastMove;

    }

}
