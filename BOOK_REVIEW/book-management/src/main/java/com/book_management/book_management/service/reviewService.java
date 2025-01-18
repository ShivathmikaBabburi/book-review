package com.book_management.book_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_management.book_management.Classes.Book;
import com.book_management.book_management.Classes.Review;
import com.book_management.book_management.Classes.ReviewWithBookDTO;
import com.book_management.book_management.Classes.ReviewWithUserDTO;
import com.book_management.book_management.Classes.User;
import com.book_management.book_management.Repository.bookRepository;
import com.book_management.book_management.Repository.reviewRepository;
import com.book_management.book_management.Repository.userRepository;


@Service
public class reviewService {
	@Autowired
	private reviewRepository repo;
	@Autowired
	private userRepository userRepo;
	@Autowired
private bookRepository bookrepo;
	public reviewService(reviewRepository repo) {
		super();
		this.repo = repo;
	}

	public void addReview(Review review) {
		repo.save(review);
		
	}

	public List<Review> getAllReviews() {
		return repo.findAll();
		
	}

	public Review getReviewById(String id) {
		Optional<Review> review = repo.findById(id);
		return review.get();
	}

	public List<Review> getReviewsByUserId(String id) {
		List<Review> reviews = repo.findAll();
		Predicate<? super Review> predicate=review->review.getUserId().equals(id);
		Stream<Review> result = reviews.stream().filter(predicate);
		return result.toList();
	}
	public List<Review> getReviewsByBookId(String id) {
		List<Review> reviews = repo.findAll();
		Predicate<? super Review> predicate=review->review.getBookId().equals(id);
		Stream<Review> result = reviews.stream().filter(predicate);
		return result.toList();
	}

	public void deleteReview(String id) {
		repo.deleteById(id);
		
	}

	public void updateReview(String id, Review review) {
		Optional<Review> res=repo.findById(id);
		Review result=res.get();
		repo.deleteById(id);
		review.setId(id);
		review.setBookId(result.getBookId());
		review.setUserId(result.getUserId());
		repo.save(review);
		
	}
public List<ReviewWithUserDTO> getReviewsWithUsersByBookId(String bookId) {
		  List<Review> reviews = repo.findAll();
			Predicate<? super Review> predicate=review->review.getBookId().equals(bookId);
			
	  
	        List<Review> result = reviews.stream().filter(predicate).toList();
	        List<ReviewWithUserDTO> reviewWithUserDTOs = new ArrayList<>();

	        for (Review review : result) {
	            User user = userRepo.findById(review.getUserId()).orElse(null);
	            reviewWithUserDTOs.add(new ReviewWithUserDTO(review, user));
	        }

	        return reviewWithUserDTOs;
	  }
public List<ReviewWithBookDTO> getReviewsWithBooksByUserId(String userId) {
	  List<Review> reviews = repo.findAll();
		Predicate<? super Review> predicate=review->review.getUserId().equals(userId);
		

      List<Review> result = reviews.stream().filter(predicate).toList();
      List<ReviewWithBookDTO> res = new ArrayList<>();

      for (Review review : result) {
          Book book = bookrepo.findById(review.getBookId()).orElse(null);
          res.add(new ReviewWithBookDTO(review, book));
      }

      return res;
}
	
	
}
	


