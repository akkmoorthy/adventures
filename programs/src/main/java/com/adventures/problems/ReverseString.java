package com.adventures.problems;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Time Complexity: O(n)
public class ReverseString {

    private static final Pattern PATTERN = Pattern.compile(" +");
    private static final String WHITESPACE = " ";
    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toReverse = scanner.nextLine();

        System.out.println("To reverse: " + toReverse);
        inPlaceReverse(toReverse);

        // Reverse the string using charAt string method
        reverseUsingCharAt(toReverse);

        // Reverse the string using ToCharArray string method
        reverseUsingToCharArray(toReverse);

        // Reverse the string using string buffer reverse method
        reverseUsingStringBufferReverseMethod(toReverse);

        // Reverse the string using recursive method
        System.out.println("Reversed String using recursive Method: " + reverseRecursively(toReverse));

        String reversedV2 = reverseWordsV2(TEXT);
        System.out.println("Reversed: \n" + reversedV2);

        scanner.close();
    }

    public static void inPlaceReverse(final String input) {
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++) {
            final char current = builder.charAt(i);
            final int otherEnd = length - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd));
            // swap
            builder.setCharAt(otherEnd, current);
        }
        System.out.println("Reversed String using inPlaceReverse Method: " + builder.toString());
    }

    private static void reverseUsingCharAt(String toReverse) {
        String reversedString = "";

        for (int i = toReverse.length() - 1; i >= 0; i--) {
            reversedString = reversedString + toReverse.charAt(i);
        }

        System.out.println("Reversed String using charAt Method: " + reversedString);
    }

    private static void reverseUsingToCharArray(String toReverse) {
        String reversedString = "";
        char[] tmp = toReverse.toCharArray();

        for (int i = tmp.length - 1; i >= 0; i--) {
            reversedString = reversedString + tmp[i];
        }

        System.out.println("Reversed String using toCharArray Method: " + reversedString);
    }

    private static void reverseUsingStringBufferReverseMethod(String toReverse) {
        String reversedString = new StringBuffer(toReverse).reverse().toString();
        System.out.println("Reversed String using StringBuffer Reverse Method: " + reversedString);
    }

    private static String reverseRecursively(String toReverse) {
        // base case to handle one char string and empty string
        if (toReverse.length() < 2) {
            return toReverse;
        }

        return reverseRecursively(toReverse.substring(1)) + toReverse.charAt(0);
    }

    public static String reverseWordsV2(String str) {

        // or throw IllegalArgumentException
        if (str == null || str.isBlank()) {
            return "";
        }

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }
}