package com.tw.prereadstask.swiggycartsystem.dto;

public class CartItemDTO {
	private long cartItemId;
	private String restaurantName;
	private String foodItemName;
	private String foodItemDesc;
	private double foodItemPrice;
	
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public String getFoodItemDesc() {
		return foodItemDesc;
	}
	public void setFoodItemDesc(String foodItemDesc) {
		this.foodItemDesc = foodItemDesc;
	}
	public double getFoodItemPrice() {
		return foodItemPrice;
	}
	public void setFoodItemPrice(double foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	
}
