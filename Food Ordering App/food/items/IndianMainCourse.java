package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class IndianMainCourse implements IFoodType {
	private Map<String, Food> foodMap;

	public IndianMainCourse() {
		foodMap = new HashMap<>();
		foodMap.put("IND-M-01", new Food("Daal Chav", 903, "F-101"));
		foodMap.put("IND-M-02", new Food("Panir", 344, "F-102"));
		foodMap.put("IND-M-03", new Food("Khichdi", 203, "F-103"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IND-M"), food);
	}

}
