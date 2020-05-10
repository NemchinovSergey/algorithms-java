package com.nsergey.trainings.algorithms.twosum;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nsergey.trainings.algorithms.Utils.parseIntArray;

/**
 * https://leetcode.com/articles/two-sum/
 */
public class TwoSumTwoPassHashTable implements Task {

    @Override
    public String run(List<String> data) {
        int[] nums = parseIntArray(data.get(0));
        int target = Integer.parseInt(data.get(1));

        int[] result = twoSumWithTwoPassHashTable(nums, target);
        return Arrays.toString(result);
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

        throw new IllegalArgumentException();
    }

}
