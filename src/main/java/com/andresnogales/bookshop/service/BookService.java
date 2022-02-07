package com.andresnogales.bookshop.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresnogales.bookshop.model.Book;
import com.andresnogales.bookshop.repository.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		book.setCreateTime(LocalDateTime.now());
		return bookRepository.save(book);
	}

	@Override
	public Book deleteBook(long id) {
		Book book = findById(id);
		bookRepository.deleteById(id);
		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {		
		Book book = bookRepository.findById(id);
		if (book == null) {
			throw new RuntimeException("Book not found");
		}
		return book;
	}

	@Override
	public Book modifyBook(Book book) {
		Book bookDB = findById(book.getId());
		bookDB.setTitle(book.getTitle());
		bookDB.setDescription(book.getDescription());
		bookDB.setAuthor(book.getAuthor());
		bookDB.setPrice(book.getPrice());
		bookDB.setIsbn(book.getIsbn());
		bookDB.setEditorial(book.getEditorial());
		bookDB.setCategory(book.getCategory());
		bookDB.setFormat(book.getFormat());
		bookDB.setPicture(book.getPicture());
		bookRepository.save(bookDB);
		return bookDB;
	}

	@Override
	public List<Book> findByTitle(String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}

	@Override
	public List<Book> findAllByOrderByCreateTimeDesc() {
		return bookRepository.findAllByOrderByCreateTimeDesc();
	}
	
}
