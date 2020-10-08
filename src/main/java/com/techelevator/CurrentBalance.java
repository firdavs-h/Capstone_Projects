package com.techelevator;

public class CurrentBalance {

	private double balance;
	
	public CurrentBalance() {
		this.balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance += balance;
	}
	
	public String change() {
		int dollar = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		
		while(this.balance >= 0.01) {
			if(this.balance > 1) {
				dollar++;
				this.balance -= 1.0;
			} else if(this.balance > 0.25) {
				quarter++;
				this.balance -= 0.25;
			} else if(this.balance > 0.1) {
				dime++;
				this.balance -= 0.1;
			} else if(this.balance > 0.05) {
				nickel++;
				this.balance -= 0.05;
			} else if(this.balance >= 0.01) {
				penny++;
				this.balance -= 0.01;
			}
		}
		String changeDollars = (dollar == 0 ? "" : (dollar > 1 ? ((String)(dollar + " dollars")): ((String)(dollar + " dollar"))));
		String changeQuarter = (quarter == 0 ? "" : (quarter > 1 ? ((String)(quarter + " quarters")): ((String)(quarter + " quarter"))));
		String changeDime = (dime == 0 ? "" : (dime > 1 ? ((String)(dime + " dimes")): ((String)(dime + " dime"))));
		String changeNickel =(nickel == 0 ? "" : (nickel + " nickel"));
		String changePenny = (penny == 0 ? "" : (penny > 1 ? ((String)(penny + " pennies")): ((String)(penny + " penny"))));
		String changeDollarsCoins = (changeDollars + (dollar == 0 ? "" : ", ") + changeQuarter + (quarter == 0 ? "" : ", ") + changeDime + (dime == 0 ? "" : ", ") + changeNickel + (nickel == 0 ? "" : ", ") + changePenny);
		this.balance = 0;
		return changeDollarsCoins;
	}
	
}
