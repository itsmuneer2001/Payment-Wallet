package com.jsp.PWApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.repository.AccountRepository;

@Repository
public class AccountDao {
	@Autowired
	AccountRepository repository;
	public Account saveAccount(Account account) {
		return repository.save(account);
	}
	public Account updaAccount(Account account) {
		Optional< Account> optional=repository.findById(account.getId());
		if(optional.isPresent()) {
			return repository.save(account);
		}
		return optional.get();
	}
	public Account getById(int id) {
		Optional< Account> optional=repository.findById(id);
		return optional.get();
	}
	public List<Account> getByAll(){
		return repository.findAll();
	}
	public Account delete(int id) {
		Optional<Account> optional= repository.findById(id);
		if(optional.isPresent()) {
			 repository.delete(optional.get());
		}
		return optional.get();
	}
}
