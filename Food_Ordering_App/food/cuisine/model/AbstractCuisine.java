package com.aurionpro.food.cuisine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;

public class AbstractCuisine implements ICuisine {
	protected final Map<String, IFoodType> menuMap   = new LinkedHashMap<>();
	protected final Map<String, IFoodType> pendingMap = new LinkedHashMap<>();
    private String currentMenu;


    @Override
    public void showMenu(String index) {
        String menuType = Utils.intToStringForMenu(index, menuMap);
        currentMenu     = menuType;

        IFoodType type  = menuMap.get(menuType);
        if (type == null) throw new ItemNotFoundException(menuType);

        System.out.print(" Menu : " + menuType);
        type.showFood();
    }

    @Override
    public void showMenuType() {
        Print.showMenuType(menuMap);
    }

    @Override
    public boolean showNotApproveMenu() {
    	
        if (pendingMap.isEmpty())
        	{
        	return false;
        	}
        Print.showMenuType(pendingMap);
        return true;
    }

    @Override
    public void addMenuType(String index) {
    	
        String menuType = Utils.intToStringForMenu(index, pendingMap);
        
        if (menuMap.containsKey(menuType)) throw new ItemExistException(menuType);

        menuMap.put(menuType, pendingMap.get(menuType));
        pendingMap.remove(menuType);
    }

    @Override
    public void removeMenuType(String index) {
        String menuType = Utils.intToStringForMenu(index, menuMap);
        IFoodType type  = menuMap.remove(menuType);
        pendingMap.put(menuType, type);
        System.out.println("remove sucessfully");
    }

    @Override
    public Food getFood(String foodId) {
        IFoodType type = menuMap.get(currentMenu);
        if (type == null) throw new ItemNotFoundException(currentMenu);
        return type.getFood(foodId);
    }


    public String intToString(String index) {
        return Utils.intToStringForMenu(index, menuMap);
    }

	@Override
	public void addFood(Food food,String index) {
		currentMenu = Utils.intToStringForMenu(index, menuMap);
		
		System.out.println(currentMenu);
		menuMap.get(currentMenu).newFoodAdd(food);
	}
	@Override
	public void removeFood(String foodId) {
		menuMap.get(currentMenu).removeFood(foodId);
	}
	
}
