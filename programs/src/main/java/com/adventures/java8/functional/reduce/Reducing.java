package com.adventures.java8.functional.reduce;

import java.util.Arrays;
import java.util.List;

// Reductions can be accomplished via a terminal operation named reduce(), which follows this abstraction
// and defines two signatures (the second one doesn't use an initial value):
//        T reduce​(T identity, BinaryOperator<T> accumulator)
//        Optional<T> reduce​(BinaryOperator<T> accumulator)
public class Reducing {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        int total1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();

        // We can rely on the reduce() terminal operation to compute the sum of the elements,
        // as follows (the initial value is 0, and the lambda is (m1, m2) -> m1 + m2)):
        int total2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(0, (m1, m2) -> m1 + m2);

        System.out.println("The total1 weight is: " + total1);
        System.out.println("The total2 weight is: " + total2);

        // Let's take a look at the following steps to figure this out:
        // 1. First, 0 is used as the first parameter of the lambda (m1), and 2,000 is consumed from the stream
        // and used as the second parameter (m2). 0 + 2000 produces 2000, and this becomes the new accumulated value.
        // 2. Then, the lambda is called again with the accumulated value and the next element of the stream, 1,600,
        // which produces the new accumulated value, 3,600.
        // 3. Moving forward, the lambda is called again with the accumulated value and the next element, 3,000,
        // which produces 6,600.
        // 4. If we step forward again, the lambda is called again with the accumulated value and the next element,
        // 2,000, which produces 8,600.
        // 5. Finally, the lambda is called with 8,600 and the last element of the stream, 1,700, which produces
        // the final value, 10,300.

        int max1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);

        // Calculate max using reduce
        int max2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::max)
                .orElse(-1);

        System.out.println("Max1: " + max1);
        System.out.println("Max2: " + max2);

        int min1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);

        // Calculate min using reduce
        int min2 = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);

        System.out.println("Min1: " + min1);
        System.out.println("Min2: " + min2);

        // The advantage of using reduce() is that we can easily change the computation by simply
        // passing another lambda. For example, we can quickly replace the sum with the product,
        // as shown in the following example:
        List<Double> numbers = Arrays.asList(1.0d, 5.0d, 8.0d, 10.0d);

        double total3 = numbers.stream()                
                .reduce(1.0d, (x1, x2) -> x1 * x2);

        System.out.println("Product: " + total3);

        double hm = numbers.size() / numbers.stream()
                .mapToDouble(x -> 1.0d / x)
                .reduce((x1, x2) -> (x1 + x2))
                .orElseThrow();

        System.out.println("Harmonic mean: " + hm);
    }

}
