package org.academiadecodigo.ramsters.mapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

abstract public class Element {

    private Grid grid;

    private Position position;

    private Rectangle rectangle;

    public Element(int x, int y, Grid grid) {

        this.grid = grid;

        this.position = new Position(x, y, grid);

        this.rectangle = new Rectangle(grid.colToX(x) + Grid.PADDING, grid.rowToY(y) + Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);

        this.rectangle.setColor(Color.BLACK);

        this.rectangle.draw();

    }

}
