<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form enctype="multipart/form-data" action="${pageContext.request.contextPath }/servlet/uploadServlet" method="post">
		用户名：<input type="text" name="name"><br>
		密码     ：<input type="password" name="pwd"><br>
		<input type="file" name="file"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>