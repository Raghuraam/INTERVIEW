package com.incubyte.interview.kata;

public class StringCalculator {
 
	public static int Add(String numbers) {

		int total = 0;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		String[] array = numbers.split(",");

		for (String n : array) {

			total = total + Integer.parseInt(n);	
			
		}

		return total;
	}

	public static void main(String[] args) {
		
	
	}

}
