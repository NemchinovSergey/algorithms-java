package com.nsergey.trainings.algorithms;

import com.nsergey.trainings.algorithms.twosum.TwoSumBruteForce;
import com.nsergey.trainings.algorithms.twosum.TwoSumOnePassHashTable;
import com.nsergey.trainings.algorithms.twosum.TwoSumTwoPassHashTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nsergey.trainings.algorithms.TestUtils.runTest;

public class TwoSumTest {

    @DisplayName("LeetCode - Two Sum with brute force")
    @Test
    public void testTwoSumBruteForce() {
        runTest(new TwoSumBruteForce(), "TwoSum");
    }

    @DisplayName("LeetCode - Two Sum with two pass hash table")
    @Test
    public void testTwoSumTwoPassHashTable() {
        runTest(new TwoSumTwoPassHashTable(), "TwoSum");
    }

    @DisplayName("LeetCode - Two Sum with one pass hash table")
    @Test
    public void testTwoSumOnePassHashTable() {
        runTest(new TwoSumOnePassHashTable(), "TwoSum");
    }

}
