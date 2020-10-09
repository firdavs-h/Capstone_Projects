package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

	private Product product;
	private List<String> keySetOrder = new ArrayList<String>();
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
				keySetOrder.add(temp[0]);
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

		for (int i = 0; i < keySetOrder.size(); i++) {
			String key = keySetOrder.get(i);

			System.out.println(key + " | " + getName(key) + " | " + df.format((double) getPrice(key)) + " | "
					+ getType(key) + " | " + ((getQuantity(key) == 0) ? "Sold Out" : getQuantity(key)));
		}

	}

}
