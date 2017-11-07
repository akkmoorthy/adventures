package com.adventures.problems;
import java.util.Scanner;

class Table {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
		    int table = sc.nextInt();
		    for ( int j = 1; j < 10; j++ ) {
		        System.out.print((table * j) + " ");
		    }
		}
		
		sc.close();
	}
}
