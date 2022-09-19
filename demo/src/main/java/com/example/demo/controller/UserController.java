package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
@RequiredArgsConstructor
@Controller
public class UserController {
	
	@Autowired
	private final UserRepository userRepository;
	
	
	
	@GetMapping("/auth/user")
	public ResponseEntity<List<User>> getUserList(@RequestParam(required = false) Long id){
		try {
			List<User> userList = userRepository.findAll();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/auth/user/detail/{username}")
	public ResponseEntity<User> getUserbyUsername(@PathVariable("username") String username){
		try {
			Optional<User> userData = userRepository.findByUsername(username);
			User user = userData.get();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
