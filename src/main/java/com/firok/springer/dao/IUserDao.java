package com.firok.springer.dao;

import com.firok.springer.entities.User;

public interface IUserDao extends IBaseDao<User, Long> {

	boolean userExists(String username, String email);
}
