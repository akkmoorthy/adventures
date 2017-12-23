package com.adventures.problems;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();

		System.out.println("Fibonacci Series:");
		findFibonacciSeries(number);

		System.out.println("\nFibonacci Series until a given Number:");
		findFibonacciSeriesUntilGivenNumber(number);

		System.out.println("\nFibonacci Series until a given Number using Recursive method:");
		printFibonacciRecursively(number);
		
		System.out.println("\nFibonacci Series using Array:");
		fibonacciUsingArray(number);
	}

	private static void findFibonacciSeries(int number) {
		int previousNumber = 0;
		int current = 1;

		for (int i = 1; i <= number; i++) {
			System.out.print(previousNumber + " ");

			int sum = previousNumber + current;
			previousNumber = current;
			current = sum;
		}
	}

	private static void findFibonacciSeriesUntilGivenNumber(int number) {
		int previousNumber = 0;
		int current = 1;

		while (previousNumber <= number) {
			System.out.print(previousNumber + " ");

			int sum = previousNumber + current;
			previousNumber = current;
			current = sum;
		}
	}

	static int previousNumber = 0;
	static int current = 1;

	private static void printFibonacciRecursively(int number) {
		if (number > 0) {
			System.out.print(previousNumber + " ");
			int sum = previousNumber + current;
			previousNumber = current;
			current = sum;
			
			printFibonacciRecursively(number - 1);
		}
	}

	private static void fibonacciUsingArray(int number) {
		int[] feb = new int[number];
		feb[0] = 0;
		feb[1] = 1;
		for (int i = 2; i < number; i++) {
			feb[i] = feb[i - 1] + feb[i - 2];
		}

		for (int i = 0; i < number; i++) {
			System.out.print(feb[i] + " ");
		}
	}
}