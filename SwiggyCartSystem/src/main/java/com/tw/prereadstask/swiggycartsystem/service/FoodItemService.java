package com.tw.prereadstask.swiggycartsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.prereadstask.swiggycartsystem.dbrepo.CentralRepo;
import com.tw.prereadstask.swiggycartsystem.model.FoodItem;

@Service
public class FoodItemService {
	
	@Autowired
	private CentralRepo centralRepo;
	
	public FoodItem getFoodItem(long foodItemId) {
		List<FoodItem> foodList = centralRepo.getFoodList();
		int length = foodList.size();
		FoodItem food = null;
		for(int iterator=0;iterator<length;iterator++) {
			FoodItem foodItem = foodList.get(iterator);
			if(foodItem.getFoodItemId() == foodItemId) {
				food = foodItem;
				break;
			}
		}
		return food;
	}
}
