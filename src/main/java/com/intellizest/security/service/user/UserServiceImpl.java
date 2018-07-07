package com.intellizest.security.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellizest.security.data.user.User;
import com.intellizest.security.data.user.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Transactional(readOnly = true)
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
