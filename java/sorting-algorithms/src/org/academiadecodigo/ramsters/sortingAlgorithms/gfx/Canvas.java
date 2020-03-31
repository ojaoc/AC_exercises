package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

public class Canvas {

    private Grid grid;

    public Canvas(int cols, int rows) {

        this.grid = new Grid(cols, rows);

    }

    public int getHeight() {

        return grid.getHeight();

    }

    public int getWidth() {

        return grid.getWidth();

    }

    public int getCols() {

        return grid.getCols();

    }

    public int getRows() {

        return grid.getRows();

    }

}
