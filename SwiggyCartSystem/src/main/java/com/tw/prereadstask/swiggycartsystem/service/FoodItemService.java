package com.tw.prereadstask.swiggycartsystem.service;

import com.tw.prereadstask.swiggycartsystem.model.FoodItem;
import com.tw.prereadstask.swiggycartsystem.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

  @Autowired
  private FoodItemRepository foodItemRepository;

  public String name(long foodId) throws Exception {
    FoodItem food = foodItemRepository.findById(foodId).orElseThrow(() -> {
      return new Exception("food item not present");
    });
    return food.getName();
  }
}
