package com.spring.service;

import java.util.Date;
import java.util.List;

import com.spring.beans.User;


public interface UserService {
	public void add(User user);

	public User login(String name, String password);

	public List<User> selectAll(java.sql.Date datemin, java.sql.Date datemax, String sex, String userMess);
	
	public boolean getUserName(String name);

	public User getUserById(int id);

	public void update(User user);

	public void deleteUser(int id);
}
