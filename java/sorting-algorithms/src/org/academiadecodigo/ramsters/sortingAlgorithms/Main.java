package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.Algorithms;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.BubbleSort;

public class Main {

    public static final double SCREEN_WIDTH = 1340;

    public static final double SCREEN_HEIGHT = 720;

    public static void main(String[] args) {

        Initializer initializer = new Initializer((int) SCREEN_WIDTH / 2);

        initializer.createBars();

        //initializer.sort(Algorithms.BUBBLE_SORT);

        initializer.sort(Algorithms.INSERTION_SORT);

        //initializer.sort(Algorithms.MERGE_SORT);

    }

}
