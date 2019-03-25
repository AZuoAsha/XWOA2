<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<base href="<%=basePath%>">
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">    
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
 <meta http-equiv="description" content="This is my page">
<script src="jquery-2.1.1.min.js"></script>
<script src="jquery-ui.min.js"></script>
<link type="text/css" rel="stylesheet" href="jquery-ui.min.css">
<link href="index/_css/site.css" rel="stylesheet">
<script src="jQueryMenu.js"></script>
<script src="createJS/easeljs-0.8.2.min.js"></script>
<script src="createJS/tweenjs-0.6.2.min.js"></script>
<script src="createJS/MovieClip.js"></script>
<link href="anythingSlider/anythingslider.css" rel="stylesheet">
<link href="index/_css/upload.css" rel="stylesheet">
<style type="text/css">
	.div3{
	margin-left:31%;
	border:solid 1px darkgray;
	border-radius:50%;
	width:200px;
	height:200px;
	background-image:url(<%=employee.getUserhead() %>);
	background-size:100% 100%;
	}
</style>
<script src="anythingSlider/jquery.anythingslider.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#slider').anythingSlider({
		buildArrows : false,
		autoPlay : false,
		buildStartStop : false,
		resizeContents: false	
	});
}); // end ready
</script>
</head>
<body class="body">
<div class="container">

<div class="div1"> 
<ul id="menu" class="ul">
		<li class="li2"><a href="employeeOut.jsp" class="a">退出登录</a></li>
		<li class="li">
            <a href="#" class="a">英语四六级</a>
            <ul>
                <li><a href="index.html" class="aa">英语四级CET4</a></li>
                <li><a href="AllEmployeeInfo.jsp" class="aa">英语六级CET6</a></li>
            </ul>
        </li>
 		<li class="li">
            <a href="#" class="a">PPT课程</a>
            <ul>
                <li><a href="#" class="aa">PPT入门</a></li>
                <li><a href="#" class="aa">PPT初级</a></li>
                <li><a href="#" class="aa">PPT进阶</a></li>
                <li><a href="#" class="aa">PPT高级</a></li>
            </ul>
        </li> 
        <li class="li">
            <a href="#" class="a">IT技术</a>
            <ul>
                <li><a href="#" class="aa">HTML5</a></li>
                <li><a href="#" class="aa">CSS3</a></li>
                <li><a href="#" class="aa">JS</a></li>
                <li><a href="#" class="aa">JAVA大数据</a></li>
            </ul>
        </li>
        <li class="li">
            <a href="#" class="a">学员故事</a>
            <ul>
                <li ><a href="#" class="aa">迷茫无助</a></li>
                <li ><a href="#" class="aa">成长之路</a></li>
                <li ><a href="#" class="aa">成才之路</a></li>
            </ul>
        </li>
        <li class="li">
            <a href="#" class="a">英语视频</a>
            <ul>
                <li><a href="#" class="aa">小学英语</a></li>
                <li><a href="#" class="aa">初中英语</a></li>
                <li><a href="#" class="aa">高中英语</a></li>
            </ul>
        </li>
        <li class="li3"><a href="index.jsp" class="a">首页</a></li> 
    </ul> 
</div>
<div style="overflow:hidden;">

<div class="div2">

<form action="UploadServlet" enctype="multipart/form-data" method="post" class="form">
<p class="userhead">点击圆圈修改头像,再确认：</p>
<span class="span">注意：文件名不能出现中文</span><br/>
<h2 class="h2">欢迎您!<%= employee.getFullName() %><br></h2>
<div class="div3">
<input class="input2" type="file" name="file" required></div><br/>

<div><input type="submit" value="确定修改" class="input3"/></div><br>
<span class="nickname">昵称:</span><span class="nick"><%=employee.getLoginName() %></span><br>
</form>
<span class="span2">个性签名:</span><div class="div4"><span class="span3"><%= employee.getDescription() %></span></div>
<span class="span2">个人简介:</span><div class="div5"><span class="span4"><%= employee.getRole() %></span></div>
<div style="padding-top:10%;padding-left:32%;margin-bottom:0;">

