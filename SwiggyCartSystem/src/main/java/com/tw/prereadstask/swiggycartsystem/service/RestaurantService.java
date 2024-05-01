package com.tw.prereadstask.swiggycartsystem.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.prereadstask.swiggycartsystem.dbrepo.CentralRepo;
import com.tw.prereadstask.swiggycartsystem.model.FoodItem;
import com.tw.prereadstask.swiggycartsystem.model.Restaurant;

@Service
public class RestaurantService {
	
	@Autowired
	private CentralRepo centralRepo;
	
	public String getRestaurantName(long restaurantId) {
		List<Restaurant> restaurantList = centralRepo.getRestaurantlist();
		int length = restaurantList.size();
		String restaurantName = "";
		for(int iterator=0;iterator<length;iterator++) {
			Restaurant restaurant = restaurantList.get(iterator);
			if(restaurant.getRestaurantId() == restaurantId) {
				restaurantName = restaurant.getName();
				break;
			}
		}
		return restaurantName;
	}
	
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restaurantList = centralRepo.getRestaurantlist();
		return restaurantList;
	}
	
	public ArrayList<FoodItem> getRestaurant(long restaurantId) {
		Map<Long,ArrayList<FoodItem>> restaurantFoodsList = centralRepo.getRestaurantFoods();
		ArrayList<FoodItem> restaurantFoods = restaurantFoodsList.get(restaurantId);
		return restaurantFoods;
	}
	
}
