package com.nsergey.trainings.algorithms.leetcode.twosum;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nsergey.trainings.algorithms.Utils.parseIntArray;

/**
 * https://leetcode.com/articles/two-sum/
 */
public class TwoSumOnePassHashTable implements Task {

    @Override
    public String run(List<String> data) {
        int[] nums = parseIntArray(data.get(0));
        int target = Integer.parseInt(data.get(1));

        int[] result = twoSumWithOnePassHashTable(nums, target);
        return Arrays.toString(result);
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

        throw new IllegalArgumentException();
    }

}
