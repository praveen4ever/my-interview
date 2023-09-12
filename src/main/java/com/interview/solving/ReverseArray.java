package com.interview.solving;

/**
 * The {@code ReverseArray} class provides a method for reversing an integer array.
 * It reverses the elements of the input array in-place.
 */
public class ReverseArray {

    /**
     * Reverses the elements of the given integer array in-place.
     *
     * @param input The integer array to be reversed.
     * @return The reversed integer array.
     */
    public int[] process(int[] input) {
        int length = input.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = input[i];
            input[i] = input[length - 1 - i];
            input[length - 1 - i] = temp;
        }
        return input;
    }
}
