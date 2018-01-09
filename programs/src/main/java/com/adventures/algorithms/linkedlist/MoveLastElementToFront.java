package com.adventures.algorithms.linkedlist;

public class MoveLastElementToFront {
	Node head;

	/* Drier program to test above functions */
	public static void main(String[] args) {
		MoveLastElementToFront llist = new MoveLastElementToFront();
		/*
		 * Use push() to construct below list 1->12->1->4->5
		 */
		llist.push(5);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		llist.printList();

		llist.moveLastToFront();

		System.out.println("After Moving Last element to Front: ");
		llist.printList();
	}

	void moveLastToFront() {
		if (head == null || head.next == null) {
			System.out.println("No Nodes Available to move");
			return;
		}

		Node tmp = head;
		Node prev = null;
		while (tmp.next != null) {
			prev = tmp;
			tmp = tmp.next;
		}

		tmp.next = head;
		prev.next = null;
		head = tmp;

	}

	/*
	 * Given a reference to the head of a list and an int, inserts a new Node on the
	 * front of the list.
	 */
	public void push(int new_data) {
		Node new_Node = new Node(new_data);
		new_Node.next = head;
		head = new_Node;
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
		System.out.println("NULL");
	}
}
