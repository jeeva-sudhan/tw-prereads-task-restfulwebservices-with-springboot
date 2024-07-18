package com.tw.prereadstask.swiggycartsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartItemId;

  @OneToOne
  @JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

  @OneToOne
  @JoinColumn(name = "food_id")
	private FoodItem food;

  public CartItem(Restaurant restaurant, FoodItem food) {
    this.restaurant = restaurant;
    this.food = food;
  }

  public CartItem() {}

  public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public FoodItem getFood() {
		return food;
	}
	public void setFood(FoodItem food) {
		this.food = food;
	}

}
