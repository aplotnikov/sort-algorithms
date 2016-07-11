package org.home.sort;

public class QuickSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
        return unsortedArray;
    }

    private void quickSort(int[] array, int startElementIndex, int endElementIndex) {
        int leftPartIndex = startElementIndex;
        int rightPartIndex = endElementIndex;
        int pivot = array[startElementIndex + (endElementIndex - startElementIndex) / 2];

        while (leftPartIndex <= rightPartIndex) {
            while (array[leftPartIndex] < pivot) {
                leftPartIndex++;
            }

            while (array[rightPartIndex] > pivot) {
                rightPartIndex--;
            }

            if (leftPartIndex <= rightPartIndex) {
                swap(array, leftPartIndex++, rightPartIndex--);
            }
        }

        if (startElementIndex < rightPartIndex) {
            quickSort(array, startElementIndex, rightPartIndex);
        }

        if (leftPartIndex < endElementIndex) {
            quickSort(array, leftPartIndex, endElementIndex);
        }
    }
}
