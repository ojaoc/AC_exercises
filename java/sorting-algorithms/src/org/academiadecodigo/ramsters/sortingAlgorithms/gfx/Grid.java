package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.Map;

public class Grid {

    public static final double PADDING = 10;

    //public static final int CELL_SIZE = 10;

    public static double WIDTH_UNIT;

    public static double HEIGHT_UNIT;

    public static final double SCREEN_WIDTH = 1340;

    public static final double SCREEN_HEIGHT = 720;

    private int cols;
    private int rows;

    private Rectangle screen;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        WIDTH_UNIT = Math.round(SCREEN_WIDTH / cols);
        HEIGHT_UNIT = Math.round(SCREEN_HEIGHT / rows);

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

    public static double colToX(int col) {

        return col * WIDTH_UNIT;

    }

    public static double rowToY(int row) {

        return row * HEIGHT_UNIT;

    }

}
