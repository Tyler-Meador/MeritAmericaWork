package com.meritamerica.pair7.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meritamerica.pair7.model.Users;
import com.meritamerica.pair7.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsersRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println(" 2222  ");
		Users user = repo.findByUsername(username);
		
		System.out.println(user.getUsername() + " 1111  " + user.getPassword());
		
		if(user != null) {
			
			String userLevel = user.getRole();
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority(userLevel));
			
			System.out.println(user.getUsername() + " " + user.getPassword());
			User a = new User(username, user.getPassword(), authorities);
			
			return a;
		}
		
		return null;
		
		
	}	
}
