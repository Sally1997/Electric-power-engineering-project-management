<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Planfirst</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
<style type="text/css">
.Management{
	border:thin solid ;
	width:80px;
	height:80px;
	background-color:  #333A56;
	text-align: center;
	padding:25px 5px 25px 5px;
	border-radius: 10%;

}
#PersonalManagement{
	float: right;
	margin:120px 370px 40px 0px;
}
#PlanManagement{
	float: left;
	margin:120px 0px 40px 370px;
}
</style>
  </head>
  <body> 
   <!-- 页眉-->   
     <header style="background-image: url(${pageContext.request.contextPath}/image/topbk.png)">
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
 <!--   导航栏-->
  	<div>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Brand</a>
            </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
              <li class="active nav-current" role="presentation"><a href="01-projectmanagerfirst 01.html">项目管理<span class="sr-only">(current)</span></a></li>
              <li><a href="#">文档管理</a></li>
              <li><a href="moneymanage.html">资金管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">用户XXX</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"  aria-haspopup="true" aria-expanded="false">通知<span class="badge">10</span> <span class="caret"></span></a>
				  <ul class="dropdown-menu">
					<li><a href="#">聊天消息<span class="badge" style="float: right">4</span></a></li>
					<li><a href="#">审核信息<span class="badge" style="float: right">4</span></a></li>
		            <li><a href="#">任务<span class="badge" style="float: right">2</span></a></li>
			      </ul>
              </li>
            </ul>
         </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
     </nav>
  </div>
<!--  主要内容-->
  <section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<!--图表-->
    		<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">test01</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
				<div>
				<p class="Management" id="PlanManagement" ><a href="#" style="color :white">计划管理</a></p>
				<p class="Management" id="PersonalManagement"><a href="${pageContext.request.contextPath}/servlet/staffListServlet" style="color :white"><span >人员管理</span></a></p>
				</div>	
				<br/><br/>
				<div>
				</div>		
                </div>
                </div>
            </div> 
    		</div>
    		</main>
    	</div>
    </div>
</section>

  <footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
  </div>
  </footer>
  </body>
</html>