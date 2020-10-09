package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class VendingMachine {
	//Map<String, Inventory> itemList = new HashMap<>();
	Transactions log =new Transactions();
	Scanner myScan=new Scanner(System.in);
    private Sales inventory=new Sales();
    Transactions balance = new Transactions();
	public VendingMachine() {
		
	}


	
		
	
	public String purchase() throws IOException {
		double preBalance = balance.getBalance();
		System.out.println("Please enter slot#: ");
		String location = myScan.nextLine().toUpperCase();
		
		
		
		if(inventory.getQuantity(location) == 0) {
			return "There are no more left.";
		}
		if(inventory.getPrice(location) <= balance.getBalance()) {
			inventory.getProduct(location).dispense();
			log.printTransaction(inventory.getName(location), location,  inventory.getPrice(location), preBalance);  
			balance.payment(inventory.getPrice(location));
			inventory.recordSale(location);
				return "You have purchased 1 " + inventory.getName(location) + ".";
				
		} else {
			return "The cost of this item exceeds your current balance";
		}
		
		
		
	}
	
	public String mainMenu() {
		String input;
		System.out.println("(1) Display Vending Machine Items\n" + 
				"(2) Purchase\n" + 
				"(3) Exit");
		input=myScan.nextLine();
		boolean validInput=(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"));
		while(!validInput) {
		
			System.out.println("Please select 1, 2 or 3");
			input=myScan.nextLine();
			validInput=(input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4"));
		}
		return input;
	}
	public String purchaseMenu() {
		String input;
		System.out.println("(1) Feed Money\n" + 
				"(2) Select Product\n" + 
				"(3) Finish Transaction \n"
				+ "\tCurrent money provided: " + balance.displayBalance()); 
		input=myScan.nextLine();
		boolean validInput=(input.equals("1")||input.equals("2")||input.equals("3"));
		while(!validInput) {
		
			System.out.println("Please select 1, 2 or 3");
			input=myScan.nextLine();
			validInput=(input.equals("1")||input.equals("2")||input.equals("3"));
		}
		return input;
	}
	public void displayMenu() {
		inventory.displayInventory();
		
	}
	
	public void feedMoneyExt() throws IOException {
		double preBalance = balance.getBalance();
		System.out.println("Enter bills: ");
		String input = myScan.nextLine();
		int output = Integer.parseInt(input);
		balance.feedMoney(output);
		log.printTransaction("FEED", " MONEY", balance.getBalance(), preBalance); 
		
	}
	
	public void changeMachine() throws IOException {
		double preBalance = balance.getBalance();
		System.out.println("Your change is: " + balance.change() + "\n Your current balance is: " + balance.displayBalance());
		log.printTransaction("GIVE", " CHANGE", balance.getBalance(), preBalance);
	}
	
	public void reportDatSales() {
		inventory.printSales();
	}
}
