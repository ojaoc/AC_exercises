package org.academiadecodigo.ramsters.mapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Tile extends Element{

    private Grid grid;

    private Position position;

    private Rectangle rectangle;

    public Tile(int x, int y, Grid grid) {

        super(x, y, grid);

    }

}
