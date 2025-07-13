package com.aurionpro.manager;

import java.util.LinkedHashMap;
import java.util.Map;

import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.food.cuisine.menu.IndianCuisine;
import com.aurionpro.food.cuisine.menu.ItalianCuisine;
import com.aurionpro.food.cuisine.menu.MexicanCuisine;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.food.cuisine.model.ICuisine;
import com.aurionpro.helper.Utils;

public class FoodManager {
	
	static Map<String, ICuisine> cuisineMap;
	static Map<String, ICuisine> notApproveCuisineMap;
	private static  String currentCuisineType = null;
	
	

	public FoodManager() {
		cuisineMap = new LinkedHashMap<>();
		notApproveCuisineMap = new LinkedHashMap<String, ICuisine>();
		cuisineMap.put("Indian", new IndianCuisine());
		cuisineMap.put("Italian", new ItalianCuisine());
		
		notApproveCuisineMap.put("Mexican", new MexicanCuisine());
		
	}
	
	public boolean showNotApproveCuisine() {
		if(notApproveCuisineMap.size()==0) {
			return false;
		}
		 System.out.println();
	     int i = 1;
	     for(Map.Entry<String, ICuisine> entry : notApproveCuisineMap.entrySet()) {
	    	 System.out.println(" "+i+"> "+entry.getKey());
	    	 i++;
	     }
	     return true;
	     
	}
	
	public void showCuisineTypes() {
		 System.out.println();
	     int i = 1;
	     for(Map.Entry<String, ICuisine> entry : cuisineMap.entrySet()) {
	    	 System.out.println(" "+i+"> "+entry.getKey());
	    	 i++;
	     }
	}
	

	public void showMenuType(String index) {
		
		String selectedCuisine = Utils.intToStringForCuisine(index,cuisineMap);
		currentCuisineType = selectedCuisine;
		cuisineMap.get(selectedCuisine).showMenuType();
	}
	
	
	public void showMenuFood(String index) {
		if(!cuisineMap.containsKey(currentCuisineType)) {
			throw new ItemNotFoundException(currentCuisineType);
		}
		ICuisine cuisine = cuisineMap.get(currentCuisineType);
		cuisine.showMenu(index);
		System.out.println();
	}
	
	public void addCuisine(String index) {
		String cuisineName =	Utils.intToStringForCuisine(index,notApproveCuisineMap);
		if(cuisineMap.containsKey(cuisineName)) {
			throw new ItemExistException(cuisineName);
		}
		cuisineMap.put(cuisineName, notApproveCuisineMap.get(cuisineName));
		notApproveCuisineMap.remove(cuisineName);
	}
	
	public void removeCuisine(String index) {
		String cuisineName =	Utils.intToStringForCuisine(index,cuisineMap);
		if(!cuisineMap.containsKey(cuisineName)) {
			throw new ItemNotFoundException(cuisineName);
		}
		notApproveCuisineMap.put(cuisineName, cuisineMap.get(cuisineName));
		cuisineMap.remove(cuisineName);
	}
	
	public void addMenuType(String cuisineName ,String menuType ) {
		if(!cuisineMap.containsKey(cuisineName)) {
			throw new ItemNotFoundException(cuisineName);
		}
		ICuisine cuisine = cuisineMap.get(cuisineName);
		cuisine.addMenuType(menuType);
	}
	
	public boolean showNotApproveMenuFood(String index) {
		String selectedCuisine =	Utils.intToStringForCuisine(index,cuisineMap);
		currentCuisineType = selectedCuisine;
		return cuisineMap.get(currentCuisineType).showNotApproveMenu();
	}
	public void addFoodType(String index) {
		
		cuisineMap.get(currentCuisineType).addMenuType(index);
	}
	public void removeFoodType(String index) {
		
		cuisineMap.get(currentCuisineType).removeMenuType(index);
	}
	
	
	public static Food getFood(String foodId) {
		if(!cuisineMap.containsKey(currentCuisineType)) {
			throw new ItemNotFoundException(currentCuisineType);
		}
		ICuisine cuisine = cuisineMap.get(currentCuisineType);
		return cuisine.getFood(foodId);
	}

	public void addFood(Food food,String input) {
		cuisineMap.get(currentCuisineType).addFood(food,input);
	}
	public void removeFood(String foodId) {
		cuisineMap.get(currentCuisineType).removeFood(foodId);
	}
	

	
}
