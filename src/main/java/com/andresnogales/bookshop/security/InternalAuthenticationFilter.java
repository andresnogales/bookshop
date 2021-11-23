package com.andresnogales.bookshop.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.andresnogales.bookshop.util.SecurityUtils;

public class InternalAuthenticationFilter extends OncePerRequestFilter {

	private final String accessKey;	
	
	public InternalAuthenticationFilter(String accessKey) {		
		this.accessKey = accessKey;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);
			if (requestKey == null || !requestKey.equals(accessKey)){
				throw new RuntimeException("Unauthorized");
			}
			
			UserPrincipal userPrincipal = UserPrincipal.createRootUser();
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		catch(Exception e) {
			System.out.println("Error setting user authentication");
		}
		
		filterChain.doFilter(request, response);
	}

	
}
