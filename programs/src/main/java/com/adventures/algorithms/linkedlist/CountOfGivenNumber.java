package com.adventures.algorithms.linkedlist;

//Java program to count occurrences in a linked list
public class CountOfGivenNumber {
	Node head; // head of list

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

	/*
	 * Counts the no. of occurences of a node (search_for) in a linked list
	 * (head)
	 */
	int count(int search_for) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (current.data == search_for)
				count++;
			current = current.next;
		}
		return count;
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

	/* Drier function to test the above methods */
	public static void main(String args[]) {
		CountOfGivenNumber llist = new CountOfGivenNumber();

		/*
		 * Use push() to construct below list 1->2->1->3->1
		 */
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(3);
		llist.push(1);

		llist.printList();

		/* Checking count function */
		System.out.println("\nCount of 1 is " + llist.count(1));
	}
}
