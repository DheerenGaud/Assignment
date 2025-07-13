package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class IndianSnacks implements IFoodType{
	private Map<String, Food> foodMap;

	public IndianSnacks() {
		foodMap = new HashMap<>();
		foodMap.put("IND-S-01", new Food("Samosa", 22, "F-107"));
		foodMap.put("IND-S-02", new Food("Pakoda", 70, "F-108"));
		foodMap.put("IND-S-03", new Food("Poha", 60, "F-109"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IND-S"), food);
	}

}
