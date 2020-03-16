package org.academiadecodigo.ramsters.sortingAlgorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.Algorithms;
import org.academiadecodigo.ramsters.sortingAlgorithms.algorithms.BubbleSort;

public class Main {

    public static void main(String[] args) {

        Initializer initializer = new Initializer(130);

        initializer.createBars();

        initializer.sort(Algorithms.BUBBLE_SORT);

    }

}
