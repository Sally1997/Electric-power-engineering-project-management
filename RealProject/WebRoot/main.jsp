<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>main.html</title>
	
    <meta name="keywords" content="电力工程,项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		}
		#top_fixed{
			position: fixed;
			top: 0px;
			width: 100%;
		}
		#top{
			height: 100px;
			width: 100%;
			background-color: #24292e;
			color: white;
			overflow: hidden;
		}
		#copyright{
			width:100%;
			height: 50px;	
			background-color: #0F243E;
			color: white;
			text-align: center;
		}
		#top_left{
			float:left;
			height: 100px;
			width:50%;
			margin-top:30px;
			padding-left: 50px; 
		}
		#top_right{
			float:right;
			height: 100px;
			margin-top:30px;
			margin-right: 6%;
		}
		.top_font{
			font-size: 20px;
			display: inline-block;
			width: 100%;
		
		}
		.top_font_fuben{
			font-size: 20px;
			display: inline-block;
			width: 200px;
			text-align: center;
		}
		.top_font a{
			text-decoration: none;
			color: white;
		}
		.top_font a:LINK{
			color: white;
		}
		.top_font a:HOVER{
			color: blue;
		}
		.top_font_fuben a{
			text-decoration: none;
			color: white;
		}
		.top_font_fuben a:LINK{
			color: white;
		}
		.top_font_fuben a:HOVER{
			color: blue;
		}
		#menu{
			background-color: #24292e;
			width: 100%;
			height: 42px;
			overflow: hidden;
			font-family: 黑体;
			font-weight: bold;
			
		}
		.menu_1{
			float:left;
			height: 36px;
			width: 13%;
			text-align: center;
			color: white;
			font-size: 20px;
			line-height: 36px;
		}
		.menu_font{

			position: relative;
			top: 5px;
		}
		#content_left{
			float:left;
			width: 75%;
			background-color: #F2F2F2;
			height: 1250px;
		}
		#content_right{
			float:left;
			width: 25%;
			background-color: #F2F2F2;
			height: 1250px;
		}
		#userinfo{
			background-color: white;
			height: 200px;
			width: 100%;
			margin: 10px;
			padding: 10px;
			
		}
		#tasklist{
			background-color: white;
			height: 500px;
			width: 100%;
			margin: 10px;
			overflow: hidden;
		}
		#project{
			background-color: white;
			height: 500px;
			width: 100%;
			margin: 10px;
			overflow: hidden;
		}
		#tasklist_label{
			float:left;
			background-color: #9BBB59;
			color:white;
			height: 350px;
			font-weight:bold;
			font-size:30px;
			width: 10%;
			border: 4px solid white;
			text-align: center;
			padding-top: 100px;	
		}
		#project_label{
			float:left;
			background-color: #9BBB59;
			color:white;
			height: 350px;
			font-weight:bold;
			font-size:30px;
			width: 10%;
			border: 4px solid white;
			text-align: center;
			padding-top: 100px;	
		}
		#project_detail{
			float:left;
			width:88%;	
			height: 500px;	
			background-color: white;	
		
		}
		#tasklist_detail{
			float:left;
			width:88%;	
			height: 500px;	
			background-color: white;	
		}
		.num_info{
			color: #974706;
			font-weight: bold;
			font-size: 20px;
		}
		.task_top{
			height: 50px;
			padding-left:50px;
			padding-top:20px;
			background-color: white;
		}
		.time_sort{
			color: #808080;
			font-size: 15px;
		}
		.task_def_head{
			float: left;
			width: 20%;
			height: 50px;
			color: black;
			padding-top:5px;
			font-family:黑体;
			font-weight:bold;
			text-align: center;
			line-height: 50px;
		}
		.task_def_main{
			float: left;
			width: 19.9%;
			height: 30px;
			color: black;
			line-height:50px;
			font-family:宋体;
			
			text-align: center;
		}
		.process_60{
			float: left;
			width: 60%;
			height: 30px;
			background-color: green;
		}
		.process_30{
			float: left;
			width: 30%;
			height: 30px;
			background-color: red;
		}
		#information{
			background-color: white;
			height: 500px;
			margin: 10px;
			padding-left:20px;
			overflow: hidden;
		}
		#message{
			background-color: white;
			height: 500px;
			margin: 10px;
			padding-left:20px;
			overflow: hidden;
		}
		#info_content{
			height: 400px;
			background-color: white;
		}
		#mess_content{
			height: 400px;
			background-color: white;
		}
		.moredata{
			height: 50px;
			text-align:right;		
			background-color: white;
			margin-top: 100px;
		}
		.moredata a{
			text-decoration: none;
			font-weight:bold;
		}

		.center_label{
			padding-top:10px;
			height:50px;
			font-weight:bold;
			font-size:18px;
			background-color:white;
			text-align: center;
		}
		.uf_font{
			display:inline-block;
			color: green;
			font-size: 15px;
			width: 28%;
			height: 25px;
			text-align: center;
		}
		.uf_ans_font{
			display:inline-block;
			color: red;
			font-size: 15px;
			width:50%;
			height: 25px;
			text-align: center;
		}
		.counter{
			border-radius:15px;
			width:40px;
			text-align:center;
			font-size:12px;
			display:inline-block;
			background-color: red;
			color: white;
		}
		.clear{
			clear: both;
		}
		.user_photo{
			display: inline-block;
			width: 50px;
			height: 50px;
			border-radius:50px;
			overflow: hidden;
		}
		.user_photo img {
			width: 50px;
			height: 50px;
		}
		.frame_top{
			height: 50px;
			border-bottom: 1px solid #d0d7dd;
		}
		.left_label{
			display: inline-block;
			height: 50px;
			width: 80px;
			line-height: 50px;
			font-size: 18px;
			letter-spacing:2px;
			color: #333;
			border-bottom: 4px solid #349ae8;
		}
		.more{
			display: inline-block;
			height: 20px;
			width: 45px;
			text-align:center;
			font-size:13px;
			color:white;
			background-color: gray;
			
		}
		.frame_ul{
			height: 450px;
			list-style: none;		
		}
		.frame_li{
			font-size: 15px;
			height: 50px;	
			width: 80%;	
		}
		.frame_li a{
				text-decoration:none;
		  	    width: 100%;
			    display: block;
			    float: left;
			    padding: 4px 0 3px;
			    color: #333;
			    white-space: nowrap;
			    text-overflow: ellipsis;
			    overflow: hidden;
		}
		.frame_li a:HOVER{
			text-decoration: underline;
			color: #00FA9A;
		}
		.frame_li span {
			 background: url(http://cdnpic.mgyun.com//Content/HomeV5/images/time.png) no-repeat 0 0;
			 font-size: 12px;
			 padding-left: 15px;
			 font-family: "宋体";
			 float: left;
			 line-height: 10px;
			 color: #999;
		}
		.new_task{
			display:inline-block;
			height:15px;
			width: 30px;
			background-color: red;
			line-height: 15px;
			overflow:hide;
			border-radius:5px;
			color: white;
		}
		.new_task_blank{
			display:inline-block;
			height:15px;
			width: 28px;
		}
		.task_href{
			display:inline-block;
			height:30px;
			text-decoration: none;
		}
		.task_href:HOVER{
			text-decoration:underline;
			color: #00008B;
			font-size: 20px;
			font-weight: bold;
		}
		.propmt_green{
			font-weight:bold;
			color: green;		
		}
		.propmt_red{
			font-weight:bold;
			color: red;		
		}
		
		#contex{
			
			width: 200px;
			height: 500px;
			position: fixed;
			right:0px;
			top: 142px;
			outline: 0;
		}
		#logo{
			float:left;
			background-color: #EEE9E9;
			width: 72%;
			height: 500px;
	
		}
		#jiantou{
		    width: 0;
		    height: 0;
		    border: 30px solid transparent;
		    border-right: 15px solid gray;
		    position: fixed;
  		}
  		#fuck_your_mother_BUG{
  			float:left;
  			width: 28%;
  			height: 500px;
  		}
	</style>
  </head>
  <script type="text/javascript">
  	$(document).ready(function(){
  		var hide_flag=1;
  		var frame_width=200;
  		var width=document.documentElement.clientWidth;
  		var str=(frame_width*0.72/width).toString();
  		str="-"+str;
  		$("#jiantou").mouseover(function(){
  			$(this).css("border-right","15px solid blue");
  			if(hide_flag===1){
  				$("#contex").animate({right:'-5px'},"slow");
  				hide_flag=0;
  			}
  			$("#contex").focus();
  		});
  		$("#jiantou").mouseout(function(){
  			$(this).css("border-right","15px solid gray");
  		});
/*   		$("#jiantou").click(function(){
  			if(hide_flag===1){
  				$("#contex").animate({right:'-5px'},"slow");
  				hide_flag=0;
  			}
  			else if(hide_flag===0){
  				var wd=document.documentElement.clientWidth;
		  		var str=(frame_width*0.72/wd*100).toString();
  				$("#contex").animate({right:"-"+str+"%"},"slow");		
  				hide_flag=1;
  			}
  		});*/
  		$(".more").mouseover(function(){
  			$(this).css("background-color","blue");
  		});
  		$(".more").mouseout(function(){
  			$(this).css("background-color","gray");
  		});
  		$("#contex").blur(function(){
  			var wd=document.documentElement.clientWidth;
		  	var str=(frame_width*0.72/wd*100).toString();
  			if(hide_flag===0){
	  			$("#contex").animate({right:"-"+str+"%"},"slow");
				hide_flag=1;
			}
  		}); 
		$(window).resize(function(){
			var hg=document.documentElement.clientHeight-142;
			$("#contex").css("height",hg+"px");
		  	$("#logo").css("height",hg+"px");
		  	$("#fuck_your_mother_BUG").css("height",hg+"px");
		  	$("#jiantou").css("bottom",hg/2+"px");
		  	
		  	var wd=document.documentElement.clientWidth;
		  	var str=(frame_width*0.72/wd*100).toString();
			
		    $("#contex").css("right","-"+str+"%");
		});
  	});
  </script>
