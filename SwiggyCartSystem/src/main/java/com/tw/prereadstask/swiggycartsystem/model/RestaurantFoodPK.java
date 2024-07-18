package com.tw.prereadstask.swiggycartsystem.model;

import java.io.Serializable;

public class RestaurantFoodPK implements Serializable {
  private Long restaurant;
  private Long food;

  public RestaurantFoodPK(Long restaurant, Long food) {
    this.restaurant = restaurant;
    this.food = food;
  }

  public RestaurantFoodPK() {}
}
