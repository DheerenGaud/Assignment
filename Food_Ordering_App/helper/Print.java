package com.aurionpro.helper;

import java.util.Map;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.food.cuisine.model.IFoodType;
import com.aurionpro.order.model.LineItem;
import com.aurionpro.order.model.Order;

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

   
   public static void showAllOreder(Customer customer) {
	   Map<String, Order> orderMap = customer.getOrderMap();
       
       System.out.println("\n================= ORDER HISTORY =================");

       if (orderMap == null || orderMap.isEmpty()) {
           System.out.println("No orders found for " + customer.getName());
           System.out.println("=================================================\n");
           return;
       }

    
       System.out.printf("%-10s %-12s %-12s %-12s %-15s %-15s%n",
               "Order ID", "Date", "Gross(₹)", "Net(₹)", "Payment", "Delivery");
       System.out.println("-------------------------------------------------------------"
                        + "-------------------------");

       // Body rows
       for (Order order : orderMap.values()) {
           double gross   = order.getOrderTotal();   // before discounts/taxes
           double net     = order.getFinalAmount();  // after adjustments
           String pay     = order.getPaymentMethod();
           String carrier = order.getDeliveryService();

           System.out.printf("%-10s %-12s %-12.2f %-12.2f %-15s %-15s%n",
                   order.getOrderId(),
                   order.getDate(),
                   gross,
                   net,
                   pay,
                   carrier);
       }

       System.out.println("=================================================\n");
   }
   
  public static void showInvoice(Customer customer, String orderId) {
    System.out.println("\n\n====================  TAX INVOICE  ====================\n");

    Order order = customer.getOrderMap().get(orderId);
    if(!customer.getOrderMap().containsKey(orderId)) {
		throw new ItemNotFoundException(orderId);
	}
    
    if (order == null) {
        System.out.printf("No order found with ID %s for customer %s%n",
                          orderId, customer.getName());
        System.out.println("========================================================");
        return;
    }

    final int COL1 = 18; 
    final int COL2 = 25;  
    final String ROW_FMT = "| %-" + COL1 + "s | %-" + COL2 + "s |%n";

    String border = "+" + "-".repeat(COL1 + 2)  
                   + "+" + "-".repeat(COL2 + 2)
                   + "+";

    System.out.println(border);
    System.out.printf(ROW_FMT, "Customer",         customer.getName());
    System.out.printf(ROW_FMT, "Order ID",         orderId);
    System.out.printf(ROW_FMT, "Payment Method",   order.getPaymentMethod());
    System.out.printf(ROW_FMT, "Delivery Service", order.getDeliveryService());
    System.out.printf(ROW_FMT, "Date",             order.getDate());
    System.out.println(border + "\n");

    viewOrder(order.getLineItemMap());

    /* ---------- Totals ---------- */
    double gross    = order.getOrderTotal();
    double net      = order.getFinalAmount();
    double discount = gross - net;

    System.out.println("--------------------------------------------------------");
    System.out.printf("%-25s : Rs. %8.2f%n", "Gross Total", gross);
    System.out.printf("%-25s : Rs. %8.2f%n", "Discount",    discount);
    System.out.printf("%-25s : Rs. %8.2f%n", "Net Payable", net);
    System.out.println("========================================================\n");
}

	
   public static void viewOrder(Map<String, LineItem> lineItemMap) {
			System.out.println();

			if (lineItemMap.isEmpty()) {
				System.out.println("Your Order is empty.");
				return;
			}

			System.out.printf("%-10s %-15s %-10s %-10s %-10s\n", "Line ID", "Name", "Quantity", "Price", "Total");
			System.out.println("------------------------------------------------------");

			for (Map.Entry<String, LineItem> entry : lineItemMap.entrySet()) {
			    LineItem item = entry.getValue();
			    System.out.printf("%-10s %-15s %-10d %-10.2f %-10.2f\n",
			        entry.getKey(),                     
			        item.getName(),                      
			        item.getQuantity(),                  
			        item.getUnitPrice(),                 
			        item.getLineTotal());               
			}
		}


}
