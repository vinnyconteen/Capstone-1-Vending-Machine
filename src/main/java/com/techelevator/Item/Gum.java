package com.techelevator.Item;

public class Gum extends Item{

	public Gum(String price, String slot, String name, String type, int quantity) {
		super(price, slot, name, type, quantity);
		
	}

	@Override
	public String getSound() {
		return "Chew Chew, Yum!\n\n\n";
		
	}
	
	
	
	

}
