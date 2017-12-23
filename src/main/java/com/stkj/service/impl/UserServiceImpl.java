package com.stkj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stkj.dao.UserDAO;
import com.stkj.model.User;
import com.stkj.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}

}
