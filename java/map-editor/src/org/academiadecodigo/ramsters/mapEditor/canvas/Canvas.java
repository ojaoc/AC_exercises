package org.academiadecodigo.ramsters.mapEditor.canvas;

import org.academiadecodigo.ramsters.mapEditor.elements.Designer;
import org.academiadecodigo.ramsters.mapEditor.elements.Tile;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Canvas implements KeyboardHandler {

    private Grid grid;

    private Tile[] tiles;

    private int numberOfTiles;

    private Designer designer;

    private Keyboard keyboard;

    private boolean saving;

    private boolean retrieving;

    private String filePath;


    public Canvas(int cols, int rows) {

        this.grid = new Grid(cols, rows);

        numberOfTiles = cols * rows;

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

        saving = false;

        retrieving = false;

        filePath = "tileFormat.txt";

        this.designer = new Designer(0, 0, this.grid);

        this.keyboard = new Keyboard(this);

        KeyboardEvent sPressed = new KeyboardEvent();
        KeyboardEvent sReleased = new KeyboardEvent();

        KeyboardEvent lPressed = new KeyboardEvent();
        KeyboardEvent lReleased = new KeyboardEvent();

        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        sPressed.setKey(KeyboardEvent.KEY_S);
        sReleased.setKey(KeyboardEvent.KEY_S);

        lPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        lReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        lPressed.setKey(KeyboardEvent.KEY_L);
        lReleased.setKey(KeyboardEvent.KEY_L);

        keyboard.addEventListener(sPressed);
        keyboard.addEventListener(sReleased);

        keyboard.addEventListener(lPressed);
        keyboard.addEventListener(lReleased);

    }

    public void start() throws InterruptedException{

        while (true) {

            Thread.sleep(50);

            this.designer.move();

            if (designer.isEraseAll()) {

                for (Tile tile : tiles) {

                    tile.erase();

                }

            }

            if (saving) {

                save();

            }

            if (retrieving) {

                retrieve();

            }

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

            }

        }

    }

    private void save() {

        String result = "";

        for (Tile tile : tiles) {

            result += tile.getColor() + " ";

        }

        try {

            FileWriter fileWriter = new FileWriter(filePath);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(result);

            bufferedWriter.flush();

            bufferedWriter.close();

            fileWriter.close();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    private void retrieve() {

        try {

           FileReader fileReader = new FileReader(filePath);

           BufferedReader bufferedReader = new BufferedReader(fileReader);

           String line = bufferedReader.readLine();

           bufferedReader.close();

           String[] splitLine = line.split(" ");

            for (int i = 0; i < splitLine.length; i++) {

                if (splitLine[i].contains("B")) {

                    tiles[i].erase();

                } else if (splitLine[i].contains("R")) {

                    tiles[i].paint();

                }

            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_S:

                saving = true;

                break;

            case KeyboardEvent.KEY_L:

                retrieving = true;

                break;

        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_S:

                saving = false;

                break;

            case KeyboardEvent.KEY_L:

                retrieving = false;

                break;

        }

    }

}
