<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="oa.action.*"%>
<%@ page language="java" import="oa.common.*"%>
<%@ page language="java" import="oa.domain.Employee"%>
<%@ page language="java" import="oa.service.*"%>
<%@ page language="java" import="oa.service.impl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理工勤学网</title>
<%
Employee employee=(Employee)(session.getAttribute("employee"));
%>
<style type="text/css">
	.div{
	border:1px solid;
	border-radius:8px;
	width:43%;
	float:left;
	position:absolute;
	padding:3%;
	margin-top:10%;
	margin-left:25%;
	}
	.input{
	font-size:18px;
	color:blue;
	padding:3%;
	margin:3% auto auto auto;
	}
	.input1{
	font-size:18px;
	color:blue;
	padding:3%;
	margin:3% auto auto 25%;
	}
</style>
</head>
<body>
<div class="div">
<form action="ModefyNickNameServlet" method="post">
	填写昵称:<input type="text" name="loginName" value="<%= employee.getLoginName() %>" required class="input"/><br>
	<input type="submit" value="修改" class="input1"/>
</form><br>
<a href="upload.jsp">返回</a>
</div>
</body>
</html>