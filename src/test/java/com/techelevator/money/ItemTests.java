package com.techelevator.money;


import org.junit.Assert;
import org.junit.Test;

import com.techelevator.Item.Chip;


public class ItemTests {
	
	@Test
	public void test_reduceQuantity_decreases_quantity_by_one() {
		//Arrange
		Chip item = new Chip("3.00", "A5", "yummy chips","Chip", 5);
		//Act
		item.reduceQuantity();
		//Assert
		Assert.assertEquals(4, item.getQuantity() );
	}
	
	
	
	
}