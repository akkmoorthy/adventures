package com.adventures.algorithms.arrays;

//Time Complexity: O(n)
public class ReverseArrayIterative {

	/* Function to reverse arr[] from start to end */
	static void reverseArray(int arr[], int start, int end) {
		int temp;

		for (;end > start; start++, end--) {
		temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		}
	}

	/* Utility that prints out an array on a line */
	static void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		printArray(arr, arr.length);
		reverseArray(arr, 0, arr.length-1);
		System.out.println("Reversed array is ");
		printArray(arr, arr.length);
	}
}