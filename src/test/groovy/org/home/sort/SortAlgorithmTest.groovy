package org.home.sort

import spock.lang.Specification
import spock.lang.Unroll

class SortAlgorithmTest extends Specification {
    @Unroll
    def "should sort provided array by sort algorithm #sortAlgorithm"() {
        given:
        int[] unsortedArray = [8, 5, 4, 7, 1]

        when:
        int[] actualArray = sortAlgorithm.sort(unsortedArray)

        then:
        assert actualArray == [1, 4, 5, 7, 8]

        where:
        sortAlgorithm << [new BubbleSort()]
    }
}
