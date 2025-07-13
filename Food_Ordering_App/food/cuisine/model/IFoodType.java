package com.aurionpro.food.cuisine.model;

public interface IFoodType {
	void showFood();
    Food getFood(String foodId);   
    void removeFood(String foodId);   
    void newFoodAdd(Food food);
   
}
