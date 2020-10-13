package com.techelevator;

public class Product {
	
	private String productName;
	private double productPrice;
	private String productType;
	private int quantity;
	
	public Product(String productName, double productPrice, String productType) {
		
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.quantity=5;
	}



	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public String getProductType() {
		return productType;
	}	
	public int getProductQuantity() {
		return quantity;
	}
	
	public void dispense() {
		if(quantity>0) {
		this.quantity--;
		}else {
			System.out.println("Not enough quantity left");
		}
	
	}

}
