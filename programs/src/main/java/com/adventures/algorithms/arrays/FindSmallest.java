package com.adventures.algorithms.arrays;

public class FindSmallest {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 5, 9, 3 };

		firstSmallest(arr);
		secondSmallest(arr);
	}

	private static void firstSmallest(int[] arr) {
		int firstSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < firstSmallest) {
				firstSmallest = arr[i];
			}
		}

		System.out.printf("First Smallest number is %d\n", firstSmallest);
	}

	private static void secondSmallest(int[] arr) {
		int firstSmallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		/* There should be atleast two elements */
		if (arr.length < 2) {
			System.out.println(" Invalid Input ");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < firstSmallest) {
				secondSmallest = firstSmallest;
				firstSmallest = arr[i];
			} else if (arr[i] < secondSmallest && arr[i] != firstSmallest)
				secondSmallest = arr[i];
		}

		if (secondSmallest == Integer.MAX_VALUE)
			System.out.println("There is no second" + "smallest element");
		else
			System.out.printf("Second Smallest number is %d\n", secondSmallest);
	}
}