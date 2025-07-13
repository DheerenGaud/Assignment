package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class ItalianSnacks extends AbstractFoodType {

    public ItalianSnacks() {
        foodMap.put("F-207", new Food("Bruschetta",        70, "F-207"));
        foodMap.put("F-208", new Food("Arancini",          90, "F-208"));
        foodMap.put("F-209", new Food("Mozzarella Sticks", 85, "F-209"));
    }

}
