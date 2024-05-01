package com.tw.prereadstask.swiggycartsystem.model;

public class Restaurant {
	private long restaurantId;
	private String name;
	private String restaurantDesc;
	private String address;
	
	public Restaurant() {}
	
	public Restaurant(long restaurantId, String name, String restaurantDesc, String address) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.restaurantDesc = restaurantDesc;
		this.address = address;
	}
	
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurantDesc() {
		return restaurantDesc;
	}
	public void setRestaurantDesc(String restaurantDesc) {
		this.restaurantDesc = restaurantDesc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
