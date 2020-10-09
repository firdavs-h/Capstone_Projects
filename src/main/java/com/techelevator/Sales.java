package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;
import java.util.Map;

public class Sales extends Inventory {

	private Map<String, Double> salesMap = new TreeMap<String, Double>();
	

	public Sales() {
		setSales();
	}

	public void setSales() {
		Map<String, Product> temp = super.inventoryMap;

		for (Product product : temp.values()) {

			salesMap.put(product.getProductName(), 0.0);
		}
	}

	public void printSales() {

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM-dd-uuuu_hh:mm _a");

		File report = new File("Sales_report" + formatTime.format(date) + ".txt");
		double totalSales=0;
		try (FileWriter fileWrite = new FileWriter(report, true)) {
			for (String key : salesMap.keySet()) {
				totalSales+=salesMap.get(key);
				fileWrite.write(key + " | " + salesMap.get(key) + "\n");
				System.out.println(key + " | " + salesMap.get(key));
			}
			System.out.println("\nTOTAL SALES: "+totalSales);

		} catch (IOException e) {
			System.out.println("Not able to write sales report file");
		}

	}

	public void recordSale(String location) {

		String name = super.getName(location);
		Double value = salesMap.get(name) + super.getPrice(location);

		salesMap.put(name, value);

	}

	public Map<String, Double> getSalesMap() {
		return salesMap;
	}

}
