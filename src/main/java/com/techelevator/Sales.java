package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sales extends Inventory {
	
	private Map<String, Double> salesMap = new HashMap<String, Double>();
	private Inventory currentInvetory=new Inventory();

	public Sales() {
		setSales();
	}
	
	public void setSales() {
		Map<String, Product> temp=super.inventoryMap;
		
		for (Product product : temp.values()) {
			
			salesMap.put(product.getProductName(), 0.0);
		}
	}
	
	public void printSales() {
		File report = new File("Sales_report.txt");
		if(report.exists()) {
			report.delete();
		}
		try(FileWriter fileWrite =new FileWriter(report,true)){
		for (String key: salesMap.keySet()) {
			fileWrite.write(key+"|"+salesMap.get(key)+"\n");
			System.out.println(key+"|"+salesMap.get(key));
		}
			
		} catch (IOException e) {
			System.out.println("Not able to write sales report file");
		}
		
	}
	public void recordSale(String location) {
		
		String name =super.getName(location);
		Double value =salesMap.get(name)+super.getPrice(location);
		
		salesMap.put(name,value);
		
	}

	public Map<String, Double> getSalesMap() {
		return salesMap;
	}

}
