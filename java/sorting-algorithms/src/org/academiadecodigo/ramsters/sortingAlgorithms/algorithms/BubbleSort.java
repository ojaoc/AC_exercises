package org.academiadecodigo.ramsters.sortingAlgorithms.algorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;
import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Grid;

public class BubbleSort {

    private Bar[] bars;

    private int[] sortedArr;

    public BubbleSort(int[] items, Bar[] bars) {

        sortedArr = items;

        try {

            for (int i = 0; i < sortedArr.length - 1; i++) {

                for (int j = 0; j < sortedArr.length - 1 - i; j++) {

                    Thread.sleep(1000);

                    if (sortedArr[j] > sortedArr[j + 1]) {

                        bars[j].replace(Grid.CELL_SIZE);

                        bars[j + 1].replace(-Grid.CELL_SIZE);

                        int temp = sortedArr[j];

                        sortedArr[j] = sortedArr[j + 1];

                        sortedArr[j + 1] = temp;


                    }

                }

            }

        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());

        }

        for (int item : sortedArr) {
            System.out.println(item);
        }

    }

}
