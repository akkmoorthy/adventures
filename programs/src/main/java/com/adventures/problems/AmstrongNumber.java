package com.adventures.problems;

import java.util.Scanner;

public class AmstrongNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number:");
		int number = scanner.nextInt();
		scanner.close();

		int original = number;
		usingModulus(number, original);
	}

	private static void usingModulus(int number, int original) {
		int sum = 0;
		while (number > 0) {
			int mod = number % 10;
			sum = sum + (mod * mod * mod);
			number = number / 10;
		}

		if (original == sum) {
			System.out.println(original + " is a Amsrtong Number");
		} else {
			System.out.println(original + " is a not Amsrtong Number");
		}
	}
}
