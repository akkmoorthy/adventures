package com.adventures.algorithms.linkedlist;

public class LinkedListTry1 {
	Node head;

	void insertFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;

		head = newNode;
	}

	void insertBack(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}

		Node newNode = new Node(data);
		tmp.next = newNode;
	}

	void insertAtPosition(int data, Node node) {
		if (head == null) {
			head = new Node(data);
			return;
		}

		Node tmp = head;
		Node prev = null;
		Node next = null;
		while (tmp != null) {
			if (tmp.data == node.data) {
				prev = tmp;
				next = tmp.next;
				break;
			}
			tmp = tmp.next;
		}

		Node newNode = new Node(data);
		newNode.next = next;
		prev.next = newNode;
	}

	void deleteKey(int key) {
		if (head != null && head.data == key) {
			head = head.next;
		}

		Node tmp = head;
		Node prev = null;
		while (tmp != null && tmp.data != key) {
			prev = tmp;
			tmp = tmp.next;
		}

		if (tmp == null) {
			return;
		}

		prev.next = tmp.next;
	}

	void deletePosition(int position) {
		if (position == 0 && head != null) {
			head = head.next;
			return;
		}

		int count = 0;
		Node tmp = head;
		Node prev = null;
		while (tmp != null && count != position) {
			prev = tmp;
			tmp = tmp.next;
			count++;
		}

		if (tmp == null)
			return;

		prev.next = tmp.next;
	}

	int lengthOfLinkedListRecursive(Node node) {
		if (node == null)
			return 0;

		return 1 + lengthOfLinkedListRecursive(node.next);
	}

	int lengthOfLinkedList() {
		if (head == null) {
			return 0;
		}

		Node tempNode = head;
		int count = 0;
		while (tempNode != null) {
			tempNode = tempNode.next;
			count++;
		}
		return count;
	}

	void searchIterative(int data) {
		if (head == null) {
			System.out.println("Not found");
			return;
		}

		Node tmp = head;
		while (tmp != null && tmp.data != data) {
			tmp = tmp.next;
		}

		if (tmp != null && tmp.data == data) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
	}

	int searchRecursive(int data, Node node, int position) {
		if (node == null) {
			return -1;
		}

		if (node.data == data) {
			return position;
		}

		position++;
		return searchRecursive(data, node.next, position);
	}

	void printMiddle() {
		if (head == null) {
			System.out.println("Linked List is empty");
		}

		Node tmp = head;
		Node middle = head;
		while (tmp != null && tmp.next != null) {
			middle = middle.next;
			tmp = tmp.next.next;
		}

		System.out.println("Middle element is " + middle.data);
	}

	void getNthNode(int index) {
		if (head == null)
			return;

		Node tmp = head;
		int count = 0;
		while (tmp != null && count != index) {
			count++;
			tmp = tmp.next;
		}

		if (tmp == null) {
			System.out.println("Not found");
			return;
		}

		System.out.println("Nth Node at position " + index + " is " + tmp.data);
	}

	void count(int data) {
		if (head == null)
			return;

		int count = 0;
		Node tmp = head;
		while (tmp != null) {
			if (tmp.data == data)
				count++;

			tmp = tmp.next;
		}

		System.out.println("Count  = " + count);
	}

	void printList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	public static void main(String[] args) {
		LinkedListTry1 ll = new LinkedListTry1();
		ll.insertFront(1);
		ll.insertFront(2);
		System.out.println("Print");
		ll.printList();
		System.out.println("Length of Linked List is " + ll.lengthOfLinkedList());
		ll.printMiddle();
		ll.getNthNode(1);
		ll.count(1);

		ll.insertBack(11);
		ll.insertBack(12);
		System.out.println("Print List");
		ll.printList();
		System.out.println("Length of Linked List is " + ll.lengthOfLinkedList());
		ll.printMiddle();
		ll.getNthNode(2);

		System.out.println("Print List after adding at position");
		ll.insertAtPosition(1, ll.head.next);
		ll.printList();
		System.out.println("Length of Linked List is " + ll.lengthOfLinkedList());
		ll.printMiddle();
		ll.getNthNode(1);
		ll.count(1);

		System.out.println("Delete a key");
		ll.deleteKey(2);
		ll.printList();
		System.out.println("Length of Linked List is " + ll.lengthOfLinkedList());
		System.out.println("Length of Linked List with recursion is " + ll.lengthOfLinkedListRecursive(ll.head));
		ll.printMiddle();
		ll.getNthNode(1);

		System.out.println("Delete a key at given position");
		ll.deletePosition(2);
		ll.deletePosition(0);
		ll.printList();
		System.out.println("Length of Linked List is " + ll.lengthOfLinkedList());

		System.out.println("Length of Linked List with recursion is " + ll.lengthOfLinkedListRecursive(ll.head));

		ll.searchIterative(12);
		System.out.println(ll.searchRecursive(21, ll.head, 0));
		ll.printMiddle();
		ll.getNthNode(1);
	}
}