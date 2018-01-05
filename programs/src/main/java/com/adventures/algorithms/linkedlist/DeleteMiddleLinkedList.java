package com.adventures.algorithms.linkedlist;

public class DeleteMiddleLinkedList {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void deleteNode(int key) {
		Node tempNode = head;
		Node previousNode = null;

		// If head node itself holds the key to be deleted
		if (tempNode != null && tempNode.data == key) {
			head = tempNode.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (tempNode != null && tempNode.data != key) {
			previousNode = tempNode;
			tempNode = tempNode.next;
		}

		// If key was not present in linked list
		if (tempNode == null)
			return;

		// Unlink the node from linked list
		previousNode.next = tempNode.next;
	}

	/* Given a position, delete middle node in linked list */
	void deleteMiddleNode() {
		if (head == null) {
			return;
		}

		if (head.next == null) {
			head = null;
			return;
		}

		Node fast = head;
		Node middle = head;
		Node previousNode = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			previousNode = middle;
			middle = middle.next;
		}

		// Unlink the node from linked list
		previousNode.next = middle.next;
	}

	public void printList() {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
	}

	public static void main(String[] args) {
		DeleteMiddleLinkedList llist = new DeleteMiddleLinkedList();
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

		llist.deleteMiddleNode(); // Delete key with 1
		System.out.println("\nLinked List after Deletion of middle node:");
		llist.printList();

		DeleteMiddleLinkedList llist1 = new DeleteMiddleLinkedList();
		llist1.push(5);
		llist1.push(4);
		llist1.push(3);
		llist1.push(2);
		llist1.push(1);

		System.out.println("\nCreated Linked list is:");
		llist1.printList();

		llist1.deleteMiddleNode(); // Delete key with 1
		System.out.println("\nLinked List after Deletion of middle node:");
		llist1.printList();

		DeleteMiddleLinkedList llist2 = new DeleteMiddleLinkedList();
		llist2.push(5);

		System.out.println("\nCreated Linked list is:");
		llist2.printList();

		llist2.deleteMiddleNode(); // Delete key with 1
		System.out.println("\nLinked List after Deletion of middle node:");
		llist2.printList();
	}
}