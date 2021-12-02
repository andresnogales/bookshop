package com.andresnogales.bookshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.andresnogales.bookshop.model.Role;
import com.andresnogales.bookshop.security.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${authentication.internal-api-key}")
	private String internalApiKey;
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
		.antMatchers("/api/authentication/**").permitAll()
		.antMatchers(HttpMethod.GET,  "/api/book/**").permitAll()
		.antMatchers("/api/internal/**").hasRole(Role.SYSTEM_MANAGER.name())
		.anyRequest().authenticated();
		
		http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(internalAuthenticationFilter(), JwtAuthorizationFilter.class);
	}

	@Override
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean() throws Exception {		
		return super.authenticationManagerBean();
	}
	
	
	@Bean
	public InternalAuthenticationFilter internalAuthenticationFilter() {
		return new InternalAuthenticationFilter(internalApiKey);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public WebMvcConfigurer corsConfiguration(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}			
		};
	}
	
	@Bean
	public JwtAuthorizationFilter jwtAuthorizationFilter() {
		return new JwtAuthorizationFilter();
	}
	
}
