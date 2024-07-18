package com.tw.prereadstask.swiggycartsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tw.prereadstask.swiggycartsystem.model.*;
import com.tw.prereadstask.swiggycartsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.prereadstask.swiggycartsystem.dto.UserCartResponse;

@Service
public class CartService {

  @Autowired
  private RestaurantFoodRespository restaurantFoodRespository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private CartItemRepository cartItemRepository;

  @Autowired
  private UserCartRepository userCartRepository;

  @Autowired
  private FoodItemService foodItemService;

	public List<UserCartResponse> getCartItems(String mobileNumber) throws Exception {
    User user = userRepository.findUserByMobileNumber(mobileNumber).orElseThrow(() -> {
      return new Exception("Invalid user");
    });

    List<UserCart> userCartList = userCartRepository.fetchUserCart(user.getId()).orElseThrow(() -> {
      return new Exception("No items in cart. Add the items into cart");
    });

    List<UserCartResponse> userCartResponseList = new ArrayList<>();

    int length = userCartList.size();
    for(int iterator=0;iterator<length;iterator++) {
      UserCart userCart = userCartList.get(iterator);
      CartItem cartItem = userCart.getCartItem();
      String foodName = foodItemService.name(cartItem.getFood().getId());

      RestaurantFoodPK restaurantFoodPK = new RestaurantFoodPK(cartItem.getRestaurant().getId(),cartItem.getFood().getId());
      RestaurantFood restaurantFood = restaurantFoodRespository.findById(restaurantFoodPK).orElseThrow(() -> {
        return new Exception("No food items in this restaurant");
      });;

      UserCartResponse userCartResponse = new UserCartResponse(restaurantFood.getRestaurant().getName(),foodName,restaurantFood.getFoodDescription(),restaurantFood.getFoodPrice());
      userCartResponseList.add(userCartResponse);
    }
    return userCartResponseList;
	}

	public void addItemToCart(String mobileNumber,long restaurantId,long foodItemId) throws Exception {
    User user = userRepository.findUserByMobileNumber(mobileNumber).orElseThrow(() -> {
      return new Exception("Invalid user");
    });
    RestaurantFoodPK restaurantFoodPK = new RestaurantFoodPK(restaurantId,foodItemId);
    Optional<RestaurantFood> restaurantFood = restaurantFoodRespository.findById(restaurantFoodPK);

    CartItem cartItem = new CartItem(restaurantFood.get().getRestaurant(),restaurantFood.get().getFood());
    cartItem = cartItemRepository.save(cartItem);

    UserCart userCart = new UserCart(user,cartItem);
    userCartRepository.save(userCart);
	}

	public void removeItemFromCart(String mobileNumber,long cartId) throws Exception {
    User user = userRepository.findUserByMobileNumber(mobileNumber).orElseThrow(() -> {
      return new Exception("Invalid user");
    });

    CartItem cartItem = cartItemRepository.findById(cartId).orElseThrow(() -> {
      return new Exception("Invalid cart id");
    });

    UserCartPK userCartPK = new UserCartPK(user.getId(), cartItem.getCartItemId());
    userCartRepository.deleteById(userCartPK);

    cartItemRepository.delete(cartItem);
  }
}
