package com.andresnogales.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.andresnogales.bookshop.model.User;
import com.andresnogales.bookshop.security.UserPrincipal;
import com.andresnogales.bookshop.security.jwt.IJwtProvider;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private IJwtProvider jwtProvider;
	
	@Override
	public User signInAndReturnJWT(User signRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signRequest.getUsername(), signRequest.getPassword()));
		
		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String jwt = jwtProvider.generateToken(userPrincipal);
		
		User signInUser = userPrincipal.getUser();
		signInUser.setToken(jwt);
		
		return signInUser;
	}	
}
