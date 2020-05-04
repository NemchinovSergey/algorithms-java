package com.nsergey.trainings.algorithms;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.String.format;

public class TestUtils {

    public static Path makeFileName(String pattern, String dataDirectory, int number) throws URISyntaxException {
        return Paths.get(Tester.class.getResource(format(pattern, dataDirectory, number)).toURI());
    }

    public static String readAllText(Path file) {
        try {
            byte[] bytes = Files.readAllBytes(file);
            return new String(bytes).trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readAllLines(Path file) {
        try {
            return Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
