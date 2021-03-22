package com.techelevator.money;

public class MoneyCount {
	private double balance = 0.00;
	
	public MoneyCount() {
		
	}
	
	public double getBalance() { 
		return this.balance;
	}
	
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
	
	public boolean feedMoney(double value) {
		if(value == 1.00 || value == 2.00 || value == 5.00 || value == 10.00) {
			balance += value;
			return true;
		} return false;
	}
	
	
	
}
