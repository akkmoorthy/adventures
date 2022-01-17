package com.adventures.designpatterns.singleton;

//Java program to create Thread Safe
//Singleton class

//Pros:
//Lazy initialization is possible.
//It is also thread safe.

//Cons:
//getInstance() method is synchronized so it causes slow performance as multiple threads can't access it simultaneously.
class SingletonSynchronized {
	// private instance, so that it can be
	// accessed by only by getInstance() method
	private static SingletonSynchronized instance;

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private SingletonSynchronized() {
		s = "Hello I am a string part of Singleton class";
	}

	// synchronized method to control simultaneous access
	synchronized public static SingletonSynchronized getInstance() {
		if (instance == null) {
			// if instance is null, initialize
			instance = new SingletonSynchronized();
		}
		return instance;
	}
}

public class SingletonWithSynchronizedMetho {

	public static void main(String args[]) {
		// instantiating Singleton class with variable x
		SingletonSynchronized x = SingletonSynchronized.getInstance();

		// instantiating Singleton class with variable y
		SingletonSynchronized y = SingletonSynchronized.getInstance();

		// instantiating Singleton class with variable z
		SingletonSynchronized z = SingletonSynchronized.getInstance();

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
