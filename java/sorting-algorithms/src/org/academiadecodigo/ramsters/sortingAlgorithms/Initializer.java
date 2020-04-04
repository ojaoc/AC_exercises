package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.Algorithms;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.BubbleSort;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.InsertionSort;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.MergeSort;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Canvas;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Grid;

import java.security.AlgorithmConstraints;

import static org.academiadecodigo.ramsters.sortingAlgorithms.Main.SCREEN_HEIGHT;

public class Initializer {

    private Canvas canvas;

    private int numberOfItems;

    private int[] items;

    private Bar[] bars;


    public Initializer(int numberOfItems) {

        this.canvas = new Canvas(numberOfItems, (int) SCREEN_HEIGHT / 2);

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

                new BubbleSort().sort(items, bars);

                break;

            case INSERTION_SORT:

                new InsertionSort().sort(items, bars);

                break;

            case MERGE_SORT:

                new MergeSort().sort(items, bars);

                break;

        }

    }



}
