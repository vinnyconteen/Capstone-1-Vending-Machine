package com.techelevator.money;

import org.junit.Test;
import org.junit.Assert;

public class ChangeTests {

	
	@Test
	public void test_if_dollars_are_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(5);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 20 Dimes: 0 Nickels: 0 Pennies: 0\n", balance);
		
	}
	
	@Test
	public void test_if_nickels_are_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(3.33);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 13 Dimes: 0 Nickels: 1 Pennies: 3\n", balance);
		
	}
	
	@Test
	public void test_if_change_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(3.45);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 13 Dimes: 2 Nickels: 0 Pennies: 0\n", balance);
		
	}

	@Test
	public void test_if_thirty_four_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(.34);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 1 Dimes: 0 Nickels: 1 Pennies: 4\n", balance);
		
	}
	
	@Test
	public void test_if_fourteen_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(.14); 
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 0 Dimes: 1 Nickels: 0 Pennies: 4\n", balance);
		
	}
	
	@Test
	public void test_if_sixty_four_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(.64);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 2 Dimes: 1 Nickels: 0 Pennies: 4\n", balance);
		
	}
	
	@Test
	public void test_if_sixty_nine_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(.67);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 2 Dimes: 1 Nickels: 1 Pennies: 2\n", balance);
		
	}
	
	@Test
	public void test_if_four_is_correct() {
		//Arrange
		Change changeGiven = new Change();
		
		//Act
		String balance = changeGiven.getChange(.04);
		
		//Assert
		Assert.assertEquals("\nChange => Quarters: 0 Dimes: 0 Nickels: 0 Pennies: 4\n", balance);
		
	}
	
}
