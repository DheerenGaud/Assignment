package com.aurionpro.order.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private LocalDate date;
	private String orderId;

	private Map<String, LineItem> lineItemMap;
	private double totalPice;
	
	private double finalAmount;
	
	private String paymentMethod;
	
	private String deliveryService;
	

	public Order(LocalDate date, String orderId, Map<String, LineItem> lineItemMap,String paymentMethod) {
		super();
		this.date = date;
		this.orderId = orderId;
		this.lineItemMap = lineItemMap;
		this.paymentMethod =  paymentMethod;
		calculateOrderPrice();
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	

	public void calculateOrderPrice() {
		totalPice = 0;
		for (Map.Entry<String, LineItem> entry : lineItemMap.entrySet()) {
			totalPice += entry.getValue().getLineTotal();
		}
	}

	public Map<String, LineItem> getLineItemMap() {
		return lineItemMap;
	}

	public void setLineItemMap(Map<String, LineItem> lineItemMap) {
		this.lineItemMap = lineItemMap;
	}

	public double getOrderTotal() {
		return totalPice;
	}

	public void setOrderTotal(double orderTotal) {
		this.totalPice = orderTotal;
	}
	public void setFinalAmount(double finalAmount2) {
		this.finalAmount = finalAmount2;
	}
    public double getFinalAmount(){
    	return finalAmount;
    }
    public String getPaymentMethod() {
    	return paymentMethod;
    }

	public String getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(String deliveryService) {
		this.deliveryService = deliveryService;
	}

	
	
}
