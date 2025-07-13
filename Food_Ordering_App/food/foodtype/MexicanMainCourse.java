package com.aurionpro.food.foodtype;

import com.aurionpro.food.cuisine.model.AbstractFoodType;
import com.aurionpro.food.cuisine.model.Food;

public class MexicanMainCourse extends AbstractFoodType {

    public MexicanMainCourse() {
        foodMap.put("F-304", new Food("Tacos",      130, "F-304"));
        foodMap.put("F-305", new Food("Enchiladas", 140, "F-305"));
        foodMap.put("F-306", new Food("Burritos",   150, "F-306"));
    }

}
