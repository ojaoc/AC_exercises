package org.academiadecodigo.ramsters.mapEditor.elements;

import org.academiadecodigo.ramsters.mapEditor.canvas.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile extends Element {

    public Tile(int x, int y, Grid grid) {

        super(x, y, grid);

        getRectangle().setColor(Color.BLACK);

        getRectangle().draw();

    }

    public void paint() {

        getRectangle().setColor(Color.RED);

        getRectangle().fill();

    }

    public void erase() {

        getRectangle().setColor(Color.BLACK);

        getRectangle().draw();

    }

}
