package com.meritamerica.pair7.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meritamerica.pair7.model.Users;

public interface MyUserRepo extends JpaRepository<Users, Integer>{
	Users findByUsername(String username);
}
