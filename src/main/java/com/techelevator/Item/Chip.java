package com.techelevator.Item;

public class Chip extends Item{

	public Chip(String price, String slot, String name, String type, int quantity) {
		super(price, slot, name, type, quantity);
		
	}
	
	@Override
	public String getSound() {
		return "Crunch Crunch, Yum!\n\n\n";
	}

	

}
