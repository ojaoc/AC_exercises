package org.academiadecodigo.ramsters.mapEditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;
    private Grid grid;

    public Position(int col, int row, Grid grid) {

        this.col = col;

        this.row = row;

        this.grid = grid;

    }

    public int getCol() {

        return col;

    }

    public int getRow() {

        return row;

    }

    public void setCol(int col) {

        this.col = col;

    }

    public void setRow(int row) {

        this.row = row;

    }

}
