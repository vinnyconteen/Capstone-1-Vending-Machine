package com.techelevator.money;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.VendingMachine.Inventory;

public class PurchaseTests {

		@Test
		public void check_if_dispense_outputs_proper_info() {
			//Arrange
			File input = new File("vendingmachine.csv");
			Inventory inventory = new Inventory(input);
			inventory.createInventory(input); 
			Purchase purchase = new Purchase();
			MoneyCount moneyCount = new MoneyCount();
			//Act
			moneyCount.feedMoney(10.00);
			
			//Assert
			Assert.assertEquals("Potato Crisps| Price: $3.05| Remaining Balance: $6.95\nCrunch Crunch, Yum!\n\n\n",purchase.dispense(inventory, "A1", moneyCount));
		}
}
//A1|Potato Crisps|3.05|Chip