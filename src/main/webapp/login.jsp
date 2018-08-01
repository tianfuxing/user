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
<script type="text/javascript">
$(function(){
	$("#name").blur(function(){
		var $name= $("#name").val();
		if($name!=null){
			$.ajax({
				type: "post",
				url: "checkName",
				data: "name="+$name,
				dataType:'json',
				success: function(msg){
					if(msg){
						$("#name1").html("<font color='green'>用户名正确</font>");	
					}else{
						$("#name1").html("<font color='red'>用户名不存在</font>");	
					}
				}
			})
		}else{
			$("#name1").html("<font color='red'>用户名不能为空</font>");	
		}
	})
});
</script>
</head>
<body>

<h1>用户登录</h1>
<form action="login" method="post" class="form-horizontal">
	<table>
		<tr>
			<td>用户名:</td><td><input type="text" id="name" name="name"/><span id="name1"></span></td>
		</tr>
		<tr>
			<td>密码:</td><td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td><input type = "submit"  value="登录"/></td><td><input type="button"  onclick="window.location.href='regist.jsp'" value="注册"/></td>
		</tr>
		
	</table>
</form>
<h3 style="color:red;">${fieldErrors.error[0] }</h3>
</body>
</html>