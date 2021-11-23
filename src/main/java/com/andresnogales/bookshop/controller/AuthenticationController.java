package com.andresnogales.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresnogales.bookshop.model.User;
import com.andresnogales.bookshop.service.IAuthenticationService;
import com.andresnogales.bookshop.service.IUserService;

@RestController
@RequestMapping("/api/authentication/")
public class AuthenticationController {
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user){
		return null;
	}
	
}
