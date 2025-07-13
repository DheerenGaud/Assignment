package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class IndianMainCourse extends AbstractFoodType {

	public IndianMainCourse() {
		foodMap.put("F-101", new Food("Daal Chav", 903, "F-101"));
		foodMap.put("F-102", new Food("Panir", 344, "F-102"));
		foodMap.put("F-103", new Food("Khichdi", 203, "F-103"));
	}

}
