package com.adventures.algorithms.search;

//Java program to implement linear 
//search in unsorted arrays

class LinearSearch {
	/*
	 * Function to implement search operation
	 */
	static int findElement(int arr[], int n, int key) {
		for (int i = 0; i < n; i++)
			if (arr[i] == key)
				return i;

		return -1;
	}

	// main Function
	public static void main(String args[]) {
		int arr[] = { 12, 34, 10, 6, 40 };
		int n = arr.length;

		// Using a last element as search element
		int key = 40;
		int position = findElement(arr, n, key);

		if (position == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element Found at Position: " + (position + 1));
	}
}
