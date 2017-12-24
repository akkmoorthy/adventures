package com.adventures.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListScenarios {

	public static void main(String[] args) {
		listWithoutGeneric();
		listWithGeneric();
	}

	private static void listWithoutGeneric() {
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add(3);
		list.add("4");

		System.out.println("listWithoutGeneric -" + list);
	}
	
	private static void listWithGeneric() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
//		list.add(3);
		list.add("4");

		System.out.println("listWithGeneric -" + list);
	}
}