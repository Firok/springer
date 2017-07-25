package com.firok.springer.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firok.springer.dao.UserDao;
import com.firok.springer.entity.User;



@Transactional
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean userExists(String username, String email) {

		int count = entityManager.createNamedQuery("user.findByUsernameOrEmail").setParameter("username", username)
				.setParameter("email", email).getResultList().size();
		return count > 0 ? true : false;
	}

}
