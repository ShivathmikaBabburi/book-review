package com.book_management.book_management.controller;




import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book_management.book_management.Classes.Review;
import com.book_management.book_management.Classes.ReviewWithBookDTO;
import com.book_management.book_management.Classes.ReviewWithUserDTO;
import com.book_management.book_management.service.reviewService;
@CrossOrigin("http://localhost:3000")
@RestController
public class reviewController {
	private reviewService service;

	public reviewController(reviewService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/review")
	public void addreview(@RequestBody Review review)
	{
		
	    
		service.addReview(review);}
		
	@GetMapping("/reviews")
	public List<Review> getallReviews(){
		return service.getAllReviews();
		
	}
	@GetMapping("/reviews/{id}")
	public Review getReviewById(@PathVariable String id)
	{
		return service.getReviewById(id);
	
}
	@GetMapping("/reviews/users/{id}")
	public List<ReviewWithBookDTO> getReviewsByUserId(@PathVariable String id){
		return service.getReviewsWithBooksByUserId(id);
	}
	 @GetMapping("/reviews/books/{id}")
	    public List<ReviewWithUserDTO> getReviewsWithUsersByBookId(@PathVariable String id) {
	        return service.getReviewsWithUsersByBookId(id);
	    }
	@DeleteMapping("/reviews/{id}")
	public void deleteReview(@PathVariable String id)
	{
		service.deleteReview(id);
	}
	@PatchMapping("/reviews/{id}")
	public void updateReview(@PathVariable String id,@RequestBody Review review)
	{
		service.updateReview(id,review);
	}

}
