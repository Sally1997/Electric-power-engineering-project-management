<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>服务器提示</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/serverError.css">

  </head>
  
  <body>
        <div id="top"></div>
  		<div id="flag">404 Error</div>
  	 	<div id="img"></div>
    	<div id="error">对不起，您访问的页面不存在或已被删除</div> 
    	<div id="returnS">
    		<div class="return"><a href="javascript:history.go(-1)"> 返回上一页</a></div> 
    		<div class="return"><a href="${pageContext.request.contextPath}/jsp/homeManage/main.jsp" >返回主页</a></div>
    	</div>
   
  	
  	 
  </body>
</html>
