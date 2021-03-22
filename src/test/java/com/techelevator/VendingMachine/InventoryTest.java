package com.techelevator.VendingMachine;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.VendingMachine.InventoryTest;
import com.techelevator.money.MoneyCount;
import com.techelevator.money.Purchase;




public class InventoryTest {
	File input = new File("vendingmachine.csv"); 
	
	
	@Test
	public void check_if_inventory_properly_creates_when_create_method_called() {
		
		//Arrange
		File input = new File("vendingmachine.csv");
		Inventory inventory = new Inventory(input);
		inventory.createInventory(input);
		//Act
		String test = inventory.get("A1").getSlot();
		
		//Assert
		Assert.assertEquals("A1", test);
	}
	
	
	@Test
	public void does_the_product_exist_method_proplery_output_correct_boolean_true() {
		
		//Arrange
		File input = new File("vendingmachine.csv"); 
		Inventory inventory = new Inventory(input);
		inventory.createInventory(input); 
		Purchase purchase = new Purchase();
		MoneyCount moneyCount = new MoneyCount();
		
		//Act
		boolean exist = inventory.doesProductExist("A1");
	
		//Assert
		Assert.assertEquals(true, exist);
	}
	

	@Test
	public void does_the_product_exist_method_proplery_output_correct_boolean_false() {
		
		//Arrange
		File input = new File("vendingmachine.csv"); 
		Inventory inventory = new Inventory(input);
		inventory.createInventory(input); 
		Purchase purchase = new Purchase();
		MoneyCount moneyCount = new MoneyCount();
		
		//Act
		boolean exist = inventory.doesProductExist("Z1");
	
		//Assert
		Assert.assertEquals(false, exist);
	} 
	
	@Test
	public void does_isSoldOut_method_properly_output_false_when_not_sold_out() {
		
		//Arrange
		File input = new File("vendingmachine.csv"); 
		Inventory inventory = new Inventory(input);
		inventory.createInventory(input); 
		//Act
		boolean test = inventory.isSoldOut("A1");
		//Assert
		Assert.assertFalse(test);
	}
	
	@Test
	public void does_isSoldOut_method_properly_output_true_when_sold_out() {
		
		//Arrange
		File input = new File("vendingmachine.csv"); 
		Inventory inventory = new Inventory(input);
		inventory.createInventory(input); 
		//Act
		for(int i = 0; i < 5; i++) {
		inventory.get("A1").reduceQuantity();
		}
		boolean test = inventory.isSoldOut("A1");
		//Assert
		Assert.assertTrue(test);
		
	}
	

	
}
