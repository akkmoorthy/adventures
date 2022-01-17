package com.adventures.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountInString {

    public static void main(String[] args) {
        // Collect the word frequency count via toMap():
        String str = "Lorem Ipsum is simply Ipsum Lorem not simply Ipsum";

        Map<String, Integer> mapOfWords = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .peek(p -> System.out.println("\tstream(): " + p))
                .flatMap(Arrays::stream)
                .peek(p -> System.out.println("\tflatMap(): " + p))
                .collect(Collectors.toMap(
                        w -> w.toLowerCase(), w -> 1, Integer::sum));

        System.out.println("\nWord Frequency: " + mapOfWords);
    }
}
