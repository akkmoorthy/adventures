package com.adventures.designpatterns.singleton;

//JAVA code to explain cloning 
//issue with singleton
class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// Singleton class
class SingletonClone extends SuperClass {
	// public instance initialized when loading the class
	public static SingletonClone instance = new SingletonClone();

	private SingletonClone() {
		// private constructor
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		// Instead of throwing exception, we can return the same instance
	}
}

public class SingletonCloned {
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonClone instance1 = SingletonClone.instance;
		SingletonClone instance2 = (SingletonClone) instance1.clone();
		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}
}