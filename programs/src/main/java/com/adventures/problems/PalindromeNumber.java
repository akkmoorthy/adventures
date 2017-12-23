package com.adventures.problems;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {

		System.out.println("Enter the number to reverse");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int original = n;

		scanner.close();

		int reversedNumber = 0;
		while (n > 0) {
			reversedNumber = (reversedNumber * 10) + (n % 10);
			n = n / 10;
		}

		if ( original == reversedNumber ) {
			System.out.println(original + " is a Palindrome Number");
		} else {
			System.out.println(original + " is not a Palindrome Number");
		}
		
	}
}