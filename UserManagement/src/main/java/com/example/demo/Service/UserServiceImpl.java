package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {
		if(user!=null)
		{
			return userRepo.saveAndFlush(user);
			
		}
		return null;
	}

	@Override
	public boolean loginUser(String username, String password) {
		
		User user1 = userRepo.validateUser(username, password);
		System.out.println("User: "+ user1.getUsername());
		if(user1!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
	
		List<User> userList = userRepo.findAll();
		
		if(userList!=null & userList.size() >0)
		{
			return userList;
		}
		else
			return null;
	}
	
	public Object passwordReset(int userId, User user) {
	    Optional<User> findUser = this.userRepo.findById(userId);
	    if (findUser!=null) {
	      String answer = ((User)findUser.get()).getAnswer();
	      if (user.getAnswer().equals(answer) && user.getPassword().equals(user.getConfirmPassword())) {
	        ((User)findUser.get()).setPassword(user.getPassword());
	        ((User)findUser.get()).setConfirmPassword(user.getConfirmPassword());
	        return this.userRepo.saveAndFlush(findUser.get());
	      } 
	      return "No record found";
	    } 
	    return "No User Found";
	  }
	
}

