package com.aurionpro.food.manager;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.food.model.Food;
import com.aurionpro.helper.Utils;
import com.aurionpro.order.model.LineItem;
import com.aurionpro.order.model.Order;

public class OrderManager {
static Map<String, LineItem> lineItemMap ;

	
    public	OrderManager(){
    	lineItemMap = new LinkedHashMap<String, LineItem>();
	}
    
    public void addFood(int quantity,Food food) {
	   String lineId = Utils.randomString("L");
	   lineItemMap.put(lineId,new LineItem(quantity, food.getPrice(), lineId, food.getName()));
    }
    public void addQuantity(int quantity,String lineId) {
    	LineItem selectedFood = lineItemMap.get(lineId);
    	selectedFood.addQuantity(quantity);
    }
    
    public void removeQuantityint (int quantity,String lineId) {
    	LineItem selectedFood = lineItemMap.get(lineId);
    	selectedFood.removeQuantity(quantity);
    }
    
    public void removeFood(String lineId) {
    	lineItemMap.remove(lineId);
    }
    
	private static void placeOrder(Customer cutomer,DiscountManager discountManger ) {
		System.out.println();
		System.out.println();
		System.out.println("Placeing order...");
		Order order = new Order(LocalDate.now(),Utils.randomString("ORD"), lineItemMap); // handle discount 
		
		
		// discount 
		double discountPercent = discountManger.findDiscount(order.getOrderTotal());
		double finalAmount = calculateDiscountedAmmount(discountPercent,order.getOrderTotal());		
		
		// pay 
		
		
		
		
		// invoice 
		
		cutomer.addOrder(order.getOrderId(),order);
		lineItemMap = new LinkedHashMap<String, LineItem>();
		System.out.println("order place succfully");
		viewOrderById(cutomer,order.getOrderId());
	}
	
	private static double calculateDiscountedAmmount(double discountPercent, double orderTotal) {
		return orderTotal - (orderTotal*discountPercent/100);
	}
	private static void viewOrderById(Customer cutomer ,String orderId ) {
	    System.out.println();
	    System.out.println();
	    Order order = cutomer.getOrderMap().get(orderId);
	    System.out.println("\nOrder: " + orderId);
	    System.out.println("Date : " + order.getDate());
	    System.out.println("Total: Rs." + order.getOrderTotal());

}
	
	
//	 private static void viewCurrentOrder(Map<String, LineItem> lineItemMap) {
//			System.out.println();
//		    System.out.println();
//			System.out.println("Viewing Order...");
//
//			if (lineItemMap.isEmpty()) {
//				System.out.println("Your Order is empty.");
//				return;
//			}
//
//			System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "Line ID", "Name", "Quantity", "Price", "Total");
//			System.out.println("--------------------------------------------------------------------");
//
//			for (Map.Entry<String, LineItem> entry : lineItemMap.entrySet()) {
//			    LineItem item = entry.getValue();
//			    System.out.printf("%-10s %-15s %-10d %-10.2f %-10.2f\n",
//			        entry.getKey(),                     
//			        item.getName(),                      
//			        item.getQuantity(),                  
//			        item.getUnitPrice(),                 
//			        item.getLineTotal());               
//			}
//
//		}
		

}