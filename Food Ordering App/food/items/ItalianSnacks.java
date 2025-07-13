package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class ItalianSnacks implements IFoodType {
	private Map<String, Food> foodMap;

	public ItalianSnacks() {
		foodMap = new HashMap<>();
		foodMap.put("IT-S-01", new Food("Bruschetta", 70, "F-207"));
		foodMap.put("IT-S-02", new Food("Arancini", 90, "F-208"));
		foodMap.put("IT-S-03", new Food("Mozzarella Sticks", 85, "F-209"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IT-S"), food);
	}
}
