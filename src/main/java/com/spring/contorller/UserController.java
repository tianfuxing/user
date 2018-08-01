package com.spring.contorller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.User;
import com.spring.service.UserService;

import util.DateUtil;
import util.MD5Util;

@Controller
public class UserController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/regist")
	public String regist(User u) {
		u.setHireDate(DateUtil.change(new Date()));
		u.setUpdateDate(DateUtil.change(new Date()));
		u.setPassword(MD5Util.getMD5Encoding(u.getPassword()));
		userService.add(u);
		return "login";
	}
	@RequestMapping(value="/login")
	public ModelAndView login(String name,String password,HttpServletRequest request) {
		User u = userService.login(name,MD5Util.getMD5Encoding(password));
		if(u==null) {
			return new ModelAndView("login","login_error","用户名或密码错误");
		}
		request.getSession().setAttribute("online_user",u);
		return new ModelAndView("redirect:list");
	}
	
	@RequestMapping(value="/list")
	public ModelAndView list(String datemin,String datemax,String sex,String userMess) {
		java.sql.Date datemin1=DateUtil.change(DateUtil.toDate(datemin));
		java.sql.Date datemax1=DateUtil.change(DateUtil.toDate(datemax));
		List<User> users = userService.selectAll(datemin1,datemax1,sex,userMess);
		System.out.println(datemin1+","+datemax1+","+userMess);
		return new ModelAndView("list","user_list",users);
	}
	@RequestMapping(value="/checkName",produces = "application/json")
	@ResponseBody
	public boolean  checkName(String name,HttpServletResponse response) {
		boolean bo = userService.getUserName(name);
		if(bo) {
			return true;
		}else {
			
			return false;
		}
	}
	@RequestMapping(value="/userId")
	public ModelAndView userId(int id) {
		User user = userService.getUserById(id);
		return new ModelAndView("updateUser","user",user);
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(User user) {
		user.setUpdateDate(DateUtil.change(new Date()));
		user.setPassword(MD5Util.getMD5Encoding(user.getPassword()));
		userService.update(user);
		return new ModelAndView("redirect:list");
	}
	@RequestMapping(value="/deleteUser")
	public ModelAndView deleteUser(int id) {
		System.out.println(id);
		userService.deleteUser(id);
		return new ModelAndView("redirect:list");
	}
}
