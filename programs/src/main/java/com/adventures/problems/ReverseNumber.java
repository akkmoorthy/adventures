package com.adventures.problems;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println("Enter the number to reverse");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int original = n;
		scanner.close();

		int reversedNumber = 0;
		
		//The below is to reverse using while loop
		while (n > 0) {
			reversedNumber = (reversedNumber * 10) + (n % 10);
			n = n / 10;
		}
		System.out.println("Reversed Number using while loop: " + reversedNumber);
		
		//The below is to reverse using for loop
		reversedNumber = 0;
		for(;original != 0; original /= 10) {
            reversedNumber = (reversedNumber * 10) + (original % 10);
        }
		System.out.println("Reversed Number using For loop: " + reversedNumber);
	}
}