package com.adventures.problems;

import java.util.concurrent.TimeUnit;

public class StringContainsOnlyDigits {

    private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326";

    private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
            + "749823283974232237238472392309230923849023848234580383485342234287943943094"
            + "234745374657346578465783467843653748654376837463847654382382938793287492326A";

    public static void main(String[] args) {

        System.out.println("Input text with only digits: \n" + ONLY_DIGITS + "\n");
        System.out.println("Input text with other characters: \n" + NOT_ONLY_DIGITS + "\n");

        System.out.println("Character.isDigit() solution:");
        long startTimeV1 = System.nanoTime();

        boolean onlyDigitsV11 = containsOnlyDigitsV1(ONLY_DIGITS);
        boolean onlyDigitsV12 = containsOnlyDigitsV1(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Contains only digits: " + onlyDigitsV11);
        System.out.println("Contains only digits: " + onlyDigitsV12);

        // Notice that Java 8 functional style and regular expression-based solutions are usually slow,
        // so if speed is a requirement, then it's better to rely on the first solution using Character.isDigit().
        System.out.println();
        System.out.println("String.matches() solution:");
        long startTimeV2 = System.nanoTime();

        boolean onlyDigitsV21 = containsOnlyDigitsV2(ONLY_DIGITS);
        boolean onlyDigitsV22 = containsOnlyDigitsV2(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Contains only digits: " + onlyDigitsV21);
        System.out.println("Contains only digits: " + onlyDigitsV22);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        boolean onlyDigitsV31 = containsOnlyDigitsV3(ONLY_DIGITS);
        boolean onlyDigitsV32 = containsOnlyDigitsV3(NOT_ONLY_DIGITS);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Contains only digits: " + onlyDigitsV31);
        System.out.println("Contains only digits: " + onlyDigitsV32);
    }


    // Note: For Unicode supplementary characters use codePointAt() instead of charAt()
    //       and codePoints() instead of chars()
    public static boolean containsOnlyDigitsV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean containsOnlyDigitsV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return str.matches("[0-9]+");
    }

    public static boolean containsOnlyDigitsV3(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}