package com.adventures.designpatterns.singleton;

//Java code to explain effect of 
//Serilization on singleton classes
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonSerialized implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2677298149635467880L;
	// public instance initialized when loading the class
	public static SingletonSerialized instance = new SingletonSerialized();

	private SingletonSerialized() {
		// private constructor
	}
}

class SingletonSerialized1 implements Serializable {
	private static final long serialVersionUID = 2677298149635467880L;

	// public instance initialized when loading the class
	public static SingletonSerialized1 instance = new SingletonSerialized1();

	private SingletonSerialized1() {
		// private constructor
	}

	// implement readResolve method
	protected Object readResolve() {
		return instance;
	}
}

public class SingletonSerialization {
	public static void main(String[] args) {
		singletonSerializationIssue();
		singletonSerializationIssueFixed();
	}

	private static void singletonSerializationIssueFixed() {
		try {
			SingletonSerialized1 instance1 = SingletonSerialized1.instance;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
			out.writeObject(instance1);
			out.close();

			// deserailize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));

			SingletonSerialized1 instance2 = (SingletonSerialized1) in.readObject();
			in.close();

			System.out.println("instance1 hashCode:- " + instance1.hashCode());
			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void singletonSerializationIssue() {
		try {
			SingletonSerialized instance1 = SingletonSerialized.instance;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
			out.writeObject(instance1);
			out.close();

			// deserailize from file to object
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));

			SingletonSerialized instance2 = (SingletonSerialized) in.readObject();
			in.close();

			System.out.println("instance1 hashCode:- " + instance1.hashCode());
			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
