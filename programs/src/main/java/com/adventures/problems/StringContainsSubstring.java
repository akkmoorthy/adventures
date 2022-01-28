package com.adventures.problems;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class StringContainsSubstring {

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    private static final String SUBTEXT = "programmer";

    public static void main(String[] args) {

        System.out.println("Initial text: \n" + TEXT + "\n");
        System.out.println("Text to search: \n" + SUBTEXT + "\n");

        System.out.println("String.contains() solution:");
        long startTimeV1 = System.nanoTime();

        boolean containsV1 = TEXT.contains(SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Contained? " + containsV1);

        System.out.println();
        System.out.println("Regular expression solution:");
        long startTimeV2 = System.nanoTime();

        boolean containsV2 = containsV1(TEXT, SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Contained? " + containsV2);
        System.out.println();

        System.out.println("String.indexOf() solution:");
        long startTimeV3 = System.nanoTime();

        boolean containsV3 = containsV2(TEXT, SUBTEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Contained? " + containsV3);
    }


    public static boolean containsV1(String text, String subtext) {

        if (text == null || subtext == null
                || text.isBlank() || subtext.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return text.matches("(?i).*" + Pattern.quote(subtext) + ".*");
    }

    public static boolean containsV2(String text, String subtext) {

        if (text == null || subtext == null
                || text.isBlank() || subtext.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return text.indexOf(subtext) != -1; // or lastIndexOf()
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
