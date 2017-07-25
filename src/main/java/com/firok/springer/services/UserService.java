package com.firok.springer.services;

import com.firok.springer.entity.User;

public interface UserService extends BaseService<User, Long> {

	boolean addUser(User user);
}
