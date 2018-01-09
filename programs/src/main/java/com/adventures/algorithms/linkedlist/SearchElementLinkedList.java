package com.adventures.algorithms.linkedlist;

public class SearchElementLinkedList {
	Node head; // head of list

	/* Inserts a new Node at front of the list. */
	public void push(int newData) {
		Node newNode = new Node(newData);

		/* 3. Make next of new Node as head */
		newNode.next = head;

		/* 4. Move the head to point to new Node */
		head = newNode;
	}

	public int searchIterative(int key) {
		Node tempNode = head;

		int count = 0;
		while (tempNode != null) {
			if (tempNode.data == key) {
				return count;
			}
			count++;
			tempNode = tempNode.next;
		}
		return -1;
	}

	public int searchRecursive(Node node, int key, int position) {
		if (node == null) {
			return 0;
		}

		if (node.data == key) {
			return position;
		}

		position++;
		return searchRecursive(node.next, key, position);
	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list */
		SearchElementLinkedList llist = new SearchElementLinkedList();
		llist.push(8);
		llist.push(3);
		llist.push(1);
		llist.push(2);
		llist.push(4);
		llist.push(6);

		llist.printList();
		System.out.println("\nFound at position using Iterative method: " + llist.searchIterative(6));

		System.out.println("\nFound at position  using Recursive method: " + llist.searchRecursive(llist.head, 4, 1));
	}
}