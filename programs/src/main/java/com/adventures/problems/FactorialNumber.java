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

	//Time Complexity: If D is no. of digits then it is theta(n) and theta(n) auxiliary space hence iterative is better
	private static int factorialWithRecursion(int number) {
		if (number == 0) {
			return 1;
		} else {
			return number * factorialWithRecursion((number - 1));
		}
	}

	//Time Complexity: If D is no. of digits then it is O(n)
	private static void factorialWithoutRecursion(int number) {
		int factorial = 1;
		while (number > 0) {
			factorial = factorial * number;
			number--;
		}
		System.out.println(factorial);
	}
}