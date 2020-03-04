package org.academiadecodigo.ramsters.mapEditor.canvas;

import org.academiadecodigo.ramsters.mapEditor.elements.Designer;
import org.academiadecodigo.ramsters.mapEditor.elements.Tile;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

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

    public void start() throws InterruptedException{

        while (true) {

            Thread.sleep(50);

            this.designer.move();

            comparePositions();

        }

    }

    private void comparePositions() {

        for (Tile tile : tiles) {

            if (designer.isDrawing() && !designer.isErasing()) {

                if (tile.getPosition().getRow() == designer.getPosition().getRow() &&
                tile.getPosition().getCol() == designer.getPosition().getCol()) {

                    tile.paint();


                }

            } else if (!designer.isDrawing() && designer.isErasing()){

                if (tile.getPosition().getRow() == designer.getPosition().getRow() &&
                tile.getPosition().getCol() == designer.getPosition().getCol()) {

                    tile.erase();

                }

            } else if (designer.isEraseAll()) {

                tile.erase();

            }

        }

    }

}
