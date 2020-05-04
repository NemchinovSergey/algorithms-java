package com.nsergey.trainings.algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestUtils {

    public static Path getFilePath(String fileName) throws URISyntaxException, FileNotFoundException {
        URL resource = TestUtils.class.getResource(fileName);
        if (resource == null) {
            throw new FileNotFoundException(fileName);
        }
        return Paths.get(resource.toURI());
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
