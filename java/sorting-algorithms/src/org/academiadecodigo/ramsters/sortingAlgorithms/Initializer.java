package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Canvas;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Grid;

public class Initializer {

    private Canvas canvas;

    private int numberOfItems;

    public Initializer(int numberOfItems) {

        this.canvas = new Canvas(80, 50);

        this.numberOfItems = numberOfItems;

    }

    public void createBars() {

        int currentCol = 0;

        Bar[] bars = new Bar[numberOfItems];

        for (Bar each : bars) {

            each = new Bar(currentCol, 10);

            currentCol++;

        }

    }

}
