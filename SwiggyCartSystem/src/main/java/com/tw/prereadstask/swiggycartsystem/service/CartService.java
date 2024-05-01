package com.tw.prereadstask.swiggycartsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.prereadstask.swiggycartsystem.dbrepo.CentralRepo;
import com.tw.prereadstask.swiggycartsystem.dto.CartItemDTO;
import com.tw.prereadstask.swiggycartsystem.model.Cart;
import com.tw.prereadstask.swiggycartsystem.model.FoodItem;
import com.tw.prereadstask.swiggycartsystem.util.IdGenerator;

@Service
public class CartService {
	
	@Autowired
	private CentralRepo centralRepo;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private FoodItemService foodItemService;
	
	public List<CartItemDTO> getCartItems(long userId) {
		Map<Long,ArrayList<Cart>> usersCart = centralRepo.getUsersCart();
		ArrayList<Cart> userCart = null;
		for(Map.Entry<Long, ArrayList<Cart>> cart : usersCart.entrySet()) {
			if(cart.getKey() == userId) {
				userCart = cart.getValue();
				break;
			}
		}
		
		if(userCart == null) {
			return new ArrayList<CartItemDTO>();
		}
		
		List<CartItemDTO> userCartItems = new ArrayList<CartItemDTO>();
		
		int length = userCart.size();
		for(int iterator=0;iterator<length;iterator++) {
			Cart cartItem = userCart.get(iterator);
			CartItemDTO cartItemDto = new CartItemDTO();
			cartItemDto.setCartItemId(cartItem.getCartItemId());
			cartItemDto.setRestaurantName(restaurantService.getRestaurantName(cartItem.getRestaurantId()));
			FoodItem foodItem = foodItemService.getFoodItem(cartItem.getFoodItemId());
			cartItemDto.setFoodItemName(foodItem.getName());
			cartItemDto.setFoodItemDesc(foodItem.getFoodDesc());
			cartItemDto.setFoodItemPrice(foodItem.getPrice());
			userCartItems.add(cartItemDto);
		}
		
		return userCartItems;
	}
	
	public void addItemToCart(long userId,long restaurantId,long foodItemId) {
		Map<Long,ArrayList<Cart>> usersCart = centralRepo.getUsersCart();
		IdGenerator.generateCartItemId();
		long cartItemId = IdGenerator.getCartItemId();
		
		ArrayList<Cart> userCart;
		if(usersCart.containsKey(userId)) {
			userCart = usersCart.get(userId);
		}
		else {
			userCart = new ArrayList<Cart>();
			usersCart.put(userId, userCart);
		}
		Cart cartItem = new Cart();
		cartItem.setCartItemId(cartItemId);
		cartItem.setRestaurantId(restaurantId);
		cartItem.setFoodItemId(foodItemId);
		userCart.add(cartItem);
	}
	
	public void removeItemFromCart(long cartId,long userId) {
		Map<Long,ArrayList<Cart>> usersCart = centralRepo.getUsersCart();
		ArrayList<Cart> userCart = usersCart.get(userId);
		int length = userCart.size();
		for(int iterator=0;iterator<length;iterator++) {
			Cart cartItem = userCart.get(iterator);
			if(cartItem.getCartItemId() == cartId) {
				userCart.remove(cartItem);
				break;
			}
		}
	}
}
