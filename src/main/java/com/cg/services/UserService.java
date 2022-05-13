package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.User;
import com.cg.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	public boolean isUserExist(User user)
	{
		return userRepository.existsById(user.getId());
	}
	
	public String deleteUser(long id)
	{
		userRepository.deleteById(id);
		
		return "deleted";
	}
	
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}
	

}
