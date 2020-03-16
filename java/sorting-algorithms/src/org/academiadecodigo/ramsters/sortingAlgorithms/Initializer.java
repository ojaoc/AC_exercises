package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.Algorithms;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.BubbleSort;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Canvas;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Grid;

import java.security.AlgorithmConstraints;

public class Initializer {

    private Canvas canvas;

    private int numberOfItems;

    private int[] items;

    private Bar[] bars;


    public Initializer(int numberOfItems) {

        this.canvas = new Canvas(numberOfItems, 60);

        this.numberOfItems = numberOfItems;

    }

    public void createBars() {

        int currentCol = 0;

        bars = new Bar[numberOfItems];

        items = new int[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {

            bars[i] = new Bar(currentCol, canvas);

            items[i] = bars[i].getItem();

            currentCol++;

        }

    }

    public void sort(Algorithms algorithm) {

        switch (algorithm) {

            case BUBBLE_SORT:

                BubbleSort bubbleSort = new BubbleSort(items, bars);

                break;

        }

    }

}