<body style="background-color: #F2F2F2;">


	  <div id="top_fixed">
		  <!-- 顶端 -->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font"><a href="main.html">首页</a></span>
		  		</div>
		  	 	<div id="top_right">
		  	 		<span class="user_photo" onmouseover="user_info_ap()" onmouseout="user_info_dis()"><img  src="1.jpg"></span>
		  			<span class="top_font_fuben" style="position: relative;top:-20px;"><a href="#" >用户XXX</a> | <a href="#">通知</a><span class="counter" onmouseover="ms_info_ap()" onmouseout="ms_info_dis()">10</span></span>
		  		</div>
		  		<div class="clear"></div>
		  	</div>
		  	
		  	<!-- 菜单栏 -->
		  	<div id="menu">
				<div class="menu_1" onmouseover="change_1(this);" onmouseout="change_2(this);" onclick="window.location.href='#';"><span class="menu_font">首页</span></div>
				<div class="menu_1" onmouseover="change_1(this);" onmouseout="change_2(this);" onclick="window.location.href='./01-projectmanagerfirst.html';"><span class="menu_font">项目管理</span></div>
				<div class="menu_1" onmouseover="change_1(this);" onmouseout="change_2(this);" onclick="window.location.href='./money.html';"><span class="menu_font">资金管理</span></div>
				<div class="menu_1" onmouseover="change_1(this);" onmouseout="change_2(this);" onclick="window.location.href='document2.html';"><span class="menu_font">文档管理</span></div>
				
				<div class="clear"></div>
		  	</div>
	  	</div>
	 <div style="height: 140px;width: 100%;"></div> 	
  	<!-- 详细内容模块 -->
  	<div id="content">
  		<!-- 左边 -->
  		<div id="content_left">
  			<!-- 个人信息模块 -->
  			<div id="userinfo">
  				<span>个人信息模块</span><br><br>
  				<span style="font-weight: bold;font-size: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;尊敬的用户XXX，您好！今天是X年X月X日。</span>
  			</div>
  			<!-- 任务列表 -->
  			<div id="tasklist">
  				<div id="tasklist_label">项<br>目<br>任<br>务<br>列<br>表</div>	
  				<div id="tasklist_detail">
  					<div class="task_top">
  						<span class="num_info">当前任务数量：           </span><span>    15</span>
  						<span class="time_sort">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
  											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
  												按时间排序</span>
  					</div>
  					<div id="task_bott">
  						<div>
  							<div class="task_def_head">项目名称</div>
  							<div class="task_def_head">项目当前任务</div>
  							<div class="task_def_head">开始时间</div>
  							<div class="task_def_head">截止时间</div>
  							<div class="task_def_head">状态</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
  								<a href="PlanManagement_newed.html"class="task_href">项目A</a>
  								<span class="new_task_blank"></span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_green">正在进行中</span></div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
	  							<a class="task_href">项目B</a>
	  							<span class="new_task_blank"></span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/9/12</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_green">正在进行中</span></div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
	  							<a class="task_href">项目C</a>
	  							<span class="new_task_blank"></span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/10/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_green">正在进行中</span></div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
  								<a class="task_href">项目D</a>
  								<span class="new_task">new</span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/10/20</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_red">还未开始</span></div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
  								<a class="task_href">项目D</a>
  								<span class="new_task">new</span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/11/21</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_red">还未开始</span></div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main">
  								<a class="task_href">项目D</a>
  								<span class="new_task">new</span>
  							</div>
  							<div class="task_def_main">任务为XXXXX [查看]</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main"><span class="propmt_red">还未开始</span></div>
  							<div class="clear"></div>
  						</div>
						<div class="moredata">
							<a href="#">更多>></a>
						</div>
  						
  					</div>
  				</div>
  				<div class="clear"></div>
  			</div>
  			<!-- 正在进行的项目 -->
  			<div id="project">
  				<div id="project_label"><br>项<br>目<br>进<br>度</div>	
  				<div id="project_detail">
  					<div class="task_top">
  						<span class="num_info">当前正在参与的项目数量：           </span><span>    15</span>
  						<span class="time_sort">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
  											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
  											&nbsp;&nbsp;&nbsp;&nbsp;	按时间排序</span>
  					</div>
  					<div id="project_bott">
  						<div>
  							<div class="task_def_head">项目名称</div>
  							<div class="task_def_head">任务当前进度</div>
  							<div class="task_def_head">开始时间</div>
  							<div class="task_def_head">截止时间</div>
  							<div class="task_def_head">状态</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a href="PlanManagement_newed.html" class="task_href">项目A</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_60"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第二阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a class="task_href">项目B</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_60"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第二阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a class="task_href">项目C</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_30"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第一阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a class="task_href">项目D</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_60"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第二阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a class="task_href">项目E</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_30"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第一阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div>
  							<div class="task_def_main"><a class="task_href">项目F</a></div>
  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
  								<div class="process_60"></div>
  							</div>
  							<div class="task_def_main">2017/9/10</div>
  							<div class="task_def_main">2017/10/29</div>
  							<div class="task_def_main">处于第二阶段</div>
  							<div class="clear"></div>
  						</div>
  						<div class="moredata">
  							<a href="#">更多>></a>
  						</div>
  					</div>
  				</div>
  				<div class="clear"></div>
  			</div>
  		</div>
  		
  		<!-- 右边 -->
  		<div id="content_right">
  			<!-- 公告 -->
  			<div id="information">
  				<div class="frame_top">
  					<span class="left_label">公告中心</span>
  					<span style="display: inline-block;height: 20px;width: 45%;"></span>
  					<span class="more">more+</span>
  				</div>
  				<div style="height: 10px;"></div>
  				<ul class="frame_ul">
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  				</ul>
  			</div>
  			<div style="height: 10px;background-color: #F2F2F2;"></div>
  			<!-- 文件上传信息 -->
  			<div id="message">
  				<div class="frame_top">
  					<span class="left_label">最新消息</span>
  					<span style="display: inline-block;height: 20px;width: 45%;"></span>
  					<span class="more">more+</span>
  				</div>
  				<div style="height: 10px;"></div>
  				
  				<ul class="frame_ul">
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  					<li class="frame_li">
  						<a href="#">小米手机桌面还能这么玩：逼格满满的</a>
  						<span>2017.10.26 17:59</span>
  					</li>
  				</ul>
  			</div>
  		</div>
  		<div class="clear"></div>
  	</div>
  	<!-- 隐藏内容    右边框 -->
    <div id="contex" tabindex="0">
   		<div id="fuck_your_mother_BUG">
   			<div id="jiantou">
    		</div>
   		</div>
   		<div id="logo" style="text-align: center;font-size: 40px;">
			神<br>龙<br>护<br>体<br>，<br>B<br>U<br>G<br>速<br>退<br>！
    	</div>
 		<div class="clear"></div>
    </div>
  	<!-- 版权说明 -->
  	<div id="copyright">
  		<span style="font-size: 25px;">版权说明</span>
  	</div>
  	<!-- 默认隐藏内容 -->
  	<div id="uf" style="background-color:#FFF68F;display:none; overflow: hidden;width: 23%;height: 300px;position: fixed;left: 73%;top: 80px;border-radius:20px;">
