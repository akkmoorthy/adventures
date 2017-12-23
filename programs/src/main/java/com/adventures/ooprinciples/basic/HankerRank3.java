package com.adventures.ooprinciples.basic;

public class HankerRank3 {

	public static void main(String[] args) {
		MyThread m = new MyThread() {
			public void run	() {
				System.out.println("m2");
			}
		};
		m.start();
}
}

class MyThread extends Thread{
	MyThread()
	{
		System.out.println("m");
		
		
	}
	
	public void run	() {
		System.out.println("m1");
	}
}
