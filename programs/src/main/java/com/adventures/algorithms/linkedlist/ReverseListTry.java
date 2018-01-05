package com.adventures.algorithms.linkedlist;

public class ReverseListTry {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	Node reverse(Node node) {
		if (node == null)
			return null;

		Node prev = null;
		Node next = null;
		Node current = node;
		while (current != null) {
			next = current.next;
			current.next = prev;

			prev = current;
			current = next;
		}

		node = prev;
		return head;
	}

	public static void main(String[] args) {
		ReverseListTry list = new ReverseListTry();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}
}
