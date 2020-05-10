package com.nsergey.trainings.algorithms.twosum;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
import java.util.List;

import static com.nsergey.trainings.algorithms.Utils.parseIntArray;

/**
 * https://leetcode.com/articles/two-sum/
 */
public class TwoSumBruteForce implements Task {

    @Override
    public String run(List<String> data) {
        int[] nums = parseIntArray(data.get(0));
        int target = Integer.parseInt(data.get(1));

        int[] result = twoSumBruteForce(nums, target);
        return Arrays.toString(result);
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
        throw new IllegalArgumentException();
    }

}
