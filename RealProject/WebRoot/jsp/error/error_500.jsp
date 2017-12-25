<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>服务器繁忙</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/image/1.ico" media="screen" />

 </head>
 <body> 
   <!-- 页眉-->   
     <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><img src="${pageContext.request.contextPath}/image/logo.png" width="100px">面向电力工程项目管理</span>
                    
                    <!-- end logo -->
                    
                </div>
            </div>
        </div>
      </header>

<section>
          <div class="row">
              <main style="text-align:center;margin:0 auto">
              <div class="col-lg-14">
                  <h1 style = "margin-top:28px;color:#073763;font-size:120px;letter-spacing:15px">500</h1>
                      <h2 style = "color:#073763;font-size:29px;letter-spacing:7px">ERROR  PAGE</h2>
                      <p style = "font-size:20px;color:#073763;font-family:微软雅黑;letter-spacing:7px">服务器繁忙！建议您</p>
                      <span>
                      	<a href="${pageContext.request.contextPath}/web/servlet/mainServlet"><button type="button" class="btn btn-primary">返回首页</button></a>
                      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      	<a href="javascript:history.go(-1)"><button type="button" class="btn btn-primary">后退一步</button></a>
                      </span>
              </div>
              </main>
          </div>
  </section>

  <%@include file="/footer.jsp" %>
  </body>
</html>

