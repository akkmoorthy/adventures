package com.adventures.java8.functional.defaultmethod;

import java.util.Arrays;

public interface Polygon {

    public double area();

    default double perimeter(double... segments) {

        return Arrays.stream(segments)
                .sum();
    }
}
