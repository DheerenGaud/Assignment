package com.aurionpro.helper;

import java.util.Map;

import com.aurionpro.food.model.Food;
import com.aurionpro.food.model.IFoodType;

public class Print {
   public static void showMenuType(Map<String, IFoodType> menuMap) {
	     System.out.println();
	     int i = 1;
	     for(Map.Entry<String, IFoodType> entry : menuMap.entrySet()) {
	    	 System.out.println(" "+i+"> "+entry.getKey());
	    	 i++;
	     }
   }
   
  
   public static void showFood(Map<String, Food> foodMap) {
	    System.out.println();
	    System.out.println("------------------------------------------------------------");
	    System.out.println("| Food ID    | Name                           | Price (₹)  |");
	    System.out.println("------------------------------------------------------------");
	    for (Map.Entry<String, Food> entry : foodMap.entrySet()) {
	        System.out.println(entry.getValue());
	    }
	    System.out.println("------------------------------------------------------------");
	}



}
