package com.andresnogales.bookshop.service;

import java.util.List;

import com.andresnogales.bookshop.model.Book;

public interface IBookService {

	Book findById(long id);
	Book saveBook(Book book);
	Book deleteBook(long id);
	List<Book> findAllBooks();
}
