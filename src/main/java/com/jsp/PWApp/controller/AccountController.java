package com.jsp.PWApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.service.AccountService;

import jakarta.servlet.http.HttpSession;
@RestController
public class AccountController {
	@Autowired
	AccountService service;
	@PostMapping("/accounts")
	public Account saveAccount(@RequestBody Account account,@RequestParam int user_id) {
		return service.saveAccount(account,user_id);
	}
	@PutMapping("/accounts")
	public Account updaAccount(@RequestBody Account account) {
		return service.updaAccount(account);
	}
	@GetMapping("/accounts/{id}")
	public Account getById(int id) {
		return service.getById(id);
	}
	@DeleteMapping("/accounts/{id}")
	public Account delete(@PathVariable int id) {

		return service.delete(id);
	}
	@GetMapping("/accounts")
	public List<Account> getByAll(){
		return service.getByAll();
	}
	@PatchMapping("/accounts/{amt}")
	public Account sendAmount(@PathVariable double amt,HttpSession session) {
		return service.sendAmount(amt, session);
	}
	@PatchMapping("/accounts")
	public Account reciveAmount(@RequestParam double amt,HttpSession session) {
		return service.reciveAmount(amt, session);
	}
	@GetMapping("/accounts/display")
	public Account checkAmount(HttpSession session) {
		return service.displayAmount(session);
	}
}
