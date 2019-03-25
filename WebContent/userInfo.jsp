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
	.body{
	background-image:url(img/beijing/userInfoBeijing.jpg);
	background-size:1100px 765px;
	}
	.div{
	background-image:url(img/beijing/picture2.jpg);
	background-size:900px 895px;
	border:1px solid #ccc;
	margin-top:-300px;
	margin-left:-400px;
	left:50%;top:50%;
	border-radius:8px;
	width:50%;
	float:left;
	position:absolute;
	}
	.div1{
	padding:0px;
	}
	.h2{
	color:blue;
	}
	.p{
	font-size:18px;
	}
	.span{
	font-size:18px;
	color:green;
	border-bottom:2px solid #ccc;
	}
	.span1{
	color:green;
	border-bottom:2px solid #ccc;
	}
	.a{
	 font-size:24px;
	 padding:20px;
	 position:relative;
	 z-index:2;
	}
</style>
</head>
<body class="body">

<div class="div" align="center">

<div class="div1">
<h2 class="h2">欢迎您!<%= employee.getFullName() %><br></h2>
<p class="p"><span class="span"><%= employee.getFullName() %></span>的基本信息：</p>
<p>真实姓名:<span class="span1"><%= employee.getFullName() %></span></p>
<p>用户名:<span class="span1"><%= employee.getLoginName() %></span></p>
<p>性别:<span class="span1"><%= employee.getGender() %></span></p>
<p>电子邮件:<span class="span1"><%= employee.getEmail() %></span></p>
<p>QQ:<span class="span1"><%= employee.getQq() %></span></p>
<p>微信:<span class="span1"><%= employee.getWx() %></span></p>
<p>联系电话:<span class="span1"><%= employee.getPhoneNumber() %></span></p>
<p>家庭住址:<span class="span1"><%= employee.getAddress() %></span></p>
<p>学校:<span class="span1"><%= employee.getSchool() %></span></p>
<p>国籍:<span class="span1"><%= employee.getNation() %></span></p>
<p>婚姻状况:<span class="span1"><%= employee.getIsmarry() %></span></p>
<p>兴趣爱好:<span class="span1"><%= employee.getLanqiu() %><%= employee.getZuqiu() %><%= employee.getPpqiu() %><%= employee.getStudy() %><%=employee.getJiaoy() %><%=employee.getKandsh() %><%=employee.getLvy() %><%=employee.getQita() %></span></p>
<p>出生年月:<span class="span1"><%= employee.getYear() %></span>年<span class="span1"><%= employee.getMonth() %></span>月<span class="span1"><%= employee.getDay() %></span>日</p>


<a href="upload.jsp" class="a">返回</a>
</div>
</div>
</body>
</html>