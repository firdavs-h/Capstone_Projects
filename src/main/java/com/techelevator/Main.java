package com.techelevator;

import java.io.IOException;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		VendingMachine run = new VendingMachine();

		
		boolean leaveLoop = false;
		while(!leaveLoop) {
			String input=run.mainMenu();
			if(input.equals("1")) {
				run.displayMenu();
			} else if(input.equals("2")) {			
				boolean leaveOtherLoop = false;
				while(!leaveOtherLoop) {
					String purchaseInput=run.purchaseMenu();
					if(purchaseInput.equals("1")) {
						run.feedMoneyExt();
					} else if(purchaseInput.equals("2")) {
						System.out.println(run.purchase());
					} else if(purchaseInput.equals("3")) {
						run.changeMachine();
						leaveOtherLoop = true;
					}
				}
			} else if(input.equals("3")) {
				leaveLoop = true;
				System.exit(0);
				
			} else if(input.equals("4")) {
				run.reportDatSales();
				
			}
		}

	}

}
