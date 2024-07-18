package com.tw.prereadstask.swiggycartsystem.util;

import com.tw.prereadstask.swiggycartsystem.dto.FoodResponse;
import com.tw.prereadstask.swiggycartsystem.dto.RestaurantResponse;
import com.tw.prereadstask.swiggycartsystem.model.Restaurant;
import com.tw.prereadstask.swiggycartsystem.model.RestaurantFood;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
  public RestaurantResponse toRestaurantResponse(Restaurant restaurant) {
    return new RestaurantResponse(restaurant.getName(),restaurant.getDescription(),restaurant.getAddress());
  }

  public FoodResponse toFoodResponse(RestaurantFood restaurantFood) {
    return new FoodResponse(restaurantFood.getFood().getName(),restaurantFood.getFoodDescription(),restaurantFood.getFoodPrice());
  }
}
