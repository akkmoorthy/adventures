package com.adventures.algorithms.arrays;

// Time Complexity: O(n)
public class ReverseString {

	public static void main(String[] args) {
		String toReverse = "Example";
		String reversedString = "";
		System.out.println("To reverse: " + toReverse);
		for (int i = toReverse.length() - 1; i >= 0; i--) {
			reversedString += toReverse.charAt(i);
		}
		System.out.println("Reversed String: " + reversedString);
	}
}