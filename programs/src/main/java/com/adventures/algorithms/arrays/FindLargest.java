package com.adventures.algorithms.arrays;

public class FindLargest {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 5, 9, 3, 9 };

		firstSmallest(arr);
		secondSmallest(arr);
	}

	private static void firstSmallest(int[] arr) {
		int firstLargest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstLargest) {
				firstLargest = arr[i];
			}
		}

		System.out.printf("First Largest number is %d\n", firstLargest);
	}

	private static void secondSmallest(int[] arr) {
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		/* There should be atleast two elements */
		if (arr.length < 2) {
			System.out.println(" Invalid Input ");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = arr[i];
			} else if (arr[i] > secondLargest && arr[i] != firstLargest)
				secondLargest = arr[i];
		}

		if (secondLargest == Integer.MIN_VALUE)
			System.out.println("There is no second largest element");
		else
			System.out.printf("Second Largest number is %d\n", secondLargest);
	}
}