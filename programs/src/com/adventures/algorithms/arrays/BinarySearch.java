package com.adventures.algorithms.arrays;

//Java program to implement binary search in a sorted array
//Worst Case - O(log n)
//Best Case - constant time
//Average Case - O(log n)
class BinarySearch {
	// function to implement
	// binary search
	static int binarySearch(int arr[], int low, int high, int key) {
		// If low and high are 0 then return -1
		if (high < low)
			return -1;

		// low is 0 and high is 6. (0 + 6 / 2) = 3
		int mid = (low + high) / 2;

		// If the key which needs to be searched is the mid of the array return
		// that.
		if (key == arr[mid])
			return mid;

		// If key > arr[mid] traverse above
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);

		// If key < arr[mid] traverse lower
		return binarySearch(arr, low, (mid - 1), key);
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10 };
		int n, key;
		n = arr.length;
		key = 15;

		System.out.println("Index: " + binarySearch(arr, 0, n, key));
	}
}
