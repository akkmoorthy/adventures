package com.adventures.algorithms.arrays;

public class DeleteOperationInSortedArray {

	public static void main(String[] args) {

		int i;
		int arr[] = { 10, 20, 30, 40, 50 };

		int valueToBeDeleted = 20;
		int length = arr.length;

		System.out.print("Array before deletion:\n");
		for (i = 0; i < length; i++)
			System.out.print(arr[i] + " ");

		length = deleteElement(arr, arr.length, valueToBeDeleted);

		System.out.print("\n\nArray after deletion:\n");
		for (i = 0; i < length; i++)
			System.out.print(arr[i] + " ");
	}

	/* Function to delete an element */
	static int deleteElement(int arr[], int length, int key) {
		// Find position of element to be deleted
		int pos = binarySearch(arr, 0, length - 1, key);

		if (pos == -1) {
			System.out.println("Element not found");
			return length;
		}

		int i;
		for (i = pos; i < length - 1; i++) {
			arr[i] = arr[i + 1];
		}

		return length - 1;
	}

	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low) {
			return -1;
		}

		int mid = (low + high) / 2;
		if (key == arr[mid]) {
			return mid;
		}
		if (key > arr[mid]) {
			return binarySearch(arr, (mid + 1), high, key);
		} else {
			return binarySearch(arr, low, (mid - 1), key);
		}
	}
}
