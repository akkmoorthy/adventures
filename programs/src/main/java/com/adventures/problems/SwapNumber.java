package com.adventures.problems;

import java.util.Scanner;

public class SwapNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int first = scanner.nextInt();
		int second = scanner.nextInt();

		System.out.println("Before Swapping: \nFirst Number = " + first + " Second Number = " + second);
		swapNumber(first, second);
		swapNumberWithoutTempVariable(first, second);
		swapNumberAnotherMethod(first, second);
		swapNumberUsingXor(first, second);
		
		scanner.close();
	}
	
	private static void swapNumberWithoutTempVariable(int first, int second) {
		first = first + second; 
		second = first - second; // actually (first + second) - (second), so now second is equal to first 
		first = first - second; // (first + second) -(first), now first is equal to second 
		 
		System.out.println("After Swapping without temp variable: \nFirst Number = " + first + " Second Number = " + second);
	}
	
	private static void swapNumberAnotherMethod(int first, int second) {
		first = (first + second) - (second = first);
		System.out.printf("After swapping, 'first': %d, 'second': %d %n", first, second);
	}
	
	private static void swapNumberUsingXor(int first, int second) {
		first = first ^ second; 
		second = first ^ second; 
		first = first ^ second; 
		
		System.out.printf("After swapping using XOR, 'first': %d, 'second': %d %n", first, second);
	}
	
	private static void swapNumber(int first, int second) {
		int temp;
		
		temp = first;
		first = second;
		second = temp;
		
		System.out.println("After Swapping: \nFirst Number = " + first + " Second Number = " + second);
	}
}