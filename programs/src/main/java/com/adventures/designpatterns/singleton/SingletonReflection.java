package com.adventures.designpatterns.singleton;

//Java code to explain effect of Reflection
//on Singleton property

import java.lang.reflect.Constructor;

//Overcome reflection issue: To overcome issue raised by reflection, enums are used because java ensures internally that enum value
//is instantiated only once. Since java Enums are globally accessible, they can be used for singletons. Its only drawback is that 
//it is not flexible i.e it does not allow lazy initialization.

//Singleton class
class SingletonDemo {
	// public instance initialized when loading the class
	public static SingletonDemo instance = new SingletonDemo();

	private SingletonDemo() {
		// private constructor
	}
}

public class SingletonReflection {

	public static void main(String[] args) {
		SingletonDemo instance1 = SingletonDemo.instance;
		SingletonDemo instance2 = null;
		try {
			Constructor[] constructors = SingletonDemo.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instance2 = (SingletonDemo) constructor.newInstance();
				break;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}
}