package com.aurionpro.customer.test;

import java.util.Scanner;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.exceptions.InvalidInputException;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.exceptions.NegativeValueInput;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.helper.Utils;
import com.aurionpro.manager.FoodManager;
import com.aurionpro.manager.OrderManager;
import com.aurionpro.manager.PaymentManager;
import com.aurionpro.payment.model.IPayment;

public class LaunchCustomer {
	static FoodManager foodManager;
	static Customer customer;
	static OrderManager orderManager;
	static PaymentManager paymentManager;
    static Scanner scanner;
	
	public LaunchCustomer(FoodManager foodManager2, PaymentManager paymentManager2,Scanner scanner2){
		foodManager = foodManager2;
		paymentManager= paymentManager2;
		scanner=scanner2;
		if(customer==null) {
			customer = createCustomer();
			orderManager = new OrderManager();
		}
	}
	
	public void start(){
		System.out.println();
		while (true) {
			System.out.println("\n========= Customer Menu =========");
			System.out.println("1) Make Order");
			System.out.println("2) View All Orders");
			System.out.println("3) View Order by ID");
			System.out.println("0) Logout");
			System.out.print("Enter choice: ");

			String choice = scanner.next().trim();

			switch (choice) {
			case "1":
				makeOrder();
				break;
			case "2":
				orderManager.showAllOrders(customer);
				break;
			case "3":
				if(orderManager.showAllOrders(customer)) {
					System.out.print("Enter Order ID: ");
					String orderId = scanner.next().trim();
					orderManager.showInvoice(customer, orderId);
				}
				break;
			case "0":
				System.out.println("Exiting customer menu...");
				return;
			default:
				System.out.println("Invalid option. Try again.");
			}

		}
		

	}
	private static void makeOrder() {

		try {
			while (true) {
				System.out.println("\n1) Show Menu");
				System.out.println("2) View Current Order");
				System.out.println("3) Update Order");
				System.out.println("4) Place Order");
				System.out.println("0) Exit");
				System.out.print("Enter choice: ");

				String choice = scanner.next().trim();
				switch (choice) {
				case "1":
					showCuisine();
					break;
				case "2":
					orderManager.showCuurentOrder();
					break;
				case "3":
					updateOrder();
					break;
				case "4":
					placeOrder();
					break;

				case "0":
					return;
				default:
					System.out.println("Invalid choice. Try again.");
				}
			}

		}catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		catch (ItemExistException e) {
			System.out.println(e.getMessage());
		}
		catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static void placeOrder() {
		if(!orderManager.canPlaceOrder()) {
			System.out.println();
			System.out.println("Food cart is empty");
			return;
		}
		System.out.println();
		System.out.println("Select Payment Method");
		paymentManager.showAllPaymentMathod();
		System.out.println("0) exit ");

		System.out.println("write the paymet name");
		String input = scanner.next().trim().toLowerCase();
		if (input.equals("exit")) {
			return;
		}
		IPayment paymentMethod = paymentManager.getPaymentMethod(input);
		paymentMethod.collectDetails(scanner);
		orderManager.placeOrder(customer, paymentMethod);

	}

	private static void updateOrder() {
		try {
			while (true) {
				System.out.println();
				orderManager.showCuurentOrder();
				System.out.println();
				System.out.println("1) Set Quantity");
				System.out.println("2) Remove Item");
				System.out.println("0) Exit");
				String input = scanner.next().trim();
				if (input.equals("0")) {
					return;
				}
				System.out.println("Enter Line Id");
				String lineId = scanner.next().trim();
				switch (input) {
				case "1":
					System.out.println("Enter new Quantity");
					int quantity = scanner.nextInt();

					if (quantity < 0) {
						throw new NegativeValueInput(quantity);
					}
					// negative exception
					orderManager.setQuantity(lineId, quantity);
					break;
				case "2":
					orderManager.removeFood(lineId);
					break;
				default:
					System.out.println("Invalid choice");
				}
			}
		}catch (ItemExistException e) {
			System.out.println(e.getMessage());
		}
		catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static void showCuisine() {
		try {
			String input = "";
			while (true) {
				foodManager.showCuisineTypes();
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}
				foodManager.showMenuType(input);

				selectMenu();

			}

		} 
		catch (InvalidInputException e) {
			  System.out.println("dsmdk");
			System.out.println(e.getMessage());
		}catch (ItemExistException e) {
			System.out.println(e.getMessage());
		}
		catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private static void selectMenu() {

		System.out.println(" 0> exit ");
		String input = scanner.next();
		if (input.equals("0")) {
			return;
		}
		
		foodManager.showMenuFood(input);

		System.out.println();

		System.out.println("Enter Food-ID");
		String foodId = scanner.next();

		System.out.println("Enter Quntetity");
		int quantity = scanner.nextInt();
		
		if (quantity < 0) {
			throw new NegativeValueInput(quantity);
		}

		Food food = foodManager.getFood(foodId);
		orderManager.addFood(quantity, food);

		return;
	}

	private static Customer createCustomer() {
		System.out.println();
		System.out.println("Enter Your Name");
		String name = scanner.next();
		String customerId = Utils.randomString("C");
		return new Customer(name, customerId);
	}
	
}
