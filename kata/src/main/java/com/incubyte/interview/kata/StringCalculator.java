package com.incubyte.interview.kata;

public class StringCalculator {
 
	private static int count;
	public static int Add(String numbers) {
		
		count++;
		
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
					int temp = Integer.parseInt(n);
					if(temp<0){
						throw new Exception("negatives not allowed "+n);	
					}else if(temp>1000){
						continue;
					}
					
					total = total + temp;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			
		}

		return total;
	}
	
	public static int getCalledCount(){
		
		return count;
	}

	public static void main(String[] args) {
		
	
	}

}
