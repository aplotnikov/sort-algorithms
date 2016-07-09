package org.home.sort;

import static java.util.Arrays.copyOfRange;

public class MergeSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        if (unsortedArray.length < 2) {
            return unsortedArray;
        }

        int middleElementIndex = unsortedArray.length / 2;

        int[] rightPart = copyOfRange(unsortedArray, 0, middleElementIndex);
        int[] leftPart = copyOfRange(unsortedArray, middleElementIndex, unsortedArray.length);

        return merge(sort(rightPart), sort(leftPart));
    }

    private int[] merge(int[] rightPart, int[] leftPart) {
        int[] result = new int[rightPart.length + leftPart.length];

        int rightPartIndex = 0;
        int leftPartIndex = 0;
        int resultIndex = 0;

        while (rightPartIndex < rightPart.length && leftPartIndex < leftPart.length) {
            if (rightPart[rightPartIndex] < leftPart[leftPartIndex]) {
                result[resultIndex++] = rightPart[rightPartIndex++];
                continue;
            }

            result[resultIndex++] = leftPart[leftPartIndex++];
        }

        if (rightPartIndex < rightPart.length) {
            copy(result, resultIndex, rightPart, rightPartIndex);
        } else if (leftPartIndex < leftPart.length) {
            copy(result, resultIndex, leftPart, leftPartIndex);
        }

        return result;
    }

    private void copy(int[] targetArray, int startIndexOfTargetArray, int[] sourceArray, int startIndexOfSourceArray) {
        for (int i = startIndexOfTargetArray, j = startIndexOfSourceArray; j < sourceArray.length; i++, j++) {
            targetArray[i] = sourceArray[j];
        }
    }
}
