package com.adventures.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Java Program to find first duplicate, non-repeated character in a String. It
 * demonstrate three simple example to do this programming problem.
 */
public class FirstNonRepeatedCharacterInString {

	private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
			+ "showed me that anything is possible and that you're never too young to think big. "
			+ "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
			+ "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
			+ "computer science.";

	// Ӝ -> Unicode: \u04DC, Code Point: 1244
	// 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
	private static final String TEXT_CP = "😍 💕 I Ӝ love you Ӝ so much 😍";

	private static final int EXTENDED_ASCII_CODES = 256; // can be increased to 65535

	public static void main(String[] args) {

		System.out.println("Input text: \n" + TEXT + "\n");

		System.out.println("\n\nASCII or 16 bits Unicode characters (less than 65,535 (0xFFFF)) examples:\n");

		System.out.println("Loop and break solution:");
		long startTimeV1 = System.nanoTime();

		char firstcharV1 = firstNonRepeatedCharacterV1(TEXT);

		displayExecutionTime(System.nanoTime() - startTimeV1);
		System.out.println("Found character: " + firstcharV1);

		System.out.println();
		System.out.println(" 256 ASCII codes solution:");
		long startTimeV2 = System.nanoTime();

		char firstcharV2 = firstNonRepeatedCharacterV2(TEXT);

		displayExecutionTime(System.nanoTime() - startTimeV2);
		System.out.println("Found character: " + firstcharV2);

		System.out.println();
		System.out.println("LinkedHashMap based solution:");
		long startTimeV3 = System.nanoTime();

		char firstcharV3 = firstNonRepeatedCharacterV3(TEXT);

		displayExecutionTime(System.nanoTime() - startTimeV3);
		System.out.println("Found character: " + firstcharV3);

		System.out.println();
		System.out.println("Java 8, functional-style solution:");
		long startTimeV4 = System.nanoTime();

		char firstcharV4 = firstNonRepeatedCharacterV4(TEXT);

		displayExecutionTime(System.nanoTime() - startTimeV4);
		System.out.println("Found character: " + firstcharV4);

		System.out.println("\n---------------------------------------------\n");

		System.out.println("Input text: \n" + TEXT_CP + "\n");

		System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

		System.out.println();
		System.out.println("Java 8, functional-style solution:");
		long startTimeV5 = System.nanoTime();

		String firstcharV5 = firstNonRepeatedCharacterVCP4(TEXT_CP);

		displayExecutionTime(System.nanoTime() - startTimeV5);
		System.out.println("Found character: " + firstcharV5);
	}

	private static void displayExecutionTime(long time) {
		System.out.println("Execution time: " + time + " ns" + " ("
				+ TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
	}

	public static char firstNonRepeatedCharacterV1(String str) {

		if (str == null || str.isBlank()) {
			// or throw IllegalArgumentException
			return Character.MIN_VALUE;
		}

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (ch == str.charAt(j) && i != j) {
					count++;
					break;
				}
			}

			if (count == 0) {
				return ch;
			}
		}

		return Character.MIN_VALUE;
	}

	public static char firstNonRepeatedCharacterV2(String str) {

		if (str == null || str.isBlank()) {
			// or throw IllegalArgumentException
			return Character.MIN_VALUE;
		}

		int[] flags = new int[EXTENDED_ASCII_CODES];

		for (int i = 0; i < flags.length; i++) {
			flags[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (flags[ch] == -1) {
				flags[ch] = i;
			} else {
				flags[ch] = -2;
			}
		}

		int position = Integer.MAX_VALUE;
		for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
			if (flags[i] >= 0) {
				position = Math.min(position, flags[i]);
			}
		}

		return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
	}

	public static char firstNonRepeatedCharacterV3(String str) {

		if (str == null || str.isBlank()) {
			// or throw IllegalArgumentException
			return Character.MIN_VALUE;
		}

		Map<Character, Integer> chars = new LinkedHashMap<>();

		// or use for(char ch: str.toCharArray()) { ... }
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}

		for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return Character.MIN_VALUE;
	}

	public static char firstNonRepeatedCharacterV4(String str) {

		if (str == null || str.isBlank()) {
			// or throw IllegalArgumentException
			return Character.MIN_VALUE;
		}

		Map<Integer, Long> chs = str.chars()
				.mapToObj(cp -> cp)
				.collect(Collectors.groupingBy(Function.identity(),
						LinkedHashMap::new, Collectors.counting()));

		return (char) (int) chs.entrySet().stream()
				.filter(e -> e.getValue() == 1L)
				.findFirst()
				.map(Map.Entry::getKey)
				.orElse(Integer.valueOf(Character.MIN_VALUE));
	}

	public static String firstNonRepeatedCharacterVCP4(String str) {

		if (str == null || str.isBlank()) {
			// or throw IllegalArgumentException
			return String.valueOf(Character.MIN_VALUE);
		}

		Map<Integer, Long> chs = str.codePoints()
				.mapToObj(cp -> cp)
				.collect(Collectors.groupingBy(Function.identity(),
						LinkedHashMap::new, Collectors.counting()));

		int cp = chs.entrySet().stream()
				.filter(e -> e.getValue() == 1L)
				.findFirst()
				.map(Map.Entry::getKey)
				.orElse(Integer.valueOf(Character.MIN_VALUE));

		return String.valueOf(Character.toChars(cp));
	}

	/*
	 * Using LinkedHashMap to find first non repeated character of String
	 * Algorithm : Step 1: get character array and loop through it to build a
	 * hash table with char and their count. Step 2: loop through LinkedHashMap
	 * to find an entry with value 1, that's your first non-repeated character,
	 * as LinkedHashMap maintains insertion order.
	 */
	public static char getFirstNonRepeatedChar(String str) {
		Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>(str.length());
		for (char c : str.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("didn't find any non repeated Character");
	}

	/*
	 * * Finds first non repeated character in a String in just one pass. * It
	 * uses two storage to cut down one iteration, standard space vs time *
	 * trade-off.Since we store repeated and non-repeated character separately,
	 * * at the end of iteration, first element from List is our first non *
	 * repeated character from String.
	 */
	public static char firstNonRepeatingChar(String word) {
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonRepeating = new ArrayList<Character>();
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}

	/*
	 * * Using HashMap to find first non-repeated character from String in Java.
	 * * Algorithm : * Step 1 : Scan String and store count of each character in
	 * HashMap * Step 2 : traverse String and get count for each character from
	 * Map. * Since we are going through String from first to last character, *
	 * when count for any character is 1, we break, it's the first * non
	 * repeated character. Here order is achieved by going * through String
	 * again.
	 */
	public static char firstNonRepeatedCharacter(String word) {
		HashMap<Character, Integer> scoreboard = new HashMap<Character, Integer>();
		// build table [char -> count]
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}
		// since HashMap doesn't maintain order, going through string again
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (scoreboard.get(c) == 1) {
				return c;
			}
		}
		throw new RuntimeException("Undefined behaviour");
	}
}