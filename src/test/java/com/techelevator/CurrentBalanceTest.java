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
		blanche.setBalance(2.14);
		
		//Act
		String expected = ("2 dollars, 1 dime, 4 pennies");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	
}
