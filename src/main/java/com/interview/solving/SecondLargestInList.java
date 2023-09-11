package com.interview.solving;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Logical problem to find the second largest element in the array
 */
@Service
public class SecondLargestInList {
    /**
     *  Input as array of integer and output will be the second largest element in that array
     * @param input
     * @return second largest element
     * @throws Exception
     */
    public int process(int[] input) throws Exception {
        if (input == null || input.length == 0) {
            throw new Exception("Invalid input");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (first < input[i]) {
                second = first;
                first = input[i];
            } else if (second < input[i]) {
                second = input[i];
            }
        }

        if(first == second)
            throw new Exception("not found");
        return second;
    }

    public int processv2(int input[]) throws Exception {
        if (input == null || input.length == 0) {
            throw new Exception("Invalid input");
        }
        Optional<Integer> oi = Arrays.stream(input).boxed().collect(Collectors.toSet()).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        if(oi.isPresent())
            return oi.get();
        else
            throw new Exception("not found");
    }
}
