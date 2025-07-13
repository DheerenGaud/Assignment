package com.aurionpro.food.cuisine.menu;

import com.aurionpro.food.cuisine.model.AbstractCuisine;
import com.aurionpro.food.foodtype.ItalianDessert;
import com.aurionpro.food.foodtype.ItalianMainCourse;
import com.aurionpro.food.foodtype.ItalianSnacks;

public class ItalianCuisine extends AbstractCuisine {
	public ItalianCuisine() {
		menuMap.put("Dessert", new ItalianDessert());
		menuMap.put("MainCourse", new ItalianMainCourse());
		
		pendingMap.put("Snacks", new ItalianSnacks());
	}
	 
}
