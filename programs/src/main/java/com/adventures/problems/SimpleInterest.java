package com.adventures.problems;

import java.util.Scanner;

class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			int principal = sc.nextInt();
			int time = sc.nextInt();
			int rate = sc.nextInt();

			System.out.println((principal * rate * time) / 100);
		}

		sc.close();
	}
}