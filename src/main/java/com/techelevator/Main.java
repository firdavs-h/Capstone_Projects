package com.techelevator;

public class Main {
	
	
	public static void main(String[] args) {
		
		VendingMachine run =new VendingMachine();

		String input=run.mainMenu();
		if(input.equals("1")) {
			run.displayMenu();
			run.mainMenu();
		}
		if(input.equals("2")) {
			String purchaseInput=run.purchaseMenu();
			if(purchaseInput.equals("1")) {
				//feed money
				
			}
		}
		if(input.equals("3")) {
			System.exit(0);
			
		}
		if(input.equals("4")) {
			System.exit(0);
			
		}

	}

}
