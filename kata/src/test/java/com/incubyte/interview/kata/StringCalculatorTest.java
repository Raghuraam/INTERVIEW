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
		

}
