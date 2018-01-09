package com.adventures.designpatterns.singleton;

//Static initializer based Java implementation of
//singleton design pattern

//Pros:
//Very simple to implement.
//No need to implement getInstance() method. Instance can be accessed directly.

//Cons:
//May lead to resource wastage. Because instance of class is created always, whether it is required or not.
//CPU time is also wasted in creation of instance if it is not required.
//Exception handling is not possible.
class SingletonEager {
	private static SingletonEager obj = new SingletonEager();

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private SingletonEager() {
		s = "Hello I am a string part of Singleton class";
	}

	public static SingletonEager getInstance() {
		return obj;
	}
}

public class SingletonEagerInstantiation {

	public static void main(String args[]) {
		// instantiating Singleton class with variable x
		SingletonEager x = SingletonEager.getInstance();

		// instantiating Singleton class with variable y
		SingletonEager y = SingletonEager.getInstance();

		// instantiating Singleton class with variable z
		SingletonEager z = SingletonEager.getInstance();

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
