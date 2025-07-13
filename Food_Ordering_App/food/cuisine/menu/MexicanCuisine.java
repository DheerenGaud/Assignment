package com.aurionpro.food.cuisine.menu;

import com.aurionpro.food.cuisine.model.AbstractCuisine;
import com.aurionpro.food.foodtype.MexicanDessert;
import com.aurionpro.food.foodtype.MexicanMainCourse;
import com.aurionpro.food.foodtype.MexicanSnacks;

public class MexicanCuisine extends AbstractCuisine{
	
	public MexicanCuisine() {
	
		menuMap.put("Dessert", new MexicanDessert());
		menuMap.put("MainCourse", new MexicanMainCourse());
		
		pendingMap.put("Snacks", new MexicanSnacks());
		
	}

	 
}
