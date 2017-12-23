package com.adventures.problems;

import java.util.Scanner;

public class CompoundInterest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();

		for (int i = 0; i < count; i++) {
			double P;
			double T;
			double N;
			double R;

			P = scan.nextDouble();
			T = scan.nextDouble();
			N = scan.nextDouble();
			R = scan.nextDouble();
			double r = R / 100;
			double mn = r / N;
			double base = 1 + mn;
			double power = N * T;
			double amt = P * (Math.pow(base, power));

			System.out.println((int) amt);
		}

		scan.close();
	}
}