<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>员工登陆</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/js/yqz.js"></script>
   <!--jsp-->
    
    <meta charset=UTF-8>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <script type="text/javascript">
  			function sign_in_check(e){
   				return false;
  			}
  			 //更新验证码
  			function updateCode(){
  				var img=document.getElementById("img");
  				img.src="${pageContext.request.contextPath}/web/servlet/validatecode?"+new Date();
  			}
  			
    	</script>
  		<style type="text/css">
  		.jumbotron h1{
			color: white;
			font-weight: lighter;
			letter-spacing: 5px;
		}
  		</style>
  </head>

  <body>
  <section>
      <div class="container-fluid">
          <div class="row">
             
              <div class="col-lg-8">
              	  <div class="jumbotron" style="background-color: transparent;text-align:right">
              	  	<h1>面向电力项目工程管理</h1>
              	  	<p>一个快捷，方便的项目管理网站，专门为电力工程设计</p>
              	  </div>
              </div>
       	  </div>
              
      </div>
  </section>
  
  
  	<!-- 修改人员界面 -->
<div class="modal fade" id="overHehe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">登录提示：</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
			  <div class="form-group">
				<label style="margin-left: 20%;">当前当户已经登录，是否继续登录？</label>
			
			  </div>
			  
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" onclick="notLogin();">不登录</button>
        <button type="button2" class="btn btn-primary" onclick="login();">登录</button>
      </div>
    </div>
  </div>
  </div>
  <script type="text/javascript">
  	//取消登录
  	function notLogin(){
  		location.href="/RealProject/offline.html";
  	}
  	
  	//登录
  	function login(){
  		location.href="/RealProject/web/servlet/login?staffno=${overLogin_staffno}&password=${overLogin_password}&validatecode=${overLogin_validatecode}&over=1&remember=${overLogin_remember}";
  	}
  </script>
  </body>
  <script type="text/javascript">
  	window.onload=function(){
  		$("#overHehe").modal("show");
  	};
  </script>
</html>
