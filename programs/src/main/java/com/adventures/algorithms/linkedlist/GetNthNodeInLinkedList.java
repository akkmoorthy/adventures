package com.adventures.algorithms.linkedlist;

// Java program to find n'th node in linked list

class GetNthNodeInLinkedList {
	Node head; // the head of list

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Takes index as argument and return data at index */
	public int GetNth(int index) {
		Node current = head;
		int count = 0;
		/*
		 * index of Node we are currently looking at
		 */
		while (current != null && count != index) {
			count++;
			current = current.next;
		}

		if (current == null) {
			return -1;
		}

		return current.data;
	}

	/*
	 * Given a reference to the head of a list and an int, inserts a new Node on the
	 * front of the list.
	 */
	public void push(int new_data) {

		/* 1. alloc the Node and put data */
		Node new_Node = new Node(new_data);

		/* 2. Make next of new Node as head */
		new_Node.next = head;

		/* 3. Move the head to point to new Node */
		head = new_Node;
	}

	/* Drier program to test above functions */
	public static void main(String[] args) {
		/* Start with empty list */
		GetNthNodeInLinkedList llist = new GetNthNodeInLinkedList();

		/*
		 * Use push() to construct below list 1->12->1->4->1
		 */
		llist.push(1);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		/* Check the count function */
		System.out.println("Element at index 3 is " + llist.GetNth(3));
	}
}