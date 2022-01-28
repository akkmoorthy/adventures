package com.adventures.others.immutable;

public class PassReturnMutablesToImmutableClass {

    public static void main(String[] args) {

        Radius r = new Radius();
        r.setStart(0);
        r.setEnd(120);

        Point1 p = new Point1(1.23, 4.12, r);

        System.out.println("Radius start: " + p.getRadius().getStart());
        r.setStart(5);
        p.getRadius().setStart(5);
        System.out.println("Radius start: " + p.getRadius().getStart());
    }

}

final class Point1 {

    private final double x;
    private final double y;
    private final Radius radius;

    public Point1(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;

        Radius clone = new Radius();
        clone.setStart(radius.getStart());
        clone.setEnd(radius.getEnd());

        this.radius = clone;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Radius getRadius() {

        Radius clone  = new Radius();
        clone.setStart(this.radius.getStart());
        clone.setEnd(this.radius.getEnd());

        return clone;
    }
}

//    Passing mutable objects to an immutable class can break down immutability. Let's consider the following mutable class:
class Radius {

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

