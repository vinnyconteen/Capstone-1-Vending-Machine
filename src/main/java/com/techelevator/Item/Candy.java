package com.techelevator.Item;

public class Candy extends Item{

	public Candy(String price, String slot, String name, String type, int quantity) {
		super(price, slot, name, type, quantity);
		
	}
	
	@Override
	public String getSound() {
		return "Munch Munch, Yum!\n\n\n";
	}
	
	
}
