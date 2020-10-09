package com.techelevator;

import org.junit.Assert;
import org.junit.Test;



public class ProductTest {
	Product testProduct = new Product("Random chips", 1.25, "chip");
	
	@Test
	public void randomProductTest() {
		
		Assert.assertEquals("Random chips", testProduct.getProductName());
		Assert.assertEquals("chip", testProduct.getProductType());
		Assert.assertEquals(1.25, testProduct.getProductPrice(),0);
		Assert.assertEquals(5, testProduct.getProductQuantity());
		testProduct.dispense();
		testProduct.dispense();
		testProduct.dispense();
		testProduct.dispense();
		Assert.assertEquals(1, testProduct.getProductQuantity());
		testProduct.dispense();
		Assert.assertEquals(0, testProduct.getProductQuantity());
		testProduct.dispense();
		Assert.assertEquals(0, testProduct.getProductQuantity());
	}

}
