package com.adventures.problems;

import org.springframework.util.StringUtils;
import java.util.Scanner;

public class CountCharactersInString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String");
		String str = scanner.nextLine();
		System.out.println("Enter a Character");
		char search = scanner.next().charAt(0);
		scanner.close();

		countUsingForLoop(str, search);
		countUsingEnhancedForLoop(str, search);
		countUsingSpringStringUtils(str, search);
	}

	private static void countUsingSpringStringUtils(String str, char search) {
		// Using Spring framework StringUtils class for finding occurrence of
		// another String
		int count = StringUtils.countOccurrencesOf(str, String.valueOf(search));

		System.out.printf("The character %c is found %d times in the %s\n", search, count, str);
	}

	private static void countUsingForLoop(String str, char search) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.toLowerCase().charAt(i) == search) {
				count++;
			}
		}

		System.out.printf("The character %c is found %d times in the %s\n", search, count, str);
	}

	private static void countUsingEnhancedForLoop(String str, char search) {
		int count = 0;
		for (char a : str.toCharArray()) {
			if (a == search) {
				count++;
			}
		}

		System.out.printf("The character %c is found %d times in the %s\n", search, count, str);
	}
}
