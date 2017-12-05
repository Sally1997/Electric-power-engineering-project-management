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

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/dtree.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dtree.css">
	   
	
 </head>
 <body> 
   <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
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
						<button type="button" class="btn btn-primary" style="float: right;"><a href="${pageContext.request.contextPath}/jsp/projectManage/PlanManagement_NewTask.jsp" style="color:white">新建子任务</a></button>
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
