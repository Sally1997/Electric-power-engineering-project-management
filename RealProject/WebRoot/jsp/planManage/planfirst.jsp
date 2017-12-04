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
   <!-- 网页头部 -->
	<%@ include file="/head.jsp"%>
   <script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
	
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