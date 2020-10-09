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


	
		
	
	public String purchase(Transactions t, String location) throws IOException {
		System.out.println(location);
		Product updateQuantity = (Product) itemList.values();
		Inventory currentItem = itemList.get(location);
		if(currentItem.getQuantity(location) == 0) {
			return "There are no more left.";
		}
		if(currentItem.getPrice(location) < t.getBalance()) {
			t.printTransaction(currentItem.getName(location), location, (int) currentItem.getPrice(location));  
				updateQuantity.dispense(1);
				totalSales += currentItem.getPrice(location);
				return "You have purchased 1 " + currentItem.getName(location) + ".";
			
		} else {
			return "The cost of this item exceeds your current balance";
		}
		
		
		
	}
	
}
