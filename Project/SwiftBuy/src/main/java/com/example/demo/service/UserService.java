package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public Users registerUSer(Users user) {
		if(userRepository.findByUsername(user.getUsername()).isPresent()) 
		{
			throw new RuntimeException("Username is already taken");
		}
		
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Emailis already registered");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	   return userRepository.save(user);
	}
}
