package com.techelevator;

//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;

public class CurrentBalance {

	protected double balance;
	
	public CurrentBalance() {
		this.balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String change() {
		int dollar = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		
//		BigDecimal qCoin = new BigDecimal(0.25).setScale(2, RoundingMode.HALF_EVEN);
//		BigDecimal dCoin = new BigDecimal(0.10).setScale(2, RoundingMode.HALF_EVEN);
//		BigDecimal nCoin = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_EVEN);
//		BigDecimal pCoin = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_EVEN);
			this.balance += 0.01;
			while(this.balance > 0.01) {
				if(this.balance > 1) {
					dollar++;
					this.balance--;
				} else if(this.balance > .25) {
					quarter++;
					this.balance -= 0.25;
				} else if(this.balance > .1) {
					dime++;
					this.balance -= .1;
				} else if(this.balance > .05) {
					nickel++;
					this.balance -= .05;
				} else if(this.balance >= .01) {
					penny++;
					this.balance -= .01;
				}
			}

		String changeDollars = (dollar == 0 ? "" : (dollar > 1 ? ((String)(dollar + " dollars")): ((String)(dollar + " dollar"))));
		String changeQuarter = (quarter == 0 ? "" : (quarter > 1 ? ((String)(quarter + " quarters")): ((String)(quarter + " quarter"))));
		String changeDime = (dime == 0 ? "" : (dime > 1 ? ((String)(dime + " dimes")): ((String)(dime + " dime"))));
		String changeNickel =(nickel == 0 ? "" : (nickel + " nickel"));
		String changePenny = (penny == 0 ? "" : (penny > 1 ? ((String)(penny + " pennies")): ((String)(penny + " penny"))));
		String changeDollarsCoins = (changeDollars + (quarter == 0 ? "" : ", ") + changeQuarter + (dime == 0 ? "" : ", ") + changeDime + (nickel == 0 ? "" : ", ") + changeNickel + (penny == 0 ? "" : ", ") + changePenny);
		this.balance = 0;
		return changeDollarsCoins;
	}
	
}
