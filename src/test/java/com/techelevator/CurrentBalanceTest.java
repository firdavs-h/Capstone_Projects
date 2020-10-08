package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CurrentBalanceTest {

	public CurrentBalanceTest() {
		
	}
	
	@Test
	public void change_machine() {
		//Arrange
		CurrentBalance blanche = new CurrentBalance();
		blanche.setBalance(100.99);
		
		//Act
		String expected = ("100 dollars, 3 quarters, 2 dimes, 4 pennies");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	
}
