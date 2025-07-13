package com.aurionpro.customer.test;

import java.util.Scanner;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.exceptions.InvalidInputException;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.exceptions.NegativeValueInput;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.helper.Utils;
import com.aurionpro.manager.DeliveryManager;
import com.aurionpro.manager.DiscountManager;
import com.aurionpro.manager.FoodManager;
import com.aurionpro.manager.OrderManager;
import com.aurionpro.manager.PaymentManager;

public class LaunchAdmin {
	static FoodManager foodManager;
	static Customer customer;
	static OrderManager orderManager;
	static DeliveryManager deliveryManager;
	static PaymentManager paymentManager;
	static Scanner scanner;
    static DiscountManager discountManager;
	public LaunchAdmin(FoodManager foodManager2, PaymentManager paymentManager2, Scanner scanner2) {
		foodManager = foodManager2;
		paymentManager = paymentManager2;
		scanner = scanner2;
		discountManager = new DiscountManager();
		deliveryManager = new DeliveryManager();
	}

	public void start() {
		try {
			while (true) {
				System.out.println("\n--- Main Menu ---");
				System.out.println("1) Cuisine");
				System.out.println("2) Payment");
				System.out.println("3) Discount");
				System.out.println("4) Delivery");
				System.out.println("5) Exit");
				System.out.print("Enter your choice: ");

				String input = scanner.next();

				switch (input) {
				case "1":
					System.out.println("Showing Cuisine...");
					foodManagement();
					break;

				case "2":
					System.out.println("Processing Payment...");
					paymentManagement();
					break;

				case "3":
					System.out.println("Applying Discount...");
					 discountManagement();
					break;

				case "4":
					System.out.println("Arranging Delivery...");
					 deliveryManagement();
					break;

				case "5":
					System.out.println("Exiting... Thank you!");
					return;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	
	
	private void deliveryManagement() {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("\n--- Delivery Management ---");
	        System.out.println("1) Show All Delivery Methods");
	        System.out.println("2) Add Delivery Method");
	        System.out.println("3) Remove Delivery Method");
	        System.out.println("0) Exit");
	        System.out.print("Choose an option: ");

	        String choice = scanner.nextLine();

	        switch (choice) {
	            case "1":
	                  System.out.println();      
	                   deliveryManager.showAllDeliveries();
	                break;

	            case "2":
	                addDeliveryMethod();     // prompt user, then add
	                break;

	            case "3":
	                removeDeliveryMethod();  // prompt user, then remove
	                break;

	            case "0":
	                System.out.println("Leaving Delivery Management …");
	                return;                         // break out of the loop

	            default:
	                System.out.println("Invalid input — please enter 0–3.");
	        }
	    }
	}


	
	
	
	
	
	
	
	
	private void removeDeliveryMethod() {
		try {
			System.out.println("");
			if(!deliveryManager.showAllDeliveries()) {
				return ;
			}
			System.out.println("0) exit");
			System.out.println();
			System.out.println("Enter Name of Delivery  ");
			
			String input = scanner.next().toLowerCase();
			
			if (input.equals("0")) {
				return;
			}
			deliveryManager.removeDelivery(input);
			
			System.out.println("Delivery Method Removed Succesfully ");
		}  catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void addDeliveryMethod() {
		try {
			System.out.println("");
			if(!deliveryManager.showNotApproveDeliveries()) {
				return ;
			}
			System.out.println("0) exit");
			System.out.println();
			System.out.println("Enter Name of Delivery  ");
			
			String input = scanner.next().toLowerCase();
			
			if (input.equals("0")) {
				return;
			}
			deliveryManager.addDelivery(input);
			System.out.println("Delivery Method Added Succesfully ");
		}  catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}	
	}

	private void discountManagement() {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("\n--- Discount Management ---");
	        System.out.println("1) Show Discounts");
	        System.out.println("2) Add Discount");
	        System.out.println("3) Remove Discount");
	        System.out.println("0) Exit");
	        System.out.print("Choose an option: ");

	        String choice = scanner.nextLine();

	        switch (choice) {
	            case "1":
	                showDiscounts();                 
	                break;

	            case "2":
	                addDiscount();            
	                break;

	            case "3":
	                removeDiscount();         // pick which to remove
	                break;

	            case "0":
	                System.out.println("Leaving Discount Management …");
	                return;                          // break out of the loop

	            default:
	                System.out.println("Invalid input — please enter 0 – 3.");
	        }
	    }
	}


	private void addDiscount() {
		
		try {
			System.out.println();
			if(!discountManager.shownotApproveDiscounts()) {
				return ;
			}
			System.out.println("0) exit");
			System.out.println();
			System.out.println("Enter Discount Amount");
			
			try {
				int input = scanner.nextInt();
				if (input == 0) {
					return;
				}
				discountManager.addDiscount(input);
			} catch (Exception e) {
				throw new InvalidInputException("Require Integer Value ");
			}
			
		}  catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
private void removeDiscount() {
		
		try {
			System.out.println();
			if(!discountManager.showAllDiscounts()) {
				return ;
			}
			System.out.println("0) exit");
			System.out.println();
			System.out.println("Enter Discount Amount");
			
			
			try {
				int input =   scanner.nextInt();
				if (input == 0) {
					return;
				}
				discountManager.removeDiscount(input);
			} catch (Exception e) {
				throw new InvalidInputException("Require Integer Value ");
			}
			
		}  catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	private void showDiscounts() {
       System.out.println();
       discountManager.showAllDiscounts();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private void paymentManagement() {
	    Scanner scanner = new Scanner(System.in);
	    String input;

	    while (true) {
	        System.out.println("\n--- Payment Management ---");
	        System.out.println("1) Show Payment Methods");
	        System.out.println("2) Add Payment Method");
	        System.out.println("3) Remove Payment Method");
	        System.out.println("0) Exit");
	        System.out.print("Enter your choice: ");
	        input = scanner.nextLine();

	        switch (input) {
	            case "1":
	                showPaymentMethods(); 
	                break;

	            case "2":
	                 addPaymentMethod();
	                break;

	            case "3":
	                  removePaymentMethod();
	                break;

	            case "0":
	                System.out.println("Exiting Payment Management...");
	                return;

	            default:
	                System.out.println("Invalid input. Please enter a number between 0 and 3.");
	        }
	    }
	}

	private void showPaymentMethods() {
		System.out.println();
		paymentManager.showAllPaymentMathod();
	}
	
	private void addPaymentMethod() {
		try {
			System.out.println();
			if(!paymentManager.showNotApprovePaymnetMathod()) {
				return ;
			}
			System.out.println("0) exit ");
			System.out.println();
			System.out.println("Emter Paymet Name");
			String input = scanner.next().toLowerCase();
			
			if (input.equals("0")) {
				return;
			}
			
			paymentManager.addNewPayment(input);
			System.out.println("New Payment Method Added");
			
		}  catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	private void removePaymentMethod() {
	    try {
	    	System.out.println();
			if(!paymentManager.showAllPaymentMathod()) {
				return ;
			}
			System.out.println("0) exit ");
			System.out.println();
			System.out.println("Emter Paymet Name");
			String input = scanner.next().toLowerCase();
			
			if (input.equals("0")) {
				return;
			}
			
			paymentManager.removePayment(input);
			System.out.println(" Payment Method Removed");
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	

	private void foodManagement() {
		try {
			while (true) {
				System.out.println("\n--- Food Management ---");
				System.out.println("1) Show Menu");
				System.out.println("2) Add Cuisine");
				System.out.println("3) Remove Cuisine");
				System.out.println("4) Add New Food Type");
				System.out.println("5) Remove Food Type");
				System.out.println("6) Add New Food");
				System.out.println("7) Remove Food");
				System.out.println("0) Exit");
				System.out.print("Enter your choice: ");

				String choice = scanner.next();

				switch (choice) {
				case "1":
					showMenu();
					break;

				case "2":
					addCuisine();
					break;

				case "3":
					removeCuisine();
					break;

				case "4":
					addFoodType();
					break;

				case "5":
					removeFoodType();
					break;

				case "6":
					addFood();
					break;

				case "7":
					removeFood();
					break;

				case "0":
					System.out.println("Returning to main menu...");
					return; // exits the loop & method

				default:
					System.out.println("Invalid choice — please try again.");
				}
			}

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static void showMenu() {
		try {
			String input = "";
			while (true) {
				System.out.println();
				System.out.println("MENU");
				foodManager.showCuisineTypes();
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}

				foodManager.showMenuType(input);

				selectMenu();

			}

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
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

		return;
	}

	private void addCuisine() {
		try {
			System.out.println();
			System.out.println("ADD CUISINE");
			if (!foodManager.showNotApproveCuisine()) {
				return;
			}
			System.out.println(" 0> exit ");
			String input = scanner.next();

			if (input.equals("0")) {
				return;
			}
			foodManager.addCuisine(input);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private void removeCuisine() {
		try {

			System.out.println();
			 System.out.println("REMOVE CUISINE");
			foodManager.showCuisineTypes();
			System.out.println(" 0> exit ");
			String input = scanner.next();

			if (input.equals("0")) {
				return;
			}
			foodManager.removeCuisine(input);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void addFoodType() {
		try {
			System.out.println();
			System.out.println("ADD FOOD TYPE");
			foodManager.showCuisineTypes();
			System.out.println(" 0> exit ");
			String input = scanner.next();

			if (input.equals("0")) {
				return;
			}

			if (!foodManager.showNotApproveMenuFood(input)) {
				return;
			}
			System.out.println(" 0> exit ");
			input = scanner.next();
			if (input.equals("0")) {
				return;
			}

			foodManager.addFoodType(input);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void removeFoodType() {
		try {
			System.out.println();
			System.out.println("REMOVE FOOD-TYPE");
			foodManager.showCuisineTypes();
			System.out.println(" 0> exit ");
			String input = scanner.next();

			if (input.equals("0")) {
				return;
			}

			System.out.println("Select FoodType To Remove");
			foodManager.showMenuType(input);
			System.out.println(" 0> exit ");

			input = scanner.next();
			if (input.equals("0")) {
				return;
			}

			foodManager.removeFoodType(input);

		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void addFood() {
		try {
			String input = "";
			while (true) {
				 System.out.println("ADD FOOD");
				foodManager.showCuisineTypes();
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}

				foodManager.showMenuType(input);
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}
				Food food = createFood();
				foodManager.addFood(food, input);

			}
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private Food createFood() {
		System.out.println();
		System.out.println("Enter Food Name");
		String name = scanner.next();
		System.out.println("Enter Food Price");

		try {
			double price = scanner.nextDouble();
			String foodId = Utils.randomString("F");
			return new Food(name, price, foodId);
		} catch (Exception e) {
			throw new InvalidInputException("Require Double Value ");
		}
	}

	private void removeFood() {
		try {
			String input = "";
			while (true) {
				 System.out.println("REMOVE FOOD");
				foodManager.showCuisineTypes();
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}

				foodManager.showMenuType(input);
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}
				
				System.out.println();
			    System.out.println("Enter Food Id to remove food");
				foodManager.showMenuFood(input);
				System.out.println(" 0> exit ");
				input = scanner.next();

				if (input.equals("0")) {
					return;
				}
				foodManager.removeFood(input);
				System.out.println("Food Removed Succesfully");
			}
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		} catch (ItemExistException e) {
			System.out.println(e.getMessage());
		} catch (ItemNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (NegativeValueInput e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
