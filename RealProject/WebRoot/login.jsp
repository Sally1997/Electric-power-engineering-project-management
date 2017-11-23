<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--用户登录后，输入账号，如果账号存在，则显示头像，否则默认头像，如果账号和密码正确，则跳转到主页，否则提示错误信息为“用户名或密码错误/验证码错误，请重新输入”。
   登录的 处理页面为StaffLogin(servlet) --%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		
		<title>员工登陆</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/LoginC.css" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/yqz.js"></script>

		<script type="text/javascript">
  			function sign_in_check(e){
   				return false;
  			}
  			 //更新验证码
  			function updateCode(){
  				var img=document.getElementById("img");
  				img.src="${pageContext.request.contextPath}/web/servlet/validatecode?"+new Date();
  			}

 			//	获取用户头像 	
  			function getUserLogo(){
  				var id=document.getElementById("userid").value;
  				if(id!=""){
  					getUserLogoUrl(id,document.getElementById("user_logo"));
  				}
  			}
  			window.onload=function(){
  				if("${account.staffno}"!=""){
  					//获取用户头像
  					getUserLogo();
  				}
  			}	
    	</script>
	</head>
	
    <body>
    	<header>
     		<p> 面向电力工程的项目管理系统</p>
	    </header>
	    
	    <!-- image位于body左侧，Login位于body右侧 -->
	    <section >
	    	<div id="image"></div>
	    	<div id="login">
    			<!-- 头像 -->
	     		<div id="portrait">
	     			<img src="${pageContext.request.contextPath }/image/unlogin.jpg" id="user_logo"  >
	     		</div>
	  		
	  			<!-- 登陆 -->
 	  			<c:if test="${empty uri}">
 	  				<form action="${pageContext.request.contextPath }/web/servlet/login" method="post">
 	  			</c:if>
 	  			<c:if test="${not empty uri }">
 	  				<form action="${pageContext.request.contextPath }/web/servlet/login?uri=${uri}" method="post">
 	  			</c:if>
	 	  			<label for="userid"   >账号</label></br>
		  			<input type="text" id="userid" name="staffno"  class="inputB"  placeholder="请输入您的账号" value="${account.staffno }" onblur="getUserLogo();"></br>
		  			<label for="passwd" >密码</label></br>
		  			<input type="password" id="passwd" name="password"  class="inputB" placeholder="请输入您的密码" ></br>
		  				
		  			<label for="validate_code" >验证码</label>
		  			<img alt="验证码" id="img" src="${pageContext.request.contextPath }/web/servlet/validatecode"  onclick="updateCode();"></br>
		  			<input type="text" id="validate_code" name="validatecode" class="inputB" ></br>
	 	  			<input type="submit" id="submitB"  value="登 录" > 
		  			<p style="color:red; text-align:center"> ${error['username'] } ${error['validatecode'] }${locError } </p>
		  			<p id="prompt"> 忘记密码?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">联系管理员</a></p>
		 		 	 
	  			</form>
	  			
   			<div class="clear"></div>
	    	</div>
	  
		<footer>
	 		<p>版权声明</p>
		</footer>
	 
	</body> 
</html>