package com.adventures.algorithms.arrays;

import java.util.Arrays;
import java.util.BitSet;

//You are given a list of n-1 integers and these integers are in the range of 1 to n. 

//There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

//Time Complexity: O(n)
public class FindMissingNumber {
	// Function missing number

	// Method 1:
	/*
	 * 1. Get the sum of numbers total = n*(n+1)/2 2. Subtract all the numbers
	 * from sum and you will get the missing number.
	 */
	static int getMissingNo(int a[], int n) {
		int i, total;
		// The below is without considering 1 missing number
		// total = n * (n + 1) / 2;

		// Take the missing number as well in the length
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total = total - a[i];

		return total;
	}

	// Method 2:
	static int getMissingNoUsingXor(int a[], int n) {
		int i;
		int x1 = a[0];
		int x2 = 1;

		/* For xor of all the elements in array */
		for (i = 1; i < n; i++) {
			x1 = x1 ^ a[i];
		}

		/* For xor of all the elements from 1 to n+1 */
		for (i = 2; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}

		return (x1 ^ x2);
	}

	private static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);
		for (int number : numbers) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers),
				count);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}
	}

	/* program to test above function */
	public static void main(String args[]) {
		int a[] = { 1, 2, 4, 5, 6 };

		int miss = getMissingNo(a, a.length);
		System.out.println("Using Method 1: " + miss);

		miss = getMissingNoUsingXor(a, a.length);
		System.out.println("Using XOR " + miss);

		// one missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6 }, 6);

		// two missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6, 7, 9, 8, 10 }, 10);

		// three missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6, 9, 8 }, 10);

		// four missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 9, 8 }, 10);
	}
}