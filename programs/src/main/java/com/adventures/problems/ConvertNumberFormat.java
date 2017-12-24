package com.adventures.problems;

public class ConvertNumberFormat {

	public static void main(String[] args) {
		convertBinaryToDecimal();
		convertDecimalToBinary();
		convertOctalToDecimal();
		convertDecimalToOctal();
		convertHexadecimalToDecimal();
		convertDecimalToHexadecimal();
	}

	private static void convertBinaryToDecimal() {
		String strBinaryNumber = "111000";

		int decimalNumber = Integer.parseInt(strBinaryNumber, 2);
		System.out.printf("After converting Binary number of %s to Decimal number is %d\n", strBinaryNumber,
				decimalNumber);
	}

	private static void convertDecimalToBinary() {
		int decimalNumber = 56;

		String strBinaryNumber = Integer.toBinaryString(decimalNumber);
		System.out.printf("After converting Decimal number of %d to Binary number is %s\n", decimalNumber,
				strBinaryNumber);
	}

	private static void convertOctalToDecimal() {
		String strOctalNumber = "33";

		int decimalNumber = Integer.parseInt(strOctalNumber, 8);
		System.out.printf("After converting Octal number of %s to Decimal number is %d\n", strOctalNumber,
				decimalNumber);
	}

	private static void convertDecimalToOctal() {
		int decimalNumber = 56;

		String strOctalNumber = Integer.toOctalString(decimalNumber);
		System.out.printf("After converting Decimal number of %d to Octal number is %s\n", decimalNumber,
				strOctalNumber);
	}

	private static void convertHexadecimalToDecimal() {
		String strHexadecimalNumber = "20";

		int decimalNumber = Integer.parseInt(strHexadecimalNumber, 16);
		System.out.printf("After converting Hexadecimal number of %s to Decimal number is %d\n", strHexadecimalNumber,
				decimalNumber);
	}

	private static void convertDecimalToHexadecimal() {
		int decimalNumber = 32;

		String strHexadecimalNumber = Integer.toHexString(decimalNumber);
		System.out.printf("After converting Decimal number of %d to Hexadecimal number is %s\n", decimalNumber,
				strHexadecimalNumber);
	}
}
