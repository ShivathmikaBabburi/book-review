package com.book_management.book_management.Classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Books")
public class Book {
@Id
private String id;
private String author;
private String name;
public Book(String id, String author, String name) {
	super();
	this.id = id;
	this.author = author;
	this.name = name;
}
public Book() {
	super();
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Book [id=" + id + ", author=" + author + ", name=" + name + "]";
}


}
