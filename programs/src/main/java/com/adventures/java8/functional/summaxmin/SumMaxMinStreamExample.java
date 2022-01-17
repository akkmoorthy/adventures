package com.adventures.java8.functional.summaxmin;

import java.util.Arrays;
import java.util.List;

public class SumMaxMinStreamExample {

    // sum(), max(), and min() are known as special cases of reduction.
    // By reduction, we mean an abstraction based on two main statements:
    // 1. Take an initial value (T)
    // 2. Take a BinaryOperator<T> to combine two elements and produce a new value
    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        int total1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();

        System.out.println("The total1 weight is: " + total1);

        int max1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);

        System.out.println("Max1: " + max1);

        int min1 = melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);

        System.out.println("Min1: " + min1);
    }

}
