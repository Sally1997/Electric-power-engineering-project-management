<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.DTree" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PlanManagement_Newed</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
    
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/dtree.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dtree.css">
	
 </head>
 <body> 
   <!-- 页眉-->   
     <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><img src="${pageContext.request.contextPath }/src/logo.png" width="100px">面向电力工程项目管理</span>
                    
                    <!-- end logo -->
                    
                </div>
            </div>
        </div>
      </header>
 <!--   导航栏-->
  	<div>
        <nav class="navbar navbar-default">
          <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Brand</a>
            </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
              <li class="active nav-current" role="presentation"><a href="01-projectmanagerfirst 01.html">项目管理</a></li>
              <li><a href="#">文档管理</a></li>
              <li><a href="moneymanage.html">资金管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">用户XXX</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"  aria-haspopup="true" aria-expanded="false">通知<span class="badge">10</span> <span class="caret"></span></a>
				  <ul class="dropdown-menu">
					<li><a href="#">聊天消息<span class="badge" style="float: right">4</span></a></li>
					<li><a href="#">审核信息<span class="badge" style="float: right">4</span></a></li>
		            <li><a href="#">任务<span class="badge" style="float: right">2</span></a></li>
			      </ul>
              </li>
            </ul>
         </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
     </nav>
  </div>
<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-14 main-content">
    		
    		<div class="col-lg-6" >
   	        <div class="panel panel-primary" >
    	        <div class="panel-heading">test01</div><!-- 这里是这个项目的名字 -->
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- ...你这里源代码是一张图...我也不知道你该怎么实现...给你空出来好吧 -->
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
             
                 </div><!-- 剩下的你依次对齐吧。。。 -->
 
                </div>
            </div> 
    		</div>

			<div id="account" class="col-lg-6" style="padding-left: 10px">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading"><span id="fozza_where">任务节点</span><span id="task_name">Child2.2.2</span>详细信息</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
						<!-- 同意 -->
					<div id="responsible_per" class="block"><!--这里我就不给你把缩进改到后面了。。。太难改了。。。你反正晓得下面都是一块的-->
						<div id="first_left">
						<font>任务名称:</font>
						</div>
						<div id="first_right">
						<font id="TaskName">Child2.2.2</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font>负责人:</font>
						</div>
						<div id="first_right">
						<font id="CharP">李维</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >开始日期:</font>
						</div>
						<div id="first_right">
						<font id="new_s_time">2017/10/24</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >截止日期：</font>
						</div>
						<div id="first_right">
						<font id="new_e_time">2018/02/24</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >预算：</font>
						</div>
						<div id="first_right">
						<font id="new_budget">2000元</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left" name="new_fl">
						<font >指标：</font>
						</div>
						<div id="first_right">
						<font id="new_index">
							<ul>
								<li>上传施工现场勘查报告</li>
								<li>上传施工图纸</li>
								<li>购买施工材料</li>
							</ul>
						</font>
						</div>
						</div>
                        
                        <div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;"><a href="PlanManagement_NewMilestone.html" style="color:white">新建子任务</a></button>
						<br/><br/>
						</div>

                </div>
                </div>
            </div> 
    		</div>
    		</main>
	    </div>
	</div>
 </section>
 
  
<footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
  </div>
  </footer>
</body>
<script type="text/javascript">
	var aja = new XMLHttpRequest();
	window.onload = function(){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var str = aja.responseText;
				var ss = str.split(",");
				var p = document.getElementById("fozza_where");
				p.innerHTML = ss[0];
				p = document.getElementById("task_name");
				p.innerHTML = ss[1];
				p = document.getElementById("TaskName");
				p.innerHTML = ss[2];
				p = document.getElementById("CharP");
				p.innerHTML = ss[3];
				p = document.getElementById("new_s_time");
				p.innerHTML = ss[4];
				p = document.getElementById("new_e_time");
				p.innerHTML = ss[5];
				p = document.getElementById("new_budget");
				p.innerHTML = ss[6];
				p = document.getElementsByName("new_fl")[0];
				p.style.display = "none";
				p = document.getElementById("new_index");
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
				p = document.getElementById("task_name");
				p.innerHTML = ss[1];
				p = document.getElementById("TaskName");
				p.innerHTML = ss[2];
				p = document.getElementById("CharP");
				p.innerHTML = ss[3];
				p = document.getElementById("new_s_time");
				p.innerHTML = ss[4];
				p = document.getElementById("new_e_time");
				p.innerHTML = ss[5];
				p = document.getElementById("new_budget");
				p.innerHTML = ss[6];
				if (ss[7] == null) {
					p = document.getElementsByName("new_fl")[0];
					p.style.display = "none";
					p = document.getElementById("new_index");
					p.style.display = "none";
				} else {
					p = document.getElementsByName("new_fl")[0];
					p.style.display = "block";
					p = document.getElementById("new_index");
					p.style.display = "block";
					p = document.getElementById("new_index");
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
