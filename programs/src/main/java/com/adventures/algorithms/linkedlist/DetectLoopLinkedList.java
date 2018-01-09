package com.adventures.algorithms.linkedlist;

import java.util.HashSet;

public class DetectLoopLinkedList {
	Node head;

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public int detectLoop() {
		if (head == null)
			return 0;

		Node slow = head;
		Node fast = head;

		int len = 1;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				System.out.println("Loop Detected");
				countNodes(slow);
				return len;
			}
			len++;
		}

		System.out.println("No Loop Detected");
		return len;
	}

	// Returns count of nodes present in loop.
	int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.next != n) {
			res++;
			temp = temp.next;
		}

		System.out.println("Res = " + res);
		return res;
	}

	// Returns true if there is a loop in linked
	// list else returns false.
	static boolean detectLoop(Node h) {
		HashSet<Node> s = new HashSet<Node>();
		while (h != null) {
			// If we have already has this node
			// in hashmap it means their is a cycle
			// (Because you we encountering the
			// node second time).
			if (s.contains(h))
				return true;

			// If we are seeing the node for
			// the first time, insert it in hash
			s.add(h);

			h = h.next;
		}

		return false;
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		DetectLoopLinkedList llist = new DetectLoopLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		llist.head.next.next.next = llist.head;

		System.out.println("Length of the loop is: " + llist.detectLoop());

		System.out.println("Detect Loop using HashSet: ");
		if (detectLoop(llist.head))
			System.out.println("Loop found");
		else
			System.out.println("No Loop");
	}
}