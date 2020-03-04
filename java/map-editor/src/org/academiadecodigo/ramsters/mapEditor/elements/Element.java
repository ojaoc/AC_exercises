package org.academiadecodigo.ramsters.mapEditor.elements;

import org.academiadecodigo.ramsters.mapEditor.canvas.Grid;
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

    }

    public Grid getGrid() {

        return grid;

    }

    public Position getPosition() {

        return position;

    }

    public Rectangle getRectangle() {

        return rectangle;

    }
}