<!--    		<span style="font-size: 20px;font-weight: bold;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人信息</span><br> -->
   		<div style="width: 100%;height: 27px;text-align: center;">
   			<span style="font-size: 20px;font-weight: bold;">个人信息</span><br>
   		</div>
   		<span class="uf_font">账户</span> :<span class="uf_ans_font">5412535</span> <br>
   		<span class="uf_font">姓名</span> :<span class="uf_ans_font">王尼玛</span> <br>
   		<span class="uf_font">性别</span> :<span class="uf_ans_font">男</span> <br>
   		<span class="uf_font">出生日期</span> :<span class="uf_ans_font">1998-3-2</span> <br>
   		<span class="uf_font">邮箱</span> :<span class="uf_ans_font">yqz88888888@gmail.com</span> <br>
   		<span class="uf_font">项目数量</span> :<span class="uf_ans_font">5</span> <br>
   		<span class="uf_font">任务数量</span> :<span class="uf_ans_font">10</span> <br>
   		<span class="uf_font">上次登录</span> :<span class="uf_ans_font">2017-10-18 22:25:20</span> <br>
   	</div>
   	
  	<div id="ms" style="background-color:#FFF68F;display:none;width: 13%;height: 300px;position: fixed;left: 86%;top: 80px;border-radius:20px">
  		<div style="width: 100%;height: 50px;text-align: center;">
   			<span style="font-size: 20px;font-weight: bold;">通知</span><br>
   		</div>
   	</div>

</body>

<script type="text/javascript">
	  	var frame_width=200;
	  	var height=document.documentElement.clientHeight-142;
	  	var width=document.documentElement.clientWidth;
	  	$("#contex").css("height",height+"px");
	  	$("#contex").css("width",frame_width+"px");
	  	$("#logo").css("height",height+"px");
	  	$("#fuck_your_mother_BUG").css("height",height+"px");
	  	$("#jiantou").css("bottom",height/2+"px");
	   	var str=(frame_width*0.72/width*100).toString();
		$("#contex").css("right","-"+str+"%");		
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
		function change_1(ele){
		ele.style.borderWidth="0 0 3px 0";
		ele.style.borderColor="blue";
		ele.style.borderStyle="solid";
		ele.style.color="#CDCDC1";
		ele.style.fontSize="30px";
		}
		function change_2(ele){
			ele.style.borderWidth="0 0 0 0";
			ele.style.color="white";
			ele.style.fontSize="20px";
		}
</script>
</html>
