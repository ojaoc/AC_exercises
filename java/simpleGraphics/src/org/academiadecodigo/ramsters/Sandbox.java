package org.academiadecodigo.ramsters;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Sandbox {

    public static void main(String[] args) {

        Plaything movable = new Plaything();

        Rectangle rectange = new Rectangle(Plaything.PADDING, Plaything.PADDING, Plaything.SIDE_BOARD, Plaything.SIDE_BOARD);

        rectange.setColor(Color.GREEN);

        rectange.fill();

        movable.init();







    }

}
