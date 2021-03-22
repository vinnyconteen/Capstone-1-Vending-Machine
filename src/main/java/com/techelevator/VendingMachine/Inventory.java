package com.techelevator.VendingMachine;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.Item.Candy;
import com.techelevator.Item.Chip;
import com.techelevator.Item.Drink;
import com.techelevator.Item.Gum;
import com.techelevator.Item.Item;

public class Inventory {
	private File inputFile;
	private Map<String, Item> inventoryList = new LinkedHashMap<>();

	public Inventory(File inputFile) {
		this.inputFile = inputFile;
	}

	public void createInventory(File inputFile) { 				// Takes in a file then converts a file
		try (Scanner fileScanner = new Scanner(inputFile)) { 	// each line into an array then adds
			while (fileScanner.hasNextLine()) { 				// slot as key and val as object.
				String line = fileScanner.nextLine();
				String[] itemInfo = line.split("\\|");
				int quantity = 5;
				
				if(itemInfo[3].equals("Chip")) {
					Chip item = new Chip(itemInfo[2], itemInfo[0], itemInfo[1], itemInfo[3], quantity);
					inventoryList.put(itemInfo[0], item); 
				}
				if(itemInfo[3].equals("Candy")) {
					Candy item = new Candy(itemInfo[2], itemInfo[0], itemInfo[1], itemInfo[3], quantity);
					inventoryList.put(itemInfo[0], item);
				}
				if(itemInfo[3].equals("Gum")) {
					Gum item = new Gum(itemInfo[2], itemInfo[0], itemInfo[1], itemInfo[3], quantity);
					inventoryList.put(itemInfo[0], item);
				}
				if(itemInfo[3].equals("Drink")) {
					Drink item = new Drink(itemInfo[2], itemInfo[0], itemInfo[1], itemInfo[3], quantity);
					inventoryList.put(itemInfo[0], item);
				}
			}
		} catch (Exception e) {
			System.out.println("File does not exist");
		}

	}

	public void emptyInventory() {
		inventoryList.clear();
	}
	
	public String inventoryDisplay(){
		String display = "";
		for(String position : inventoryList.keySet()) {
			display = display + inventoryList.get(position).getSlot();
			display += " | ";
			display = display + inventoryList.get(position).getName();
			display += " | ";
			display = display + "$" + inventoryList.get(position).getPrice();
			display += " | ";
			int currentQuantity = (inventoryList.get(position).getQuantity());
			String stringQuantity = "";
			stringQuantity += currentQuantity;
			display += "Qty: ";
			display = display + stringQuantity; 
			display += "\n";
			
		}
		return display;
	}
	
	public Item get(String slot) {
		return inventoryList.get(slot);
	}
	
	public boolean doesProductExist(String slot) {
		if(inventoryList.containsKey(slot)) {
			return true;
		} return false;
	}
	
	public boolean isSoldOut(String slot ) {
		if(inventoryList.get(slot).getQuantity() == 0) {
			return true;
		} return false;
	}
			

}
