package org.academiadecodigo.ramsters.mapEditor;

public class Canvas {

    private Grid grid;

    private Tile[] tiles;

    private Designer designer;


    public Canvas(int cols, int rows) {

        this.grid = new Grid(cols, rows);

        int numberOfTiles = cols * rows;

        this.tiles = new Tile[numberOfTiles];

        int temporaryCol = 0;

        int temporaryRow = 0;

        for (int i = 0; i < tiles.length; i++) {

            tiles[i] = new Tile(temporaryCol, temporaryRow, this.grid);

            if (temporaryCol < cols - 1) {

                temporaryCol++;


            } else {

                temporaryRow++;

                temporaryCol = 0;

            }

        }

        this.designer = new Designer(0, 0, this.grid);

    }



}
