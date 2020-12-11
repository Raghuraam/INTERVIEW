package com.incubyte.interview.kata;

public class StringCalculator {
 
	private static int count;
	
	private static String escapedDelimiter(String str) {
		String resultStr = "";
		
		for(int i=0; i<str.length(); i++) {
			resultStr = resultStr+"\\"+str.charAt(i);
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
		int delimieterIndex = 0;
		String delimiter;
		
		if(numbers.indexOf('[')!=-1 && numbers.indexOf('[')==0) {
			
			delimieterIndex = numbers.indexOf(']');
			delimiter = numbers.substring(1, delimieterIndex);
			array = numbers.split("\n");
			array = array[1].split(escapedDelimiter(delimiter));
		}
		else if(numbers.indexOf('\n')!=-1 && numbers.indexOf('\n')==0) {
			delimieterIndex = numbers.indexOf('\n');
			delimiter = numbers.substring(0, delimieterIndex);
			array = numbers.split(delimiter);
		} else {
			array = numbers.split(",|\\n|;");
		}

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
