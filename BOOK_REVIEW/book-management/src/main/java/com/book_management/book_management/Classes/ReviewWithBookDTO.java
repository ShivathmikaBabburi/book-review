package com.book_management.book_management.Classes;

public class ReviewWithBookDTO {
	private Review review;
	private Book book;
	public ReviewWithBookDTO(Review review, Book book) {
		super();
		this.review = review;
		this.book = book;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}


