package com.adventures.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RemoveDuplicateCharacterInString {

    private static final String TEXT = "!ABCBA;C D E-D  D  DFA;";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("StringBuilder and indexOf() solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = removeDuplicatesV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("String with no duplicates: \n" + resultV1);

        System.out.println();
        System.out.println("LinkedHashSet and StringBuilder solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = removeDuplicatesV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("String with no duplicates: \n" + resultV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String resultV3 = removeDuplicatesV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("String with no duplicates: \n" + resultV3);
    }


    public static String removeDuplicatesV1(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chArray) {
            if (sb.indexOf(String.valueOf(ch)) == -1) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static String removeDuplicatesV2(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> chHashSet = new HashSet<>();
        for (char c : chArray) {
            if (chHashSet.add(c)) {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static String removeDuplicatesV3(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }


    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
