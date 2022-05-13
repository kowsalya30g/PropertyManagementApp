package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.User;
import com.cg.services.UserService;

@RestController
public class SecurityController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup/addUser")
	public ResponseEntity<Object>  addUser(@RequestBody User user)
	{
		if(!userService.isUserExist(user))
		    return new ResponseEntity<Object>(userService.addUser(user).getName()+"  : " + "Registered", HttpStatus.OK) ;
		else
			return  new ResponseEntity<Object>( "you have already registered",HttpStatus.OK);
		
	}
	
	@PostMapping("/signin")
	public Object checkUser(@RequestBody User user)
	{
		if(userService.isUserExist(user))
		    return "You Can Access PMS";
		
		return "Not Registered Yet in PMS";
		
	}
	

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") long id)
	{
		 return userService.deleteUser(id);
		
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}



	
}
