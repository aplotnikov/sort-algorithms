package org.home.sort;

import static java.util.stream.IntStream.range;

public class HeapSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        buildHeap(unsortedArray);

        range(0, unsortedArray.length)
                .forEach(currentElementIndex -> minHeap(unsortedArray, currentElementIndex, unsortedArray.length - 1));

        return unsortedArray;
    }

    private void buildHeap(int[] array) {
        int amountOfElements = array.length - 1;
        for (int i = amountOfElements / 2; i >= 0; i--) {
            minHeap(array, i, amountOfElements);
        }
    }

    private void minHeap(int[] array, int parentElementIndex, int lastElementIndex) {
        int leftChildElementIndex = 2 * parentElementIndex;
        int rightChildElementIndex = leftChildElementIndex + 1;

        int largestElementIndex = leftChildElementIndex <= lastElementIndex && array[leftChildElementIndex] < array[parentElementIndex]
                ? leftChildElementIndex
                : parentElementIndex;

        if (rightChildElementIndex <= lastElementIndex && array[rightChildElementIndex] < array[largestElementIndex]) {
            largestElementIndex = rightChildElementIndex;
        }

        if (largestElementIndex != parentElementIndex) {
            swap(array, parentElementIndex, largestElementIndex);
            minHeap(array, largestElementIndex, lastElementIndex);
        }
    }
}
