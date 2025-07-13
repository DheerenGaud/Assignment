package com.aurionpro.food.menu;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.food.items.IndianDessert;
import com.aurionpro.food.items.IndianMainCourse;
import com.aurionpro.food.items.IndianSnacks;
import com.aurionpro.food.model.IFoodType;
import com.aurionpro.helper.Print;
import com.aurionpro.menu.model.ICuisine;

public class IndianCuisine implements ICuisine {
	private Map<String, IFoodType> menuMap;

	public IndianCuisine() {
		menuMap = new HashMap<String, IFoodType>();
		menuMap.put("Dessert", new IndianDessert());
		menuMap.put("MainCourse", new IndianMainCourse());
		menuMap.put("Snacks", new IndianSnacks());
	}

	@Override
	public void showMenu(String menutype) {
		menuMap.get(menutype).showFood();
	}

	@Override
	public void showMenuType() {
		Print.showMenuType(menuMap);
	}

	@Override
	public void addMenuType(String menuType, IFoodType foodType) {
		menuMap.put(menuType,foodType);
	}

}
