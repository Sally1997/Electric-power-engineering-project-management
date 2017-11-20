<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>面向电力的项目管理系统/计划管理</title>
		<link rel="stylesheet" href="css/PlanManagement_NewMilestone.css" type="text/css">
	</head>
	
	<body>
		<header>
		  	<span id="headerLeft"> <a href="main.html">首页</a>  >> <a href="01-projectmanagerfirst.html"> 项目管理</a> >> XXX项目>>计划管理>>新建阶段</span>
		  	<span id="headerRight">
		  		<img  src="Portrait.png" alt="这是你上传的头像"> <span id="headerUser"> 用户XXX|通知 <span id="notifNum">10</span>  </span>
		  	</span>
		</header>

		<nav>
			<span class="menu"><a href="main.html"> <span id="MPageLink">首页</span> </a></span>
			<span class="menu"><a href="01-projectmanagerfirst.html">项目管理</a></span>
			<span class="menu"><a href="money.html">资金管理</a></span>
			<span class="menu"><a href="document2.html">文档管理</a></span>
		</nav>

		<section >
			<p id="TaskShow"></p>
			<div id="MileStone">
			<form id="addMileStone"  method="post" action="">
				<div class="tableRow">
				<p class="tableAttribute">阶段名称: </p>
				<p class="tableContent"><input type="text" name="StageName" value="阶段XXX"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">负责人：</p>
				<p class="tableContent">	<input type="text" name="PersonInCharge" value="负责人XXX"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">	开始日期：</p>
				<p class="tableContent"><input type="date" name="StartDate"></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute">截止日期：</p>
				<p class="tableContent"><input type="date" name="EndDate"></p>
                </div>

                <div class="tableRow">
				<p class="tableAttribute">预算：</p>
				<p class="tableContent"><input type="number" name="budget"><span>元</span></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute"><!--记得改成列表-->
				指标：
				</p>
				<p class="tableContent">
				<textarea name="IndexInfo"></textarea></p>
				</div>
			</form>
				<p>
					<!-- <input class="submit" id="new_class_1" type="button" onclick="upload()" value="新建阶段"> -->
					<!-- <a href="PlanManagement_NewMilestone.html">新建阶段</a> -->
					<span class="submit"><a style="cursor:pointer" onclick="upload()">新建阶段</a></span>
					<span class="submit"><a   href="PlanManagement_Newed.jsp">结束新建</a></span>
				</p>
			</div>
		</section>

		<footer>
			<p>
		    版权说明
		    </p>
		</footer>

	</body>
	<script type="text/javascript">
<!--

//-->
	function upload(){
		/* method = "post";
		action = "/servlet/StageServlet"; */
		document.getElementById("addMileStone").action="${pageContext.request.contextPath}/servlet/StageServlet";
		document.getElementById("addMileStone").submit();
	}
</script>
	
</html>








