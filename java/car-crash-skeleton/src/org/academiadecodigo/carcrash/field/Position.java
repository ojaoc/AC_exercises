package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.helper.RandomGenerator;

public class Position {

    private int col = RandomGenerator.generateCol();

    private int row = RandomGenerator.generateRow();

    public int getCol() {

        return col;

    }

    public void setCol(int col) {

        this.col += col;

    }

    public int getRow() {

        return row;

    }

    public void setRow(int row) {

        this.row += row;

    }

}
