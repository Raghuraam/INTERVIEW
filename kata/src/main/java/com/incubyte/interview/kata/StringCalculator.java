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
			
				try {
					
					if(Integer.parseInt(n)<0){
						throw new Exception("negatives not allowed "+n);	
					}
					
					total = total + Integer.parseInt(n);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
		}

		return total;
	}

	public static void main(String[] args) {
		
	
	}

}
