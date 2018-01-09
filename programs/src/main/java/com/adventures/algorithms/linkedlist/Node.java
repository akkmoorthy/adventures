package com.adventures.algorithms.linkedlist;

public class Node {
	int data;
	String strData;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}

	Node(String d) {
		strData = d;
		next = null;
	}
}