package org.home.sort;

public abstract class SortAlgorithm {
    public abstract int[] sort(int[] unsortedArray);

    protected void swap(int[] array, int firstElementIndex, int secondElementIndex) {
        int previousElement = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = previousElement;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
