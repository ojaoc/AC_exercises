package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.Algorithms;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.BubbleSort;

public class Main {

    public static void main(String[] args) {

        Initializer initializer = new Initializer(80);

        initializer.createBars();

        initializer.sort(Algorithms.BUBBLE_SORT);

    }

}