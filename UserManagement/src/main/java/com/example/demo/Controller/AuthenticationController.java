package com.example.demo.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("auth/v1")
public class AuthenticationController 
{
	private Map<String, String> mapObj = new HashMap<String, String>();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		if(userService.addUser(user)!=null)
	{
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
		return new ResponseEntity<String>("user registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//method to generate token inside login API
	public String generateToken(String username, String password) throws ServletException, Exception
	{
		String jwtToken;
		if(username ==null || password ==null)
		{
			throw new ServletException("Please enter valid credentials");
		}
		
		boolean flag = userService.loginUser(username, password);
		
		if(!flag)
		{
			throw new ServletException("Invalid credentials");
		}
		
		else
		{
			jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
						.setExpiration(new Date(System.currentTimeMillis()+3000000))
						.signWith(SignatureAlgorithm.HS256, "secret key").compact();
						
		}
		
		return jwtToken;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logiUser(@RequestBody User user)
	{
		try
		{
			String jwtToken = generateToken(user.getUsername(), user.getPassword());
			mapObj.put("Message", "User successfully logged in");
			mapObj.put("Token:", jwtToken);
			
		}
		catch(Exception e)
		{
			mapObj.put("Message", "User not logged in");
			mapObj.put("Token:", null);
			return new ResponseEntity<>(mapObj, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(mapObj, HttpStatus.OK);
	}
	
	@PutMapping({"/forgetPassword/{userId}"})
	  public ResponseEntity<?> passwordReset(@PathVariable("userId") int userId, @RequestBody User user) {
	    Object passwordReset = this.userService.passwordReset(userId, user);
	    User user2 = this.userRepository.findById(userId).get();
	    if (passwordReset != null && user2.getAnswer().equals(user.getAnswer()) && user.getPassword().equals(user.getConfirmPassword())) {
	      String msg = String.format("Password Reset Successfully, Your current password : %s %n Use This Password for Login", new Object[] { user.getPassword() });
	      return new ResponseEntity(msg,HttpStatus.CREATED);
	    } 
	    if (passwordReset != null && user2.getAnswer() != user.getAnswer()) {
	      String msg = String.format("Password Reset Failed,Your answer does not match with database data %n Please Enter Correct Answer", new Object[0]);
	      return new ResponseEntity(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	    } 
	    return new ResponseEntity("No User Found with userId :" + userId,HttpStatus.NO_CONTENT);
	  }

}

