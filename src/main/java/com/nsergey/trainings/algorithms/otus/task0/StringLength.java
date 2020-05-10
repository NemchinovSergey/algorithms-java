package com.nsergey.trainings.algorithms.otus.task0;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
import java.util.List;

public class StringLength implements Task {

    @Override
    public String run(List<String> data) {
        return String.valueOf(data.get(0).length());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: <data>");
            return;
        }
        String result = new StringLength().run(Arrays.asList(args));
        System.out.println("Result: " + result);
    }

}
