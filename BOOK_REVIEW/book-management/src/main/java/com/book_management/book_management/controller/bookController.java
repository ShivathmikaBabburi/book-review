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

import com.book_management.book_management.Classes.Book;
import com.book_management.book_management.service.bookService;
@CrossOrigin("http://localhost:3000")
@RestController
public class bookController {
	private bookService service;

	public bookController(bookService service) {
		super();
		this.service = service;
	}
	@PostMapping("/book")
	public void addBook(@RequestBody Book book)
	{
		service.createBook(book);
	}
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return service.getAllBooks();
	}
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable String id)
	{
		return service.getBookById(id);
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable String id)
	{
		service.deleteBook(id);
	}
	@PatchMapping("/books/{id}")
	public void updateBook(@PathVariable String id,@RequestBody Book book)
	{
		service.updateBook(id,book);
	}
	

}
