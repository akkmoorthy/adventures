package com.adventures.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		insertionSort(new int[] { 12, 11, 13, 5, 6 });
	}

	private static void insertionSort(int[] arr) {
		System.out.println("Before Sorting: " + Arrays.toString(arr));

		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one
			 * position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
			System.out.println("After Swapping: " + Arrays.toString(arr));
		}

		System.out.println("After Sorting: " + Arrays.toString(arr));
	}
}