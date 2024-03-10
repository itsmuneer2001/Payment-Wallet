package com.jsp.PWApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.jsp.PWApp.dto.User;
import com.jsp.PWApp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repository;

	public User save(User user) {
		return repository.save(user);
	}

	public User update(User user) {
		Optional<User> op = repository.findById(user.getId());
		if (op.get() != null) {
			return repository.save(user);
		}
		return null;
	}

	public User getBtId(int id) {
		Optional<User> op = repository.findById(id);
		return op.get();
	}

	public List<User> getAllUser() {
		return repository.findAll();
	}

	public User delete(int id) {
		Optional<User> op = repository.findById(id);
		if (op.get() != null) {
			repository.delete(op.get());
		}
		return op.get();
	}
	public User getEmailById(String email) {
		return repository.findByLogin(email);
	}


}
