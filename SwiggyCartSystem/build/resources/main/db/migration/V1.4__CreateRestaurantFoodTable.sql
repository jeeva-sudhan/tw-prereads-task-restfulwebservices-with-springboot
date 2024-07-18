CREATE TABLE restaurantfood (
  restaurant_id BIGINT,
  food_id BIGINT,
  food_description VARCHAR(510),
  food_price DOUBLE PRECISION,
  FOREIGN KEY(restaurant_id) REFERENCES restaurant(id),
  FOREIGN KEY(food_id) REFERENCES fooditem(id)
);
