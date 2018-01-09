package com.adventures.designpatterns.singleton;

enum Enum {
	INSTANCE;
	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

public class SingletonEnum {
	public static void main(String[] args) {
		Enum singleton = Enum.INSTANCE;
		System.out.println(singleton.getValue());
		singleton.setValue(2);
		System.out.println(singleton.getValue());
	}
}