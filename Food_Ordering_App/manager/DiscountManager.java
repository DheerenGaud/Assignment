package com.aurionpro.manager;

import java.util.Map;
import java.util.TreeMap;

import com.aurionpro.discount.model.IDiscount;
import com.aurionpro.discount.types.Discount_01;
import com.aurionpro.discount.types.Discount_02;
import com.aurionpro.discount.types.Discount_03;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;

public class DiscountManager {
   private static Map<Integer,IDiscount> disCountMap ;
   private static Map<Integer, IDiscount> notApproveDisocutMap;

    
    static{
    	disCountMap =  new TreeMap<Integer, IDiscount>((a,b)->b-a);
    	notApproveDisocutMap = new TreeMap<Integer, IDiscount>((a,b)->b-a);
    	disCountMap.put(500, new Discount_01());
    	disCountMap.put(1500, new Discount_02());
    	notApproveDisocutMap.put(3000, new Discount_03());
    }
    
    public boolean showAllDiscounts() {
        if (disCountMap.isEmpty()) {
            System.out.println("No Discounts Found.");
            return false;
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.printf("| %-10s | %-10s |\n", "Amount", "Percent (%)");
        System.out.println("-----------------------------");

        for (Map.Entry<Integer, IDiscount> entry : disCountMap.entrySet()) {
            System.out.printf("| %-10d | %-10.2f |\n", entry.getKey(), entry.getValue().getDiscountParcent());
        }

        System.out.println("-----------------------------");
        return true;
    }
    
    public boolean shownotApproveDiscounts() {
        if (notApproveDisocutMap.isEmpty()) {
            System.out.println("No Discounts Found.");
            return false;
        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.printf("| %-10s | %-10s |\n", "Amount", "Percent (%)");
        System.out.println("-----------------------------");

        for (Map.Entry<Integer, IDiscount> entry : notApproveDisocutMap.entrySet()) {
            System.out.printf("| %-10d | %-10.2f |\n", entry.getKey(), entry.getValue().getDiscountParcent());
        }

        System.out.println("-----------------------------");
        return true;
    }
    

    public void addDiscount(int hittingAmount) {
        if (disCountMap.containsKey(hittingAmount)) {
            throw new ItemExistException("Discount already active at " + hittingAmount);
        }
        IDiscount d = notApproveDisocutMap.get(hittingAmount);
        if (d == null) {
            throw new ItemNotFoundException("No pending discount at " + hittingAmount);
        }
        disCountMap.put(hittingAmount, d);
        notApproveDisocutMap.remove(hittingAmount);
    }

    public void removeDiscount(int hittingAmount) {
        if (!disCountMap.containsKey(hittingAmount)) {
            throw new ItemNotFoundException("No active discount at " + hittingAmount);
        }
        notApproveDisocutMap.put(hittingAmount, disCountMap.get(hittingAmount));
        disCountMap.remove(hittingAmount);
    }
    
    public static double findDiscount(double amount) {
    	System.out.println("in find dicount");
    	System.out.println();
    	for(Map.Entry<Integer,IDiscount> entry : disCountMap.entrySet()) {
    		if(entry.getKey()<amount) {
    			return entry.getValue().getDiscountParcent();
    		}
    	}
    	return 0;
    }
    
    static double calculateDiscountedAmmount(double discountPercent, double orderTotal) {
		return orderTotal - (orderTotal*discountPercent/100);
	}
    
}
