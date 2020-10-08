package com.techelevator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class VendingMachineTests {
	@Test
	public void display_items_is_properly_displayed() {
		VendingMachine vending = new VendingMachine();
		List<String> expected = new ArrayList<>();
		expected.add("A1|Potato Crisps|3.05|Chip");
		expected.add("B1|Stackers|1.45|Chip");
		List<String> actual = vending.displayInventory();
		Assert.assertEquals(expected, actual);
		
	}

}