<p><a href="userInfo.jsp" class="a2">查看个人信息</a></p>
<p><a href="ModefyNickName.jsp" class="a2">修改昵称</a></p>
<p><a href="employeeInfo.jsp" class="a2">完善个人信息</a></p>
<p><a href="AllEmployeeInfo.jsp" class="a2">查看全部成员</a></p>
<p><a href="employeeOut.jsp" class="a2">退出登录</a></p>
</div>
</div>
<div class="div6">	
	<!-- 此处写内容 -->
 <canvas id="gameView" width="430%" height="150px" style="margin-left:32%;background:url(img/beijing/robot.gif);background-size:100% 100%;" align="center"></canvas>
    <script src="createJS/jQueryMovieclip.js"></script>
	</div><br>
	<div style="width:68%;height:600px;margin-top:200px;margin-left:32%;margin-bottom:auto;">
	<div class="header" align="center">
   <p class="logo">理工勤学网 <i><font size="20">&</font></i> 微信小程序</p>
  </div>
  <div class="content">
    <div class="main">
      <h1>Anything Slider</h1>
      <div id="slider">
        <div class="slidePanel"><a href="hxm/hhh/li--3/li11/li1.html"><h2>The Amazing Pumpkin</h2><p><img src="images/pumpkin.jpg" alt="Pumpkin" width="215" height="119" class="imgLeft">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. </p>
          <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. </p>
        </a></div>
        <div class="slidePanel"><a href="hxm/hhh/li--3/li22/li2.html"><h2>The Amazing Grape</h2><p><img src="images/grapes.jpg" alt="Grapes" width="213" height="118" class="imgLeft">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.</p>
          <p>Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. </p>
        </a></div>
        <div class="slidePanel"><a href="hxm/hhh/li--3/li33/li3.html"><h2>The Amazing Assorted Vegetables</h2><p><img src="images/various.jpg" alt="Various" width="210" height="117" class="imgLeft">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. </p></a></div>
      </div>
    </div>
  </div>
	</div>
	
	<div class="footer" style="width:100%;background:#334873;margin-top:100px;">
<p align="center"> <a href="hxm/hhh/aboutus/aboutus.html">关于我们</a> ||<a href="hxm/hhh/contus/coutus.html">联系我们</a>||<a href="leaveWords.jsp">意见反馈</a><br><span style="color: white;">地址:成都市成华区二仙桥东三路1号成都理工大学<br>联系电话:13547937119<br>联系人:微信小程序团队</span><br><span id="dt">自动显示时间...</span></p>

</div>
	
 </div>
 
 <div   style="clear:both"></div>
 
</div>
<script language="javascript"> 
//从服务器上获取初始时间 
var currentDate = new Date(<%=new java.util.Date().getTime()%>); 


function run() 
{ 
currentDate.setSeconds(currentDate.getSeconds()+1); 
var time = "";
var year = currentDate.getFullYear();
var month = currentDate.getMonth() + 1;
var day = currentDate.getDate();
var show_day=new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六'); 
var week=currentDate.getDay();
var hour = currentDate.getHours();
var minute = currentDate.getMinutes();
var second = currentDate.getSeconds();
if(hour < 10){
	time += "0" + hour;
}else{
	time += hour;
}
time += ":";
if(minute < 10){
	time += "0" + minute;
}else{
	time += minute;
}
time += ":";
if(second < 10){
	time += "0" + second;
}else{
	time += second;
}
document.getElementById("dt").innerHTML ="今天是公元"+ year+"年"+month+"月"+day+"日   "+", " +show_day[week]+", "+"  现在是: "+ time;     
} 
window.setInterval("run();", 1000); 
</script> 
<span style="color: #ff0000;font-size:20px;">当前在线人数为:<%=SessionCounter.getActiveSessions() %>人</span>
</body>
</html>