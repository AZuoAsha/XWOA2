<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="oa.action.*"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="oa.common.*"%>
<%@ page language="java" import="oa.domain.Employee"%>
<%@ page language="java" import="oa.service.*"%>
<%@ page language="java" import="oa.service.impl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<%
Employee employee=(Employee)(session.getAttribute("employee"));
List<Employee> userList=(List<Employee>)(session.getAttribute("EmployeeAll"));
%>
<%
    	for(Employee u:userList){
    %>
<style type="text/css">
	.body{
	background:url(img/beijing/mainuser.jpg);
	background-size:100% 135%;
	}
	.container{
	position:relative;
	}
	.userhead1{
	width:150px;
	height:150px;
	border:1px solid darkgray;
	border-radius:50%;
	
	background-size:100% 100%;"
	padding:2% auto auto 6%;
	margin:2% auto 2% 23%;
	}
	.userInfo{
	border:1px solid darkgray;
	width:20%;
	height:25%;
	margin:2% auto 2% 40%;
	border-radius:8px;
	display:block;
	background:url(img/beijing/user_1.jpg);
	background-size:100% 100%;
	}
	.user1{
	padding-left:30%;
	}
	.user2{
	padding-left: 3%;
	padding-right: 3%;
	}
</style>
</head>
<body class="body">
<div class="container">

<div class="userInfo">
 <div class="userhead1" style="background-image:url(<%=u.getUserhead() %>)"></div>
<div class="user1">用户名:<%=u.getLoginName() %></div><br>
<div class="user1">姓名:<%=u.getFullName()%></div><br>
<div class="user2"  align="center">个性签名:<br><%=u.getDescription()%></div><br>
<div class="user2"  align="center">个人简介:<br><%=u.getRole()%></div><br>
</div>
    <%}
    %>
<div align="center" style="margin-bottom:3%;">
 <a href="upload.jsp" style="color:#FF3;font-size:24px;">返回</a>  </div>
 </div>
  
    
</body>
</html>