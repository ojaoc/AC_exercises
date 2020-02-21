package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.*;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle car;

    private SimpleGfxGrid simpleGfxGrid;


    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){

        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        simpleGfxGrid = grid;

        car = new Rectangle(grid.columnToX(super.getCol()) + SimpleGfxGrid.PADDING, grid.rowToY(super.getRow()) + SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());

        show();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){

        super(col, row, grid);

        simpleGfxGrid = grid;

        car = new Rectangle(grid.columnToX(col) + SimpleGfxGrid.PADDING, grid.rowToY(row) + SimpleGfxGrid.PADDING, grid.getCellSize(), grid.getCellSize());

        show();

    }


    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {


        car.fill();

    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {

        car.delete();

    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int previousCol = simpleGfxGrid.columnToX(getCol());

        int previousRow = simpleGfxGrid.rowToY(getRow());

        super.moveInDirection(direction, distance);


        car.translate(simpleGfxGrid.columnToX(getCol()) - previousCol, simpleGfxGrid.rowToY(getRow()) - previousRow);

    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        super.setColor(color);

        car.setColor(SimpleGfxColorMapper.getColor(color));

    }
}
