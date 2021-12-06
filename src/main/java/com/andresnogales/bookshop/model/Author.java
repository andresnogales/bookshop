package com.andresnogales.bookshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "full_name", nullable = false, length = 100)
	private String fullName;
	
	@Column(name="biography")
	private String biography;
	
	@Column(name = "picture", nullable = true, length = 200)
	private String picture;
	
	public Author() {
	}

	public Author(Integer id, String fullName, String biography, String picture) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.biography = biography;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
