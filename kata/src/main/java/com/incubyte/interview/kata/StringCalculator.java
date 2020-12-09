package com.incubyte.interview.kata;

public class StringCalculator {
 
	public static int Add(String numbers) {

		int total = 0;
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		String[] array = numbers.split(",|\\n|;");

		for (String n : array) {
			if(n.equals(" ") || n.isEmpty()){
				continue;
			}
			total = total + Integer.parseInt(n);	
			
		}

		return total;
	}

	public static void main(String[] args) {
		
	
	}

}
