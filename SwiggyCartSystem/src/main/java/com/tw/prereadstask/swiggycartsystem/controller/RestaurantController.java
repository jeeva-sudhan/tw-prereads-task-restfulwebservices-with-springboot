package com.tw.prereadstask.swiggycartsystem.controller;

import java.util.List;

import com.tw.prereadstask.swiggycartsystem.dto.FoodResponse;
import com.tw.prereadstask.swiggycartsystem.dto.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.prereadstask.swiggycartsystem.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<RestaurantResponse>> getAllRestaurant() {
		List<RestaurantResponse> restaurantList = restaurantService.getAllRestaurant();
		return new ResponseEntity<List<RestaurantResponse>>(restaurantList,HttpStatus.OK);
	}

	@GetMapping(path = "/food/{restaurantId}", produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<FoodResponse>> getRestaurant(@PathVariable long restaurantId) throws Exception{
		List<FoodResponse> restaurantFoods = restaurantService.getRestaurantFood(restaurantId);
		return new ResponseEntity<List<FoodResponse>>(restaurantFoods,HttpStatus.OK);
	}
}
