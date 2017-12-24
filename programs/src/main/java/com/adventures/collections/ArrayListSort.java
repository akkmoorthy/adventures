package com.adventures.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSort {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Anil");
		list.add("Fahad");
		list.add("Charan");
		list.add("Babu");
		
		System.out.println("Without Sorting -" + list);
		
		Collections.sort(list);
		
		System.out.println("After Sorting -" + list);
		Collections.reverse(list);
		System.out.println("After Reverse Sorting -" + list);
		
		removeNegative();
	}

	static void removeNegative() {
		
		ArrayList<ArrayList<Integer>> array =
	            new ArrayList<ArrayList<Integer>>();
	        for(int i=0; i<10000; i++) {
	            try {
	                array.add(new ArrayList<Integer>(1000000));
	            } catch (OutOfMemoryError e) {
	                System.out.println(i);
	                break;
	            }
	        }
	}
}

