package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions extends CurrentBalance {
	
	private boolean isComplete = false;
	
	

	public void transactionComplete() {
		isComplete = true;
	}

	public boolean getTransactionStatus() {
		return isComplete;
	}

	public void printTransaction(String itemName, String itemLocation, double itemPrice) throws IOException {
		File transactionLog = new File("Log.txt");
		if (!transactionLog.exists()) {
			try {
				transactionLog.createNewFile();
			} catch (IOException e) {
				System.out.println("Something went wrong");
			}
			try (PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {
				pw.println("DateTime  |Product|Slot|AmountAccepted|Balance");

			}

		}
		try(PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true))) {
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " | ");
			pw.print(itemName + " | ");
			pw.print(itemLocation + " | ");
			pw.print(getBalance() + " | ");
			pw.println(getBalance() - itemPrice);
		}
	}
	public String feedMoney(int amount) {
		if(amount == 1.00 || amount == 2.00 || amount == 5.00 || amount == 10.00) {
			setBalance(amount);
			return amount + (amount > 1 ? " dollars" : " dollar") + " accepted";
		} else {
			return "Amount not accepted. Please only feed whole dollar amounts into the vending machine.";
		}
	}
}
