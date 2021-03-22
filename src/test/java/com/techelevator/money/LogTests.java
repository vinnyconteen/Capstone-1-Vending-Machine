package com.techelevator.money;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.VendingMachine.Log;

public class LogTests {
	
	@Test
	public void check_if__properly_creates_file() throws IOException {
		//Arrange
		File logFile = new File("audit.txt");
		Log log = new Log();
		log.createLogFile(logFile);
		//Act
		
		//Assert
		Assert.assertTrue(logFile.exists());
	}
	
	@Test
	public void check_if_log_properly_writes_to_file() throws IOException {
		//Act
		File logFile = new File("audit.txt"); 
		Log log = new Log();
		log.createLogFile(logFile);
		Scanner scanner = new Scanner(logFile);
		String test = "";
		 
		
		//Arrange
		
		log.logAction("test-log");
		while(scanner.hasNextLine()) {
			test = scanner.nextLine();
		}
		
		//Assert
		Assert.assertEquals(LocalDate.now().toString() + "|"+"test-log", test);
	}
	
	
}
