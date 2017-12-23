package com.adventures.ooprinciples.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HankerTest4 {

	// int[] prices = { 1, 2, 3, 4 };
	// int[] prices = { 4, 9, 2, 3 };

	static long calculateAmount(int[] prices) {
		long totalPrice = 0;
		if (prices.length > 0) {
			List<Integer> minValue = new ArrayList<>();

			for (int i = 0; i < prices.length; i++) {
				if (i == 0) {
					totalPrice += prices[i];
					minValue.add(prices[i]);
					// } else if (i == 1) {
					// totalPrice = totalPrice + (prices[i] - prices[i-1]);
					// totalPrice += prices[i];
					// minValue.add(prices[i]);
				} else {
					minValue.add(prices[i]);
					int min = Collections.min(minValue);

					if (min > prices[i]) {
						totalPrice += 0;
					} else {
						totalPrice += (prices[i] - min);
					}
				}
			}
			/*
			 * for (int i = 0; i < prices.length - 1; i++) { if (i == 0) {
			 * totalPrice += prices[i]; minValue.add(prices[i]); } else { for
			 * (int j = i + 1; j <= (i + 1); j++) { minValue.add(prices[i]); int
			 * min = Collections.min(minValue);
			 * 
			 * if (min > prices[i]) { totalPrice += 0; } else { totalPrice +=
			 * (prices[i] - min); } } }
			 * 
			 * }
			 */
		}

		return totalPrice;
	}

	public static int minValue(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[0];
	}

	public static void main(String[] args) {
		// HankerTest4 hankerTest4 = new HankerTest4();
		// System.out.println(hankerTest4.calculateAmount());

		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			try {
				bw = new BufferedWriter(new FileWriter(fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		long res;
		int prices_size = 0;
		prices_size = Integer.parseInt(in.nextLine().trim());

		int[] prices = new int[prices_size];
		for (int i = 0; i < prices_size; i++) {
			int prices_item;
			prices_item = Integer.parseInt(in.nextLine().trim());
			prices[i] = prices_item;
		}

		res = calculateAmount(prices);
		try {
			bw.write(String.valueOf(res));
			bw.newLine();

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}