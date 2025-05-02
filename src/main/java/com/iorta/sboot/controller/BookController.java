package com.iorta.sboot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@GetMapping
	public String getBooks(@RequestParam(required = false) String author) {
		if (author != null) {
			return "Fetching books written by author: " + author;
		}
		return "Fetching all books";
	}
	
	@GetMapping("/{id}")
	public String getBooksById(@PathVariable int id) {
		return "Fetching book with ID: " + id;
	}
	
	@PostMapping()
	public String addBooks(@RequestBody Book book) {
		return "Added Book with Title - " + book.getTitle() + ", Author - " + book.getAuthor();
	}
	
	@PutMapping("/{id}")
	public String updateBooks(@PathVariable int id, @RequestBody Book book) {
		return "Book with ID " + id + " updated" + "\nTitle: " + book.getTitle() + ", Author: " + book.getAuthor();
	}
	
	@DeleteMapping("/{id}")
	public String deleteBooks(@PathVariable int id) {
		return "Book with ID " + id + " deleted.";
	}
	

}
