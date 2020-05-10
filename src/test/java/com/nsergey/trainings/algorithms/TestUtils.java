package com.nsergey.trainings.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestUtils {

    private static final Logger log = LogManager.getLogger(TestUtils.class);

    public static void runTest(Task task, String dir) {
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

    public static void runTest(Task task, Path inFile, Path outFile) {
        List<String> input = readAllLines(inFile);
        log.info("input: {}", input);

        String expected = readAllText(outFile);
        log.info("expected: '{}'", expected);

        String actual = task.run(input);
        log.info("actual: '{}'", actual);

        assertEquals(expected, actual);
    }

    private static Path getFilePath(String fileName) throws URISyntaxException, FileNotFoundException {
        URL resource = TestUtils.class.getResource(fileName);
        if (resource == null) {
            throw new FileNotFoundException(fileName);
        }
        return Paths.get(resource.toURI());
    }

    private static String readAllText(Path file) {
        try {
            byte[] bytes = Files.readAllBytes(file);
            return new String(bytes).trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readAllLines(Path file) {
        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
