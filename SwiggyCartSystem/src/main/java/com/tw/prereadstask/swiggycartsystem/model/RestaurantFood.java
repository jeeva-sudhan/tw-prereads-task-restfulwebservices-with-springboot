package com.tw.prereadstask.swiggycartsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurantfood")
@IdClass(RestaurantFoodPK.class)
public class RestaurantFood {
  @Id
  @OneToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Id
  @OneToOne
  @JoinColumn(name = "food_id")
  private FoodItem food;

  @Column(name = "food_description")
  private String foodDescription;

  @Column(name = "food_price")
  private double foodPrice;

  public RestaurantFood(Restaurant restaurant,FoodItem food, String foodDescription, double foodPrice) {
    this.restaurant = restaurant;
    this.food = food;
    this.foodDescription = foodDescription;
    this.foodPrice = foodPrice;
  }

  public RestaurantFood() {}

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public FoodItem getFood() {
    return food;
  }

  public String getFoodDescription() {
    return foodDescription;
  }

  public double getFoodPrice() {
    return foodPrice;
  }
}
