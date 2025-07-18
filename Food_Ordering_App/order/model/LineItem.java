package com.aurionpro.order.model;

public class LineItem {
	private int quantity;
	private double unitPrice;
	private String name;
	private double lineTotal;
	
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		calculateLineTotal();
	}
	public void addQuantity(int quantity) {
		this.quantity += quantity;
		calculateLineTotal();
	}
	public void removeQuantity(int quantity) {
		this.quantity -= quantity;
		calculateLineTotal();
	}
	

	@Override
	public String toString() {
		return "LineItem [quantity=" + quantity + ", unitPrice=" + unitPrice + ", name=" + name + ", lineTotal="
				+ lineTotal + "]";
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	

	public String getName() {
		return name;
	}
	public double getLineTotal() {
		return lineTotal;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public LineItem(int quantity, double price,  String name) {
		super();
		this.quantity = quantity;
		this.unitPrice = price;
		this.name = name;
		calculateLineTotal();
	}
	
	public void calculateLineTotal() {
		lineTotal = unitPrice*quantity;
	}

}
