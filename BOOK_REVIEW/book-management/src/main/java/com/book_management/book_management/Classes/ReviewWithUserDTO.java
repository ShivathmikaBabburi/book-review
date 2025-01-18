package com.book_management.book_management.Classes;
public class ReviewWithUserDTO {
    private Review review;
    private User user;

    // Constructors, getters, and setters
    public ReviewWithUserDTO(Review review, User user) {
        this.review = review;
        this.user = user;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
