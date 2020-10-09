package com.techelevator;

import org.junit.Assert; 
import org.junit.Test;

public class SalesTest {
	
	Inventory testInventory =new Inventory();
	Sales testSales =new Sales();
	
	@Test
	public void setSales_Cloud_Popcorn_print_00() {

		Assert.assertEquals(0.0, testSales.getSalesMap().get("Cloud Popcorn"),0);
	}
	@Test
	public void printSalesTest() {
		
		testSales.printSales();
	}
	@Test
	public void recordSales_for_A1_updates_Potato_Crisps_to_3_05(){
		
		testSales.recordSale("A1");
		Assert.assertEquals(3.05, testSales.getSalesMap().get("Potato Crisps"),0);
		testSales.printSales();
	}

}
