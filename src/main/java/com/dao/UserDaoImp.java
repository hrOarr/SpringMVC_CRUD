package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int InsertUser(User user) {
		String sql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
		Object[] args = {user.getName(), user.getEmail(), user.getCountry()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public User selectUser(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		Object[] args = {id};
		return jdbcTemplate.queryForObject(sql, new UserMapper(), args);
	}

	@Override
	public List<User> allUsers() {
		String sql = "SELECT * FROM users";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	@Override
	public int updateUser(User user) {
		String sql = "UPDATE users SET name=?, email=?, country=? WHERE id=?";
		Object[] args = {user.getName(), user.getEmail(), user.getCountry(), user.getId()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		Object[] args = {id};
		return jdbcTemplate.update(sql, args);
	}

}
