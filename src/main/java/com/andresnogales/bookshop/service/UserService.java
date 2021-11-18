package com.andresnogales.bookshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andresnogales.bookshop.model.Role;
import com.andresnogales.bookshop.model.User;
import com.andresnogales.bookshop.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setCreateTime(LocalDateTime.now());	
		
		return userRepository.save(user);	
	}

	@Override
	public Optional<User> findUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public void makeAdmin(String username) {
		userRepository.updateUserRole(username, Role.ADMIN);		
	}

}
