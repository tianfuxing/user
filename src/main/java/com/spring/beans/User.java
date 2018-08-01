package com.spring.beans;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private String password;
	private int age;
	private String sex;
	private Date hireDate;
	private Date updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String name, int age, String sex, Date hireDate, Date updateDate) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.hireDate = hireDate;
		this.updateDate = updateDate;
	}
	
	public User(String name, String password, int age, String sex, Date hireDate, Date updateDate) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.hireDate = hireDate;
		this.updateDate = updateDate;
	}
	public User() {
		super();
	}
	
}
