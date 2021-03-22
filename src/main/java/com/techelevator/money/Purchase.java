package com.techelevator.money;

import java.util.Map;

import com.techelevator.Item.Item;
import com.techelevator.VendingMachine.Inventory;

public class Purchase {
	
	public Purchase() {
	}
	
	public String dispense(Inventory currentInventory, String slot, MoneyCount currentMoneyCount) {
		String dispenseList = "";
		String costString = currentInventory.get(slot).getPrice();
		Double cost = Double.parseDouble(costString);
		currentMoneyCount.setBalance(currentMoneyCount.getBalance() - cost);
		dispenseList += currentInventory.get(slot).getName();
		dispenseList = dispenseList + "| Price: $" + currentInventory.get(slot).getPrice();
		dispenseList = dispenseList + "| Remaining Balance: $" + currentMoneyCount.getBalance();
		dispenseList = dispenseList + "\n" + currentInventory.get(slot).getSound();
		return dispenseList;
	}
	
	
}
