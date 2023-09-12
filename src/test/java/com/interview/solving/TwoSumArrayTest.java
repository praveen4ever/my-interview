package com.interview.solving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for testing the TwoSumArray class.
 */
public class TwoSumArrayTest {

    /**
     * Test case for finding a valid pair that exists in the array.
     */
    @Test
    public void testFindTwoSum_ValidPairExists() {
        TwoSumArray twoSumArray = new TwoSumArray();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumArray.findTwoSum(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    /**
     * Test case for finding a valid pair that exists in the array with negative numbers.
     */
    @Test
    public void testFindTwoSum_ValidPairExistsWithNegativeNumbers() {
        TwoSumArray twoSumArray = new TwoSumArray();

        int[] nums = {-2, 7, 11, -4};
        int target = 3;
        int[] result = twoSumArray.findTwoSum(nums, target);

        assertArrayEquals(new int[]{0, 2}, result);
    }

    /**
     * Test case for when no valid pair exists in the array.
     */
    @Test
    public void testFindTwoSum_NoValidPairExists() {
        TwoSumArray twoSumArray = new TwoSumArray();

        int[] nums = {1, 2, 3, 4};
        int target = 10;
        int[] result = twoSumArray.findTwoSum(nums, target);

        assertArrayEquals(new int[0], result);
    }

    /**
     * Test case for a single-element array.
     */
    @Test
    public void testFindTwoSum_SingleElementArray() {
        TwoSumArray twoSumArray = new TwoSumArray();

        int[] nums = {5};
        int target = 5;
        int[] result = twoSumArray.findTwoSum(nums, target);

        assertArrayEquals(new int[0], result);
    }
}
