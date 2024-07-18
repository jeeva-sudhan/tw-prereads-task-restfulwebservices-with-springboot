package com.tw.prereadstask.swiggycartsystem.dto;

public class RestaurantResponse {
  private String name;
  private String description;
  private String address;

  public RestaurantResponse(String name, String description, String address) {
    this.name = name;
    this.description = description;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getAddress() {
    return address;
  }
}
