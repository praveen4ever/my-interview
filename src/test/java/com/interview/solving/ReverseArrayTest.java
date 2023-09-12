package com.interview.solving;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The {@code ReverseArrayTest} class is a JUnit test class for testing the {@link ReverseArray} class.
 * It includes parameterized tests to verify the correctness of the {@link ReverseArray#process(int[])} method.
 */
public class ReverseArrayTest {

    /**
     * Parameterized test to verify the correctness of the {@link ReverseArray#process(int[])} method.
     *
     * @param input    The input integer array to be reversed.
     * @param expected The expected result after reversing the input array.
     */
    @ParameterizedTest(name = "{index} - {2}")
    @MethodSource("testData")
    @DisplayName("Reverse Array Test")
    @Order(3)
    @Tag("positive")
    public void testReverseArray(int[] input, int[] expected,String desc) {
        ReverseArray ra = new ReverseArray();
        assertArrayEquals(ra.process(input), expected);
    }

    @ParameterizedTest(name = "{index} - {2}")
    @MethodSource("testData")
    @DisplayName("Reverse Array TestV2")
    @Order(2)
    @Tag("positive")
    public void testReverseArrayV2(int[] input, int[] expected,String desc) {
        ReverseArray ra = new ReverseArray();
        assertArrayEquals(ra.processV2(input), expected);
    }

    /**
     * Provides test data for the parameterized tests.
     *
     * @return A stream of arguments containing input arrays and their expected reversed forms.
     */

    @Contract(" -> new")
    private  static @NotNull Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}, "Even array test"),
                Arguments.of(new int[]{3, 4, 5}, new int[]{5, 4, 3}, "Odd array test"),
                Arguments.of(new int[]{}, new int[]{}, "Empty array test"),
                Arguments.of(new int[]{0}, new int[]{0}, "Single array test"),
                Arguments.of(new int[]{1, 2, 3, 4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,25}, new int[]{25, 25, 24, 23, 22, 21, 20, 19, 18, 17,
                        16, 15, 14, 13, 12, 11, 10, 9, 8, 7,
                        6, 5, 4, 3, 2, 1}, "Large array test")
        );
    }
}
