package com.adventures.java8.functional.summarization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

// summingInt(ToIntFunction<? super T> mapper) collector
public class Main {


    // So, Collectors.summingInt() is a factory method that takes a function that's capable of mapping an object
    // into an int that has to be summed as an argument. A collector is returned that performs the summarization
    // via the collect() method
    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600)
        );

        int sumWeightsGrams = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight));

        double sumWeightsKg1 = melons.stream()
                .collect(Collectors.summingDouble(m -> (double) m.getWeight() / 1000.0d));

        double sumWeightsKg2 = melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight)) / 1000.0d;

        // Since summarizations are actually reductions, the Collectors class provides a reducing() method as well.
        // Obviously, this method has a more general utilization, allowing us to provide all kinds of lambdas via its
        // three flavors:
        //
        //reducing(BinaryOperator<T> op)
        //reducing(T identity, BinaryOperator<T> op)
        //reducing(U identity, Function<? super T,​? extends U> mapper, BinaryOperator<U> op)
        double sumWeightsKg3 = melons.stream()
                .collect(Collectors.reducing(0.0,
                        m -> (double) m.getWeight() / 1000.0d, (m1, m2) -> m1 + m2));

        double sumWeightsKg4 = melons.stream()
                .collect(Collectors.reducing(0,
                        m -> m.getWeight(), (m1, m2) -> m1 + m2)) / 1000.0d;

        System.out.println("Sum melons weights in grams: " + sumWeightsGrams + " grams");
        System.out.println("Sum melons weights in kg (v1): " + sumWeightsKg1 + " kg");
        System.out.println("Sum melons weights in kg (v2): " + sumWeightsKg2 + " kg");
        System.out.println("Sum melons weights in kg (v3): " + sumWeightsKg3 + " kg");
        System.out.println("Sum melons weights in kg (v4): " + sumWeightsKg4 + " kg");

        double avgWeights = melons.stream()
                .collect(Collectors.averagingInt(Melon::getWeight));
        System.out.println("\nAvg melons weights: " + avgWeights + " grams");

        long nrOfMelon1 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .count();

        long nrOfMelon2 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.counting());

        long nrOfMelon3 = melons.stream()
                .filter(m -> m.getWeight() == 3000)
                .collect(Collectors.reducing(0L, m -> 1L, Long::sum));

        System.out.println("\nNumber of melons of 3000g (v1): " + nrOfMelon1);
        System.out.println("Number of melons of 3000g (v2): " + nrOfMelon2);
        System.out.println("Number of melons of 3000g (v3): " + nrOfMelon3);

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        Melon heaviestMelon = melons.stream()
                .collect(Collectors.maxBy(byWeight))
                .orElseThrow();

        Melon lightestMelon = melons.stream()
                .collect(Collectors.minBy(byWeight))
                .orElseThrow();

        System.out.println("\nHeaviest melon: " + heaviestMelon);
        System.out.println("Lightest melon: " + lightestMelon);

        // Whenever we need two or more of these operations, we can rely on Collectors.summarizingInt(),
        // summarizingLong(), and summarizingDouble(). These methods wrap these operations in IntSummaryStatistics,
        // LongSummaryStatistics, and DoubleSummaryStatistics, respectively, as follows:
        IntSummaryStatistics melonWeightsStatistics
                = melons.stream().collect(Collectors.summarizingInt(Melon::getWeight));
        System.out.println("\nMelons weights statistics: " + melonWeightsStatistics);

        // For each of these operations, we have dedicated getters like getMax, getMin, getCount, getSum, getAverage
        System.out.println("Weight of the heaviest melon: " + melonWeightsStatistics.getMax() + " grams");
    }

}
