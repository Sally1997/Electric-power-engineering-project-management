<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>面向电力工程的项目管理系统/首页</title>
    
	<link rel="stylesheet" type="text/css" href="/EProject/css/HomeC.css">
	<script type="text/javascript">
  			function showTime() {
  				var currTime=new Date();
  				var year=currTime.getFullYear();
  				var month=currTime.getMonth()+1;
  				var date=currTime.getDate();
  				document.getElementById("currTime").innerHTML=year+"年"+month+"月"+date+"日"+currTime.toLocaleTimeString();
  				
  			}
  			setInterval("showTime()",10);
  			
  			function user_info_ap(){
			
				var kz=document.getElementById("uf");
				kz.style.display="block";
			}
			
			function user_info_dis(){
				var kz=document.getElementById("uf");
				kz.style.display="none";
			}
			
			function ms_info_ap(){
			
				var kz=document.getElementById("ms");
				kz.style.display="block";
			}
			
			function ms_info_dis(){
				var kz=document.getElementById("ms");
				kz.style.display="none";
			}
  		</script>
  </head>
  
  <body>
  <!-- 页面顶部，包括当前位置，用户信息，通知和菜单栏 -->
  	<header>
  		<div id="top">
  			<div id="top_left">
  				<span class=="top_font"><a herf="Home.jsp">首页</a></span>
  			</div>
  			
  			<div id="top_right">
  				<span class="user_photo" > <img src="#" alt="头像"></span>
  				
  				<span class="top_font" style="position:relative;top:-20px;font-size:16px;margin-left:10px;">
  					<a onmoueseover="user_info_ap()" onmouseout="user_info_dis()" href="#">用户XXX</a>
  					<a href="#" onmouseover="ms_info_ap()"onmouseout="ms_info_dis()">通知</a>
  					<span class="counter" >10</span>
  				</span>
  			</div>
  		
  	    
  	     <!-- 菜单栏链接 -->
		  	<!-- 首页部分链接改为Home.Jsp，其余先不变 -->
		  	<nav>
				<span class="menu"><a href="Home.jsp">首页</a></span> 
				<span class="menu"><a href="01-projectmanagerfirst.html">项目管理</a></span> 
			    <span class="menu"> <a href="money.html">资金管理</a></span> 
			    <span class="menu"> <a href="document2.html">文档管理</a></span> 
		  		<div class="clear"></div>
		  	</nav>  
		  	<div class="clear"></div>
		  </div>
		  	
  	</header>
  	
  	 <!-- 公告模块 -->
    <aside id="Notice">
    
    </aside>
    
  	<!-- 个人信息模块 -->
  	<section id="PInfo">
  		<p>个人信息模块</p>
  	   	<p> &nbsp;&nbsp;&nbsp;&nbsp;尊敬的用户 ${param.Name},您好，今天是<span id="currTime"></span></p>
  	</section>
  	
  	<!-- 个人任务列表模块 -->
    <section id="PTask">
    </section>
    
    
     <!-- 消息模块 -->
    <aside id="News">
    
    </aside>
    
    <!-- 项目进度模块-->
    <section id="ProjSche">
    </section>
    
    
    <footer>
    	<p> 版权声明</p>
    </footer>
    
    
  
   <!-- 隐藏信息部分：用户信息和通知 -->
   
    <!-- 为什么这块显示不了？？？ -->
    <div id="uf" class="hiddenms" style="right: 140px">
        <div class="triangle"></div>
  		<div class="uf_font">
   		<span>账户</span> :<span>王尼玛</span> <br>
   		<span>项目数量</span> :<span>5</span> <br>
   		<span>任务数量</span> :<span>10</span> <br>
   		<span>上次登录</span> :<br><span>2017-10-18 22:25:20</span> <br>“<br>
   		</div>
   	</div>
    
    <div id="ms" class="hiddenms" style="right:70px">
        <div class="triangle"></div>
        <div class="uf_font">反正这里有通知</div>
   	</div>
   	
  </body>
</html>
