package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class IndianDessert implements IFoodType{
	private Map<String, Food> foodMap;

	public IndianDessert() {
		foodMap = new HashMap<>();
		foodMap.put("IND-D-01", new Food("Gulab Jamun", 60, "F-104"));
		foodMap.put("IND-D-02", new Food("Rasgulla", 50, "F-105"));
		foodMap.put("IND-D-03", new Food("Jalebi", 45, "F-106"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IND-D"), food);
	}


}
