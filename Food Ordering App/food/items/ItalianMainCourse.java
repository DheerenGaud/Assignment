package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class ItalianMainCourse implements IFoodType {
	private Map<String, Food> foodMap;

	public ItalianMainCourse() {
		foodMap = new HashMap<>();
		foodMap.put("IT-M-01", new Food("Lasagna", 200, "F-204"));
		foodMap.put("IT-M-02", new Food("Spaghetti Carb", 180, "F-205"));
		foodMap.put("IT-M-03", new Food("Risotto", 160, "F-206"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IT-M"), food);
	}
}
