package org.academiadecodigo.ramsters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Plaything implements KeyboardHandler {

    public static final int SIDE_BOARD = 600;

    public static final int PADDING = 10;

    private Keyboard keyboard;

    private Rectangle rectangle;

    public Plaything() {

        this.keyboard = new Keyboard(this);

        this.rectangle = new Rectangle(PADDING, PADDING, 20, 20);

    }

    public void init() {

        rectangle.setColor(Color.BLACK);
        rectangle.fill();

        KeyboardEvent upPressed = new KeyboardEvent();
        KeyboardEvent downPressed = new KeyboardEvent();
        KeyboardEvent rightPressed = new KeyboardEvent();
        KeyboardEvent leftPressed = new KeyboardEvent();

        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPressed.setKey(KeyboardEvent.KEY_UP);

        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPressed.setKey(KeyboardEvent.KEY_DOWN);

        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);

        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);

        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                if (rectangle.getY() - PADDING < PADDING) return;

                rectangle.translate(0, -10);

                break;

            case KeyboardEvent.KEY_DOWN:

                if (rectangle.getY() + PADDING >= SIDE_BOARD) return;

                rectangle.translate(0, 10);

                break;

            case KeyboardEvent.KEY_RIGHT:

                if (rectangle.getX() + PADDING >= SIDE_BOARD) return;

                rectangle.translate(10, 0);

                break;

            case KeyboardEvent.KEY_LEFT:

                if (rectangle.getX() - PADDING < PADDING) return;

                rectangle.translate(-10, 0);

                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        

    }
}
