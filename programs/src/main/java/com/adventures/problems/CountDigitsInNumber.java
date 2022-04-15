package com.adventures.problems;

import java.util.Scanner;

//Time Complexity: If D is no. of digits then it is theta(D)
public class CountDigitsInNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = scanner.nextInt();
		int temp = number;
		scanner.close();
		
		int count =0;
		while (number > 0 ) {
			number = number / 10;
			count++;
		}
		
		System.out.printf("Total Number of Digits in %d is %d", temp, count);
	}
}