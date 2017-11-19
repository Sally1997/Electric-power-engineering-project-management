<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>面向电力的项目管理系统/计划管理</title>
		<link rel="stylesheet" href="PlanManagement_Newed.css" type="text/css">
	</head>
	
	<body>
		<header>
		  	<span id="headerLeft"> <a href="main.html">首页</a> >><a href="01-projectmanagerfirst.html">项目管理</a> >> XXX项目 >>计划管理 >> 查看计划图</span>
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

        
		<section>
            <div id="TaskDetails">
			<p id="TaskNote"> 您当前处于任务节点<span id="TaskName">Child2.2.2</span>,详细信息如下：</p>
			<form id="MileStone">
				<div class="tableRow">
				<p class="tableAttribute">	任务名称: </p>
				<p class="tableContent"><input type="text" name="MileStone" value="Child2.2.2"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">负责人：</p>
				<p class="tableContent">	<input type="text" name="PersonInCharge" value="李维"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">	开始日期：</p>
				<p class="tableContent"><input type="date" name="StartDate" value="2017-10-26"></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute">截止日期：</p>
				<p class="tableContent"><input type="date" name="EndDate" value="2018-02-24"></p>
                </div>

                <div class="tableRow">
				<p class="tableAttribute">预算：</p>
				<p class="tableContent"><input type="number" name="budget" value="3000"><span>元</span></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute"><!--记得改成列表-->
				指标：
				</p>
				<p class="tableContent">
					<textarea> 
				    1.上传施工现场勘查报告 
				    2.上传施工图纸 
				    3.购买施工材料
					</textarea>
				</p>
				</div>
			</form>
				<p id="addSubTask">
					<a href="PlanManagement_NewTask.html" id="A">新建子任务</a>
				</p>
	        </div>

			<div id="ProjectTree">
			<p> 计划树状图</p>
			<p><img src="计划树状图.png" alt="这是你的计划图，以树状图的形式展示"></p>
			</div>

		
		</section>
		

		<footer>
			<p>
		    版权说明
		    </p>
		</footer>

</body>
</html>