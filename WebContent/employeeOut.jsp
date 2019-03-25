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
</head>
<body>
<% 
session.removeAttribute("employee");
response.sendRedirect("login_bg.html");
 %> 
</body>
</html>