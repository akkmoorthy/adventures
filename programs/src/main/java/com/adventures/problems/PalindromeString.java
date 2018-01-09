package com.adventures.problems;

public class PalindromeString {
	public static void main(String args[]) {
		System.out.println("Is aaa palindrom?: " + isPalindromUsingCharAt("aaa"));
		System.out.println("Is abca palindrom?: " + isPalindromUsingCharAt("abca"));
		System.out.println("Is bbbb palindrom?: " + isPalindromUsingCharAt("bbbb"));
		System.out.println("Is defg palindrom?: " + isPalindromUsingCharAt("defg"));

		System.out.println("Is aaa palindrom?: " + isPalindromString("aaa"));
		System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
		System.out.println("Is bbbb palindrom?: " + isPalindromString("bbbb"));
		System.out.println("Is defg palindrom?: " + isPalindromString("defg"));
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
}