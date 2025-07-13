package com.aurionpro.food.cuisine.model;

public interface ICuisine  {
    void  showMenu(String index);
    void showMenuType();
    void addMenuType(String index);
	Food getFood(String foodId);
	boolean showNotApproveMenu();
	void removeMenuType(String index);
	void addFood(Food food,String index);
	void removeFood(String foodId);
}
