package com.adventures.problems;

import java.util.Scanner;

public class FactorialNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();

		System.out.print("Factorial without Recursion: ");
		factorialWithoutRecursion(number);

		System.out.println("Factorial without Recursion: " + factorialWithRecursion(number));

	}

	private static int factorialWithRecursion(int number) {
		if (number == 0) {
			return 1;
		} else {
			return factorialWithRecursion((number - 1)) * number;
		}
	}

	private static void factorialWithoutRecursion(int number) {
		int factorial = 1;
		while (number > 0) {
			factorial = factorial * number;
			number--;
		}
		System.out.println(factorial);
	}
}