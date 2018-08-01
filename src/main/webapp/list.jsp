<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<link rel="stylesheet" type="text/css"  href="js/calendar/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
<script type="text/javascript" src="js/calendar/calendar-en.js"></script>
<script type="text/javascript" src="js/calendar/calendar-setup.js"></script>
<script type="text/javascript" src="js/calendar/calendar-zh.js"></script>
<script type="text/javascript" src="js/calendar/calendar.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>用户列表</h1>
<form action="list" method="post" class="form-inline">
	开始日期:<input class="input-text"  type="date" name="datemin" />
	结束日期:<input class="input-text"  type="date" name="datemax" >
	性别:<select size="1" name="sex">
		<option value="" selected>请选择性别</option>
		<option>男</option>
		<option>女</option>
	</select>
	用户模糊查询:<input type="text"  placeholder="输入用户名"  name="userMess" >
	<input type="submit" value="搜索"> <input type="button" onclick="window.location.href='login.jsp'" value="重新登陆">
	<input type="button" onclick="window.location.href='regist.jsp'" value="添加用户">
</form>
<table class="table table-bordered">
	<tr>
		<td>编号</td>
		<td>用户名</td>
		<td>性别</td>
		<td>年龄</td>
		<td>入职日期</td>
		<td>操作</td>
	</tr>
	<c:forEach var="u" items="${user_list }">
		<tr id="${u.id}">
		<td>${u.id}</td>
		<td>${u.name}</td>
		<td>${u.sex}</td>
		<td>${u.age}</td>
		<td>${u.hireDate}</td>
		<td><a class="dele" id="${u.id}">删除</a><a href="userId?id=${u.id}"> 修改</a></td>
	<!--<a href="deleteUser?user.id=${u.id}" name="dele">删除</a>  -->
	</tr>
	</c:forEach>
</table>
<script type="text/javascript">
	$(function(){
		$(".dele").click(function(){
			var v = confirm("确定删除吗？");
			var value =$(this).prop("id");			
			if(v){
				$.post("deleteUser",{id:value},function(data){
					var tr = document.getElementById(value);
					tr.parentNode.removeChild(tr);  
				});
			}	
		})	
	})
	
</script>
</body>
</html>