package com.adventures.designpatterns.adapter;

public class AdapterPattern {

	public static void main(String[] args) {
		String testString = " Formatting line 1. Formatting line 2. Formatting line 3.";
		TextFormattable newLineFormatter = new NewLineFormatter();
		String resultString = newLineFormatter.formatText(testString);
		System.out.println(resultString);

		CsvFormattable csvFormatter = new CsvFormatter();
		TextFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);
		String resultCsvString = csvAdapter.formatText(testString);
		System.out.println(resultCsvString);
	}
}

interface TextFormattable {
	String formatText(String text);
}

class NewLineFormatter implements TextFormattable {
	@Override
	public String formatText(String text) {
		String formattedText = text.replace(".", "\n");
		return formattedText;
	}
}

interface CsvFormattable {
	String formatCsvText(String text);
}

class CsvFormatter implements CsvFormattable {
	@Override
	public String formatCsvText(String text) {
		String formattedText = text.replace(".", ",");
		return formattedText;
	}
}

class CsvAdapterImpl implements TextFormattable {
	CsvFormattable csvFormatter;

	public CsvAdapterImpl(CsvFormattable csvFormatter) {
		this.csvFormatter = csvFormatter;
	}

	@Override
	public String formatText(String text) {
		String formattedText = csvFormatter.formatCsvText(text);
		return formattedText;
	}
}