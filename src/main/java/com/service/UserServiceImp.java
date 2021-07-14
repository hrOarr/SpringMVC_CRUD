package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImp implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImp(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int InsertUser(User user) {
		return userDao.InsertUser(user);
	}

	@Override
	public User selectUser(int id) {
		return userDao.selectUser(id);
	}

	@Override
	public List<User> allUsers() {
		return userDao.allUsers();
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

}
