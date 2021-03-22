package com.techelevator.Item;

public class Drink extends Item{

	public Drink(String price, String slot, String name, String type, int quantity) {
		super(price, slot, name, type, quantity);
		
	}
	@Override
	public String getSound() {
		return "Glug Glug, Yum!\n\n\n";
	}
	

}
