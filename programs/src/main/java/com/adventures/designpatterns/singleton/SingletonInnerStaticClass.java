package com.adventures.designpatterns.singleton;

//Java code for Bill Pugh Singleton Implementaion
class SingletonBillPughImplementation {

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private SingletonBillPughImplementation() {
		s = "Hello I am a string part of Singleton class";
	}

	// Inner class to provide instance of class
	private static class BillPughSingleton {
		private static final SingletonBillPughImplementation INSTANCE = new SingletonBillPughImplementation();
	}

	public static SingletonBillPughImplementation getInstance() {
		return BillPughSingleton.INSTANCE;
	}
}

public class SingletonInnerStaticClass {

	public static void main(String args[]) {
		// instantiating Singleton class with variable x
		SingletonBillPughImplementation x = SingletonBillPughImplementation.getInstance();

		// instantiating Singleton class with variable y
		SingletonBillPughImplementation y = SingletonBillPughImplementation.getInstance();

		// instantiating Singleton class with variable z
		SingletonBillPughImplementation z = SingletonBillPughImplementation.getInstance();

		// changing variable of instance x
		x.s = (x.s).toUpperCase();

		System.out.println("String from x is " + x.s);
		System.out.println("String from y is " + y.s);
		System.out.println("String from z is " + z.s);
		System.out.println("\n");

		// changing variable of instance z
		z.s = (z.s).toLowerCase();

		System.out.println("String from x is " + x.s);
		System.out.println("String from y is " + y.s);
		System.out.println("String from z is " + z.s);
	}

}
