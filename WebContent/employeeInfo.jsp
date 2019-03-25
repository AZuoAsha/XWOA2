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
<%
Employee employee=(Employee)(session.getAttribute("employee"));
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css" rel="stylesheet">
.wrap {
	margin: 0 auto;
	width: 500px;
	border-bottom-color: #666;
	border: solid 1px;
	border-radius: 8px;
}
.text {
	padding: 20px;
}
.sub {
	padding-left: 50%;
	padding-right:50%;
	position:relative;
}
#p{
	padding:22px;
	font-size:18px;	
}
.a{
	padding:22px;
	font-size:18px;
	color:blue;
}
</style>
</head>
<body>
<div class="wrap">
  <h1 align="center">完善信息</h1>
  <form action="EmployeeInfoServlet" method="post">
    <p id="p">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出生日期：
    <select name="year" id="select_k1" class="xla_k" >
       <option value="请选择">请选择</option>
        <option value="1976">1976</option>
        <option value="1977">1977</option>
        <option value="1978">1978</option>
        <option value="1979">1979</option>
        <option value="1980">1980</option>
        <option value="1981">1981</option>
        <option value="1982">1982</option>
        <option value="1983">1983</option>
        <option value="1984">1984</option>
        <option value="1985">1985</option>
        <option value="1986">1986</option>
        <option value="1987">1987</option>
        <option value="1988">1988</option>
        <option value="1989">1989</option>
        <option value="1990">1990</option>
        <option value="1991">1991</option>
        <option value="1992">1992</option>
        <option value="1993">1993</option>
        <option value="1994">1994</option>
        <option value="1995">1995</option>
        <option value="1996">1996</option>
        <option value="1997">1997</option>
        <option value="1998">1998</option>
        <option value="1999">1999</option>
        <option value="2000">2000</option>
        <option value="2001">2001</option>
        <option value="2002">2002</option>
        <option value="2003">2003</option>
        <option value="2004">2004</option>
        <option value="2005">2005</option>
        <option value="2006">2006</option>
        <option value="2007">2007</option>
        <option value="2008">2008</option>
        <option value="2009">2009</option>
        <option value="2010">2010</option>
        <option value="2011">2011</option>
        <option value="2012">2012</option>
        <option value="2013">2013</option>
      </select>
      年
      <select name="month" id="select_k1" class="xla_k" required>
        <option value="请选择">请选择</option>
        <option value="12">12</option>
        <option value="11">11</option>
        <option value="10">10</option>
        <option value="9">9</option>
        <option value="8">8</option>
        <option value="7">7</option>
        <option value="6">6</option>
        <option value="5">5</option>
        <option value="4">4</option>
        <option value="3">3</option>
        <option value="2">2</option>
        <option value="1">1</option>
      </select>月
      <select name="day" id="select_k1" class="xla_k" required>
        <option value="请选择">请选择</option>
        <option value="31">31</option>
        <option value="30">30</option>
        <option value="29">29</option>
        <option value="28">28</option>
        <option value="27">27</option>
        <option value="26">26</option>
        <option value="25">25</option>
        <option value="24">24</option>
        <option value="23">23</option>
        <option value="22">22</option>
        <option value="21">21</option>
        <option value="20">20</option>
        <option value="19">19</option>
        <option value="18">18</option>
        <option value="17">17</option>
        <option value="16">16</option>
        <option value="15">15</option>
        <option value="14">14</option>
        <option value="13">13</option>
        <option value="12">12</option>
        <option value="11">11</option>
        <option value="10">10</option>
        <option value="9">9</option>
        <option value="8">8</option>
        <option value="7">7</option>
        <option value="6">6</option>
        <option value="5">5</option>
        <option value="4">4</option>
        <option value="3">3</option>
        <option value="2">2</option>
        <option value="1">1</option>
      </select>
      日 </p>
    <p id="p">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;婚姻状况:
    <label>
        <input name="ismarry" type="radio" value="保密" checked required>
        保密: </label>
      <label style="padding:22px;font-size:18px">
        <input name="ismarry" type="radio" value="已婚" required>
       已婚:</label>
      <label style="padding:22px;font-size:18px">
        <input name="ismarry" type="radio" value="未婚" required>
        未婚: </label>
       </p>
       <p id="p">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;兴趣爱好:
	<input type="checkbox" name="lanqiu" value="篮球," checked >
     篮球:
      <input type="checkbox"  name="zuqiu" value="足球," >
足球:
      <input type="checkbox"  name="ppqiu" value="乒乓球," >
      乒乓球：
      <input type="checkbox"  name="kandsh" value="看电视," >
   看电视：
      <input type="checkbox"  name="jiaoy" value="交友," >
 交友：
      <input type="checkbox"  name="lvy" value="旅游," >
      旅游：
      <input type="checkbox" name="study" value="学习," >
     学习：
      <input type="checkbox" name="qita" value="其他" >
    其他： </p>
    <p class="text" id="p">个性签名:<textarea name="description" cols="50" rows="10" ></textarea>
    </p>
    <p class="text" id="p">个人简介:<textarea name="role" cols="50" rows="20" required></textarea>
    </p>
    <p class="sub">
      <input type="submit" name="submit" value="点击保存"/>
    </p>
    <a href="upload.jsp" class="a">返回</a>
  </form>
</div>
</body>
</html>