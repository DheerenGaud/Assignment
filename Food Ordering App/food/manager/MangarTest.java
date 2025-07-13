package com.aurionpro.food.manager;

import com.aurionpro.food.items.IndianStarter;
import com.aurionpro.food.menu.MexicanCuisine;

public class MangarTest {

	public static void main(String[] args) {
		FoodManager foodManager = new FoodManager();
		
		// show cuisine
		foodManager.showCuisineTypes();
		
		// slection of Cuisine
		//foodManager.showMenuType("Indian");
	    foodManager.showMenuType("Italian");
		
		// selection if menu
		foodManager.showMenuFood("MainCourse");
	
		
		// daynamic cuisine adding .. 
	    foodManager.addCuisine("Maxican", new MexicanCuisine());
	    foodManager.showMenuType("Maxican");
		foodManager.showCuisineTypes();
		foodManager.showMenuFood("Snacks");
		
		// dynamicly adding new Menu in Cuisine
		foodManager.addMenuType("Indian", "Starter", new IndianStarter());
		foodManager.showMenuType("Indian");
	    foodManager.showMenuFood("Starter");
	    
	    OrderManagerr orderMAnager = new OrderManagerr();
	}

}
