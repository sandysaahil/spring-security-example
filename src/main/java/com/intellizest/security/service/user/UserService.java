package com.intellizest.security.service.user;

import java.util.List;

import com.intellizest.security.data.user.User;

public interface UserService {
	
	void save(User user);
	List<User> list();
	User findByUsername(String username);
}
