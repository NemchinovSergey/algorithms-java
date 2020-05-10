package com.nsergey.trainings.algorithms;

import com.nsergey.trainings.algorithms.taskTwoSum.TwoSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nsergey.trainings.algorithms.TestUtils.runTest;

public class TwoSumTest {

    @DisplayName("LeetCode - Two Sum")
    @Test
    public void testTwoSum() {
        runTest(new TwoSum(), "TwoSum");
    }

}
