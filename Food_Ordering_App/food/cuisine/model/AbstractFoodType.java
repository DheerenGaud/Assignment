package com.aurionpro.food.cuisine.model;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.helper.Print;

public class AbstractFoodType implements IFoodType {
	protected  Map<String, Food> foodMap = new HashMap<>();

  
    @Override
    public final void showFood() {
        Print.showFood(foodMap);
    }

    @Override
    public final Food getFood(String foodId) {
        Food f = foodMap.get(foodId);
        if (f == null) throw new ItemNotFoundException(foodId);
        return f;
    }

  

    @Override
    public final void removeFood(String foodId) {
        Food f = foodMap.remove(foodId);
        if (f == null) throw new ItemNotFoundException(foodId);
    }

    @Override
    public final void newFoodAdd(Food food) {
        String id = food.getFoodId();
        if (foodMap.containsKey(id))
            throw new ItemExistException(id);
        checkFoodName(food.getName().toLowerCase());
        foodMap.put(id, food);
        System.out.println("Food Added SuccesFully");
    }

	private void checkFoodName(String name) {
		for(Map.Entry<String, Food> food : foodMap.entrySet()) {
			String name2 = food.getValue().getName().toLowerCase();
			if(name.equals(name2)) {
				throw new ItemExistException(name2);
			}
		}
	}
}
