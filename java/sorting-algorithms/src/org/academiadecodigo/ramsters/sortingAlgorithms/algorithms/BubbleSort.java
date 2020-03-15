package org.academiadecodigo.ramsters.sortingAlgorithms.algorithms;

public class BubbleSort {

    private int[] sortedArr;

    public BubbleSort(int[] items) {

        sortedArr = items;

        for (int i = 0; i < sortedArr.length - 1; i++) {

            for (int j = 0; j < sortedArr.length - 1 - i; j++) {

                if (sortedArr[j] > sortedArr[j + 1]) {

                    int temp = sortedArr[j];

                    sortedArr[j] = sortedArr[j + 1];

                    sortedArr[j + 1] = temp;

                }

            }

        }

        for (int item : sortedArr) {
            System.out.println(item);
        }

    }

}
