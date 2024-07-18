package com.tw.prereadstask.swiggycartsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.tw.prereadstask.swiggycartsystem.service.UserService;
import com.tw.prereadstask.swiggycartsystem.model.User;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> usersList = userService.getAllUser();
		return new ResponseEntity<List<User>>(usersList,HttpStatus.OK);
	}

	@GetMapping(path = "/{userId}",produces = {
    		MediaType.APPLICATION_JSON_VALUE
    })
	public ResponseEntity<User> getUser(@PathVariable long userId) throws Exception {
		User user = userService.getUser(userId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@PostMapping(produces = {
			    		MediaType.TEXT_PLAIN_VALUE
			    })
    public ResponseEntity<String> login(@RequestParam(value="mobileNumber") String mobileNumber) {
		if(userService.isValidUser(mobileNumber)) {
			return new ResponseEntity<String>("user login successfull",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("mobile number or password incorrect",HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping(consumes = {
					MediaType.APPLICATION_JSON_VALUE
				},
			    produces = {
			    		MediaType.TEXT_PLAIN_VALUE
			    })
	public ResponseEntity<String> signup(@RequestBody User user) {
		long userId = userService.addUser(user);
		return new ResponseEntity<String>("User registered successfully: " +userId,HttpStatus.OK);
	}

}
