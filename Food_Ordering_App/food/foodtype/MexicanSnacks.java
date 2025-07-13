package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class MexicanSnacks extends AbstractFoodType {

    public MexicanSnacks() {
        foodMap.put("F-307", new Food("Nachos",          90, "F-307"));
        foodMap.put("F-308", new Food("Quesadilla",     110, "F-308"));

    }

}
