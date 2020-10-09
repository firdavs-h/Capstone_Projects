package com.techelevator;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class VendingMachine {

	Transactions log = new Transactions();
	Scanner myScan = new Scanner(System.in);
	private Sales inventory = new Sales();
	Transactions balance = new Transactions();

	public VendingMachine() {

	}

	public String purchase() throws IOException {
		double preBalance = balance.getBalance();
		System.out.println("Please enter slot#: ");
		String location = myScan.nextLine().toUpperCase();
		if (slotCheck(location)) {

			if (inventory.getQuantity(location) == 0) {
				return "There are no more left.";
			}
			if (inventory.getPrice(location) <= balance.getBalance()) {
				inventory.getProduct(location).dispense();
				balance.payment(inventory.getPrice(location));
				log.printTransaction(inventory.getName(location), location, balance.displayBalance(), preBalance);
				inventory.recordSale(location);
				return "You have purchased 1 " + inventory.getName(location) + flavorText(location);

			} else {
				return "The cost of this item exceeds your current balance";
			}
		} else {

		
			return "Invalid slot number";
		}

	}

	public String mainMenu() {
		String input;
		System.out.println("(1) Display Vending Machine Items\n" + "(2) Purchase\n" + "(3) Exit");
		input = myScan.nextLine();
		boolean validInput = (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4"));
		while (!validInput) {

			System.out.println("Please select 1, 2 or 3");
			input = myScan.nextLine();
			validInput = (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4"));
		}
		return input;
	}

	public String purchaseMenu() {
		String input;
		System.out.println("(1) Feed Money\n" + "(2) Select Product\n" + "(3) Finish Transaction \n"
				+ "\tCurrent money provided: " + balance.displayBalance());
		input = myScan.nextLine();
		boolean validInput = (input.equals("1") || input.equals("2") || input.equals("3"));
		while (!validInput) {

			System.out.println("Please select 1, 2 or 3");
			input = myScan.nextLine();
			validInput = (input.equals("1") || input.equals("2") || input.equals("3"));
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
		log.printTransaction("FEED", " MONEY: ", balance.displayBalance(), preBalance);

	}

	public void changeMachine() throws IOException {
		double preBalance = balance.getBalance();
		System.out.println(
				"Your change is: " + balance.change() + "\n Your current balance is: " + balance.displayBalance());
		log.printTransaction("GIVE", " CHANGE: ", balance.displayBalance(), preBalance);
	}

	public void reportDatSales() {
		inventory.printSales();
	}

	public String flavorText(String location) {
		if (inventory.getType(location).equals("Chip")) {
			return ". Crunch Crunch, Yum!";
		} else if (inventory.getType(location).equals("Candy")) {
			return ". Munch Munch, Yum!";
		} else if (inventory.getType(location).equals("Drink")) {
			return ". Glug Glug, Yum!";
		} else if (inventory.getType(location).equals("Gum")) {
			return ". Chew Chew, Yum!";
		}
		return null;
	}

	public boolean slotCheck(String location) {
		Set<String> slots = new TreeSet<String>(inventory.getInventoryMap().keySet());
		boolean slotExist = true;
		if (!(slots.contains(location))) {
			slotExist = false;
		}
		return slotExist;
	}
}
