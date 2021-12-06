package com.andresnogales.bookshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andresnogales.bookshop.model.Author;

public interface IAuthorRepository extends CrudRepository<Author, Integer> {

	public Author findById(int id);
	public List<Author> findAll();
}
