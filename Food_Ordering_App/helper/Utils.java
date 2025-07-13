package com.aurionpro.helper;

import java.util.Map;

import com.aurionpro.exceptions.InvalidInputException;
import com.aurionpro.exceptions.NegativeValueInput;
import com.aurionpro.food.cuisine.model.ICuisine;
import com.aurionpro.food.cuisine.model.IFoodType;

public class Utils {
  public static String  randomString(String prefix) {
	  int randomNumber = (int) (Math.random()*1000)+1;
	  return prefix+"-"+randomNumber;
  }
  
  public static String intToStringForCuisine(String index, Map<String, ICuisine> cuisineMap) {
	    int i ;
	    try {
	        i = Integer.parseInt(index);
	    } catch (NumberFormatException e) {
	        throw new InvalidInputException("Index must be a valid integer: " + index);
	    }
	    if(i<0) {
	    	throw new NegativeValueInput(i);
	    }
	    for (Map.Entry<String, ICuisine> entry : cuisineMap.entrySet()) {
	        if (--i == 0) return entry.getKey();
	    }
	    throw new InvalidInputException(index);
	}

	public static String intToStringForMenu(String index, Map<String, IFoodType> menuMap) {
		
	    int i ;
	    try {
	        i = Integer.parseInt(index);
	    } catch (NumberFormatException e) {
	        throw new InvalidInputException("Index must be a valid integer: " + index);
	    }
	    if(i<0) {
	    	throw new NegativeValueInput(i);
	    }
	    for (Map.Entry<String, IFoodType> entry : menuMap.entrySet()) {
	    
	        if (--i == 0) return entry.getKey();
	    }
	    throw new InvalidInputException(index);
	   
	}

  

}
