package com.adventures.problems;

import java.util.Scanner;

public class FloydTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows of floyd's triangle you want");
		int number = scanner.nextInt();
		scanner.close();

		int num = 1;

		for (int i = 0; i <= number; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
	}
}