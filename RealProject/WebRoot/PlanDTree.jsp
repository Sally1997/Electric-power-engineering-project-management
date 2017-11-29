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
	
	<%
		List<DTree> dlist = (ArrayList)request.getAttribute("list");
	 %>
	<script type="text/javascript">
		tree = new dTree('tree');
	<%
		Iterator<DTree> it = dlist.iterator();
		while(it.hasNext()){
		DTree dt = it.next();
		System.out.println(dt);
	%>
		tree.add('<%=dt.getCurrentNode()%>','<%=dt.getParentNode()%>','<%=dt.getNodeName()%>','javascript: showthisnode(<%=dt.getCurrentNode()%>)');
	<% 
		}
	 %>
	 document.write(tree);
	</script>
	
	
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br>

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
	function showthisnode(no){
		var aja = new XMLHttpRequest();
	}
</script>
</html>
