package com.techelevator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class VendingMachineTests {
	
	VendingMachine testVendingMachine =new VendingMachine();


	@Test
	public void mainManu_various_tests() {
		//input 1,2,3 or 4 in Scanner should return 1,2,3 or 4 
		boolean testInputs=(testVendingMachine.mainManu().equals("1") || testVendingMachine.mainManu().equals("2") ||
				testVendingMachine.mainManu().equals("3") || testVendingMachine.mainManu().equals("4"));
		
		Assert.assertEquals(true, testInputs);
	}
	@Test
	public void purchaseManu_various_tests() {
		//input 1,2 or 3in Scanner should return 1,2 or 3 
		boolean testInputs=(testVendingMachine.purchaseManu().equals("1") || testVendingMachine.purchaseManu().equals("2") ||
				testVendingMachine.purchaseManu().equals("3"));
		
		Assert.assertEquals(true, testInputs);
	}
	
}
