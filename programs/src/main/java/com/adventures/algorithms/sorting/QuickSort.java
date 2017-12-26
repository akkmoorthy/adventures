package com.adventures.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String args[]) {
		// unsorted integer array
		int[] unsorted = { 6, 5, 3, 1, 8, 7, 2, 4 };
		System.out.println("Unsorted array :" + Arrays.toString(unsorted));
		sort(unsorted);
		System.out.println("Sorted array :" + Arrays.toString(unsorted));
	}

	public static void sort(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return;
		}
		quickSort(numbers, 0, numbers.length - 1);
	}

	/* * This method implements in-place quicksort algorithm recursively. */
	private static void quickSort(int[] input, int low, int high) {
		int i = low;
		int j = high;
		// pivot is middle index
		int pivot = input[(low + high) / 2];
		// Divide into two arrays
		while (i <= j) {
			while (input[i] < pivot) {
				i++;
			}
			while (input[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(input, i, j);
				// move index to next position on both sides
				i++;
				j--;
			}

			System.out.println("After Swapping :" + Arrays.toString(input));
		}
		// calls quickSort() method recursively
		if (low < j) {
			quickSort(input, low, j);
		}
		if (i < high) {
			quickSort(input, i, high);
		}
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}