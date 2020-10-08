package com.techelevator;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class VendingMachine {
	private Map<String, Inventory> itemList = new HashMap<>();
	private int totalSales = 0;

	
	
	public List<String> displayInventory() {
		List<String> items = new ArrayList<>();
		Set<String> itemKeys = itemList.keySet();
		for(String s : itemKeys) {
			Inventory i = itemList.get(s);
			StringBuffer itemString = new StringBuffer();
			itemString.append(i.getLocation() + " | ");
			itemString.append(i.getName() + " | ");
			itemString.append("$" i.getPrice() + " | ");
			itemString.append(i.getType);
			if(i.getQuantity == 0) {
				itemString.append("Sold out");
			} else {
				itemString.append(i.getQuantity());
			} items.add(itemString.toString());
		}
		return items;
		
	}
	
	
}
