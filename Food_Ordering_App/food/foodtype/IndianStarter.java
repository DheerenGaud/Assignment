package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class IndianStarter extends AbstractFoodType {

    public IndianStarter() {
        foodMap.put("F-110", new Food("Paneer Tikka", 130, "F-110"));
        foodMap.put("F-111", new Food("Chicken Tandoori", 180, "F-111"));
        foodMap.put("F-112", new Food("Hara Bhara Kabab", 100, "F-112"));
    }

}
