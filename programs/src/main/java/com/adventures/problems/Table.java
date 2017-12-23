package com.adventures.problems;

import java.util.Scanner;

/*
 * Input a number and the multiplication will happen upto 10 
 */
class Table {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int table = sc.nextInt();

		for (int j = 1; j <= 10; j++) {
			System.out.print((table * j) + " ");
		}

		sc.close();
	}
}