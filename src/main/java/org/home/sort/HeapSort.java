package org.home.sort;

public class HeapSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        buildHeap(unsortedArray);

        int lastElementIndex = unsortedArray.length - 1;

        for (int i = lastElementIndex; i > 0; i--) {
            swap(unsortedArray, 0, i);
            maxHeap(unsortedArray, 0, --lastElementIndex);
        }

        return unsortedArray;
    }

    private void buildHeap(int[] array) {
        int amountOfElements = array.length - 1;
        for (int i = amountOfElements / 2; i >= 0; i--) {
            maxHeap(array, i, amountOfElements);
        }
    }

    private void maxHeap(int[] array, int parentElementIndex, int lastElementIndex) {
        int leftChildElementIndex = 2 * parentElementIndex;
        int rightChildElementIndex = leftChildElementIndex + 1;

        int largestElementIndex = leftChildElementIndex <= lastElementIndex && array[leftChildElementIndex] > array[parentElementIndex]
                ? leftChildElementIndex
                : parentElementIndex;

        if (rightChildElementIndex <= lastElementIndex && array[rightChildElementIndex] > array[largestElementIndex]) {
            largestElementIndex = rightChildElementIndex;
        }

        if (largestElementIndex != parentElementIndex) {
            swap(array, parentElementIndex, largestElementIndex);
            maxHeap(array, largestElementIndex, lastElementIndex);
        }
    }
}
