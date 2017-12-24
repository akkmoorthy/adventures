package com.adventures.algorithms.search;

//Java program to implement binary search in a sorted array
//Worst Case - O(log n)
//Best Case - constant time
//Average Case - O(log n)
class BinarySearch {
	// function to implement
	// binary search
	static int binarySearchRecursive(int arr[], int low, int high, int key) {
		// If low and high are 0 then return -1
		if (low > high)
			return -1;

		// low is 0 and high is 6. (0 + 6 / 2) = 3
		int mid = (low + high) / 2;

		// If the key to be searched is the mid of the array return that
		if (key == arr[mid])
			return mid;

		// If key > arr[mid] traverse above
		if (key > arr[mid])
			return binarySearchRecursive(arr, (mid + 1), high, key);

		// If key < arr[mid] traverse lower
		return binarySearchRecursive(arr, low, (mid - 1), key);
	}

	static int binarySearchIterative(int arr[], int low, int high, int key) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10 };
		int n, key;
		n = arr.length;
		key = 10;

		System.out.println("Search using Iterative: Index: " + binarySearchIterative(arr, 0, n-1, key));
		System.out.println("Search using Recursive: Index: " + binarySearchRecursive(arr, 0, n-1, key));
	}
}
