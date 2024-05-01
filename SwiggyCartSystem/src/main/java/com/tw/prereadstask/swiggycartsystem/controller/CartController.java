package com.tw.prereadstask.swiggycartsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tw.prereadstask.swiggycartsystem.dto.CartItemDTO;
import com.tw.prereadstask.swiggycartsystem.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
	public ResponseEntity<List<CartItemDTO>> getCartItems(@RequestParam long userId) {
		List<CartItemDTO> userCart = cartService.getCartItems(userId);
		return new ResponseEntity<List<CartItemDTO>>(userCart,HttpStatus.OK);
	}
	
	@PostMapping(produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> addCartItem(@RequestParam long userId,@RequestParam long restaurantId,@RequestParam long foodItemId) {
		cartService.addItemToCart(userId, restaurantId, foodItemId);
		return new ResponseEntity<String>("food item added into cart successfully",HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{cartId}",produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> removeCartItem(@PathVariable long cartId,@RequestParam long userId) {
		cartService.removeItemFromCart(cartId, userId);
		return new ResponseEntity<String>("food item removed from cart successfully",HttpStatus.OK);
	}
}
