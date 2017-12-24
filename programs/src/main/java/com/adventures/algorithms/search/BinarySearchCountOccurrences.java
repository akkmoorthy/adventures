package com.adventures.algorithms.search;

//Java program to implement binary search in a sorted array
//Worst Case - O(log n)
//Best Case - constant time
//Average Case - O(log n)
class BinarySearchCountOccurrences {

	static int binarySearch(int arr[], int low, int high, int key, boolean isFirst) {
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				result = mid;
				if (isFirst) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
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
		int arr[] = { 5, 6, 7, 8, 8, 9 };
		int n, key;
		n = arr.length;
		key = 8;

		int firstIndex = binarySearch(arr, 0, n - 1, key, true);
		int lastIndex = 0;
		if (firstIndex == -1) {
			System.out.println("No Occurrences");
		} else {
			lastIndex = binarySearch(arr, 0, n - 1, key, false);
			System.out.println("firstIndex: " + firstIndex + "\nlastIndex: " + lastIndex + "\nNumber of occurrences: "
					+ (lastIndex - firstIndex + 1));
		}
	}
}