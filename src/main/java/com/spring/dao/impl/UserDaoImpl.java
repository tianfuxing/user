package com.spring.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.spring.beans.User;
import com.spring.dao.UserDao;
@Component
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public void add(User u) {
		template.insert("com.spring.mapper.UserMapper.add",u);
	}

	@Override
	public User login(String name, String password) {
		Map<String,Object> map = new HashMap<>();
		map.put("name",name);
		map.put("password",password);
		User user = template.selectOne("com.spring.mapper.UserMapper.login",map);
		return user;
	}

	@Override
	public List<User> selectAll(java.sql.Date datemin,java.sql.Date datemax,String sex,String userMess) {
		Map<String,Object> map = new HashMap<>();
		map.put("datemin",datemin);
		map.put("datemax",datemax);
		if(userMess==null || userMess.equals("")) {
			map.put("userMess",userMess);
		}else {
			map.put("userMess","%"+userMess+"%");
		}
		map.put("sex",sex);
		List<User> users = template.selectList("com.spring.mapper.UserMapper.selectAll",map);
		return users;
	}

	@Override
	public boolean getUserName(String name) {
		Map<String,Object> map = new HashMap<>();
		map.put("name",name);
		User user = template.selectOne("com.spring.mapper.UserMapper.getUserName",map);
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public User getUserById(int id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		User user = template.selectOne("com.spring.mapper.UserMapper.getUserById",map);
		return user;
	}

	@Override
	public void update(User user) {
		System.out.println(user.getId());
		template.update("com.spring.mapper.UserMapper.update",user);
	}

	@Override
	public void deleteUser(int id) {
		System.out.println(id);
		template.delete("com.spring.mapper.UserMapper.deleteUser", id);
	}
}
