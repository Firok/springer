package com.firok.springer.services;

import com.firok.springer.entities.User;

public interface IUserService extends IBaseService<User, Long> {

	boolean addUser(User user);
}
