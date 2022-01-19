package com.andresnogales.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresnogales.bookshop.model.Author;
import com.andresnogales.bookshop.repository.IAuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private IAuthorRepository authorRepository;
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public Author findById(int id) {
		Author author = authorRepository.findById(id);
		if (author == null) {
			throw new RuntimeException("Author not found");
		}
		return author;
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}

	public Author modifyAuthor(Author author) {
		Author authorDb = findById(author.getId());
		authorDb.setFullName(author.getFullName());
		authorDb.setBiography(author.getBiography());
		authorDb.setPicture(author.getPicture());
		authorRepository.save(authorDb);
		return authorDb;
	}

	public Author deleteAuthor(Integer id) {
		Author author = findById(id);
		authorRepository.deleteById(id);
		return author;
	}

}
