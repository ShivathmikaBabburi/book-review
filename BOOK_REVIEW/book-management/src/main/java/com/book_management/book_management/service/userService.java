package com.book_management.book_management.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.book_management.book_management.Classes.Review;
import com.book_management.book_management.Classes.User;
import com.book_management.book_management.Repository.userRepository;


@Service
public class userService {
	private userRepository repo;

	public userService(userRepository repo) {
		super();
		this.repo = repo;
	}
	public void addUser(User user) {
		repo.save(user);
		
	}
	public List<User> getAllUsers() {
		
		return repo.findAll();
	}
	public User getUserById(String id) {
		Optional<User> user = repo.findById(id);
		
		return user.get();
	}
	public void deleteUser(String id) {
		
		
		repo.deleteById(id);
	}
	public void updateUser(String id, User user) {
		repo.deleteById(id);
		user.setId(id);
		repo.save(user);
		
	}
	public User getUserByEmail(String email) {
	    // Use Java stream to find the user by email
	    Optional<User> optionalUser = repo.findAll().stream()
	            .filter(user -> user.getEmail().equals(email))
	            .findFirst();

	    // Return the user if found, otherwise return null
	    return optionalUser.orElse(null);
	}

}
