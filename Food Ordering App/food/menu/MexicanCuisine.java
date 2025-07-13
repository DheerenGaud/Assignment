package com.aurionpro.food.menu;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.items.MexicanDessert;
import com.aurionpro.food.items.MexicanMainCourse;
import com.aurionpro.food.items.MexicanSnacks;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.menu.model.ICuisine;

public class MexicanCuisine implements ICuisine {
	private Map<String, IFoodType> menuMap;

	public MexicanCuisine() {
		menuMap = new HashMap<String, IFoodType>();
		menuMap.put("Dessert", new MexicanDessert());
		menuMap.put("MainCourse", new MexicanMainCourse());
		menuMap.put("Snacks", new MexicanSnacks());
	}

	@Override
	public void showMenu(String menuType) {
		menuMap.get(menuType).showFood();
	}

	@Override
	public void showMenuType() {
		Print.showMenuType(menuMap);
	}

	@Override
	public void addMenuType(String menuType, IFoodType foodType) {
		menuMap.put(menuType, foodType);
	}
}
