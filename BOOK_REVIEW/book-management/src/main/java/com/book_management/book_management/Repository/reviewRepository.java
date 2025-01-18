package com.book_management.book_management.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book_management.book_management.Classes.Review;
@Repository
public interface reviewRepository extends MongoRepository<Review,String> {

}
