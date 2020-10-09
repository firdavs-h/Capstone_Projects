package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrentBalance {

	protected BigDecimal balance;
	
	public CurrentBalance() {
		this.balance = BigDecimal.ZERO;
	}

	public double getBalance() {
		double doubleBalance = balance.doubleValue();
		return doubleBalance;
	}
	
	public String displayBalance() {
		String output = null;
		if(balance.compareTo(BigDecimal.ZERO) == 1) {
			DecimalFormat df = new DecimalFormat("###.00");
			output = df.format(getBalance());	
		} else {
			output = "0.00";
		}
		return output;
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
		
		
	
			while(this.balance.compareTo(BigDecimal.ZERO) == 1) {
			//	if(this.balance.compareTo(BigDecimal.ONE) >= 0) {
					//dollar++;
					//this.balance = this.balance.subtract(BigDecimal.ONE);
				//} else 
					if(this.balance.compareTo(qCoin) >= 0) {
					quarter++;
					this.balance = this.balance.subtract(qCoin);
				} else if(this.balance.compareTo(dCoin) >= 0) {
					dime++;
					this.balance = this.balance.subtract(dCoin);
				} else if(this.balance.compareTo(nCoin) >= 0) {
					nickel++;
					this.balance = this.balance.subtract(nCoin);
				} else if(this.balance.compareTo(pCoin) >= 0) {
					penny++;
					this.balance = this.balance.subtract(pCoin);
				}
			}

		String changeDollars = (dollar == 0 ? "" : (dollar > 1 ? ((String)(dollar + " dollars")): ((String)(dollar + " dollar"))));
		String changeQuarter = (quarter == 0 ? "" : (quarter > 1 ? ((String)(quarter + " quarters")): ((String)(quarter + " quarter"))));
		String changeDime = (dime == 0 ? "" : (dime > 1 ? ((String)(dime + " dimes")): ((String)(dime + " dime"))));
		String changeNickel =(nickel == 0 ? "" : (nickel + " nickel"));
		String changePenny = (penny == 0 ? "" : (penny > 1 ? ((String)(penny + " pennies")): ((String)(penny + " penny"))));
		String changeDollarsCoins = (changeDollars + (quarter == 0 ? "" : "") + changeQuarter + (dime == 0 ? "" : ", ") + changeDime + (nickel == 0 ? "" : ", ") + changeNickel + (penny == 0 ? "" : ", ") + changePenny);
		this.balance = BigDecimal.ZERO;
		return changeDollarsCoins;
	}
	
}
