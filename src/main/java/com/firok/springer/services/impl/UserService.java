package com.firok.springer.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firok.springer.dao.IBaseDao;
import com.firok.springer.dao.IUserDao;
import com.firok.springer.entities.User;
import com.firok.springer.services.IUserService;

@Service
public class UserService extends BaseService<User, Long> implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	protected IBaseDao<User, Long> getDao() {
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
