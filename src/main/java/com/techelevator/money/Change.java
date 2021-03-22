package com.techelevator.money;

public class Change {
	
	public String getChange(double balance) {

		//double balance = new getBalance;
		
		//set variables of the coins
		double quarters = 0.25;
		double dimes = 0.10;
		double nickels = 0.05;
		double pennies = 0.01;
		
		//set counter
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		int pennyCount = 0;

		
		if(balance >= quarters) {
			quarterCount = (int)(balance / quarters);
			balance = balance % quarters;
		} 
		if (balance >= dimes) {
			dimeCount = (int)(balance / dimes);
			balance = balance % dimes;
		} 
		if (balance >= nickels) {
			nickelCount = (int)(balance / nickels);
			balance = balance % nickels;
		} 
		if (balance >= pennies) {
			pennyCount = (int)(balance / pennies);
			balance = balance % pennies;
		} 
		
		return "\nChange => Quarters: " + quarterCount + " Dimes: " + dimeCount + " Nickels: " + nickelCount + " Pennies: "+ pennyCount + "\n";	
	
	}
}
