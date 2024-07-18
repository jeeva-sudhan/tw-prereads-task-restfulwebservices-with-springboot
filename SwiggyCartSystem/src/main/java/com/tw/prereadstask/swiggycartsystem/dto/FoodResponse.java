package com.tw.prereadstask.swiggycartsystem.dto;

public class FoodResponse {
  private String name;
  private String description;
  private double price;

  public FoodResponse(String name, String description, double price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public FoodResponse() {}

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }
}
