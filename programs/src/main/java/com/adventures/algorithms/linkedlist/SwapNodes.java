package com.adventures.algorithms.linkedlist;

public class SwapNodes {
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

		swapNodesMethod1(12, 20);

		System.out.print("\nAfter Swapping: ");
		printList();
		
		printMiddle();
	}

	static void printMiddle()
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("\nThe middle element is [" +
                                slow_ptr.data + "] \n");
        }
    }
	
	// private static void swapNodesMethod2(int x, int y) {
	// if (head == null || head.next == null) {
	// return;
	// }
	//
	// Node tmp = head;
	// Node nodeX = null;
	// Node nodeY = null;
	//
	// while (tmp != null) {
	// if (tmp.data == x) {
	// nodeX = tmp;
	// }
	// if (tmp.data == y) {
	// nodeY = tmp;
	// }
	//
	// tmp = tmp.next;
	// }
	//
	// if (nodeX == null || nodeY == null) {
	// return;
	// }
	//
	// swap(nodeX, nodeY);
	// swap(nodeX.next, nodeY.next);
	// }

	private static void swap(Node nodeX, Node nodeY) {
		Node tmpNode = nodeX;
		nodeX = nodeY;
		nodeY = tmpNode;
	}

	private static void swapNodesMethod1(int x, int y) {
		if (head == null || head.next == null) {
			return;
		}

		Node prevX = null;
		Node currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		Node prevY = null;
		Node currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (prevX == null || prevY == null) {
			return;
		}

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else // make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else // make x the new head
			head = currX;

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
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