package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class MexicanMainCourse implements IFoodType {
	private Map<String, Food> foodMap;

	public MexicanMainCourse() {
		foodMap = new HashMap<>();
		foodMap.put("MX-M-01", new Food("Tacos", 130, "F-304"));
		foodMap.put("MX-M-02", new Food("Enchiladas", 140, "F-305"));
		foodMap.put("MX-M-03", new Food("Burritos", 150, "F-306"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("MX-M"), food);
	}
}
