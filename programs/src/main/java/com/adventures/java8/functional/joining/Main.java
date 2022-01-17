package com.adventures.java8.functional.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Collectors.joining() is to concatenate the elements of a stream into a String in the encounter order.
// Optionally, these collectors can use a delimiter, a prefix, and a suffix, and so the most comprehensive
// joining() flavor is String joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix).
public class Main {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600)
        );

        // We can also enrich the output with a prefix and suffix:
        String melonNames = melons.stream()
                .map(Melon::getType)
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ", "Available melons: ", " Thank you!"));

        System.out.println("Melon names:\n" + melonNames);
    }

}
