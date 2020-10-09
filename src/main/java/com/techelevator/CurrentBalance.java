package com.techelevator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CurrentBalance {

	protected BigDecimal balance;
	
	public CurrentBalance() {
		this.balance = BigDecimal.ZERO;
	}

	public double getBalance() {
		double doubleBalance = balance.doubleValue();
		return doubleBalance;
	}

	public void setBalance(double balance) {
		this.balance = this.balance.add(new BigDecimal(balance)).setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public String change() {
		int dollar = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		
		BigDecimal qCoin = new BigDecimal(0.25).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal dCoin = new BigDecimal(0.10).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal nCoin = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal pCoin = new BigDecimal(0.01).setScale(2, RoundingMode.HALF_EVEN);
		try {
			while(this.balance.compareTo(pCoin) == 1) {
				if(this.balance.compareTo(BigDecimal.ONE) == 1) {
					dollar++;
					this.balance.subtract(BigDecimal.ONE);
				} else if(this.balance.compareTo(qCoin) == 1) {
					quarter++;
					this.balance.subtract(qCoin);
				} else if(this.balance.compareTo(dCoin) == 1) {
					dime++;
					this.balance.subtract(dCoin);
				} else if(this.balance.compareTo(nCoin) == 1) {
					nickel++;
					this.balance.subtract(nCoin);
				} else if(this.balance.compareTo(pCoin) == 1) {
					penny++;
					this.balance.subtract(pCoin);
				}
			}
		}
		catch(Exception e) {
			System.out.println("infinite loop");
		}
		String changeDollars = (dollar == 0 ? "" : (dollar > 1 ? ((String)(dollar + " dollars")): ((String)(dollar + " dollar"))));
		String changeQuarter = (quarter == 0 ? "" : (quarter > 1 ? ((String)(quarter + " quarters")): ((String)(quarter + " quarter"))));
		String changeDime = (dime == 0 ? "" : (dime > 1 ? ((String)(dime + " dimes")): ((String)(dime + " dime"))));
		String changeNickel =(nickel == 0 ? "" : (nickel + " nickel"));
		String changePenny = (penny == 0 ? "" : (penny > 1 ? ((String)(penny + " pennies")): ((String)(penny + " penny"))));
		String changeDollarsCoins = (changeDollars + (dollar == 0 ? "" : ", ") + changeQuarter + (quarter == 0 ? "" : ", ") + changeDime + (dime == 0 ? "" : ", ") + changeNickel + (nickel == 0 ? "" : ", ") + changePenny);
		this.balance = BigDecimal.ZERO;
		return changeDollarsCoins;
	}
	
}
