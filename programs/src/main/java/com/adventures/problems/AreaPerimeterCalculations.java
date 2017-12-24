package com.adventures.problems;

import java.util.Scanner;

public class AreaPerimeterCalculations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter radius of a circle");
		int radius = scanner.nextInt();
		areaAndPerimeterOfCircle(radius);
		
		System.out.println("\nPlease enter length and breadth of a rectangle\n");
		int length = scanner.nextInt();
		int breadth = scanner.nextInt();
		areaAndPerimeterOfRectangle(length, breadth);
		
		System.out.println("\nPlease enter side of Square\n");
		int side = scanner.nextInt();
		areaAndPerimeterOfSquare(side);
		
		scanner.close();
	}

	private static void areaAndPerimeterOfCircle(int radius) {
		System.out.printf("Area of circle of radius %d = %f", radius, (3.14 * radius * radius));
		System.out.printf("\nPerimeter of circle of radius %d = %f", radius, (2 * 3.14 * radius));
	}

	private static void areaAndPerimeterOfSquare(int side) {
		System.out.printf("Area of Square of radius %d = %d", side, (side * side));
		System.out.printf("\nPerimeter of circle of radius %d = %d", side, (4 * side));
	}

	private static void areaAndPerimeterOfRectangle(int width, int length) {
		System.out.printf("\nArea of Rectangle with width - %d and length - %d = %d", width, length, (width * length));
		System.out.printf("\nPerimeter of Rectangle with width - %d and length - %d = %d", width, length, (2 * width * length));
	}
}