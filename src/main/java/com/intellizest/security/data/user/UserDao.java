package com.intellizest.security.data.user;

import java.util.List;

public interface UserDao {
	void save(User user);
	List<User> list();
	User findByUsername(String username);
}
