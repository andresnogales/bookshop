package com.andresnogales.bookshop.service;

import java.util.List;

import com.andresnogales.bookshop.model.Book;

public interface IBookService {

	Book saveBook(Book book);
	void deleteBook(Long id);
	List<Book> findAllBooks();
}
