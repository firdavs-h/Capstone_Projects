package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CurrentBalanceTest {

	public CurrentBalanceTest() {
		
	}
	
	@Test
	public void quarters_machine() {
		//Arrange
		CurrentBalance blanche = new CurrentBalance();
		blanche.setBalance(2.50);
		
		//Act
		String expected = ("10 quarters");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	
	@Test
	public void nickels_machine() {
		//Arrange
		CurrentBalance blanche = new CurrentBalance();
		blanche.setBalance(.05);
		
		//Act
		String expected = ("1 nickel");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	@Test
	public void dime_machine() {
		//Arrange
		CurrentBalance blanche = new CurrentBalance();
		blanche.setBalance(.40);
		
		//Act
		String expected = ("1 quarter, 1 dime, 1 nickel");
		
		//Assert
		Assert.assertEquals(expected, blanche.change());
	}
	
}
