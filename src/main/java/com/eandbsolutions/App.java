package com.eandbsolutions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        int[] unsorted = new int[]{3, 0, 1, 4, 2};

        int j = unsorted.length - 1;
        int tempLower;
        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i] < unsorted[i - 1]) {
                System.out.println(String.format("Moving %d below %d", unsorted[i], unsorted[i - 1]));
                tempLower = unsorted[i];
                unsorted[i] = unsorted[i - 1];
                unsorted[i - 1] = tempLower;
            }

            if (unsorted[j] < unsorted[j - 1]) {
                System.out.println(String.format("Moving %d above %d", unsorted[j - 1], unsorted[j]));
                tempLower = unsorted[j];
                unsorted[j] = unsorted[j - 1];
                unsorted[j - 1] = tempLower;
            }
        }

        String joined;
        joined = Arrays.stream(unsorted).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(joined);
    }
}
