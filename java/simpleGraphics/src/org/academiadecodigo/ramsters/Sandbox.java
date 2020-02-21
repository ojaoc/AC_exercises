package org.academiadecodigo.ramsters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Sandbox implements KeyboardHandler {

    public static void main(String[] args) {

        Rectangle rectange = new Rectangle(0, 0, 400, 400);

        rectange.setColor(Color.GREEN);

        rectange.fill();

        Rectangle smallRectangle = new Rectangle(0, 0, 10, 10);

        smallRectangle.setColor(Color.BLACK);

        smallRectangle.fill();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();



    }

}
