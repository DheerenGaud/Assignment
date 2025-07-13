package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class ItalianDessert extends AbstractFoodType {

    public ItalianDessert() {
        foodMap.put("F-201", new Food("Tiramisu",    120, "F-201"));
        foodMap.put("F-202", new Food("Panna Cotta", 100, "F-202"));
        foodMap.put("F-203", new Food("Cannoli",      90, "F-203"));
    }
}
