package com.tw.prereadstask.swiggycartsystem.dto;

public class UserCartResponse {
	private String restaurantName;
	private String foodItemName;
	private String foodItemDesc;
	private double foodItemPrice;

  public UserCartResponse(String restaurantName, String foodItemName, String foodItemDesc, double foodItemPrice) {
    this.restaurantName = restaurantName;
    this.foodItemName = foodItemName;
    this.foodItemDesc = foodItemDesc;
    this.foodItemPrice = foodItemPrice;
  }

  public UserCartResponse() {}

  public String getRestaurantName() {
    return restaurantName;
  }

  public String getFoodItemName() {
    return foodItemName;
  }

  public String getFoodItemDesc() {
    return foodItemDesc;
  }

  public double getFoodItemPrice() {
    return foodItemPrice;
  }
}
