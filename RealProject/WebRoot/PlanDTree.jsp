<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.DTree" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/PlanDTree.css">                                    
<script type="text/javascript" src="${pageContext.request.contextPath }/js/dtree.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dtree.css">
<title>项目管理</title>
<meta name="keywords" content="电力工程项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
</head>
<body>
    <div id="top_fixed">
		  <!-- 顶端-->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font">  <a href="main.html">首页</a>  >> <a href="01-projectmanagerfirst.html"> 项目管理</a> >> XXX项目>>计划管理>>新建阶段</span>
		  		</div>
		  	 	<div id="top_right">
		  			<span class="user_photo"><img  src="1.png"></span>
		  			<span class="top_font" style="position: relative;top:-20px;font-size: 16px; margin-left:10px;"  >
		  			<a onmouseover="user_info_ap()" onmouseout="user_info_dis()" href="#" >用户XXX</a> | 
		  			<a href="#" onmouseover="ms_info_ap()"onmouseout="ms_info_dis()">通知</a>
		  			<span class="counter" >10</span></span>
		  		</div>
		  			        
		  	<!-- 菜单栏-->
		  	<div id="menu">
				<div class="menu_1"><span ><a href="main.html">首页</a></span></div>
				<div class="menu_1"><span ><a  href="01-projectmanagerfirst.html">项目管理</a></span></div>
			    <div class="menu_1"><span ><a  href="money.html">资金管理</a></span></div>
			    <div class="menu_1"><span ><a  href="document2.html">文档管理</a></span></div>
				<div class="clear"></div>
		  	</div>
		  		<div class="clear"></div>
		  	</div>  

    </div>
		
	<%-- <div id="dTree">
	<script type="text/javascript">
	d=new dTree("d");
	d.add("1",-1,'项目');
	var str = "";
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var pdt = document.getElementById("plantdtree");
			pdt.innerHTML = aja.responseText;
		}
	}
	//创建连接
	aja.open("get","${pageContext.request.contextPath }/servlet/DTreeNodeServlet",true);
	//发送请求
	aja.send(null);
	document.write(d);
	</script>
	</div>	
	<div id="plantdtree"></div> --%>
	
	<div id="fozza_2">
		<p> 计划树状图</p>
		<%
			List<DTree> dlist = (ArrayList)request.getAttribute("list");
	 	%>
			<script type="text/javascript">
			tree = new dTree('tree');
		<%
			Iterator<DTree> it = dlist.iterator();
			while(it.hasNext()){
				DTree dt = it.next();
		%>
			tree.add('<%=dt.getCurrentNode()%>','<%=dt.getParentNode()%>','<%=dt.getNodeName()%>','javascript: showthisnode(<%=dt.getCurrentNode()%>)');
		<% 
			}
		 %>
		 	document.write(tree);
		</script>
	</div>
	
	
	<section>
            <div id="TaskDetails">
			<p id="TaskNote"> 您当前处于<span id="fozza_where">任务节点</span><span id="TaskName">Child2.2.2</span>,详细信息如下：</p>
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

				<div class="tableRow" id="fozza_tablerow">
				<p class="tableAttribute"><!--记得改成列表-->
				指标：
				</p>
				<p class="tableContent">
					<textarea id="fozza_area"> 
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
		</section>
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>

	<!-- 版权声明 -->
  	<div id="copyright" style="position:fixed;bottom:0px">
  		<span>版权声明</span>
  	</div>
  	
  	<!-- 默认隐藏内容 -->
  	<div id="uf" class="hiddenms" style="right: 140px">
        <div class="triangle"></div>
  		<div class="uf_font">
   		<span>账户</span> :<span>王尼玛</span> <br>
   		<span>项目数量</span> :<span>5</span> <br>
   		<span>任务数量</span> :<span>10</span> <br>
   		<span>上次登录</span> :<br><span>2017-10-18 22:25:20</span> <br><br>
   		</div>
   	</div>
   	
  	<div id="ms" class="hiddenms" style="right:70px">
        <div class="triangle"></div>
        <div class="uf_font">反正这里有通知</div>
   	</div>
	

</body>
<script type="text/javascript">
	function user_info_ap(){
		var kz=document.getElementById("uf");
		kz.style.display="block";
	}
	function user_info_dis(){
		var kz=document.getElementById("uf");
		kz.style.display="none";
	}
	function ms_info_ap() {
		var kz = document.getElementById("ms");
		kz.style.display = "block";
	}
	function ms_info_dis() {
		var kz = document.getElementById("ms");
		kz.style.display = "none";
	}
	var aja = new XMLHttpRequest();
	window.onload = function(){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var str = aja.responseText;
				var ss = str.split(",");
				var p = document.getElementById("fozza_where");
				p.innerHTML = ss[0];
				p = document.getElementById("TaskName");
				p.innerHTML = ss[1];
				p = document.getElementsByName("MileStone")[0];
				p.value = ss[2];
				p = document.getElementsByName("PersonInCharge")[0];
				p.value = ss[3];
				p = document.getElementsByName("StartDate")[0];
				p.value = ss[4];
				p = document.getElementsByName("EndDate")[0];
				p.value = ss[5];
				p = document.getElementsByName("budget")[0];
				p.value = ss[6];
				p = document.getElementById("fozza_tablerow");
				p.style.display = "none";
			}
		}
		//创建连接
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+'<%=dlist.get(0).getCurrentNode()%>');
		//发送请求
		aja.send(null);
	}
	function showthisnode(no){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var str = aja.responseText;
				var ss = str.split(",");
				var p = document.getElementById("fozza_where");
				p.innerHTML = ss[0];
				p = document.getElementById("TaskName");
				p.innerHTML = ss[1];
				p = document.getElementsByName("MileStone")[0];
				p.value = ss[2];
				p = document.getElementsByName("PersonInCharge")[0];
				p.value = ss[3];
				p = document.getElementsByName("StartDate")[0];
				p.value = ss[4];
				p = document.getElementsByName("EndDate")[0];
				p.value = ss[5];
				p = document.getElementsByName("budget")[0];
				p.value = ss[6];
				if(ss[7]==null){
					p = document.getElementById("fozza_tablerow");
					p.style.display="none";
				}
				else{
					p = document.getElementById("fozza_tablerow");
					p.style.display="block";
					p = document.getElementById("fozza_area");
					p.innerHTML = ss[7];
				}
			}
		}
		//创建连接
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+no);
		//发送请求
		aja.send(null);
	}
	
</script>
</html>
