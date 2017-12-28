package com.adventures.algorithms.linkedlist;

public class FindPositionFromLast {

	Node head; // head of the list

	/* Linked List node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * This function prints contents of linked list starting from the given node
	 */
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + "->");
			tnode = tnode.next;
		}
	}

	private void printNthFromLast(int position) {
		if (head == null) {
			return;
		}

		int length = 0;
		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}

		System.out.println("\nLength = " + length);

		tmp = head;
		for (int i = 0; tmp != null && i < length - position; i++) {
			tmp = tmp.next;
		}

		System.out.printf("Position = %d Data = %d", position, tmp.data);

	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Drier program to test above methods */
	public static void main(String[] args) {
		FindPositionFromLast llist = new FindPositionFromLast();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		llist.printList();

		llist.printNthFromLast(3);
	}
}
