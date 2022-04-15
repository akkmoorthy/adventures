package com.adventures.problems;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		int prime = 5;

		boolean isPrime = prime(prime);
		// If isPrime is true then the number is prime else not
		if (isPrime)
			System.out.println(prime + " is a Prime Number");
		else
			System.out.println(prime + " is not a Prime Number");

		isPrime = isPrime(prime);
		// If isPrime is true then the number is prime else not
		if (isPrime)
			System.out.println(prime + " is a Prime Number");
		else
			System.out.println(prime + " is not a Prime Number");

		isPrime = isPrime1(prime);
		// If isPrime is true then the number is prime else not
		if (isPrime)
			System.out.println(prime + " is a Prime Number");
		else
			System.out.println(prime + " is not a Prime Number");
	}

	// Less Efficient Code
	static boolean prime(int prime) {
		int temp;
		boolean isPrime = true;
		if (prime == 0 || prime == 1) {
			System.out.println(prime + " is not a Prime Number");
		} else {
			for (int i = 2; i <= prime / 2; i++) {
				System.out.println(i);
				temp = prime % i;
				if (temp == 0) {
					isPrime = false;
					break;
				}
			}
		}

		return isPrime;
	}

	//Efficient Code
	static boolean isPrime(int n)
	{
		if(n==1)
			return false;

		for(int i=2; i*i<=n; i++)
		{
			if(n % i == 0)
				return false;
		}

		return true;
	}

	//More Efficient Code
	static boolean isPrime1(int n)
	{
		if(n==1)
			return false;

		if(n==2 || n==3)
			return true;

		if(n%2==0 || n%3==0)
			return false;

		for(int i=5; i*i<=n; i=i+6)
		{
			if(n % i == 0 || n % (i + 2) == 0)
				return false;
		}

		return true;
	}
}