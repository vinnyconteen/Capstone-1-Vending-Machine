package com.techelevator.money;

import org.junit.Assert;
import org.junit.Test;

public class MoneyCountTests {

	
	@Test
	public void check_if_feed_money_alters_balance_acordingly() {
		//Arrange
		MoneyCount test = new MoneyCount();
		//Act
		test.feedMoney(1.00);
		//Assert
		Assert.assertEquals(1.00, test.getBalance(), 0); 
	}
	
	@Test
	public void check_to_see_if_returns_false_when_given_imporper_dollar_value() {
		//Arrange
		MoneyCount test = new MoneyCount();
		//Act
		test.feedMoney(1.21);
		//Assert
		Assert.assertEquals(false, test.feedMoney(1.21));
	}
	
	@Test
	public void check_to_see_if_returns_true_when_given_proper_dollar_value() {
		//Arrange
		MoneyCount test = new MoneyCount();
		//Act
		test.feedMoney(1.00);
		//Assert
		Assert.assertEquals(true, test.feedMoney(1.00));
	}
	
	
	
	
}
