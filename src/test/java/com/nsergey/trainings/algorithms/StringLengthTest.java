package com.nsergey.trainings.algorithms;

import com.nsergey.trainings.algorithms.task0.StringLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.nsergey.trainings.algorithms.TestUtils.runTest;

public class StringLengthTest {

    @DisplayName("Проверка тестирования")
    @Test
    public void testStringLength() {
        runTest(new StringLength(), "0.String");
    }

}
