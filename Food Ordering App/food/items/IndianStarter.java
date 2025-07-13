package com.aurionpro.food.items;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class IndianStarter implements IFoodType {
	private Map<String, Food> foodMap;

	public IndianStarter() {
		foodMap = new HashMap<>();
		foodMap.put("IND-ST-01", new Food("Paneer Tikka", 130, "F-110"));
		foodMap.put("IND-ST-02", new Food("Chicken Tandoori", 180, "F-111"));
		foodMap.put("IND-ST-03", new Food("Hara Bhara Kabab", 100, "F-112"));
	}

	@Override
	public void showFood() {
		Print.showFood(foodMap);
	}

	@Override
	public void addFood(Food food) {
		foodMap.put(Utils.randomString("IND-ST"), food);
	}
}
