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
	@Test
	public void display_items_is_properly_displayed() {
		testInventory.setInventory();
		testInventory.displayInventory();
//		Inventory vending = new Inventory();
//		List<String> expected = new ArrayList<>();
//		expected.add("A1|Potato Crisps|3.05|Chip");
//		expected.add("B1|Stackers|1.45|Chip");
//		List<String> actual = vending.displayInventory();
//		Assert.assertEquals(expected, actual);
		
	}
}
