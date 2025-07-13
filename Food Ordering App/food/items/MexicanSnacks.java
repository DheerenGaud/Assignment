package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class MexicanSnacks implements IFoodType {
	private Map<String, Food> foodMap;

	public MexicanSnacks() {
		foodMap = new HashMap<>();
		foodMap.put("MX-S-01", new Food("Nachos", 90, "F-307"));
		foodMap.put("MX-S-02", new Food("Quesadilla", 110, "F-308"));
		foodMap.put("MX-S-03", new Food("Guacamole with Chips", 70, "F-309"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("MX-S"), food);
	}
}
