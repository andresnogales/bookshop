package com.andresnogales.bookshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.andresnogales.bookshop.model.Book;


public interface IBookRepository extends CrudRepository<Book, Long> {
	public Book findById(long id);
	public List<Book> findAll();
	
	@Query("select b from Book b where b.title LIKE %:bookTitle%")
	List<Book> findByTitle(@Param ("bookTitle") String bookTitle);
}
