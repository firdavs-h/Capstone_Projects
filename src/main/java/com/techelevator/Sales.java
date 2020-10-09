package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Sales extends Inventory {
	
	private Map<String, Double> salesMap = new HashMap<String, Double>();
	//private Inventory currentInvetory=new Inventory();

	public Sales() {
		
		
	}
	
	public void setSales() {
		Map<String, Product> temp=super.inventoryMap;
		
		for (Product product : temp.values()) {
			
			salesMap.put(product.getProductName(), 0.0);
		}
	}
	
	public void printSales() {
		
		for (String key: salesMap.keySet()) {
			
			System.out.println(key+"|"+salesMap.get(key));
			
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
