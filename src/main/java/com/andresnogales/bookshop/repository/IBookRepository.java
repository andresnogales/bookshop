package com.andresnogales.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andresnogales.bookshop.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {
	
}
