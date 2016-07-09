package org.home.sort;

import static java.util.stream.IntStream.range;

public class SelectionSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        range(0, unsortedArray.length - 1).forEach(i -> {
            int index = findIndexForSmallestElement(unsortedArray, i);
            swap(unsortedArray, index, i);
        });

        return unsortedArray;
    }

    private int findIndexForSmallestElement(int[] array, int startIndex) {
        return range(startIndex + 1, array.length)
                .reduce(startIndex, (smallestElementIndex, currentElementIndex) -> {
                            if (array[currentElementIndex] < array[smallestElementIndex]) {
                                return currentElementIndex;
                            }

                            return smallestElementIndex;
                        }
                );
    }
}
