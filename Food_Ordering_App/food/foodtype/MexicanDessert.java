package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class MexicanDessert extends AbstractFoodType {

    public MexicanDessert() {
        foodMap.put("F-301", new Food("Churros",           80, "F-301"));
        foodMap.put("F-302", new Food("Flan",              75, "F-302"));
        foodMap.put("F-303", new Food("Tres Leches Cake",  95, "F-303"));
    }

}
	