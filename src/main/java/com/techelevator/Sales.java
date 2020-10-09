package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Sales {
	
	private Map<String, Double> salesMap = new HashMap<String, Double>();
	private Inventory currentInvetory;

	public Sales() {
		
		
	}
	
	public void setSales() {
		Map<String, Product> temp=currentInvetory.getInventoryMap();
		
		for (Product product : temp.values()) {
			
			salesMap.put(product.getProductName(), 0.0);
		}
	}
	
	public void printSales() {
		
		for (Map.Entry<String, Double> entry: salesMap.entrySet()) {
			
			System.out.println(entry.getKey());
			
		}
		
	}

}
