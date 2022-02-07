package com.andresnogales.bookshop.service;

import java.util.List;

import com.andresnogales.bookshop.model.Book;

public interface IBookService {

	Book findById(long id);
	Book saveBook(Book book);
	Book deleteBook(long id);
	Book modifyBook(Book book);
	List<Book> findAllBooks();
	List<Book> findByTitle(String bookTitle);
	List <Book> findAllByOrderByCreateTimeDesc();
}
