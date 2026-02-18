package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.User;
import com.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	//Register
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	
	//Login
	@PostMapping("/login")
	public String login(@RequestBody User user) {  
		User existingUser = userRepository.findByEmail(user.getEmail());
		
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
	       return "Login Successful";
		}
		return "Invalid Email or Password!";
	}
		
}
