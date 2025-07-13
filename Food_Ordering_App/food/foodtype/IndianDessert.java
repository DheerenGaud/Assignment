package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class IndianDessert extends AbstractFoodType{

    public IndianDessert() {
        foodMap.put("F-104", new Food("Gulab Jamun", 60, "F-104"));
        foodMap.put("F-105", new Food("Rasgulla",    50, "F-105"));
        foodMap.put("F-106", new Food("Jalebi",      45, "F-106"));     
    }


}
