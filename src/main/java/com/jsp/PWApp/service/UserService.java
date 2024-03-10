package com.jsp.PWApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PWApp.dao.UserDao;

import com.jsp.PWApp.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	public User save(User user) {
		return dao.save(user);
	}
	public User update(User user) {
		return dao.update(user);
	}
	public User getById(int id) {
		return dao.getBtId(id);
	}
	public List<User> getByAll(){
		return dao.getAllUser();
	}
	public User dalete(int id) {
		return dao.delete(id);
	}
	public User login(String email,String password) {
		User user=dao.getEmailById(email);
		if(user!=null) {
			return dao.getEmailById(email);
		}
		return null;
		
	}

}
