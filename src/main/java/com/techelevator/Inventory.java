package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
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

}
