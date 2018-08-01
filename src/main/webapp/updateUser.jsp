<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%= basePath%>" target="_self"/>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>用户注册</h1>
<form action="update" method="post" id="user-regist" class="form-horizontal">
	<input type="hidden" name="id" value="${user.id}"/></br>
<table>
	<tr>
		<td>用户名:</td><td><input type="text" name="name" id="name" value="${user.name}" readonly="readonly"/><span id="name1"></span></td>
	</tr>
	<tr>	
		<td>密码:</td><td><input type="password" name="password" value="${user.password}"/></td>
	</tr>
	<tr>	
		<td>年龄:</td><td><input type="text" name="age" value="${user.age}"/></td>
	</tr>
	<tr>	
		<td>性别:</td><td><input name="sex" type="radio"  value="男" checked>男<input name="sex" type="radio"  value="女" checked>女</td>
	</tr>
	<tr>
		<td>日期:</td><td><input type="text" name="hireDate" value="${user.hireDate}"/></td>
	</tr>
	<tr>
	 <td><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>

</body>
</html>