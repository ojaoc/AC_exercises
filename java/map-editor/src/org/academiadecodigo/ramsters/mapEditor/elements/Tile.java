package org.academiadecodigo.ramsters.mapEditor.elements;

import org.academiadecodigo.ramsters.mapEditor.canvas.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile extends Element {

    private String color;

    public Tile(int x, int y, Grid grid) {

        super(x, y, grid);

        color = "B";

        getRectangle().setColor(Color.BLACK);

        getRectangle().draw();

    }

    public void paint() {

        color = "R";

        getRectangle().setColor(Color.RED);

        getRectangle().fill();

    }

    public void erase() {

        color = "B";

        getRectangle().setColor(Color.BLACK);

        getRectangle().draw();

    }

    public String getColor() {

        return color;

    }

}
