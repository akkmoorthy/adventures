package com.adventures.algorithms.linkedlist;

public class LinkedListStringPalindrome {
	Node head;

	public static void main(String[] args) {
		LinkedListStringPalindrome list = new LinkedListStringPalindrome();
		list.head = new Node("a");
		list.head.next = new Node("bc");
		list.head.next.next = new Node("d");
		list.head.next.next.next = new Node("dcb");
		list.head.next.next.next.next = new Node("a");

		list.printList();
		System.out.println("Is Palindrome: " + list.isPalindrome());
	}

	boolean isPalindrome() {
		String str = "";
		Node tmp = head;
		while (tmp != null) {
			str += tmp.strData;
			tmp = tmp.next;
		}

		System.out.println(str);
		return checkStrIsPalindrome(str);
	}

	boolean checkStrIsPalindrome(String str) {
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}

		return true;
	}

	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.strData + "->");
			tnode = tnode.next;
		}
		System.out.println("NULL");
	}
}
