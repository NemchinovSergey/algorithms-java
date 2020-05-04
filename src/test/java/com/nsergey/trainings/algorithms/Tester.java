package com.nsergey.trainings.algorithms;

import com.nsergey.trainings.algorithms.task0.StringLength;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

import static com.nsergey.trainings.algorithms.TestUtils.*;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Tester {

    private static final Logger log = LogManager.getLogger(Tester.class);

    private void runTest(Task task, String dir) {
        log.info("Task: {}", task.getClass().getName());
        for (int i = 0; ; i++) {
            try {
                Path input = getFilePath(format("/%s/test.%d.in", dir, i));
                Path expected = getFilePath(format("/%s/test.%d.out", dir, i));
                log.info("Test #{}", i);
                runTest(task, input, expected);
            } catch (FileNotFoundException e) {
                log.info("Finished");
                return;
            } catch (Exception e) {
                fail(e);
            }
        }
    }

    private void runTest(Task task, Path inFile, Path outFile) {
        List<String> input = readAllLines(inFile);
        String expected = readAllText(outFile);
        String actual = task.run(input);

        log.info("input: {}", input);
        log.info("expected: '{}'", expected);
        log.info("actual: '{}'", actual);

        assertEquals(expected, actual);
    }

    @DisplayName("Проверка тестирования")
    @Test
    public void testStringLength() {
        runTest(new StringLength(), "0.String");
    }

}
