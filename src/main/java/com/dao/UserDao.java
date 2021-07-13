package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {
	public int InsertUser(User user);
	public User selectUser(int id);
	public List<User> allUsers();
	public int updateUser(User user);
	public int deleteUser(int id);
}