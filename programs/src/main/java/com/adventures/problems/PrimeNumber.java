package com.adventures.problems;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter any number:");
		int prime = scanner.nextInt();
		scanner.close();

		int temp;
		boolean isPrime = true;

		if (prime == 0 || prime == 1) {
			System.out.println(prime + " is not a Prime Number");
		} else {
			for (int i = 2; i <= prime / 2; i++) {
				System.out.println(i);
				temp = prime % i;
				if (temp == 0) {
					isPrime = false;
					break;
				}
			}
		}
		// If isPrime is true then the number is prime else not
		if (isPrime)
			System.out.println(prime + " is a Prime Number");
		else
			System.out.println(prime + " is not a Prime Number");
	}
}