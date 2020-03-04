package org.academiadecodigo.ramsters.mapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;

    public static final int CELL_SIZE = 20;

    private int cols;
    private int rows;

    private Rectangle field;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        this.field = new Rectangle(PADDING, PADDING, colToX(cols), rowToY(rows));

        field.setColor(Color.BLACK);
        field.draw();

    }

    public int getCols() {

        return cols;

    }

    public int getRows() {

        return rows;

    }

    public int getWidth() {

        return field.getWidth();

    }

    public int getHeight() {

        return field.getHeight();

    }

    public int getX() {

        return field.getX();

    }

    public int getY() {

        return field.getY();

    }

    public int colToX(int col) {

        return col * CELL_SIZE;

    }

    public int rowToY(int row) {

        return row * CELL_SIZE;

    }

}
