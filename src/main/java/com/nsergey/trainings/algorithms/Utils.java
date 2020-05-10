package com.nsergey.trainings.algorithms;

import java.util.Arrays;

public abstract class Utils {

    public static int[] parseIntArray(String numbers) {
        String unbracketed = numbers.replace("[", "").replace("]", "");
        String[] strings = unbracketed.split(",");
        return Arrays.stream(strings).mapToInt(s -> Integer.parseInt(s.trim())).toArray();
    }

}
