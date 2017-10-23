package com.adventures.algorithms.arrays;

public class InsertOperationInSortedArray {

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = new int[20];
		arr[0] = 12;
		arr[1] = 16;
		arr[2] = 20;
		arr[3] = 40;
		arr[4] = 50;
		arr[5] = 70;

		int valueToBeInserted = 26;
		int totalElementsPresent = 6;

		System.out.print("\nBefore Insertion: ");
		for (int i = 0; i < totalElementsPresent; i++) {
			System.out.print(arr[i] + " ");
		}

		// Inserting key
		totalElementsPresent = insertSorted(arr, totalElementsPresent, valueToBeInserted, arr.length);

		System.out.print("\nAfter Insertion: ");
		for (int i = 0; i < totalElementsPresent; i++)
			System.out.print(arr[i] + " ");
	}

	private static int insertSorted(int[] arr, int totalElementsPresent, int valueToBeInserted, int length) {

		if (totalElementsPresent >= length) {
			return totalElementsPresent;
		}

		int i;

		for (i = totalElementsPresent - 1; (arr[i] > valueToBeInserted && i >= 0); i--) {
			arr[i + 1] = arr[i];
		}

		arr[i + 1] = valueToBeInserted;

		//The below solution is another way of doing
		/*
		 * for (i = totalElementsPresent - 1; i >= 0; i--) {
		 * System.out.println("i= " + i);
		 * if ( arr[i] > valueToBeInserted) {
		 * arr[i + 1] = arr[i]; 
		 * } else { 
		 * arr[i + 1] = valueToBeInserted;
		 * break;
		 * } }
		 */

		return (totalElementsPresent + 1);
	}
}