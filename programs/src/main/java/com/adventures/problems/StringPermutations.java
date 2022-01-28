package com.adventures.problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringPermutations {

    private static final String TEXT = "ABC";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("Permute and store in Set - recursive solution:");
        long startTimeV1 = System.nanoTime();

        Set<String> collector = permuteAndStore(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println(collector);

        System.out.println();
        System.out.println("Permute and print - recursive solution:");
        long startTimeV2 = System.nanoTime();

        permuteAndPrint(TEXT);

        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV2);

        System.out.println();
        System.out.println("Permute and return Stream - recursive solution:");
        long startTimeV3 = System.nanoTime();

        Stream<String> result = permuteAndReturnStream(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        result.forEach(System.out::println);

        System.out.println();
        System.out.println("Permute and print Stream - recursive solution:");
        long startTimeV4 = System.nanoTime();

        permuteAndPrintStream(TEXT);

        System.out.println();
        displayExecutionTime(System.nanoTime() - startTimeV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

    public static void permuteAndPrint(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrint("", str);
    }

    private static void permuteAndPrint(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    public static Set<String> permuteAndStore(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptySet();
        }

        return permuteAndStore("", str);
    }

    private static Set<String> permuteAndStore(String prefix, String str) {

        Set<String> permutations = new HashSet<>();

        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permuteAndStore(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    public static void permuteAndPrintStream(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return;
        }

        permuteAndPrintStream("", str);

    }

    private static void permuteAndPrintStream(String prefix, String str) {

        int n = str.length();
        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            IntStream.range(0, n)
                    .parallel()
                    .forEach(i -> permuteAndPrintStream(prefix + str.charAt(i),
                            str.substring(i + 1, n) + str.substring(0, i)));
        }
    }

    public static Stream<String> permuteAndReturnStream(String str) {

        if (str == null || str.isBlank()) {
            return Stream.of("");
        }

        return IntStream.range(0, str.length())
                .parallel()
                .boxed()
                .flatMap(i -> permuteAndReturnStream(str.substring(0, i) + str.substring(i + 1))
                        .map(c -> str.charAt(i) + c)
                );
    }

}