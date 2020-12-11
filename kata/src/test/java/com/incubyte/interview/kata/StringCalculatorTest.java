package com.incubyte.interview.kata;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {
	
	/**
	 * to test empty, "1", "1,2" inputs
	 */
	public void testCase1(){
		
		Assert.assertEquals(0, StringCalculator.Add(""));
		Assert.assertEquals(1, StringCalculator.Add("1"));
		Assert.assertEquals(3, StringCalculator.Add("1,2"));
	}
	
	/**
	 * to test unknown amount of inputs
	 */
	public void testCase2(){
		
		Assert.assertEquals(6, StringCalculator.Add("1,2,3"));
		Assert.assertEquals(10, StringCalculator.Add("1,2,3,4"));
		Assert.assertEquals(155, StringCalculator.Add("1,2,3,4,5,6,7,8,9,10,100"));
	}
	
	/**
	 * to test unknown amount of inputs
	 */
	public void testCase3(){
		
		Assert.assertEquals(6, StringCalculator.Add("1\n2,3"));
		
	}
	
	/**
	 * to support different delimiters
	 */
	public void testCase4(){
		
		Assert.assertEquals(3, StringCalculator.Add(";\n1;2"));
	}
	
	/**
	 * to exclude negative numbers
	 */
	public void testCase5(){
		Assert.assertEquals(3, StringCalculator.Add(";\n1;2;-5"));
	}
	
	/**
	 * to exclude all negative numbers
	 */
	public void testCase6(){
		Assert.assertEquals(0, StringCalculator.Add(";\n-1;-2;-5"));
	}
	
	public void testCase7(){
		Assert.assertEquals(6, StringCalculator.Add(";\n1;-2;-5;5;1005"));
		Assert.assertNotSame(1005, StringCalculator.Add("1005"));
	}
	
	/**
	 * to get called count for Add method
	 */
	public void testCase8(){
		
		Assert.assertNotSame(0, StringCalculator.getCalledCount());
	}
	
	/**
	 * to support longer length delimiter
	 */
	public void testCase9(){
		Assert.assertEquals(6, StringCalculator.Add("[***]\n1***2***3"));
		Assert.assertEquals(106, StringCalculator.Add("[---]\n1---2---3---100"));
	}
		

}
