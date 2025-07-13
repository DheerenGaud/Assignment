package com.aurionpro.customer.test;

import java.util.Scanner;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.exceptions.NegativeValueInput;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.helper.Utils;
import com.aurionpro.manager.FoodManager;
import com.aurionpro.manager.OrderManager;
import com.aurionpro.manager.PaymentManager;
import com.aurionpro.payment.model.IPayment;

public class Test {
	static FoodManager foodManager;
	static Customer customer;
	static OrderManager orderManager;
	static PaymentManager paymentManager;

	public static void main(String[] args) {
		System.out.println("Welcome to Dheeren Mini-Food");

		foodManager = new FoodManager();
		paymentManager = new PaymentManager();
		Scanner scanner = new Scanner(System.in);
		selectMode(scanner);
		scanner.close();
	}

	private static void selectMode(Scanner scanner) {
		while (true) {
			System.out.println("\n=========== Select Mode ===========");
			System.out.println("1) Customer");
			System.out.println("2) Admin");
			System.out.println("0) Exit");
			System.out.print("Enter choice: ");

			String input = scanner.next().trim();
          
			switch (input) {
			case "1":
				launchCustomerFlow(scanner);
				
				break;
			case "2":
				launchAdminFlow(scanner);
				break;
			case "0":
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Invalid choice. Please choose 1, 2 or 0.");
			}
		}
		
	}

	private static void launchCustomerFlow(Scanner scanner) {
		System.out.println();
		System.out.println(">> Customer mode selected");
		LaunchCustomer lauchCustome = new LaunchCustomer(foodManager, paymentManager, scanner);
		lauchCustome.start();
		return ;
	}

	private static void launchAdminFlow(Scanner scanner) {
		System.err.println();
		System.out.println(">> Admin mode selected");
		LaunchAdmin launchAdmin = new LaunchAdmin(foodManager, paymentManager, scanner);
		launchAdmin.start();
		return ;
	}

}
