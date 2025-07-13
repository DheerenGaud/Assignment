package com.aurionpro.manager;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aurionpro.customer.model.Customer;
import com.aurionpro.exceptions.ItemNotFoundException;
import com.aurionpro.exceptions.PaymentExceptions;
import com.aurionpro.food.cuisine.model.Food;
import com.aurionpro.helper.Print;
import com.aurionpro.helper.Utils;
import com.aurionpro.order.model.LineItem;
import com.aurionpro.order.model.Order;
import com.aurionpro.payment.model.IPayment;

public class OrderManager {
	static Map<String, LineItem> lineItemMap;

	public OrderManager() {
		lineItemMap = new LinkedHashMap<String, LineItem>();
	}

	public void addFood(int quantity, Food food) {
		String foodId = food.getFoodId();
		if (lineItemMap.containsKey(food.getFoodId())) {
			lineItemMap.get(foodId).addQuantity(quantity);
			return;
		}
		lineItemMap.put(food.getFoodId(), new LineItem(quantity, food.getPrice(), food.getName()));
	}

	public void addQuantity(int quantity, String lineId) {
		if (!lineItemMap.containsKey(lineId)) {
			throw new ItemNotFoundException(lineId);
		}
		LineItem selectedFood = lineItemMap.get(lineId);
		selectedFood.addQuantity(quantity);
	}

	public void removeQuantityint(int quantity, String lineId) {
		if (!lineItemMap.containsKey(lineId)) {
			throw new ItemNotFoundException(lineId);
		}
		LineItem selectedFood = lineItemMap.get(lineId);
		selectedFood.removeQuantity(quantity);
	}

	public void removeFood(String lineId) {
		lineItemMap.remove(lineId);
	}

	public void showCuurentOrder() {
		viewOrder(lineItemMap);
	}

	public static boolean showAllOrders(Customer customer) {
        if(customer.getOrderMap().size()==0) {
        	System.out.println();
        	System.out.println("No Order...");
        	return false;
        }
		Print.showAllOreder(customer);
		return true;
	}

	public static void placeOrder(Customer cutomer, IPayment paymentMethod) {
		System.out.println();
		System.out.println();
		System.out.println("Placeing order...");
		Order order = new Order(LocalDate.now(), Utils.randomString("ORD"), lineItemMap,
				paymentMethod.getPayMethodName()); // handle discount

		// discount
		double discountPercent = DiscountManager.findDiscount(order.getOrderTotal());
		double finalAmount = DiscountManager.calculateDiscountedAmmount(discountPercent, order.getOrderTotal());
		order.setFinalAmount(finalAmount);

		// delevry boy
		if (!DeliveryManager.assignDelivery(order)) {
			System.out.println("Delivery Services Not Found");
			return;
		}

		try {
			if (PaymentManager.paymentProcess(paymentMethod, finalAmount)) {
				
				// invoice
				System.out.println("order place succfully");
				cutomer.addOrder(order.getOrderId(), order);
				showInvoice(cutomer, order.getOrderId());
				
				lineItemMap = new LinkedHashMap<String, LineItem>();
				return;
			}
			
		} catch (PaymentExceptions e) {
			System.out.println(e.getMessage());
        } 
		catch (Exception e) {
            throw new PaymentExceptions("Invalid input: " + e.getMessage());
        }


		System.out.println("Payment Unsuccessful");

	}

	public static void showInvoice(Customer customer, String orderId) {
		Print.showInvoice(customer, orderId);
	}

	private static void viewOrder(Map<String, LineItem> lineItemMap) {
		Print.viewOrder(lineItemMap);
	}

	public void setQuantity(String lineId, int quantity) {
		if (!lineItemMap.containsKey(lineId)) {
			throw new ItemNotFoundException(lineId);
		}

		if (quantity == 0) {
			removeFood(lineId);
			return;
		}
		lineItemMap.get(lineId).setQuantity(quantity);
		return;

	}

	public boolean canPlaceOrder() {
		
		return !lineItemMap.isEmpty();
	}

}