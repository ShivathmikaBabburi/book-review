package com.book_management.book_management.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book_management.book_management.Classes.User;

import java.util.Optional;

@Repository
public interface userRepository extends MongoRepository<User, String>{

    Optional<User> findByName(String username);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
}
