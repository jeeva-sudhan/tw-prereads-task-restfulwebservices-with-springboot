package com.tw.prereadstask.swiggycartsystem.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.prereadstask.swiggycartsystem.model.FoodItem;
import com.tw.prereadstask.swiggycartsystem.model.Restaurant;
import com.tw.prereadstask.swiggycartsystem.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<Restaurant>> getAllRestaurant() {
		List<Restaurant> restaurantList = restaurantService.getAllRestaurant();
		return new ResponseEntity<List<Restaurant>>(restaurantList,HttpStatus.OK);
	}
	
	@GetMapping(path = "/{restaurantId}", produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<ArrayList<FoodItem>> getRestaurant(@PathVariable long restaurantId) {
		ArrayList<FoodItem> restaurantFoods = restaurantService.getRestaurant(restaurantId);
		return new ResponseEntity<ArrayList<FoodItem>>(restaurantFoods,HttpStatus.OK);
	}
}
