package org.academiadecodigo.ramsters.sortingAlgorithms.gfx;

public class Canvas {

    private Grid grid;

    private Bar[] bars;

    public Canvas(int cols, int rows) {

        this.grid = new Grid(cols, rows);

    }

    public int getHeight() {

        return grid.getHeight();

    }

    public void setBars(Bar[] bars) {

        this.bars = bars;

    }

}
