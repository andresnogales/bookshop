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

import com.andresnogales.bookshop.model.Author;
import com.andresnogales.bookshop.service.AuthorService;

@RestController
@RequestMapping("api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<?> saveAuthor(@RequestBody Author author){
		return new ResponseEntity<>(authorService.saveAuthor(author),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") Integer id){
		return new ResponseEntity<>(authorService.deleteAuthor(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modifyAuthor(@RequestBody Author author){
		return new ResponseEntity<>(authorService.modifyAuthor(author),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAuthor(@PathVariable("id") Integer id){
		return new ResponseEntity<>(authorService.findById(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAuthors(){
		return new ResponseEntity<>(authorService.findAll(),HttpStatus.OK);
	}

}
