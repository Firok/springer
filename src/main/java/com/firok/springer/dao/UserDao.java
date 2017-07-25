package com.firok.springer.dao;

import com.firok.springer.entity.User;

public interface UserDao extends BaseDao<User, Long> {

	boolean userExists(String username, String email);
}
