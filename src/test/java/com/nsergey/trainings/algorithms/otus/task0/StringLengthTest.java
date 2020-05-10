package com.nsergey.trainings.algorithms.otus.task0;

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
