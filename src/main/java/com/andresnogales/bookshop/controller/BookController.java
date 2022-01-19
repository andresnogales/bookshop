package com.andresnogales.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresnogales.bookshop.model.Book;
import com.andresnogales.bookshop.service.IBookService;

@RestController
@RequestMapping("api/book")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@PostMapping
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
		return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyBook(@RequestBody Book book){
		return new ResponseEntity<>(bookService.modifyBook(book),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable("id") Long id){
		return new ResponseEntity<>(bookService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooks(){
		return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping("/search/{title}")
	public ResponseEntity<?> getByTitle(@PathVariable("title") String title){
		return new ResponseEntity<>(bookService.findByTitle(title),HttpStatus.OK);
	}
}
