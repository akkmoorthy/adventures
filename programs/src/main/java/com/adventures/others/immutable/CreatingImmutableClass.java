package com.adventures.others.immutable;

// The class should be marked as final to suppress extensibility (other classes cannot extend this class; therefore, they cannot override methods)
//All fields should be declared private and final (they are not visible in other classes, and they are initialized only once in the constructor of this class)
//The class should contain a parameterized public constructor (or a private constructor and factory methods for creating instances) that initializes the fields
//The class should provide getters for fields
//The class should not expose setters
public class CreatingImmutableClass {

    public static void main(String[] args) {

        Point p = new Point(1.2, 33.4);

        System.out.println("X: " + p.getX());
        System.out.println("Y: " + p.getY());
    }

}

final class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
