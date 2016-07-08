package org.home.sort;

import static java.util.stream.IntStream.range;

public class BubbleSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        int amountOfElements = unsortedArray.length;

        range(1, amountOfElements).forEach(
                i -> range(0, amountOfElements - i).forEach(
                        j -> {
                            if (unsortedArray[j] > unsortedArray[j + 1]) {
                                swap(unsortedArray, j, j + 1);
                            }
                        })
        );

        return unsortedArray;
    }
}
