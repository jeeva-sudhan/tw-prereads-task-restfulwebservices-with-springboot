package com.tw.prereadstask.swiggycartsystem.service;

import com.tw.prereadstask.swiggycartsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tw.prereadstask.swiggycartsystem.model.User;

@Service
public class UserService {


  @Autowired
  private UserRepository userRepository;

	public List<User> getAllUser() {
    Iterable<User> users = userRepository.findAll();
    List<User> usersList = new ArrayList<>();
    for(User user : users) {
      usersList.add(user);
    }
    return usersList;
	}

	public User getUser(long userId) throws Exception {
		User user = userRepository.findById(userId).orElseThrow(() -> {
      return new Exception("user not found");
    });
    return user;
	}

	public boolean isValidUser(String mobileNumber) {
    Optional<User> user = userRepository.findUserByMobileNumber(mobileNumber);
    return user.isPresent();
	}

	public long addUser(User user) {
    user = userRepository.save(user);
		return user.getId();
	}
}
