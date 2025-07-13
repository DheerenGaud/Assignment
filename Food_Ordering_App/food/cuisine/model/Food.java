package com.aurionpro.food.cuisine.model;

public class Food {
	private String name;
	private double price;
	private String foodId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public Food(String name, double price, String foodId) {
	
		this.name = name;
		this.price = price;
		this.foodId = foodId;
	
	}

	@Override
	public String toString() {
	    return String.format("| %-10s | %-30s | %-10.2f |", foodId, name, price);
	}

	

}
