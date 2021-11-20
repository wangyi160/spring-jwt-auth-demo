package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("javainuse".equals(username)) {
			UserDetails user1 = User
					.withUsername("javainuse")
					.authorities("ROLE_USER")
					.passwordEncoder(passwordEncoder::encode)
					.password("password")
					.build();
			
			return user1;
			
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
		}
		else if ("javaadmin".equals(username)) {
			UserDetails user1 = User
					.withUsername("javaadmin")
					.authorities("ROLE_USER", "ROLE_ADMIN")
					.passwordEncoder(passwordEncoder::encode)
					.password("password")
					.build();
			
			return user1;
			
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
		}
		else {
			System.out.println(username);
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		
	}
}
