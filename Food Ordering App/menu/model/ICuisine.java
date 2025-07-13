package com.aurionpro.menu.model;

import com.aurionpro.food.model.IFoodType;

public interface ICuisine {
    void  showMenu(String menutype);
    void showMenuType();
    void addMenuType(String menuType,IFoodType foodType);
}
