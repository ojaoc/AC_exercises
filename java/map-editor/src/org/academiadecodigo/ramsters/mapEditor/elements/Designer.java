package org.academiadecodigo.ramsters.mapEditor.elements;

import org.academiadecodigo.ramsters.mapEditor.canvas.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Designer extends Element implements KeyboardHandler {

    private Direction direction;

    private boolean drawing;

    private boolean erasing;

    private boolean eraseAll;

    private Keyboard keyboard;

    private int xSpeed;
    private int ySpeed;

    public Designer(int x, int y, Grid grid) {

        super(x, y, grid);

        this.keyboard = new Keyboard(this);

        direction = Direction.STOP;

        drawing = false;

        erasing = false;

        eraseAll = false;

        getRectangle().setColor(Color.GREEN);

        getRectangle().fill();

        KeyboardEvent upPressed = new KeyboardEvent();
        KeyboardEvent upReleased = new KeyboardEvent();

        KeyboardEvent downPressed = new KeyboardEvent();
        KeyboardEvent downReleased = new KeyboardEvent();

        KeyboardEvent leftPressed = new KeyboardEvent();
        KeyboardEvent leftReleased = new KeyboardEvent();

        KeyboardEvent rightPressed = new KeyboardEvent();
        KeyboardEvent rightReleased = new KeyboardEvent();

        KeyboardEvent spacePressed = new KeyboardEvent();
        KeyboardEvent spaceReleased = new KeyboardEvent();

        KeyboardEvent dPressed = new KeyboardEvent();
        KeyboardEvent dReleased = new KeyboardEvent();

        KeyboardEvent cPressed = new KeyboardEvent();
        KeyboardEvent cReleased = new KeyboardEvent();


        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKey(KeyboardEvent.KEY_UP);

        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downReleased.setKey(KeyboardEvent.KEY_DOWN);

        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);

        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);

        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);

        dPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        dReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        dPressed.setKey(KeyboardEvent.KEY_D);
        dReleased.setKey(KeyboardEvent.KEY_D);

        cPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        cReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        cPressed.setKey(KeyboardEvent.KEY_C);
        cReleased.setKey(KeyboardEvent.KEY_C);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(upReleased);

        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(downReleased);

        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(leftReleased);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(rightReleased);

        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(spaceReleased);

        keyboard.addEventListener(dPressed);
        keyboard.addEventListener(dReleased);

        keyboard.addEventListener(cPressed);
        keyboard.addEventListener(cReleased);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                direction = Direction.UP;

                break;

            case KeyboardEvent.KEY_DOWN:

                direction = Direction.DOWN;

                break;

            case KeyboardEvent.KEY_LEFT:

                direction = Direction.LEFT;

                break;

            case KeyboardEvent.KEY_RIGHT:

                direction = Direction.RIGHT;

                break;

            case KeyboardEvent.KEY_SPACE:

                drawing = true;

                break;

            case KeyboardEvent.KEY_D:

                erasing = true;

                break;

            case KeyboardEvent.KEY_C:

                eraseAll = true;

                break;

        }



    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
            case KeyboardEvent.KEY_DOWN:
            case KeyboardEvent.KEY_LEFT:
            case KeyboardEvent.KEY_RIGHT:

                direction = Direction.STOP;

                break;

            case KeyboardEvent.KEY_SPACE:

                drawing = false;

                break;

            case KeyboardEvent.KEY_D:

                erasing = false;

                break;

            case KeyboardEvent.KEY_C:

                eraseAll = false;

                break;

        }


    }

    public void move() {

        switch (direction) {

            case UP:

                ySpeed = -1;

                if (getPosition().getRow() + ySpeed < 0) return;

                getPosition().setRow(ySpeed);

                getRectangle().translate(0, -Grid.CELL_SIZE);

                break;

            case DOWN:

                ySpeed = 1;

                if (getPosition().getRow() + ySpeed >= getGrid().getRows()) return;

                getPosition().setRow(ySpeed);

                getRectangle().translate(0, Grid.CELL_SIZE);

                break;

            case LEFT:

                xSpeed = -1;

                if (getPosition().getCol() + xSpeed < 0) return;

                getPosition().setCol(xSpeed);

                getRectangle().translate(-Grid.CELL_SIZE, 0);

                break;

            case RIGHT:

                xSpeed = 1;

                if (getPosition().getCol() + xSpeed >= getGrid().getCols()) return;

                getPosition().setCol(xSpeed);

                getRectangle().translate(Grid.CELL_SIZE, 0);

                break;

        }

    }

    public boolean isDrawing() {

        return drawing;

    }

    public boolean isErasing() {

        return erasing;

    }

    public boolean isEraseAll() {

        return eraseAll;

    }
}
