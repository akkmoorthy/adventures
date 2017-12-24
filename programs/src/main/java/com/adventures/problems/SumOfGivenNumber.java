package com.adventures.problems;

import java.util.Scanner;

public class SumOfGivenNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		scanner.close();

		int sum = 0;
		while (number > 0) {
			int mod = number % 10;
			sum = sum + mod;
			number = number / 10;
		}
		System.out.printf("Sum is %d", sum);
	}
}