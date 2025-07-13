package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class ItalianDessert implements IFoodType {
	private Map<String, Food> foodMap;

	public ItalianDessert() {
		foodMap = new HashMap<>();
		foodMap.put("IT-D-01", new Food("Tiramisu", 120, "F-201"));
		foodMap.put("IT-D-02", new Food("Panna Cotta", 100, "F-202"));
		foodMap.put("IT-D-03", new Food("Cannoli", 90, "F-203"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IT-D"), food);
	}
}
