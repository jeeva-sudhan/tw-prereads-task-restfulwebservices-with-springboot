package com.tw.prereadstask.swiggycartsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.tw.prereadstask.swiggycartsystem.model.User;
import com.tw.prereadstask.swiggycartsystem.dbrepo.CentralRepo;
import com.tw.prereadstask.swiggycartsystem.dto.UserDTO;
import com.tw.prereadstask.swiggycartsystem.util.IdGenerator;

@Service
public class UserService {
	
	@Autowired
	private CentralRepo centralRepo;
	
	public List<User> getAllUser() {
		List<User> usersList = centralRepo.getUsersList();
		return usersList;
	}
	
	public User getUser(long userId) {
		List<User> usersList = centralRepo.getUsersList();
		int length = usersList.size();
		User user = null;
		
		for(int iterator=0;iterator<length;iterator++) {
			User userItr = usersList.get(iterator);
			if(userItr.getUserId() == userId) {
				user = userItr;
				break;
			}
		}
		return user;
	}
	
	public boolean isValidUser(long mobileNumber, String password) {
		boolean result = false;
		List<User> usersList = centralRepo.getUsersList();
		int length = usersList.size();
		
		for(int iterator=0;iterator<length;iterator++) {
			User user = usersList.get(iterator);
			if(user.getMobileNumber() == mobileNumber && user.getPassword().equals(password)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public long addUser(UserDTO userDto) {
		long userId;
		IdGenerator.generateUserId();
		userId = IdGenerator.getUserId();
		
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userDto.getUserName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setPassword(userDto.getPassword());
		user.setAddress(userDto.getAddress());
		
		List<User> usersList = centralRepo.getUsersList();
		usersList.add(user);
		
		return userId;
	}
}
