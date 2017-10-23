package com.adventures.algorithms.arrays;

//Find duplicates in O(n) time and O(1) extra space | Set 1

//Time Complexity: O(n)
//Auxiliary Space: O(1)
class FindDuplicate {
	void printRepeatingUsingAbs(int arr[], int size) {
		int i;
		System.out.print("The repeating elements are: ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

	void printRepeating( int arr[], int n)
	{
	    // First check all the values that are
	    // present in an array then go to that
	    // values as indexes and increment by
	    // the size of array
	    for (int i = 0; i < n; i++)
	    {
	        int index = arr[i] % n;
	        arr[index] += n;
	    }
	 
	    // Now check which value exists more
	    // than once by dividing with the size
	    // of array
	    for (int i = 0; i < n; i++)
	    {
	        if ((arr[i]/n) > 1)
	        	System.out.print(i + " ");
	    }
	}
	
	/* Driver program to test the above function */
	public static void main(String[] args) {
		FindDuplicate duplicate = new FindDuplicate();
		int arr[] = {1, 6, 3, 1, 3, 6, 6};
		System.out.println("\nUsing ABS: ");
		duplicate.printRepeatingUsingAbs(arr, arr.length);
		
		int array[] = {1, 6, 3, 1, 3, 6, 6};
		System.out.println("\nUsing Another Method: ");
		duplicate.printRepeating(array, array.length);
	}
}