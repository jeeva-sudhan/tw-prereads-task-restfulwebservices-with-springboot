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

import com.tw.prereadstask.swiggycartsystem.dto.UserCartResponse;
import com.tw.prereadstask.swiggycartsystem.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE
	})
    public ResponseEntity<List<UserCartResponse>> getCartItems(@RequestParam String mobileNumber) throws Exception {
		List<UserCartResponse> userCart = cartService.getCartItems(mobileNumber);
		return new ResponseEntity<List<UserCartResponse>>(userCart,HttpStatus.OK);
	}

	@PostMapping(produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> addCartItem(@RequestParam String mobileNumber,@RequestParam long restaurantId,@RequestParam long foodItemId) throws Exception {
		cartService.addItemToCart(mobileNumber, restaurantId, foodItemId);
		return new ResponseEntity<String>("food item added into cart successfully",HttpStatus.OK);
	}

	@DeleteMapping(path = "/{cartId}",produces = {
			MediaType.TEXT_PLAIN_VALUE
	})
	public ResponseEntity<String> removeCartItem(@PathVariable long cartId,@RequestParam String mobileNumber) throws Exception {
		cartService.removeItemFromCart(mobileNumber, cartId);
		return new ResponseEntity<String>("food item removed from cart successfully",HttpStatus.OK);
	}
}
