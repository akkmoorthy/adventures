package com.adventures.algorithms.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		bubbleSort(new int[] { 20, 12, 45, 19, 91, 55 });

		bubbleSortImproved(new int[] { 20, 12, 45, 19, 91, 55 });
	}

	private static void bubbleSort(int[] arr) {
		System.out.print("Array Before Sorting: ");
		printArray(arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					swapNumber(arr, i, j);
				}
			}
		}
		
		System.out.print("\nArray After Sorting: ");
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for (int number : arr) {
			System.out.print(number + " ");
		}
	}

	public static void bubbleSortImproved(int[] arr) {
		System.out.print("\nArray Before Sorting: ");
		printArray(arr);
		
		boolean swapped = true;
		int last = arr.length - 2;
		// only continue if swapping of number has occurred
		while (swapped) {
			swapped = false;
			for (int i = 0; i <= last; i++) {
				if (arr[i] > arr[i + 1]) {
					// pair is out of order, swap them
					swapNumber(arr, i, i + 1);
					swapped = true;
					// swapping occurred
				}
			}
			// after each pass largest element moved to end of array
			last--;
		}
		
		System.out.print("\nArray After Sorting: ");
		printArray(arr);
	}

	private static void swapNumber(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}