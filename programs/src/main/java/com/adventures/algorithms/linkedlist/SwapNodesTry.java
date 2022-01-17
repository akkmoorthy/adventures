package com.adventures.algorithms.linkedlist;

public class SwapNodesTry {

	private static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		push(14);
		push(20);
		push(13);
		push(12);
		push(15);
		push(10);

		System.out.print("Before Swapping: ");
		printList();

		// swapNodesMethod2(12, 20);

//		swapNodesMethod1(12, 20);

		System.out.print("\nAfter Swapping: ");
		printList();
	}

	private static void swapNodes(int x, int y) {
		if ( head == null ) {
			return;
		}
		
		Node nodeX = null;
		Node nodeY = null;
		Node tmp = head;
		
		while (tmp != null) {
			
		}
	}

	private static void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	private static void printList() {
		if (head == null) {
			return;
		}

		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}
}