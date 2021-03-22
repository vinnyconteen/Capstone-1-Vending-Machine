package Application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.techelevator.VendingMachine.Inventory;
import com.techelevator.VendingMachine.Log;
import com.techelevator.money.Change;
import com.techelevator.money.MoneyCount;
import com.techelevator.money.Purchase;

public class VendingMachieOperation {

	public static void main(String[] args) {
		
		

		System.out.println("Welcome to Vendo-Matic 800");
		System.out.println("************************************");
		File logFile = new File("audit.txt");
		Log log = new Log();
		try {
			log.createLogFile(logFile);
		} catch (IOException e) {
			System.out.println("Log file attemted to create failed");
		}

		Scanner keyboardInput = new Scanner(System.in);
 
		File input = new File("vendingmachine.csv");

		Inventory inventory = new Inventory(input);

		inventory.createInventory(input);

		while (true) {
			while (true) {

				System.out.println("(1) Display Vending Machine Items");
				System.out.println("(2) Purchase");
				System.out.println("(3) Exit");
				String selection = keyboardInput.nextLine();

				if (selection.equals("1")) {
					System.out.println(inventory.inventoryDisplay());
					continue;
				}

				if (selection.equals("3")) {
					System.exit(0);
				}

				if (selection.equals("2")) {
					break;
				} else {
					System.out.println("Invalid Choice");
					continue;
				}
			}

			MoneyCount moneyCount = new MoneyCount();

			while (true) {

				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");
				System.out.println("Current Money Provide: $" + moneyCount.getBalance());
				String selection = keyboardInput.nextLine();

				Purchase purchase = new Purchase();

				if (!selection.equals("1") || !selection.equals("2") || !selection.equals("3")) {
					System.out.println("*******************************");
					System.out.println("Improper Input, Please choose [1] , [2] or [3]");
					System.out.println("*******************************\n\n");
					continue;
				}

				if (selection.equals("1")) {

					while (true) {
						System.out.println("Add money");
						String moneyInput = keyboardInput.nextLine();
						String moneyLog = moneyInput;
						double money = Double.parseDouble(moneyInput);
						boolean isProperBills = moneyCount.feedMoney(money);
						if (!isProperBills) {
							System.out.println("Invalid money input");
							continue;
						}

						try {
							log.logAction("FEED MONEY: $" + moneyLog + " $" + moneyCount.getBalance());
						} catch (IOException e) {
							System.out.println("failed to log money input");
						}
						System.out.println("Add more money?[Y] or [N]");
						String moreMoney = keyboardInput.nextLine();
						if (moreMoney.equalsIgnoreCase("y")) {
							continue;
						} else if (moreMoney.equalsIgnoreCase("n")) {
							break;
						} else {
							System.out.println("*******************************");
							System.out.println("Improper Input, Please choose Yes[Y] or No[N]");
							System.out.println("*******************************\n\n");
						}

					}

					continue;

				}
				if (selection.equals("2")) { 

					System.out.println("Please select a product using code");
					String productSelection = keyboardInput.nextLine();

					String logProductSelection = productSelection;

					if (!inventory.doesProductExist(productSelection)) {
						System.out.println("Product does not exist");
						continue;
					}

					if (inventory.doesProductExist(productSelection)) {
						if (inventory.isSoldOut(productSelection) == true) {
							System.out.println("*******************************");
							System.out.println("Product is sold out");
							System.out.println("*******************************\n\n");
							continue;
						}
					}

					double checkToSeeIfFundsSufficent = Double.parseDouble(inventory.get(productSelection).getPrice());
					if (moneyCount.getBalance() >= checkToSeeIfFundsSufficent) {
						double previousBalance = moneyCount.getBalance();
						System.out.println(purchase.dispense(inventory, productSelection, moneyCount));
						inventory.get(productSelection).reduceQuantity();
						try {
							log.logAction(inventory.get(productSelection).getName()
									+ inventory.get(productSelection).getSlot() + " $" + previousBalance + " $"
									+ moneyCount.getBalance());
						} catch (IOException e) {
							System.out.println("log of purchase failed");
						}
						continue;
					} else {
						System.out.println("*******************************");
						System.out.println("Insufficent Funds, Try Again");
						System.out.println("*******************************\n\n");
						continue;
					}
				}
				if (selection.equals("3")) {
					Change change = new Change();
					try {
						log.logAction("GIVE CHANGE: $" + moneyCount.getBalance() + "$0.00");
					} catch (IOException e) {
						System.out.println("log of purchase failed");
					}
					System.out.println(change.getChange(moneyCount.getBalance()));
					break;
				}
				break;

			}

			continue;

		}

	}

}