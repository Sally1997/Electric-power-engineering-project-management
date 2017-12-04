<%@page import="java.util.HashMap"%>
<%@page import="com.holyshit.domain.Document"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<body style="background-color: #F2F2F2;">


	<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
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

  						<span class="num_info">当前正在参与的项目数量：           </span><span>    ${fn:length(projectNames)} </span>
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
  						<c:forEach items="${tasks }" var="task" varStatus="hehe">
	  						<div>
  								<c:choose>
  									<c:when test="${task.tstate=='0' }">
  										<div class="task_def_main">
			  								<a href="PlanManagement_newed.html"class="task_href">${projectNames[hehe.index] }</a>
			  								<span class="new_task_blank"></span>
			  							</div>
			  							<div class="task_def_main"><span class="task_content_1">${task.taskname }</span><span class="task_content_1">[<a href="#" style="text-decoration: none;">查看</a>]</span></div>
			  							<div class="task_def_main">${task.stime }</div>
			  							<div class="task_def_main">${task.etime }</div>
  										<div class="task_def_main">
  											<span style="color: red;">还未开始</span>
  										</div>
  										<div class="clear"></div>
  									</c:when>
  									
  									<c:when test="${task.tstate=='1' }">
  										<div class="task_def_main">
			  								<a href="PlanManagement_newed.html"class="task_href">${projectNames[hehe.index]}</a>
			  								<span class="new_task_blank"></span>
			  							</div>
			  							<div class="task_def_main"><span style="display: inline-block;width: 40%;height: 30px;overflow: hidden;">${task.taskname }</span><span style="display: inline-block;width: 40%;height: 30px;">[<a href="#" style="text-decoration: none;">查看</a>]</span></div>
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
  						<span class="num_info">当前正在参与的项目数量：           </span><span>    ${fn:length(projects) }</span>

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
  					<c:if test="${fn:length(staffDoc['docs'])>8 }">
  						<c:forEach items="${staffDoc['docs'] }" begin="0" end="7" step="1" var="doc">
  							<li class="frame_li">
  								<a href="${pageContext.request.contextPath}/web/servlet/docDetailMessage?id=${doc.dno}">${doc.dtitle }</a>
  								<span><fmt:formatDate value="${doc.uploadtime }" type="both"/></span>
  							</li>
  						</c:forEach>
  					</c:if>
  						
  					<c:if test="${fn:length(staffDoc['docs'])<=8 }">
  						<c:forEach items="${staffDoc['docs'] }" var="doc">
  							<li class="frame_li">
  								<a href="${pageContext.request.contextPath}/web/servlet/docDetailMessage?id=${doc.dno}">${doc.dtitle }</a>
  								<span><fmt:formatDate value="${doc.uploadtime }" type="both"/></span>
  							</li>
  						</c:forEach>
  					</c:if>
  				
  				</ul>
  			</div>
  		</div>
  		<div class="clear"></div>
  	</div>
  	
  	<!-- 版权说明 -->
  	<div id="copyright">
  		<span style="font-size: 25px;">版权说明</span>
  	</div>

</body>


</html>
