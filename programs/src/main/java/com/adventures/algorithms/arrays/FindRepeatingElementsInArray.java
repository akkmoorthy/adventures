package com.adventures.algorithms.arrays;

public class FindRepeatingElementsInArray {

	// Method:1 - Use 2 loops and compare
	void printRepeatingUsingNestedLoop(int arr[], int size) {
		int i, j;
		System.out.print("Repeated Elements are: ");
		for (i = 0; i < size; i++) {
			for (j = i + 1; j < size; j++) {
				if (arr[i] == arr[j])
					System.out.print(arr[i] + " ");
			}
		}
	}

	void printRepeatingTempCountArray(int arr[], int size) {
		int count[] = new int[size];
		int i;

		System.out.print("Repeated elements are: ");
		for (i = 0; i < size; i++) {
			if (count[arr[i]] == 1)
				System.out.print(arr[i] + " ");
			else
				count[arr[i]]++;
		}
	}

	void printRepeatingUsingAbs(int arr[], int size) {
		int i;
		System.out.print("The repeating elements are: ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

	public static void main(String[] args) {
		FindRepeatingElementsInArray repeat = new FindRepeatingElementsInArray();
		int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
		int arr_size = arr.length;
		System.out.println("Using NestedLoop: ");
		repeat.printRepeatingUsingNestedLoop(arr, arr_size);
		System.out.println("\nUsing TempCountArray: ");
		repeat.printRepeatingTempCountArray(arr, arr_size);
		System.out.println("\nUsing ABS: ");
		repeat.printRepeatingUsingAbs(arr, arr_size);
	}
}