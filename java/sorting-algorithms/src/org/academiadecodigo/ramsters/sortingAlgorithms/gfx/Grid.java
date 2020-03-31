package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;

    //public static final int CELL_SIZE = 10;

    public static int CELL_SIZE;

    public static final int SCREEN_WIDTH = 1600;

    public static final int SCREEN_HEIGHT = 720;

    private int cols;
    private int rows;

    private Rectangle screen;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        CELL_SIZE = SCREEN_WIDTH / cols;

        this.screen = new Rectangle(PADDING, PADDING, SCREEN_WIDTH, SCREEN_HEIGHT);

        screen.setColor(Color.BLACK);
        screen.fill();

    }

    public int getCols() {

        return cols;

    }

    public int getRows() {

        return rows;

    }

    public int getWidth() {

        return screen.getWidth();

    }

    public int getHeight() {

        return screen.getHeight();

    }

    public int getX() {

        return screen.getX();

    }

    public int getY() {

        return screen.getY();

    }

    public static int colToX(int col) {

        return col * CELL_SIZE;

    }

    public static int rowToY(int row) {

        return row * 10;

    }

}
