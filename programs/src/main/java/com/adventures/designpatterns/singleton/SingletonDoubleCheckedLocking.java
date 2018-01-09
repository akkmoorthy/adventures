package com.adventures.designpatterns.singleton;

//Double Checked Locking based Java implementation of
//singleton design pattern

//Pros:
//Lazy initialization is possible.
//It is also thread safe.
//Performance reduced because of synchronized keyword is overcome.

//Cons:
//First time, it can affect performance.
class SingletonDoubleLock {
	private volatile static SingletonDoubleLock obj;

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private SingletonDoubleLock() {
		s = "Hello I am a string part of Singleton class";
	}

	public static SingletonDoubleLock getInstance() {
		if (obj == null) {
			// To make thread safe
			synchronized (SingletonDoubleLock.class) {
				// check again as multiple threads
				// can reach above step
				if (obj == null)
					obj = new SingletonDoubleLock();
			}
		}
		return obj;
	}
}

public class SingletonDoubleCheckedLocking {

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