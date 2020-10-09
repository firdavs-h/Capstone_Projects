package com.techelevator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class VendingMachineTests {
	
	VendingMachine testVendingMachine =new VendingMachine();


	@Test
	public void mainManu_various_tests() {
		//input 3 in Scanner should return 3
		boolean testInputs=(testVendingMachine.mainManu().equals("1") || testVendingMachine.mainManu().equals("2") ||
				testVendingMachine.mainManu().equals("3") || testVendingMachine.mainManu().equals("4"));
		
		Assert.assertEquals(true, testInputs);
	}
	
}
