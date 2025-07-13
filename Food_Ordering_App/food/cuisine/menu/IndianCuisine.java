package com.aurionpro.food.cuisine.menu;

import com.aurionpro.food.cuisine.model.AbstractCuisine;
import com.aurionpro.food.foodtype.IndianDessert;
import com.aurionpro.food.foodtype.IndianMainCourse;
import com.aurionpro.food.foodtype.IndianSnacks;

public class IndianCuisine extends AbstractCuisine  {
	   public IndianCuisine() {
	        menuMap.put("Dessert",    new IndianDessert());
	        menuMap.put("MainCourse", new IndianMainCourse());
	        
	        pendingMap.put("Snacks",  new IndianSnacks());
	    }
}
