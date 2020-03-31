package org.academiadecodigo.ramsters.sortingAlgorithms.algorithms;

import org.academiadecodigo.ramsters.sortingAlgorithms.gfx.Bar;

public class MergeSort implements Sorter {

    private Bar[] bars;

    @Override
    public void sort(int[] items, Bar[] bars) {

        this.bars = bars;

        divide(items, 0, items.length - 1);

    }

    private void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {

        int leftArrSize = middleIndex - leftIndex + 1;

        int rightArrSize = rightIndex - middleIndex;

        int[] leftArr = new int[leftArrSize];

        int[] rightArr = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {

            leftArr[i] = array[leftIndex + i];

        }

        for (int j = 0; j < rightArrSize; j++) {

            rightArr[j] = array[middleIndex + 1 + j];

        }

        int i = 0, j = 0;

        int mergedArrIndex = leftIndex;

        try {

            while (i < leftArrSize && j < rightArrSize) {

                Thread.sleep(1);

                if (leftArr[i] <= rightArr[j]) {

                    array[mergedArrIndex] = leftArr[i];

                    bars[mergedArrIndex].replace(leftArr[i]);

                    i++;

                } else {

                    array[mergedArrIndex] = rightArr[j];

                    bars[mergedArrIndex].replace(rightArr[j]);

                    j++;

                }

                mergedArrIndex++;

            }

            while (i < leftArrSize) {

                Thread.sleep(1);

                array[mergedArrIndex] = leftArr[i];

                bars[mergedArrIndex].replace(leftArr[i]);

                i++;

                mergedArrIndex++;

            }

            while (j < rightArrSize) {

                Thread.sleep(1);

                array[mergedArrIndex] = rightArr[j];

                bars[mergedArrIndex].replace(rightArr[j]);

                j++;

                mergedArrIndex++;

            }

        } catch (InterruptedException ex) {

            ex.printStackTrace();

        }

    }

    private void divide(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {

            int middleIndex = (leftIndex + rightIndex) / 2;

            divide(array, leftIndex, middleIndex);

            divide(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);

        }

    }

}
