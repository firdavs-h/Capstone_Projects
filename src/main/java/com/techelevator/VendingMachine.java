package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class VendingMachine {
	Map<String, Inventory> itemList = new HashMap<>();
	private int totalSales = 0;
	

	public VendingMachine() {

	}


	public List<String> displayInventory() {
		List<String> items = new ArrayList<>();
		Set<String> itemKeys = itemList.keySet();
		DecimalFormat df = new DecimalFormat("###.00");
		for(String s : itemKeys) {
			Inventory i = itemList.get(s);
			StringBuffer itemString = new StringBuffer();
			//itemString.append(i.getLocation() + " | ");
			itemString.append(i.getName(s) + " | ");
			itemString.append("$" + df.format((double)i.getPrice(s)) + " | ");
			itemString.append(i.getType(s));
			if(i.getQuantity(s) == 0) {
				itemString.append("Sold out");
			} else {
				itemString.append(i.getQuantity(s));
			} items.add(itemString.toString());
		}
		return items;
		
	} 
	public String purchase(CurrentBalance b, String location) {
		return null;
	}
	public void printSalesReport() {
		
	}
}
