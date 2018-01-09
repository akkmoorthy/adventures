package com.adventures.algorithms.linkedlist;

public class LengthEvenOrOdd {

	Node head;

	/* Drier program to test above functions */
	public static void main(String[] args) {
		LengthEvenOrOdd llist = new LengthEvenOrOdd();
		/*
		 * Use push() to construct below list 1->12->1->4->5
		 */
		llist.push(5);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		llist.printList();

		llist.lengthEvenOrOdd1();
		llist.lengthEvenOrOdd2();

		llist.push(3);
		System.out.println("After pushing 1 node");
		llist.printList();
		llist.lengthEvenOrOdd1();
		llist.lengthEvenOrOdd2();
	}

	void lengthEvenOrOdd1() {
		Node fast = head;
		while (fast != null && fast.next != null) {
			System.out.print(fast.data + " ");
			fast = fast.next.next;
		}

		if (fast != null)
			System.out.println("Method::1 - Odd Length");
		else
			System.out.println("Method::1 - Even Length");
	}

	void lengthEvenOrOdd2() {
		int length = 0;
		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}

		if (length % 2 == 0)
			System.out.println("Method::2 - Even Length");
		else
			System.out.println("Method::2 - Odd Length");
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