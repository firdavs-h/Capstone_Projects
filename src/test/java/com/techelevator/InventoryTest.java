package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Inventory;




public class InventoryTest {
	
	Inventory testInventory =new Inventory();

	@Test
	public void mapkey_A2_returns_productName_Stackers() {
		testInventory.setInventory();
		String expected= "Stackers";
		String actual= testInventory.getInventoryMap().get("A2").getProductName();
		Assert.assertEquals(expected, actual);
		
	}
}
