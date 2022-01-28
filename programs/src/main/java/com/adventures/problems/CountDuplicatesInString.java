package com.adventures.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CountDuplicatesInString {
    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";
    // Ӝ -> Unicode: \u04DC, Code Point: 1244
    // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
    // 🎼 -> \uD83C\uDFBC, Code Point: 127932
    // 😍 ->\uD83D\uDE0D, Code Point: 128525
    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

        System.out.println("HashMap based solution:");
        long startTimeV1 = System.nanoTime();

        Map<Character, Integer> duplicatesV1 = countDuplicateCharactersV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println(Arrays.toString(duplicatesV1.entrySet().toArray()));
        // or: duplicatesV1.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV2 = System.nanoTime();

        Map<Character, Long> duplicatesV2 = countDuplicateCharactersV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println(Arrays.toString(duplicatesV2.entrySet().toArray()));
        // or: duplicatesV2.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));

        System.out.println("\n--------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP + "\n");
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");
        System.out.println("HashMap based solution:");
        long startTimeV3 = System.nanoTime();

        Map<String, Integer> duplicatesV3 = countDuplicateCharactersVCP1(TEXT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println(Arrays.toString(duplicatesV3.entrySet().toArray()));
        // or: duplicatesV3.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV4 = System.nanoTime();

        Map<String, Long> duplicatesV4 = countDuplicateCharactersVCP2(TEXT_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println(Arrays.toString(duplicatesV4.entrySet().toArray()));
        // or: duplicatesV4.forEach( (k, v) -> System.out.print(k + "="+ v + ", "));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

    public static Map<Character, Integer> countDuplicateCharactersV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();

        // or use for(char ch: str.toCharArray()) { ... }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersVCP1(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            /*
            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() - 1 && str.codePointCount(i, i + 2) == 1) {
                i++;
            }
            */

            // or, like this (this code produce the same result as the commented code above
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) { // 2 means a suroggate pair
                i++;
            }

            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        // Call the String.chars() method on the original string. This will return IntStream. This IntStream contains an integer representation of the characters from the given string.
        //Transform IntStream into a stream of characters via the mapToObj() method (convert the integer representation into the human-friendly character form).
        //Finally, group the characters (Collectors.groupingBy()) and count them (Collectors.counting()).
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    public static Map<String, Long> countDuplicateCharactersVCP2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Collections.emptyMap();
        }

        // Solution to cover Unicode surrogate pairs can be done as follows:
        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}
