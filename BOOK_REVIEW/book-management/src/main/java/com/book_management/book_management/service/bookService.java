package com.book_management.book_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.book_management.book_management.Classes.Book;
import com.book_management.book_management.Repository.bookRepository;

@Service
public class bookService {
	private bookRepository repo;

	public bookService(bookRepository repo) {
		super();
		this.repo = repo;
	}

	public void createBook(Book book) {
		repo.save(book);
		
	}

	public List<Book> getAllBooks() {
		
		return repo.findAll();
	}

	public Book getBookById(String id) {
		Optional<Book> book = repo.findById(id);
		return book.get();
	}

	public void deleteBook(String id) {
		repo.deleteById(id);
		
	}

	public void updateBook(String id, Book book) {
		repo.deleteById(id);
		book.setId(id);
		repo.save(book);
		
	}
	

}
