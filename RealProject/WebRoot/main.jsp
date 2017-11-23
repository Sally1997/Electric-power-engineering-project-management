<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <title>main.html</title>
	
    <meta name="keywords" content="电力工程,项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
  </head>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/yqz.js"></script>
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
  <script type="text/javascript">
  	window.onload=function(){
  		getUserLogoUrl("${staff.staffno}",document.getElementById("user_logo"));
  	};
  </script>
<body style="background-color: #F2F2F2;">


	  <div id="top_fixed">
		  <!-- 顶端 -->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font"><a href="main.html">首页</a></span>
		  		</div>
		  	 	<div id="top_right">
		  	 		<span class="user_photo" onmouseover="user_info_ap()" onmouseout="user_info_dis()"><img id="user_logo"></span>
		  			<span class="top_font_fuben" style="position: relative;top:-20px;"><a href="#" >${staff.name }</a> | <a href="#">通知</a><span class="counter" onmouseover="ms_info_ap()" onmouseout="ms_info_dis()">10</span></span>
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
  				<span style="font-weight: bold;font-size: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;尊敬的${staff.name }，您好！今天是<%=Calendar.getInstance().get(Calendar.YEAR)%>年<%=Calendar.getInstance().get(Calendar.MONTH)+1 %>月<%=Calendar.getInstance().get(Calendar.DATE) %>日。</span>
  			</div>
  			<!-- 任务列表 -->
  			<div id="tasklist">
  				<div id="tasklist_label">项<br>目<br>任<br>务<br>列<br>表</div>	
  				<div id="tasklist_detail">
  					<div class="task_top">
  						<c:if test="${empty taskSize }">
  							<span class="num_info">当前正在参与的项目数量：           </span><span>    0</span>
  						</c:if>
  						<c:if test="${not empty taskSize }">
  							<span class="num_info">当前正在参与的项目数量：           </span><span>    ${taskSize}</span>
  						</c:if>
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
  						<c:forEach items="${tasks }" var="task">
	  						<div>
  								<c:choose>
  									<c:when test="${task.tstate=='0' }">
  										<div class="task_def_main">
			  								<a href="PlanManagement_newed.html"class="task_href">${task.taskname }</a>
			  								<span class="new_task_blank"></span>
			  							</div>
			  							<div class="task_def_main"><span class="task_content_1">${task.taskcontent }</span><span class="task_content_1">[<a href="#" style="text-decoration: none;">查看</a>]</span></div>
			  							<div class="task_def_main">${task.stime }</div>
			  							<div class="task_def_main">${task.etime }</div>
  										<div class="task_def_main">
  											<span style="color: red;">还未开始</span>
  										</div>
  										<div class="clear"></div>
  									</c:when>
  									
  									<c:when test="${task.tstate=='1' }">
  										<div class="task_def_main">
			  								<a href="PlanManagement_newed.html"class="task_href">${task.taskname }</a>
			  								<span class="new_task_blank"></span>
			  							</div>
			  							<div class="task_def_main"><span style="display: inline-block;width: 40%;height: 30px;overflow: hidden;">${task.taskcontent }</span><span style="display: inline-block;width: 40%;height: 30px;">[<a href="#" style="text-decoration: none;">查看</a>]</span></div>
			  							<div class="task_def_main">${task.stime }</div>
			  							<div class="task_def_main">${task.etime }</div>
  										<div class="task_def_main">
  											<span style="color: green;">正在进行</span>
  										</div>
  										<div class="clear"></div>
  									</c:when>
  								</c:choose>
	  							
	  						</div>
  						</c:forEach>
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
  						<c:if test="${empty projectSize }">
  							<span class="num_info">当前正在参与的项目数量：           </span><span>    0</span>
  						</c:if>
  						<c:if test="${not empty projectSize }">
  							<span class="num_info">当前正在参与的项目数量：           </span><span>    ${projectSize}</span>
  						</c:if>
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
  						<c:forEach items="${projects }" var="project">
	  						<div>
	  							<div class="task_def_main"><a href="PlanManagement_newed.html" class="task_href">${project.pname }</a></div>
	  							<div class="task_def_main" style="border-radius:5px;border: 2px solid #A9A9A9;">
	  								<div class="process_60" style="width: ${project.pstage*100}%;"></div>
	  							</div>
	  							<div class="task_def_main">${project.stime }</div>
	  							<div class="task_def_main">${project.etime }</div>
	  							<div class="task_def_main">
	  								<c:choose>
	  									<c:when test="${project.pstate=='0' }"><span style="color: red;">项目还未开始</span></c:when>
	  								</c:choose>
	  								<c:choose>
	  									<c:when test="${project.pstate=='1' }"><span style="color: green;">正处于第一阶段</span></c:when>
	  								</c:choose>
	  								<c:choose>
	  									<c:when test="${project.pstate=='2' }"><span style="color: green;">正处于第二阶段</span></c:when>
	  								</c:choose>
	  								<c:choose>
	  									<c:when test="${project.pstate=='3' }"><span style="color: green;">正处于第三阶段</span></c:when>
	  								</c:choose>
	  								<c:choose>
	  									<c:when test="${project.pstate=='4' }"><span style="color: blue;">项目已经完成</span></c:when>
	  								</c:choose>
	  							</div>
	  							<div class="clear"></div>
	  						</div>
  						</c:forEach>
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
   		<span class="uf_font">账户</span> :<span class="uf_ans_font">${staff.staffno }</span> <br>
   		<span class="uf_font">姓名</span> :<span class="uf_ans_font">${staff.name }</span> <br>
   		<span class="uf_font">性别</span> :<span class="uf_ans_font">${staff.sex }</span> <br>
   		<span class="uf_font">出生日期</span> :<span class="uf_ans_font">${staff.birthday }</span> <br>
   		<span class="uf_font">邮箱</span> :<span class="uf_ans_font">${staff.email }</span> <br>
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
