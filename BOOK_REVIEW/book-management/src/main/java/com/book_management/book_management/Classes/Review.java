package com.book_management.book_management.Classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Review")
public class Review {
	@Id
	private String id;
	private String bookId;
	private String userId;
	private String review;
	public Review(String id, String bookId, String userId, String review) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.userId = userId;
		this.review = review;
	}
	
	public Review() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", bookId=" + bookId + ", userId=" + userId + ", review=" + review + "]";
	} 
	
	

}
