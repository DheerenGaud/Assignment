package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class MexicanDessert implements IFoodType {
	private Map<String, Food> foodMap;

	public MexicanDessert() {
		foodMap = new HashMap<>();
		foodMap.put("MX-D-01", new Food("Churros", 80, "F-301"));
		foodMap.put("MX-D-02", new Food("Flan", 75, "F-302"));
		foodMap.put("MX-D-03", new Food("Tres Leches Cake", 95, "F-303"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("MX-D"), food);
	}
}
