package com.adventures.problems;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveGivenCharacterInString {

    private static final String TEXT = "oobotooorogshŜoootorgo";
    private static final char CHAR = 'Ŝ';

    private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
    private static final String CHAR_CP = "Ӝ";   // Unicode: \u04DC, Code Point: 1244
    private static final String CHAR_CPS = "💕"; // Unicode: \uD83D\uDC95, Code Point: 128149

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT);
        System.out.println("Character to remove: " + CHAR + "\n");

        System.out.println("StringBuilder based solution:");
        long startTimeV1 = System.nanoTime();

        String resultV1 = removeCharacterV1(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Result: \n" + resultV1);

        System.out.println();
        System.out.println("Regular expression based solution:");
        long startTimeV2 = System.nanoTime();

        String resultV2 = removeCharacterV2(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Result: \n" + resultV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        String resultV3 = removeCharacterV3(TEXT, CHAR);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Result: \n" + resultV3);

        System.out.println();
        System.out.println("Java 8, function-style solution (code point)");
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CP + "\n");
        long startTimeV4 = System.nanoTime();

        String resultV4 = removeCharacterV4(TEXT_CP, CHAR_CP);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("Result: \n" + resultV4);

        System.out.println();
        System.out.println("Java 8, function-style solution (code point)");
        System.out.println("Input text: \n" + TEXT_CP);
        System.out.println("Character to remove: " + CHAR_CPS + "\n");
        long startTimeV5 = System.nanoTime();

        String resultV5 = removeCharacterV4(TEXT_CP, CHAR_CPS);

        displayExecutionTime(System.nanoTime() - startTimeV5);
        System.out.println("Result: \n" + resultV5);
    }


    public static String removeCharacterV1(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (char c : chArray) {
            if (c != ch) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeCharacterV2(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    public static String removeCharacterV3(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeCharacterV4(String str, String ch) {

        if (str == null || ch == null || str.isEmpty() || ch.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        if (ch.codePointCount(0, ch.length()) != 1) {
            return ""; // there is more than 1 Unicode character in the given String
        }

        int codePoint = ch.codePointAt(0);

        return str.codePoints()
                .filter(c -> c != codePoint)
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.joining());
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
