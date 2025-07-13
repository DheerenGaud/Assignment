package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class IndianSnacks extends AbstractFoodType {

    public IndianSnacks() {
        foodMap.put("F-107", new Food("Samosa", 22, "F-107"));
        foodMap.put("F-108", new Food("Pakoda", 70, "F-108"));
        foodMap.put("F-109", new Food("Poha",   60, "F-109"));
    }

}
