package com.adventures.algorithms.linkedlist;

public class FindLengthLinkedList {

	Node head; // head of list

	/* Inserts a new Node at front of the list. */
	public void push(int newData) {
		Node newNode = new Node(newData);

		/* 3. Make next of new Node as head */
		newNode.next = head;

		/* 4. Move the head to point to new Node */
		head = newNode;
	}

	public int getCountIterative() {

		Node tempNode = head;

		int count = 0;

		while (tempNode != null) {
			count++;
			tempNode = tempNode.next;
		}
		return count;
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		FindLengthLinkedList llist = new FindLengthLinkedList();
		llist.push(1);
		llist.push(3);
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(1);

		System.out.println("Count of nodes using Iterative method is " + llist.getCountIterative());

		llist.push(1);
		System.out.println("Count of nodes using Recursive method is " + llist.getCount());
	}

	public int getCount() {
		return getCountRecursive(head);
	}

	public int getCountRecursive(Node node) {
		if (node == null) {
			return 0;
		}

		return getCountRecursive(node.next) + 1;
	}
}