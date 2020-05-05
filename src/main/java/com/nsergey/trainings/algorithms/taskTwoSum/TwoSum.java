package com.nsergey.trainings.algorithms.taskTwoSum;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/articles/two-sum/
 */
public class TwoSum implements Task {

    private static final String NO_TWO_SUM_SOLUTION = "No two sum solution";

    @Override
    public String run(List<String> data) {
        int[] nums = parseIntArray(data.get(0));
        int target = Integer.parseInt(data.get(1));

        int[] result = twoSumWithOnePassHashTable(nums, target);
        return Arrays.toString(result);
    }

    private int[] parseIntArray(String numbers) {
        String unbracketed = numbers.replace("[", "").replace("]", "");
        String[] strings = unbracketed.split(",");
        return Arrays.stream(strings).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
    }

    /**
     * Time complexity: O(n^2).
     * For each element, we try to find its complement by looping through the rest of array which takes O(n) time.
     * Therefore, the time complexity is O(n^2).
     * Space complexity: O(1).
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException(NO_TWO_SUM_SOLUTION);
    }

    /**
     * Time complexity: O(n). We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
     * Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.
     */
    public int[] twoSumWithTwoPassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        throw new IllegalArgumentException(NO_TWO_SUM_SOLUTION);
    }

    /**
     * Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
    public int[] twoSumWithOnePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException(NO_TWO_SUM_SOLUTION);
    }

}
