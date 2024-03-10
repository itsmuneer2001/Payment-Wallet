package com.jsp.PWApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.PWApp.dto.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select a from User a where email=:email")
//	public User validateUser(@RequestParam String email,@RequestParam String password);
	
	public User findByLogin(String email);
}
