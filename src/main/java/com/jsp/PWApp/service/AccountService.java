package com.jsp.PWApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PWApp.dao.AccountDao;
import com.jsp.PWApp.dao.UserDao;
import com.jsp.PWApp.dto.Account;
import com.jsp.PWApp.dto.User;

import jakarta.servlet.http.HttpSession;

@Service
public class AccountService {
	@Autowired
	AccountDao dao;
	@Autowired
	UserDao userDao;

	public Account saveAccount(Account account,int user_id) {
		
		User user=userDao.getBtId(user_id);
		account.setUser(user);
		return dao.saveAccount(account);
		
//		if (account != null & user_id) { 
//			User user = (User) session.getAttribute("user");
//			account.setUser(user);
//			account.setAmount(account.getInitialAmount());
//			Account account2 = dao.saveAccount(account);
//			if (account2 != null) {
//				session.setAttribute("account", account2);
//				return account2;
//			}
//		}
//		return null;
		 
	}

	public Account updaAccount(Account account) {
		return dao.updaAccount(account);
	}

	public Account getById(int id) {
		return dao.getById(id);
	}

	public Account delete(int id) {

		return dao.delete(id);
	}

	public List<Account> getByAll() {
		return dao.getByAll();
	}

	public Account sendAmount(double amt, HttpSession session) {
		if (amt > 0) {
			Account account = (Account) session.getAttribute("account");
			if (account != null) {

				double res = account.getAmount() - amt;
				if (res > amt) {
					account.setAmount(res);
					return dao.updaAccount(account);
				}
			}
		}
		return null;

	}

	public Account reciveAmount(double amt, HttpSession session) {
		if (amt > 0) {
			Account account = (Account) session.getAttribute("account");
			if (account != null) {
				double res = account.getAmount() + amt;
				account.setAmount(res);
				return dao.updaAccount(account);
			}
		}
		return null;

	}

	public Account displayAmount(HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		if (account != null) {
			return dao.getById(account.getId());
		}
		return null;
	}

}
