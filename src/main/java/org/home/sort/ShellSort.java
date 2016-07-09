package org.home.sort;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class ShellSort extends SortAlgorithm {
    @Override
    public int[] sort(int[] unsortedArray) {
        int stepSize = initializeStepSize(unsortedArray.length);

        while (stepSize > 0) {
            int currentStepSize = stepSize;

            range(0, unsortedArray.length - stepSize).forEach(
                    i -> rangeClosed(0, i).forEach(
                            j -> {
                                if (unsortedArray[j] > unsortedArray[j + currentStepSize]) {
                                    swap(unsortedArray, j, j + currentStepSize);
                                }
                            }
                    )
            );

            stepSize = (stepSize - 1) / 3;
        }

        return unsortedArray;
    }

    private int initializeStepSize(int amountOfElements) {
        int stepSize = 1;

        while (stepSize <= amountOfElements / 3) {
            stepSize = stepSize * 3 + 1;
        }

        return stepSize;
    }
}
