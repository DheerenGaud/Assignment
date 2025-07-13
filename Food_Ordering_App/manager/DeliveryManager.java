package com.aurionpro.manager;

import java.util.HashMap;
import java.util.Map;

import com.aurionpro.delivery.model.IDelivery;
import com.aurionpro.delivery.services.Swiggy;
import com.aurionpro.delivery.services.Zepto;
import com.aurionpro.delivery.services.Zomato;
import com.aurionpro.exceptions.ItemExistException;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.order.model.Order;

public class DeliveryManager {
	 private static final Map<String, IDelivery> deliveryMap = new HashMap<>();
	 private static final Map<String, IDelivery> notApproveDeliveryMap = new HashMap<>();


	 static {
	        deliveryMap.put("swiggy", new Swiggy());
	        deliveryMap.put("zomato", new Zomato());
	        notApproveDeliveryMap.put("zepto", new Zepto());
	    }

	    public static void addDelivery(String name) {
	        name = name.toLowerCase();
	        if (deliveryMap.containsKey(name)) {
	            throw new ItemExistException(name);
	        }
	        IDelivery delivery = notApproveDeliveryMap.get(name);
	        if (delivery == null) {
	            throw new ItemNotFoundException(name);
	        }
	        deliveryMap.put(name, delivery);
	        notApproveDeliveryMap.remove(name);
	    }

	    public static void removeDelivery(String name) {
	        name = name.toLowerCase();
	        if (!deliveryMap.containsKey(name)) {
	            throw new ItemNotFoundException(name);
	        }
	        notApproveDeliveryMap.put(name, deliveryMap.get(name));
	        deliveryMap.remove(name);
	    }

	    public static IDelivery getDelivery(String name) {
	    	if(!deliveryMap.containsKey(name)) {
				throw new ItemNotFoundException(name);
			}
	        return deliveryMap.get(name.toLowerCase());
	    }
	    
	    public boolean checkIsAvailable(String name) {
	    	if(!deliveryMap.containsKey(name)) {
				throw new ItemNotFoundException(name);
			}
			  return deliveryMap.get(name).isAvailable();
		}

	    public static boolean showAllDeliveries() {
	    	if (deliveryMap.isEmpty()) {
	            System.out.println("No Discounts Found.");
	            return false;
	        }
	        System.out.println("\nAvailable Delivery Partners:");
	        for (Map.Entry<String, IDelivery> entry : deliveryMap.entrySet()) {
	            System.out.println("• " + entry.getKey());
	        }
	        return true;
	    }
	    
	    public static boolean showNotApproveDeliveries() {
	    	if (notApproveDeliveryMap.isEmpty()) {
	            System.out.println("No Discounts Found.");
	            return false;
	        }
	        System.out.println("\nAvailable Delivery Partners:");
	        for (Map.Entry<String, IDelivery> entry : notApproveDeliveryMap.entrySet()) {
	            System.out.println("• " + entry.getKey());
	        }
	        return true;
	    }
	    
	    public static boolean assignDelivery(Order order) {
	    	
	    	  for (Map.Entry<String, IDelivery> entry : deliveryMap.entrySet()) {
		            if(entry.getValue().isAvailable()) {
		            	// oder aissign
		            	order.setDeliveryService(entry.getValue().getName());
		            	return true;
		            }
		        }
	    	  return false;
	    }
}
