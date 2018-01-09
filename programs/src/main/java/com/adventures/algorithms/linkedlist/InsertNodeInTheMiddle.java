package com.adventures.algorithms.linkedlist;

public class InsertNodeInTheMiddle {
	Node head;

	/* Drier program to test above functions */
	public static void main(String[] args) {
		InsertNodeInTheMiddle llist = new InsertNodeInTheMiddle();
		/*
		 * Use push() to construct below list 1->12->1->4->1
		 */
		llist.push(1);
		llist.push(4);
		llist.push(1);
		llist.push(12);
		llist.push(1);

		llist.printList();

		llist.insertNodeMiddleUsingFloyd(3);
		System.out.println("After Inserting: ");
		llist.printList();

		llist.insertAtMid(123);
		System.out.println("After Inserting: ");
		llist.printList();
	}

	public void insertNodeMiddleUsingFloyd(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node newNode = new Node(data);
		newNode.next = slow.next;
		slow.next = newNode;
	}

	public void insertAtMid(int x) {
		if (head == null)
			head = new Node(x);
		else {
			Node newNode = new Node(x);

			Node ptr = head;
			int len = 0;
			while (ptr != null) {
				len++;
				ptr = ptr.next;
			}

			// 'count' the number of nodes after which
			// the new node is to be inserted
			int count = ((len % 2) == 0) ? (len / 2) : (len + 1) / 2;
			ptr = head;

			while (count-- > 1)
				ptr = ptr.next;

			newNode.next = ptr.next;
			ptr.next = newNode;
		}
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