package com.adventures.algorithms.arrays;

//Java program to implement binary search in a sorted array
//Worst Case - O(log n)
//Best Case - constant time
//Average Case - O(log n)
class BinarySearchFirstAndLastOccurrence {

	static int binarySearchFirstOccurrence(int arr[], int low, int high, int key) {
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				result = mid;
				high = mid - 1;
			} else if (key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	static int binarySearchLastOccurrence(int arr[], int low, int high, int key) {

		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				result = mid;
				low = mid + 1;
			} else if (key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return result;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 8, 8 };
		int n, key;
		n = arr.length;
		key = 8;

		System.out.println("First Occurrence Index: " + binarySearchFirstOccurrence(arr, 0, n - 1, key));
		System.out.println("Last Occurrence Index: " + binarySearchLastOccurrence(arr, 0, n - 1, key));
	}
}
