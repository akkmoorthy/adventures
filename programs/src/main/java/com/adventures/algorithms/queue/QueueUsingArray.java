package com.adventures.algorithms.queue;

import java.util.Arrays;

public class QueueUsingArray {
	private static int MAX = 2;
	private int[] arr = new int[MAX];
	private int front = 0, rear = 0, size = 0;

	private boolean enqueue(int x) {
		if (isFull(this)) {
			System.out.println("Queue is Full");
			return false;
		}
		arr[rear] = x;
		rear++;
		size++;
		return true;
	}

	private boolean isFull(QueueUsingArray queue) {
		return queue.size == queue.MAX;
	}

	private boolean isEmpty(QueueUsingArray queue) {
		return queue.size == 0;
	}

	private int dequeue() {
		if (isEmpty(this)) {
			System.out.println("Nothing in the queue");
			return 0;
		}

		System.out.println("Dequeue: " + arr[front]);
		size--;
		return arr[front++];
	}

	public static void main(String[] args) {
		QueueUsingArray queueUsingArray = new QueueUsingArray();
		queueUsingArray.enqueue(1);
		queueUsingArray.enqueue(2);
		queueUsingArray.enqueue(3);

		System.out.println(Arrays.toString(queueUsingArray.arr));

		queueUsingArray.dequeue();
		queueUsingArray.dequeue();
		queueUsingArray.dequeue();
	}
}