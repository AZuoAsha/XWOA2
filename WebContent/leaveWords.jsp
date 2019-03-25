<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>意见反馈</title>
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
#p{
	padding:22px;
	font-size:18px;	
}
</style>
</head>
<body>
<div class="wrap">
<form action="LeaveWordsServlet" method="post">
<p class="text" id="p">请留言:<textarea name="leaveWords" cols="50" rows="10" required></textarea>
    </p>
    <input type="submit" name="submit" value="提交留言">
</form>
</div>
</body>
</html>