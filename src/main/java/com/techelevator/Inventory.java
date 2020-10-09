package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;


public class Inventory {

	private Product product;

	private Map<String, Product> inventoryMap = new HashMap<String, Product>();

	public Inventory() {

	}

	public void setInventory() {
		File vendingFile = new File("vendingmachine.csv");
		try (Scanner fileScanner = new Scanner(vendingFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] temp = line.split("\\|");
				product = new Product(temp[1], Double.parseDouble(temp[2]), temp[3]);
				inventoryMap.put(temp[0], product);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found");
		}

	}

	public Map<String, Product> getInventoryMap() {
		return inventoryMap;
	}

	public String getName(String location) {
		return inventoryMap.get(location).getProductName();

	}

	public double getPrice(String location) {
		return inventoryMap.get(location).getProductPrice();

	}

	public String getType(String location) {
		return inventoryMap.get(location).getProductType();

	}

	public int getQuantity(String location) {
		return inventoryMap.get(location).getProductQuantity();

	}

	public void displayInventory() {
		
	
		DecimalFormat df = new DecimalFormat("###.00");
	
		for (Map.Entry<String, Product> entry: inventoryMap.entrySet()) {
		

			System.out.println(entry.getKey()+"|"+entry.getValue().getProductName()+"|"+
			df.format((double) entry.getValue().getProductPrice())+"|"+entry.getValue().getProductType()+"|"+
			((entry.getValue().getProductQuantity()==0)? "Sold Out": entry.getValue().getProductQuantity()));
			
//			Product i = inventoryMap.get(s);
//			StringBuffer itemString = new StringBuffer();
//			// itemString.append(i.getLocation() + " | ");
//			itemString.append(i.getProductName() + " | ");
//			itemString.append("$" + df.format((double) i.getProductPrice()) + " | ");
//			itemString.append(i.getProductType());
//			if (i.getProductQuantity() == 0) {
//				itemString.append("Sold out");
//			} else {
//				itemString.append(i.getProductQuantity());
//			}
//			items.add(itemString.toString());
		}
		

	}
}
