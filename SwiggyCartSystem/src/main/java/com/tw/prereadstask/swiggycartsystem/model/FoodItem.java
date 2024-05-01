package com.tw.prereadstask.swiggycartsystem.model;

public class FoodItem {
	private long foodItemId;
	private String name;
	private String foodDesc;
	private double price;
	
	public FoodItem() {}
	
	public FoodItem(long foodItemId, String name, String foodDesc, double price) {
		super();
		this.foodItemId = foodItemId;
		this.name = name;
		this.foodDesc = foodDesc;
		this.price = price;
	}
	
	public long getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(long foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFoodDesc() {
		return foodDesc;
	}
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
