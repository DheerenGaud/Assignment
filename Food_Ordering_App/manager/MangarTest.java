package com.aurionpro.manager;

import java.util.Scanner;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.payment.model.IPayment;

public class MangarTest {

	public static void main(String[] args) {
		FoodManager foodManager = new FoodManager();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("Select One");
		foodManager.showCuisineTypes();
		System.out.println(" 0> exit ");
		String input = scanner.next();
		
		if (input.equals("0")) {
			return;
		}
		
		if(!foodManager.showNotApproveMenuFood(input)) {
			return ;
		}
		System.out.println(" 0> exit ");
		input = scanner.next();
		 if (input.equals("0")) {
				return;
		}
		
		foodManager.addFoodType(input);
	  
	}

}
