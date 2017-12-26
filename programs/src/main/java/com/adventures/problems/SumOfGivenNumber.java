package com.adventures.problems;

import java.util.Scanner;

public class SumOfGivenNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		scanner.close();

		sumUsingIterative(number);
		System.out.printf("Sum using Recursive is %d\n", sumOfDigitsRecursively(number));
	}

	private static void sumUsingIterative(int number) {
		int sum = 0;
		while (number > 0) {
			int mod = number % 10;
			sum = sum + mod;
			number = number / 10;
		}
		System.out.printf("Sum using Iteratevie is %d\n", sum);
	}

	public static int sumOfDigitsRecursively(int number) {
		if (number / 10 == 0)
			return number;
		return number % 10 + sumOfDigitsRecursively(number / 10);
	}
}