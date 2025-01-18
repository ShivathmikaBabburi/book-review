package com.book_management.book_management.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book_management.book_management.Classes.Book;

@Repository
public interface bookRepository extends MongoRepository<Book, String>{

}
