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
		blanche.setBalance(2.50);
		
		//Act
		String expected = ("2 dollars, 2 quarters");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	
}
