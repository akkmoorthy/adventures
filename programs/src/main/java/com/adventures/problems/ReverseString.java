package com.adventures.problems;

import java.util.Scanner;

// Time Complexity: O(n)
public class ReverseString {

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
}