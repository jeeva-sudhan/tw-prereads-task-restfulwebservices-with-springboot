package com.tw.prereadstask.swiggycartsystem.service;

import java.util.List;
import java.util.ArrayList;

import com.tw.prereadstask.swiggycartsystem.dto.FoodResponse;
import com.tw.prereadstask.swiggycartsystem.dto.RestaurantResponse;
import com.tw.prereadstask.swiggycartsystem.model.RestaurantFood;
import com.tw.prereadstask.swiggycartsystem.repository.RestaurantFoodRespository;
import com.tw.prereadstask.swiggycartsystem.repository.RestaurantRepository;
import com.tw.prereadstask.swiggycartsystem.util.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tw.prereadstask.swiggycartsystem.model.Restaurant;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantMapper restaurantMapper;

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private RestaurantFoodRespository restaurantFoodRespository;

	public List<RestaurantResponse> getAllRestaurant() {
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
    List<RestaurantResponse> restaurantList = new ArrayList<>();
    for(Restaurant restaurant : restaurants) {
      restaurantList.add(restaurantMapper.toRestaurantResponse(restaurant));
    }
		return restaurantList;
	}

	public List<FoodResponse> getRestaurantFood(long restaurantId) throws Exception{
    List<RestaurantFood> restaurantFoods = restaurantFoodRespository.fetchRestaurantFoods(restaurantId).orElseThrow(() -> {
        return new Exception("invalid restaurant id");
    });
    List<FoodResponse> food = new ArrayList<>();
    int length = restaurantFoods.size();
    for(int iterator=0;iterator<length;iterator++) {
      RestaurantFood restaurantFood = restaurantFoods.get(iterator);
      food.add(restaurantMapper.toFoodResponse(restaurantFood));
    }
    return food;
	}

}
