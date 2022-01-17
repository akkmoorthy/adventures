package com.adventures.designpatterns.singleton;

//Java program implementing Singleton class
//with getInstance() method

//Pros:
//Object is created only if it is needed. It may overcome resource overcome and wastage of CPU time.
//Exception handling is also possible in method.

//Cons:
//Every time a condition of null has to be checked.
//instance cannot be accessed directly.
//In multithreaded environment, it may break singleton property.
class Singleton {
	// static variable single_instance of type Singleton
	private static Singleton singleInstance = null;

	// variable of type String
	public String s;

	// private constructor restricted to this class itself
	private Singleton() {
		s = "Hello I am a string part of Singleton class";
	}

	// static method to create instance of Singleton class
	public static Singleton getInstance() {
		if (singleInstance == null)
			singleInstance = new Singleton();

		return singleInstance;
	}
}

// Driver Class
class SingletonWithoutSynchronizationAndLazyInstantiation {
	public static void main(String args[]) {
		// instantiating Singleton class with variable x
		Singleton x = Singleton.getInstance();

		// instantiating Singleton class with variable y
		Singleton y = Singleton.getInstance();

		// instantiating Singleton class with variable z
		Singleton z = Singleton.getInstance();

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