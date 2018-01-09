package com.adventures.designpatterns.singleton;

//Java code to create singleton class
//Using Static block

//Pros:
//Very simple to implement.
//No need to implement getInstance() method. Instance can be accessed directly.
//Exceptions can be handled in static block.

//Cons:
//May lead to resource wastage. Because instance of class is created always, whether it is required or not.
//CPU time is also wasted in creation of instance if it is not required.
class SingletonStatic {
	// public instance
	public static SingletonStatic instance;

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private SingletonStatic() {
		s = "Hello I am a string part of Singleton class";
	}

	{
		// static block to initialize instance
		instance = new SingletonStatic();
	}
}

public class SingletonStaticBlock {

	public static void main(String args[]) {
		// instantiating Singleton class with variable x
		SingletonDoubleLock x = SingletonDoubleLock.getInstance();

		// instantiating Singleton class with variable y
		SingletonDoubleLock y = SingletonDoubleLock.getInstance();

		// instantiating Singleton class with variable z
		SingletonDoubleLock z = SingletonDoubleLock.getInstance();

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
