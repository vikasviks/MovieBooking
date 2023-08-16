package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService {
	  User addUser(User user);
	  
	  boolean loginUser(String username, String password);
	  
	  List<User> getAllUsers();
	  
	  Object passwordReset(int id, User username);

}
