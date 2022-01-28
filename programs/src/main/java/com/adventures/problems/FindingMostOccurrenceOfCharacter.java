package com.adventures.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FindingMostOccurrenceOfCharacter {

    private static final int EXTENDED_ASCII_CODES = 256;

    private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. "
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("HashMap based solution:");
        long startTimeV1 = System.nanoTime();

        Pair1 pairV1 = maxOccurenceCharacterV1(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV1);
        System.out.println("Character: " + pairV1.character);
        System.out.println("Occurrences :" + pairV1.occurrences);

        System.out.println();
        System.out.println("ASCII codes based solution:");
        long startTimeV2 = System.nanoTime();

        Pair1 pairV2 = maxOccurenceCharacterV2(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV2);
        System.out.println("Character: " + pairV2.character);
        System.out.println("Occurrences :" + pairV2.occurrences);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        long startTimeV3 = System.nanoTime();

        Pair1 pairV3 = maxOccurenceCharacterV3(TEXT);

        displayExecutionTime(System.nanoTime() - startTimeV3);
        System.out.println("Character: " + pairV3.character);
        System.out.println("Occurrences :" + pairV3.occurrences);
    }


    public static Pair1<Character, Integer> maxOccurenceCharacterV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair1.of(Character.MIN_VALUE, -1);
        }

        Map<Character, Integer> counter = new HashMap<>();
        char[] chStr = str.toCharArray();
        for (int i = 0; i < chStr.length; i++) {

            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignore spaces
                Integer noCh = counter.get(currentCh);
                if (noCh == null) {
                    counter.put(currentCh, 1);
                } else {
                    counter.put(currentCh, ++noCh);
                }
            }
        }

        int maxOccurrences = Collections.max(counter.values());

        char maxCharacter = Character.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }

        return Pair1.of(maxCharacter, maxOccurrences);
    }

    public static Pair1<Character, Integer> maxOccurenceCharacterV2(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair1.of(Character.MIN_VALUE, -1);
        }

        int maxOccurrences = -1;
        char maxCharacter = Character.MIN_VALUE;

        char[] chStr = str.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i = 0; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // ignoring space

                int code = (int) currentCh;
                asciiCodes[code]++;
                if (asciiCodes[code] > maxOccurrences) {
                    maxOccurrences = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }

        }

        return Pair1.of(maxCharacter, maxOccurrences);
    }

    public static Pair1<Character, Long> maxOccurenceCharacterV3(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return Pair1.of(Character.MIN_VALUE, -1L);
        }

        return str.chars()
                .filter(c -> Character.isWhitespace(c) == false) // ignoring space
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> Pair1.of(p.getKey(), p.getValue()))
                .orElse(Pair1.of(Character.MIN_VALUE, -1L));
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}

final class Pair1<V, C> {

    final V character;
    final C occurrences;

    public Pair1(V character, C occurrences) {
        this.character = character;
        this.occurrences = occurrences;
    }

    static <V, C> Pair1<V, C> of(V character, C occurrences) {
        return new Pair1<>(character, occurrences);
    }

    @Override
    public int hashCode() {
        return character.hashCode() ^ character.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair1)) {
            return false;
        }

        Pair1 obj = (Pair1) o;
        return this.character.equals(obj.character)
                && this.occurrences.equals(obj.occurrences);
    }
}
