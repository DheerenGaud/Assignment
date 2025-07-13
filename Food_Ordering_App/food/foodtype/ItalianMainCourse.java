package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class ItalianMainCourse extends AbstractFoodType {

    public ItalianMainCourse() {
        foodMap.put("F-204", new Food("Lasagna",          200, "F-204"));
        foodMap.put("F-205", new Food("Spaghetti Carb",   180, "F-205"));
        foodMap.put("F-206", new Food("Risotto",          160, "F-206"));
    }
}
