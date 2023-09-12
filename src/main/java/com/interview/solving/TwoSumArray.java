package com.interview.solving;

import java.util.HashMap;
import java.util.Map;

/**
 * A class for finding two numbers in an array that add up to a given target.
 */
public class TwoSumArray {

    /**
     * Finds and returns the indices of two numbers in the array that sum up to the target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum to find.
     * @return An array containing the indices of the two numbers that sum up to the target, or an empty array if not found.
     */
    public int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> complementIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementIndexMap.containsKey(complement)) {
                int index = complementIndexMap.get(complement);
                return new int[]{index, i};
            }
            complementIndexMap.put(nums[i], i);
        }

        return new int[0]; // Return an empty array if no valid pair is found.
    }

}
