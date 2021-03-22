package com.techelevator.VendingMachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Log {
	
	public Log() {
	}
	
	public void createLogFile(File logFile) throws IOException {
		
		
		
		try { 
			logFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Failed to creat file");
		}
		
		FileWriter fileWriter = new FileWriter(logFile, false);
		
		try(PrintWriter writer = new PrintWriter(fileWriter)) {
			writer.println(LocalDate.now().toString() + "|This is the beginning of Audit log"); 
		}
		
	}
	
	public void logAction(String action) throws IOException {
		
		
		FileWriter fileWriter = new FileWriter("audit.txt", true);
		
		try(PrintWriter writer = new PrintWriter(fileWriter)) {
			writer.println(LocalDate.now().toString() + "|" + action); 
		}
	}
	
}
