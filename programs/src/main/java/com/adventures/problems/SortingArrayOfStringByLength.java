package com.adventures.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class SortingArrayOfStringByLength {

    private static String[] strs = {"one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"};

    public enum Sort {
        ASC, DESC
    }

    public static void main(String[] args) {

        System.out.println("Initial (unsorted):" + Arrays.toString(strs));

        System.out.println("Integer.compare() based solution:");
        long startTimeV1 = System.nanoTime();

        sortArrayByLengthV1(strs, SortingArrayOfStringByLength.Sort.DESC);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Sorted desc: " + Arrays.toString(strs));

        System.out.println();
        System.out.println("Comparator.comparingInt() based solution:");
        long startTimeV2 = System.nanoTime();

        sortArrayByLengthV2(strs, SortingArrayOfStringByLength.Sort.ASC);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Sorted asc: " + Arrays.toString(strs));

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String[] resultV3 = sortArrayByLengthV3(strs, SortingArrayOfStringByLength.Sort.DESC);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Sorted desc: " + Arrays.toString(resultV3));
    }

    public static void sortArrayByLengthV1(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return;
        }

        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, (String s1, String s2)
                    -> Integer.compare(s1.length(), s2.length()));
        } else {
            Arrays.sort(strs, (String s1, String s2)
                    -> (-1) * Integer.compare(s1.length(), s2.length()));
        }
    }

    public static void sortArrayByLengthV2(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return;
        }

        if (direction.equals(Sort.ASC)) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
        } else {
            Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
        }
    }

    public static String[] sortArrayByLengthV3(String[] strs, Sort direction) {

        if (strs == null || direction == null || strs.length == 0) {
            // or throw IllegalArgumentException
            return new String[0];
        }

        if (direction.equals(Sort.ASC)) {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
