package com.tw.prereadstask.swiggycartsystem.repository;

import com.tw.prereadstask.swiggycartsystem.model.RestaurantFood;
import com.tw.prereadstask.swiggycartsystem.model.RestaurantFoodPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface RestaurantFoodRespository extends CrudRepository<RestaurantFood, RestaurantFoodPK> {
  @Query(value = "SELECT * FROM restaurantfood WHERE restaurant_id = :restaurantId",nativeQuery = true)
  Optional<List<RestaurantFood>> fetchRestaurantFoods(@Param("restaurantId") long restaurantId);
}
