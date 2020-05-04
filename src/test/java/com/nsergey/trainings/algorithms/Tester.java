package com.nsergey.trainings.algorithms;

import com.nsergey.trainings.algorithms.task0.StringLength;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.nsergey.trainings.algorithms.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tester {

    private static final Logger log = LogManager.getLogger(Tester.class);

    private void runTest(Task task, String dir) {
        log.info("Task: {}", task.getClass().getName());
        try {
            while (true) {
                Path inFile = makeFileName("/%s/test.%d.in", dir, number);
                Path outFile = makeFileName("/%s/test.%d.out", dir, number);

                if (Files.exists(inFile) && Files.exists(outFile)) {
                    log.info("Test #{}", i);
                    runTest(task, inFile, outFile);
                } else {
                    break;
                }
                number++;
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
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

    @Test
    public void testStringLength() {
        runTest(new StringLength(), "0.String");
    }

}
