package com.aurionpro.order.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
	private LocalDate date;
	private String orderId;

	private Map<String, LineItem> lineItemMap;
	private double orderTotal;
	
	
	
	
	public Order(LocalDate date, String orderId, Map<String, LineItem> lineItemMap) {
		super();
		this.date = date;
		this.orderId = orderId;
		this.lineItemMap = lineItemMap;
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

	public Map<String, LineItem> getLineItemSet() {
		return lineItemMap;
	}

	public void calculateOrderPrice() {
		orderTotal = 0;
		for (Map.Entry<String, LineItem> entry : lineItemMap.entrySet()) {
			orderTotal += entry.getValue().getLineTotal();
		}
	}

	public Map<String, LineItem> getLineItemMap() {
		return lineItemMap;
	}

	public void setLineItemMap(Map<String, LineItem> lineItemMap) {
		this.lineItemMap = lineItemMap;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

}
