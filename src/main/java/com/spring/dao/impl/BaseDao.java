package com.spring.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {
	protected SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	@Resource
	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
}
