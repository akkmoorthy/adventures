package com.adventures.problems;

import java.util.Scanner;

//Write a program to check whether a character is vowel or not.
//http://practice.geeksforgeeks.org/problems/vowel-or-not/0/?ref=self
/*
 * Input: The first line of the input contains T denoting total number of testcases. Each of the testcase contains one character c.
 */

/*
 * Example:
Input:
2
a
z
 */
class Vowel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		for (int i = 0; i < count; i++) {
			char vowel = sc.next().charAt(0);
			if (Character.toLowerCase(vowel) == 'a' || Character.toLowerCase(vowel) == 'e'
					|| Character.toLowerCase(vowel) == 'i' || Character.toLowerCase(vowel) == 'o'
					|| Character.toLowerCase(vowel) == 'u') {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}
}