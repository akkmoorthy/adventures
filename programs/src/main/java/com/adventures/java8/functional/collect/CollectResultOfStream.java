package com.adventures.java8.functional.collect;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// To collect the result, we can rely on the Stream.collect(Collector<? super T,A,R> collector) method.
// This method gets a single argument representing a java.util.stream.Collector or a user-defined Collector.
//
//The most famous collectors include the following:
//
// 1. toList()
// 2. toSet()
// 3. toMap()
// 4. toCollection() - The argument of the toCollection() method is a Supplier that provides a new empty Collection
// into which the results will be inserted.
public class CollectResultOfStream {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600)
        );

        // Filter melons that are heavier than 1,000 g and collect the result in a List via toList()
        List<Integer> resultToList1 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toList());

        // Filter melons that are heavier than 1,000 g and collect the result in a List via toCollection()
        List<Integer> resultToList2 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("\nCollect via toList():\n" + resultToList1);
        System.out.println("\nCollect via toCollection to ArrayList:\n" + resultToList2);

        // Filter melons that are heavier than 1,000 g and collect the result without duplicates in a Set via toSet()
        Set<Integer> resultToSet1 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toSet());

        // Filter melons that are heavier than 1,000 g and collect the result without duplicates in a Set via toCollection()
        Set<Integer> resultToSet2 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(HashSet::new));

        // Filter melons that are heavier than 1,000 grams, collect the result without duplicates,
        // and sort into ascending order in a Set via toCollection():
        Set<Integer> resultToSet3 = melons.stream()
                .map(Melon::getWeight)
                .filter(x -> x >= 1000)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("\nCollect via toSet():\n" + resultToSet1);
        System.out.println("\nCollect via toCollection() to HashSet:\n" + resultToSet2);
        System.out.println("\nCollect via toCollection() to TreeSet:\n" + resultToSet3);

        // Filter a distinct Melon and collect the result in a Map<String, Integer> via toMap():
        // The two arguments of the toMap() method represent a mapping function that's used to produce keys and
        // their respective values (this is prone to the java.lang.IllegalStateException duplicate key exception
        // if two Melon have the same key)
        Map<String, Integer> resultToMap1 = melons.stream()
                .distinct()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight));

        // Filter a distinct Melon and collect the result in a Map<Integer, Integer> via toMap() using random keys
        // (prone to the java.lang.IllegalStateException duplicate key if two identical keys are generated)
        Map<Integer, Integer> resultToMap2 = melons.stream()
                .distinct()
                .map(x -> Map.entry(new Random().nextInt(Integer.MAX_VALUE), x.getWeight()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        // Collect a Melon in a map via toMap() and avoid the potential java.lang.IllegalStateException duplicate key
        // by choosing the existing (old) value in case of a key collision:

        // The last argument of the toMap() method is a merge function and is used to resolve collisions between
        // values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction).
        // Obviously, choosing the new value can be done with (oldValue, newValue) -> newValue:
        Map<String, Integer> resultToMap3 = melons.stream()
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> oldValue));

        // The last argument of this toMap() flavor represents a Supplier that provides a new empty Map into
        // which the results will be inserted. In this example, this Supplier is needed to preserve the order
        // after sorting. Since HashMap doesn't guarantee the order of insertion, we need to rely on LinkedHashMap
        Map<String, Integer> resultToMap4 = melons.stream()
                .sorted(Comparator.comparingInt(Melon::getWeight))
                .collect(Collectors.toMap(Melon::getType, Melon::getWeight,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        System.out.println("\nCollect via toMap():\n" + resultToMap1);
        System.out.println("\nCollect via toMap() with random keys:\n" + resultToMap2);
        System.out.println("\nCollect via toMap() with old key in case of collision:\n" + resultToMap3);
        System.out.println("\nCollect via toMap() sorted:\n" + resultToMap4);

        // Collect the word frequency count via toMap():
        String str = "Lorem Ipsum is simply Ipsum Lorem not simply Ipsum";

        Map<String, Integer> mapOfWords = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(
                        w -> w.toLowerCase(), w -> 1, Integer::sum));

        System.out.println("\nWord Frequency: " + mapOfWords);
    }

}
