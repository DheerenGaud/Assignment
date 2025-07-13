package com.aurionpro.food.manager;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.menu.IndianCuisine;
import com.aurionpro.food.menu.ItalianCuisine;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.menu.model.ICuisine;

public class FoodManager {
	
	Map<String, ICuisine> cuisineMap;
	private String currentCuisineType = null;

	public FoodManager() {
		cuisineMap = new HashMap<>();
		cuisineMap.put("Indian", new IndianCuisine());
		cuisineMap.put("Italian", new ItalianCuisine());
	}
	
	public void showCuisineTypes() {
		 System.out.println();
	     int i = 1;
	     for(Map.Entry<String, ICuisine> entry : cuisineMap.entrySet()) {
	    	 System.out.println(" "+i+"> "+entry.getKey());
	    	 i++;
	     }
	}

	public void showMenuType(String selectedCuisine) {
		currentCuisineType = selectedCuisine;
		cuisineMap.get(selectedCuisine).showMenuType();
	}

	public void showMenuFood(String slectedMenuType) {
		System.out.println();
		System.out.println(" Menu : "+ slectedMenuType + " | Cusine : "+currentCuisineType);
		ICuisine cuisine = cuisineMap.get(currentCuisineType);
		cuisine.showMenu(slectedMenuType);
	}
	
	public void addCuisine(String cuisineName,ICuisine cuisine) {
		cuisineMap.put(cuisineName, cuisine);
	}
	
	public void addMenuType(String cuisineName ,String menuType, IFoodType foodType ) {
		ICuisine cuisine = cuisineMap.get(cuisineName);
		cuisine.addMenuType(menuType, foodType);
	}
}
