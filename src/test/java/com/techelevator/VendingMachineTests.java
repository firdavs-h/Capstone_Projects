package com.techelevator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class VendingMachineTests {

	VendingMachine testVendingMachine = new VendingMachine();

	@Test
	public void mainMenu_various_tests() {
		// input 1,2,3 or 4 in Scanner should return 1,2,3 or 4
		boolean testInputs = (testVendingMachine.mainMenu().equals("1") || testVendingMachine.mainMenu().equals("2")
				|| testVendingMachine.mainMenu().equals("3") || testVendingMachine.mainMenu().equals("4"));

		Assert.assertEquals(true, testInputs);
	}

	@Test
	public void purchaseMenu_various_tests() {
		// input 1,2 or 3in Scanner should return 1,2 or 3
		boolean testInputs = (testVendingMachine.purchaseMenu().equals("1")
				|| testVendingMachine.purchaseMenu().equals("2") || testVendingMachine.purchaseMenu().equals("3"));

		Assert.assertEquals(true, testInputs);
	}

	@Test
	public void slotChecker_G1_return_false() {

		Assert.assertEquals(false, testVendingMachine.slotCheck("G1"));
	}
}
