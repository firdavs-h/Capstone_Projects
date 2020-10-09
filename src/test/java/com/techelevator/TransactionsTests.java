package com.techelevator;


import org.junit.Assert;
import org.junit.Test;
public class TransactionsTests {
	@Test
	public void feedMoney_test() {
		Transactions test = new Transactions();
		String actual = test.feedMoney(5);
		Assert.assertEquals("5 dollars accepted", actual );
	}
	@Test 
	public void feedMoney_1dollarTest() {
		Transactions test = new Transactions();
		String actual = test.feedMoney(1);
		Assert.assertEquals("1 dollar accepted", actual);
	}
	@Test
	public void feedMoney_wrongAmountTest() {
		Transactions test = new Transactions();
		String actual = test.feedMoney(3);
		Assert.assertEquals("Amount not accepted. Please only feed whole dollar amounts into the vending machine.", actual); 
	}


} 
