package com.adventures.algorithms.linkedlist;

public class NodeCreationLinkedList {
	private Node head;

	/* method to create a simple linked list with 3 nodes */
	public static void main(String[] args) {
		/* Start with the empty list. */
		NodeCreationLinkedList llist = new NodeCreationLinkedList();

		/* Three nodes have been allocated dynamically.
		We have references to these three blocks as first,  
		second and third

		llist.head        second              third
		   |                |                  |
		   |                |                  |
		+----+------+     +----+------+     +----+------+
		| 1  | null |     | 2  | null |     |  3 | null |
		+----+------+     +----+------+     +----+------+ */
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		/*  Now next of first Node refers to second.  So they
		  both are linked.

		llist.head        second              third
		  |                |                  |
		  |                |                  |
		+----+------+     +----+------+     +----+------+
		| 1  |  o-------->| 2  | null |     |  3 | null |
		+----+------+     +----+------+     +----+------+ */
		llist.head.next = second;

		/*  Now next of second Node refers to third.  So all three
		  nodes are linked.

		llist.head        second              third
		  |                |                  |
		  |                |                  |
		+----+------+     +----+------+     +----+------+
		| 1  |  o-------->| 2  |  o-------->|  3 | null |
		+----+------+     +----+------+     +----+------+ */
		second.next = third;

		llist.printList();

		System.out.println("\nInsert node in front");
		llist.insertNodeInFront(4);
		llist.printList();

		System.out.println("\nInsert node in between");
		llist.insertAfterNode(llist.head.next, 8);
		llist.printList();

		System.out.println("\nInsert node in last");
		llist.insertNodeInLast(5);
		llist.printList();
	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void insertNodeInFront(int data) {
		Node fourth = new Node(data);
		fourth.next = head;
		head = fourth;
	}

	public void insertAfterNode(Node node, int data) {

		if (node == null) {
			System.out.println("The given previous node cannot be null");
			return;
		}

		Node newNode = new Node(data);

		if (node.next == null) {
			node.next = newNode;
			return;
		} else {
			newNode.next = node.next;
			node.next = newNode;
		}
	}

	public void insertNodeInLast(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node last = new Node(data);
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = last;
	}
}

/* Linked list Node */
class Node {
	int data;
	Node next;

	// Constructor to create a new node
	Node(int d) {
		data = d;
	}
}