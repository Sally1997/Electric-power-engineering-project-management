<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>员工登陆</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css">
</head>
<script type="text/javascript">
  	function sign_in_check(e){
  		
		return false;
  	}
  	function userinputCheck(e){
  		if(e.value=="请输入账号")
  			e.value="";
  		e.style.color="black";
  		e.style.fontWeight="bold";
  	}
  	function getUserLogo(){
  		var id=document.getElementById("userid").value;
  		if(id!=""){
  			//创建请求
  			var req=new XMLHttpRequest();
  			req.responseType="blob";
  			req.onreadystatechange=function(){
  				if(req.readyState==4){
  					var res=req.response;
  					if(res=="user_not_found"){
  						document.getElementById("userid").focus();
  					}else{
  						document.getElementById("user_logo").src=window.URL.createObjectURL(res);
  					}
  				}
  			};
  			//连接服务器
  			req.open("get", "${pageContext.request.contextPath}/web/servlet/getuserlogobyid?id="+id);
  			//发送请求
  			req.send(null);
  		}
  	}
  </script>
  <body>
  		<div id="top">X&nbsp;X&nbsp;X&nbsp;X&nbsp;X&nbsp;系&nbsp;统&nbsp;员&nbsp;工&nbsp;登&nbsp;陆</div>
  	
  	   <div style="background-image: url(${pageContext.request.contextPath}/image/bg.jpg);">
  		<div id="left_main">
			<span class="main_label">Service for employees</span>
			<span class="decri_label">XXX is designed for electrical engineering project management software, if you are an employee, then this software can simplify your work, if you are an administrator, it also allows you to quickly understand the process of the project......</span>
  		</div>
  		<div id="right_main">
	  		<!-- 头部logo -->
	  		<div id="top_main">
	  			<span class="logo">
	  				<img src="" id="user_logo" width="80px" height="80px">
	  			</span>
	  		</div>
	  		
	  		<!-- 中间登陆 -->
	  		<div id="content">
	  			<form action="${pageContext.request.contextPath }/web/servlet/login" method="post">
		  			<span id="capital"></span>
		  			<div id="login_form">
		  				<label for="userid" class="input_font" id="ui_label" >账号</label><span class="error">${error['username'] }</span>
		  				<input type="text" id="userid" name="staffno" class="input_frame" value="${account.staffno }" onclick="userinputCheck(this)">
		  				<label for="passwd" class="input_font">密码</label>
		  				<input type="password" id="passwd" name="password" class="input_frame" onclick="getUserLogo();">
		  				
		  				<label for="validate" class="input_font">验证码</label><span class="error">${error['validatecode'] }</span>
		  				<img alt="验证码" id="img" src="${pageContext.request.contextPath }/web/servlet/validatecode"  onclick="updateCode();">
		  				<br>
		  				<input type="text" id="validate_code" name="validatecode" class="input_frame" >
		  				
		  				
		  				
		  				<input type="submit" class="submit_font"value="登 录" >
		  			</div>
		  			<div id="find_passwd">
	  					忘记密码?
	  					<a href="javascript:putAdmin()">联系管理员</a>
		 		 	</div>
		 		 	<!-- 管理员详细信息 -->
		 		 	<div id="admin_detail">
		 		 		<span class="detail_left">电话</span>:<span class="detail_right">15823145263</span><span class="admin_font">管</span><br>
		 		 		<span class="detail_left">邮箱</span>:<span class="detail_right">fuck@gmail.com</span><span class="admin_font">理</span><br>
		 		 		<span class="detail_left">QQ</span>:<span class="detail_right">952412532</span><span class="admin_font">员</span>
		 		 	</div>
	  			</form>
	  		</div>

	  	</div>
	  	<div class="clear"></div>
	  </div>
	  <!-- 底部信息 logo -->
	  <div id="bottom">
		  <span class="cr_font">版权归XXX公司所有</span>
	  </div>
	 <!-- 透明层     -->
	<div id="meihua"></div>
  </body>
  <script type="text/javascript">
    var username=document.getElementById("userid");
  	username.style.color="gray";
  	function updateCode(){
  		var img=document.getElementById("img");
  		img.src="${pageContext.request.contextPath}/web/servlet/validatecode?"+new Date();
  	}
  	function putAdmin(){
  		var ele=document.getElementById("admin_detail");
  		var ele_2=document.getElementById("find_passwd");
  		ele.style.display="block";
  		ele_2.style.display="none";
  	}
  </script>
</html>