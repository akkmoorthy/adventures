package com.adventures.algorithms.stack;

import java.util.Arrays;

public class StackUsingArray {
	private static int MAX = 2;
	private int[] arr = new int[MAX];
	private int top = 0;

	private boolean push(int x) {
		System.out.println("top = " + top);
		if (top >= MAX) {
			System.out.println("Stack Overflow");
			return false;
		}
		arr[top] = x;
		top++;
		return true;
	}

	private int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		return arr[--top];
	}

	public static void main(String[] args) {
		StackUsingArray stackUsingArray = new StackUsingArray();
		stackUsingArray.push(1);
		stackUsingArray.push(2);
		stackUsingArray.push(3);

		System.out.println(Arrays.toString(stackUsingArray.arr));

		System.out.println("Pop: " + stackUsingArray.pop());
		System.out.println("Pop: " + stackUsingArray.pop());
	}
}