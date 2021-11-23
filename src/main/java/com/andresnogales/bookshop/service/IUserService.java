package com.andresnogales.bookshop.service;

import java.util.Optional;

import com.andresnogales.bookshop.model.User;

public interface IUserService {
	
	User saveUser(User user);
	Optional<User> findByUsername(String username);
	void makeAdmin(String username);
	
}
