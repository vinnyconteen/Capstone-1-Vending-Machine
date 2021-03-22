package com.techelevator.Item;

public abstract class Item {
	private String price;
	private String slot;
	private String name;
	private String type;
	private int quantity;
	
	public Item(String price, String slot, String name, String type, int quantity) {
		this.price = price;
		this.slot = slot;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}

	public String getPrice() {
		return price; 
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void reduceQuantity() {
		this.quantity = quantity - 1;
	}
	
	public abstract String getSound();
}
