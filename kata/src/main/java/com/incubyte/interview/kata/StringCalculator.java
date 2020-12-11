package com.incubyte.interview.kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private static int count;

	private static String escapedDelimiter(String str) {
		String resultStr = "";

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '|') {
				resultStr = resultStr + str.charAt(i);
			} else {
				resultStr = resultStr + "\\" + str.charAt(i);
			}

		}
		return resultStr;
	}

	public static int Add(String numbers) {

		count++;

		int total = 0;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		String[] array = null;
		List<String> demiliterList = new ArrayList<String>();

		if (numbers.charAt(0) == '[') {

			array = numbers.split("\n");
			String delimitersString = array[0];

			String temp = "";
			for (int i = 0; i < delimitersString.length(); i++) {

				if (delimitersString.charAt(i) != '[' && delimitersString.charAt(i) != ']') {
					temp = temp + delimitersString.charAt(i);
				} else if (delimitersString.charAt(i) == ']') {
					demiliterList.add(temp.trim());
					temp = "";
				}
			}

			String escapedDelimiter = "";
			for (String each : demiliterList) {

				escapedDelimiter = escapedDelimiter + each + "|";

			}

			escapedDelimiter = escapedDelimiter.substring(0, escapedDelimiter.length() - 1);

			array = array[1].split(escapedDelimiter(escapedDelimiter));

		} else {
			array = numbers.split(",|\\n|;");
		}

		for (String n : array) {
			if (n.equals(" ") || n.isEmpty()) {
				continue;
			}

			try {
				int temp = Integer.parseInt(n);
				if (temp < 0) {
					throw new Exception("negatives not allowed " + n);
				} else if (temp > 1000) {
					continue;
				}

				total = total + temp;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return total;
	}

	public static int getCalledCount() {

		return count;
	}

	public static void main(String[] args) {

	}
}
