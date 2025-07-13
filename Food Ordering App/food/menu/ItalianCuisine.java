package com.aurionpro.food.menu;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.items.ItalianDessert;
import com.aurionpro.food.items.ItalianMainCourse;
import com.aurionpro.food.items.ItalianSnacks;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.menu.model.ICuisine;

public class ItalianCuisine implements ICuisine {
	private Map<String, IFoodType> menuMap;

	public ItalianCuisine() {
		menuMap = new HashMap<String, IFoodType>();
		menuMap.put("Dessert", new ItalianDessert());
		menuMap.put("MainCourse", new ItalianMainCourse());
	   //  menuMap.put("Snacks", new ItalianSnacks());
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
