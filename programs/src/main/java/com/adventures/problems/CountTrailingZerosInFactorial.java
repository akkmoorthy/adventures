package com.adventures.problems;

import java.io.*;
import java.util.*;

//Time Complexity: theta(log n)
class CountTrailingZerosInFactorial {

	static int countTrailingZerosLoop(int n)
	{
		int factorial = 1;

		for(int i=2; i<=n; i++)
		{
			factorial = factorial * i;
		}

		int res = 0;
		while(factorial % 10 == 0) {
			res++;
			factorial = factorial / 10;
		}
		return res;
	}

	static int countTrailingZeros(int n)
	{
		int res = 0;

		for(int i=5; i<=n; i=i*5)
		{
			res = res + (n / i);
		}

		return res;
	}

	public static void main (String[] args) {
		
		int number = 5;
		//This will cause issue as the more the digits then int cant hold the value and will not get valid output
		System.out.println(countTrailingZerosLoop(number));
		//The below is preferred as we take the common number like 5 and then do the calculation
		System.out.println(countTrailingZeros(number));

	}
}