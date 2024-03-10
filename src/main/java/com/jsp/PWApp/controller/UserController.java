package com.jsp.PWApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jsp.PWApp.dto.User;
import com.jsp.PWApp.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return service.save(user);
	}
	@PutMapping("/users")
	public User upadte(@RequestBody User user) {
		return service.update(user);
	}
	@GetMapping("/userslist")
	public List<User> getByAll(){
		return service.getByAll();
	}

	@GetMapping("/users")
	public User getById(@RequestParam int id) {
		return service.getById(id);
	}

	@DeleteMapping("/users")
	public User dalete(@RequestParam int id) {
		return service.dalete(id);
	}
	@GetMapping("/login")
	public User login(@RequestParam String email,@RequestParam String password ) {
		return service.login(email,password);
	}



}
