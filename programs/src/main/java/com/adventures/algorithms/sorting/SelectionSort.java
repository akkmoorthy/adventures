package com.adventures.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		selectionSort(new int[] { 20, 12, 45, 19, 91, 55 });
	}

	private static void selectionSort(int[] arr) {
		System.out.println("Before Sorting: " + Arrays.toString(arr));

		int minIndex = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swapNumber(arr, minIndex, i);
		}

		System.out.println("After Sorting: " + Arrays.toString(arr));
	}

	private static void swapNumber(int[] arr, int minIndex, int i) {
		int temp = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = temp;
	}
}