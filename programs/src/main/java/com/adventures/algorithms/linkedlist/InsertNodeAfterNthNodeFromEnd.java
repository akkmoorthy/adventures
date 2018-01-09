package com.adventures.algorithms.linkedlist;

public class InsertNodeAfterNthNodeFromEnd {
	Node head;

	/* Drier program to test above functions */
	public static void main(String[] args) {
		InsertNodeAfterNthNodeFromEnd llist = new InsertNodeAfterNthNodeFromEnd();
		/*
		 * Use push() to construct below list 1->12->1->4->1
		 */
		llist.push(1);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		llist.printList();

		llist.insertNodeFromEnd(3, 3);

		System.out.println("After Inserting: ");
		llist.printList();
	}

	public void insertNodeFromEnd(int data, int position) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}

		tmp = head;
		for (int i = 1; i < (count - position); i++) {
			tmp = tmp.next;
		}

		Node newNode = new Node(data);
		newNode.next = tmp.next;
		tmp.next = newNode;
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