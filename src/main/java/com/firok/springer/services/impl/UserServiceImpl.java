package com.firok.springer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.springer.dao.BaseDao;
import com.firok.springer.dao.UserDao;
import com.firok.springer.entity.User;
import com.firok.springer.services.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	protected BaseDao<User, Long> getDao() {
		return userDao;
	}

	@Override
	public synchronized boolean addUser(User user) {
		if(userDao.userExists(user.getUsername(), user.getEmail())){
			return false;
		}
		else {
			userDao.create(user);
			return true;
		}
	}

}
