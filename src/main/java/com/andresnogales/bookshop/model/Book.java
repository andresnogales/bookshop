package com.andresnogales.bookshop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Column(name = "description", nullable = false, length = 100)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id_author")
	private Author author;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "isbn", unique = true, nullable = false, length = 20)
	private String isbn;
	
	@Column(name = "editorial", nullable = false,  length = 100)
	private String editorial;
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;
	
	@Column(name = "format", nullable = true, length = 10)
	private String format;
	
	@Column(name = "picture", nullable = true, length = 200)
	private String picture;
	
	@Column(name = "create_time", nullable = false)
	private LocalDateTime createTime;
	
	@Column(name = "featured", nullable = true)
	private Boolean featured;
	
	public Book() {
		
	}

	public Book(Long id, String title, String description, Author author, Double price, String isbn, String editorial,
			Category category, String format, String picture, LocalDateTime createTime, Boolean featured) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.editorial = editorial;
		this.category = category;
		this.format = format;
		this.picture = picture;
		this.createTime = createTime;
		this.featured = featured;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	
		
}
