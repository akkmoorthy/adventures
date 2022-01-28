package com.adventures.problems;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class JoinStringWithDelimiter {

    private static final String TEXT_1 = "Illinois";
    private static final String TEXT_2 = "Mathematics";
    private static final String TEXT_3 = "and";
    private static final String TEXT_4 = "Science";
    private static final String TEXT_5 = "Academy";

    public static void main(String[] args) {

        System.out.println("Join multiple string via Java 8, String.join():");
        long startTimeV1 = System.nanoTime();

        String stringV1 = String.join(" ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("String: " + stringV1);

        System.out.println();
        System.out.println("Join multiple string via StringBuilder:");
        long startTimeV2 = System.nanoTime();

        String stringV2 = joinByDelimiterV1(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("String: " + stringV2);

        System.out.println();
        System.out.println("Join multiple string via Java 8, Collectors.joining():");
        long startTimeV3 = System.nanoTime();

        String stringV3 = joinByDelimiterV2(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("String: " + stringV3);

        System.out.println();
        System.out.println("Join multiple string via Java 8, StringJoiner:");
        long startTimeV4 = System.nanoTime();

        String stringV4 = joinByDelimiterV3(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("String: " + stringV4);
    }

    public static String joinByDelimiterV1(char delimiter, String... args) {

        if (args == null || args.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length - 1; i++) {
            result.append(args[i]).append(delimiter);
        }

        result.append(args[i]);

        return result.toString();
    }

    public static String joinByDelimiterV2(char delimiter, String... args) {

        if (args == null || args.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

    public static String joinByDelimiterV3(char delimiter, String... args) {

        if (args == null || args.length == 0) {
            // or throw IllegalArgumentException
            return "";
        }

        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for (String arg : args) {
            joiner.add(arg);
        }

        return joiner.toString();
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

}
