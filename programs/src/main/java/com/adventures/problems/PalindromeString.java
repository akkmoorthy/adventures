package com.adventures.problems;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PalindromeString {

    private static final String TEXT = "ABCDEFEDCBA";

    public static void main(String args[]) {
        System.out.println("Is aaa palindrom?: " + isPalindromUsingCharAt("aaa"));
        System.out.println("Is abca palindrom?: " + isPalindromUsingCharAt("abca"));
        System.out.println("Is bbbb palindrom?: " + isPalindromUsingCharAt("bbbb"));
        System.out.println("Is defg palindrom?: " + isPalindromUsingCharAt("defg"));

        System.out.println("Is aaa palindrom?: " + isPalindromString("aaa"));
        System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
        System.out.println("Is bbbb palindrom?: " + isPalindromString("bbbb"));
        System.out.println("Is defg palindrom?: " + isPalindromString("defg"));


        System.out.println("Meet-in-the-middle 'while' solution:");
        long startTimeV1 = System.nanoTime();

        boolean resultV1 = isPalindromeV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV1);

        System.out.println();

        System.out.println("StringBuilder solution:");
        long startTimeV3 = System.nanoTime();

        boolean resultV3 = isPalindromeV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV3);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV4 = System.nanoTime();

        boolean resultV4 = isPalindromeV4(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV4);
        System.out.println("'" + TEXT + "' is palindrome? " + resultV4);
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }

    public static boolean isPalindromeV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (right > left) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromUsingCharAt(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * Java method to check if given String is Palindrome
     *
     * @param text
     * @return true if text is palindrome, otherwise false
     */
    public static boolean isPalindromString(String text) {
        String reverse = reverse(text);
        if (text.equals(reverse)) {
            return true;
        }
        return false;
    }

    /**
     * Java method to reverse String using recursion
     *
     * @param input
     * @return reversed String of input
     */
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }


    public static boolean isPalindromeV3(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean isPalindromeV4(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return false;
        }

        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }
}