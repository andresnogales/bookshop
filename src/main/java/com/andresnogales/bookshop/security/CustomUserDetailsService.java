package com.andresnogales.bookshop.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.andresnogales.bookshop.model.User;
import com.andresnogales.bookshop.service.IUserService;
import com.andresnogales.bookshop.util.SecurityUtils;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findByUsername(username).
				orElseThrow(() -> new UsernameNotFoundException(username + "  not found"));
		
		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		
		UserPrincipal userPrincipal = new UserPrincipal();
		userPrincipal.setId(user.getId());
		userPrincipal.setUsername(username);
		userPrincipal.setPassword(user.getPassword());
		userPrincipal.setAuthorities(authorities);
		userPrincipal.setUser(user);
		return userPrincipal;
	}

}
