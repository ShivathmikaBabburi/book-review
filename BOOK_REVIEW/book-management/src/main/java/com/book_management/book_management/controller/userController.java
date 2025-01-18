package com.book_management.book_management.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book_management.book_management.Classes.User;
import com.book_management.book_management.service.userService;

@CrossOrigin("http://localhost:3000")
@RestController
public class userController {
	
private userService service;

public userController(userService service) {
	super();
	this.service = service;
}
@PostMapping("/user")
public ResponseEntity<String> createUser(@RequestBody User user)
{
	
			if (service.getUserByEmail(user.getEmail()) != null) {
				// Return a conflict response if user already exists
				return ResponseEntity.status(HttpStatus.CONFLICT).body("User with Email " + user.getEmail() + " already exists.");
			}

			// If the user does not exist, add it
			service.addUser(user);

			// Return a success response
			return ResponseEntity.status(HttpStatus.CREATED).build();
}

@GetMapping("/users")
public List<User> getAllUsers()
{
	return service.getAllUsers();
	
}

@GetMapping("/users/{id}")
public User getUserById(@PathVariable String id) {
	return service.getUserById(id);
	
}
@GetMapping("/users/email/{email}")
public User getUserbyEmail(@PathVariable String email)
{
	return service.getUserByEmail(email);
}
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable String id)
{
	 service.deleteUser(id);
}
@PatchMapping("/users/{id}")
public void updateuser(@PathVariable String id,@RequestBody User user)

{
	service.updateUser(id,user);
}
}
