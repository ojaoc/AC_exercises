package org.academiadecodigo.ramsters.sortingAlgorithms.algorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;

public class BubbleSort implements Sorter {

    @Override
    public void sort(int[] items, Bar[] bars) {

        try {

            for (int i = 0; i < items.length - 1; i++) {

                for (int j = 0; j < items.length - 1 - i; j++) {

                    Thread.sleep(1);

                    if (items[j] > items[j + 1]) {

                        int temp = items[j];

                        items[j] = items[j + 1];

                        items[j + 1] = temp;

                        bars[j].replace(items[j]);

                        bars[j + 1].replace(items[j + 1]);

                    }

                }

            }

        } catch (InterruptedException ex) {

            System.out.println(ex.getMessage());

        }

        for (int item : items) {

            System.out.println(item);

        }

    }

}
