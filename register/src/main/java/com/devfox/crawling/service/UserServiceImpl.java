package com.devfox.crawling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devfox.crawling.dao.UserDAO;
import com.devfox.crawling.logic.Members;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public Members getUserOne(String common,String col) {
		return userDAO.getUserOne(common,col);
	}

	@Override
	public int userJoin(Members members) {
		return userDAO.userJoin(members);
	}
	
}