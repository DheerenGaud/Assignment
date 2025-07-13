package com.aurionpro.customer.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.aurionpro.order.model.Order;

public class Customer {
	private String name;
	private String customerId;
	private Map<String, Order> orderMap;
	
	public Customer(String name, String customerId) {
		super();
		this.name = name;
		this.customerId = customerId;
		orderMap =  new LinkedHashMap<String, Order>();
	}

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Map<String, Order> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Order> orderMap) {
		this.orderMap = orderMap;
	}
	public void addOrder(String orderId,Order order) {
		orderMap.put(orderId, order);
	}
	public void removeOrder(String orderId,Order order) {
		orderMap.remove(orderId);
	}
}
