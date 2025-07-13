package com.aurionpro.food.manager;

import java.util.Map;
import java.util.TreeMap;

import com.aurionpro.food.discount.Discount_02;
import com.aurionpro.food.discount.Discount_01;
import com.aurionpro.food.model.IDiscount;

public class DiscountManager {
    Map<Integer,IDiscount> disCountMap ;
    
    public DiscountManager() {
    	disCountMap =  new TreeMap<Integer, IDiscount>((a,b)->b-a);
    	disCountMap.put(500, new Discount_01());
    	disCountMap.put(1500, new Discount_02());
    }
    
    public void addNewDiscount(IDiscount discount) {
    	disCountMap.put(discount.getHittingAmount(), discount);
    }
    
    public void removeDiscount(IDiscount discount) {
    	disCountMap.remove(discount);
    }
    
    public double findDiscount(double amount) {
    	for(Map.Entry<Integer,IDiscount> entry : disCountMap.entrySet()) {
    		if(entry.getKey()<amount) {
    			return entry.getValue().getDiscountParcent();
    		}
    	}
    	return 0;
    }
    
}
