package com.adventures.algorithms.linkedlist;

public class NodeDeletionLinkedList {

	Node head; // head of list

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

	/* Given a position, delete in linked list */
	void deleteNodeAtPosition(int position) {

		if (head == null) {
			return;
		}

		Node tempNode = head;

		// If head node itself holds the position to be deleted
		if (position == 0) {
			head = tempNode.next;
			return;
		}

		Node previousNode = null;
		int count = 0;
		while (tempNode != null && count != position) {
			previousNode = tempNode;
			tempNode = tempNode.next;
			count++;
		}

		// If key was not present in linked list
		if (tempNode == null)
			return;

		// Unlink the node from linked list
		previousNode.next = tempNode.next;
	}

	public void printList() {
		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.next;
		}
	}

	public static void main(String[] args) {
		NodeDeletionLinkedList llist = new NodeDeletionLinkedList();
		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

		llist.deleteNode(1); // Delete key with 1
		System.out.println("\nLinked List after Deletion of key 1:");
		llist.printList();

		llist.deleteNodeAtPosition(2); // Delete position with 2
		System.out.println("\nLinked List after Deletion of position 2:");
		llist.printList();
	}
}