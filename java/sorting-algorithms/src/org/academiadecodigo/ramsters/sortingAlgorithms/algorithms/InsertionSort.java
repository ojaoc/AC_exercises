package org.academiadecodigo.ramsters.sortingAlgorithms.algorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;

public class InsertionSort implements Sorter {

    @Override
    public void sort(int[] items, Bar[] bars) {

        try {

            for (int i = 1; i < items.length; i++) {

                int key = items[i];

                int j = i - 1;

                while (j >= 0 && items[j] > key) {

                    Thread.sleep(1);

                    items[j + 1] = items[j];

                    bars[j + 1].replace(items[j]);

                    j -= 1;

                }

                items[j + 1] = key;

                bars[j + 1].replace(key);

            }

        } catch (InterruptedException ex) {

            ex.printStackTrace();

        }

        for (int item : items) {

            System.out.println(item);

        }

    }

}
