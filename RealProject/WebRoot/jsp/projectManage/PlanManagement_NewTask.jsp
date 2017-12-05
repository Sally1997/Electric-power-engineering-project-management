<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/PlanManage/AddUser.jsp"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PlanManagement_NewTask</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/fozza.css" type="text/css">


 </head>
 <body> 
   <!-- 页眉-->   
     <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><<img src="${pageContext.request.contextPath }/src/logo.png" width="100px">面向电力工程项目管理</span>
                    
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
    		<main class="col-lg-12 main-content">
    		
    		<div class="col-lg-8" style="float:none; margin: 20px auto">
   	        <div class="panel panel-primary" style="margin: 20px auto">
    	        <div class="panel-heading">test01</div><!-- 这里是这个项目的名字 -->
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <table id = "newms" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th align="center">阶段名称</th>
			    <th align="center">负责人</th>
			    <th align="center">开始日期</th>
			    <th align="center">截止日期</th>
			    <th align="center">预算(元)</th>
		    </tr>
	        </table>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>

			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">任务新建</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
					<form action="${pageContext.request.contextPath}/servlet/TaskServlet" method="post" name="form1">
						<!--任务名称 -->
						<div id="milestone_name" class="block">
						<div id="first_left">
						<font class="text">任务名称:</font>
						</div>
						<div id="first_right">
						<input type="text" name="TaskName" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 负责人： -->
						<div id="manager_name" class="block">
						<div id="first_left">
						<font class="text">负责人：</font>
						</div>
						<div id="first_right">
						<input type="text" name="PersonInCharge" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 开始日期 -->
						<div id="start_time" class="block">
						<div id="first_left">
						<font class="text">开始日期：</font>
						</div>
						<div id="first_right">
						<input type="date" name="StartDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>


						<!-- 截止日期 -->
						<div id="end_time" class="block">
						<div id="first_left">
						<font class="text">截止日期：</font>
						</div>
						<div id="first_right">
						<input type="date" name="EndDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 预算 -->
						<div id="budget" class="block">
						<div id="first_left">
						<font class="text">预算：</font>
						</div>
						<div id="first_right">
						<input type="number" name="budget" size="40px;"><span>&nbsp;&nbsp;元</span>
						</div>
						<div class="clear"></div>
						</div>


						<!-- 指标 -->
						<div id="others" class="block">
						<div id="first_left">
						<font class="text">指标:</font>
						</div>
						<div id="first_right">
						<input type="text" name="IndexInfo" size="40px;">
						</div>
						</div>
						<div class="clear"></div>
						<div>
						
						</div>
                    
，
                    <div id="responsible_per" class="block">
						<div style="text-align: right">
						    <input type = "submit" name = "submit" class="btn btn-primary" value = "新建任务" onClick="addElement();">	
							<button type=""class="btn btn-primary" ><a href="PlanManagement_Newed" style="color:white;">结束新建</a></button>
						</div>
						<div class="clear"></div>
						</div>
                    </form>
                </div>
                </div>
            </div> 
    		</div>
    		</main>
	    </div>
	</div>
 </section>
 
	<%-- div下拉菜单 --%>
	<div id="fozza1" class="fozza2"></div>
  
<footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
  </div>
  </footer>
</body>
<script type="text/javascript">
function addElement()
{
	var msname = document.createTextNode(form1.msname.value);
	var mngname = document.createTextNode(form1.mngname.value);
	var StartDate = document.createTextNode(form1.StartDate.value);
	var EndDate = document.createTextNode(form1.EndDate.value);
	var budget = document.createTextNode(form1.budget.value);

	var td_msname = document.createElement("td");
	td_msname.setAttribute("width","20%");
	td_msname.setAttribute("height","27");
	var td_mngname = document.createElement("td");
	td_mngname.setAttribute("width","20%");
	td_mngname.setAttribute("height","27");
	var td_StartDate = document.createElement("td");
	td_StartDate.setAttribute("width","20%");
	td_StartDate.setAttribute("height","27");
	var td_EndDate = document.createElement("td");
	td_EndDate.setAttribute("width","20%");
	td_EndDate.setAttribute("height","27");
	var td_budget = document.createElement("td");
	td_budget.setAttribute("width","20%");
	td_budget.setAttribute("height","27");
	var tr = document.createElement("tr"); 
	//创建一个tr类型的Element节点
	var tbody = document.createElement("tbody"); 
	//创建一个tbody类型的Element节点
	//将TextNode节点加入到td类型的节点中
	td_msname.appendChild(msname);
	td_mngname.appendChild(mngname);
	td_StartDate.appendChild(StartDate);
	td_EndDate.appendChild(EndDate);
	td_budget.appendChild(budget);
	//将td类型的节点添加到tr节点中
	tr.appendChild(td_msname);
	tr.appendChild(td_mngname);	
	tr.appendChild(td_StartDate);	
	tr.appendChild(td_EndDate);	
	tr.appendChild(td_budget);	
	tbody.appendChild(tr); //将tr节点加入tbody中

	var tComment = document.getElementById("newms"); //获取table对象

	tComment.appendChild(tbody); //将节点tbody加入节点尾部
	
	form1.msname.value="";
	form1.mngname.value="";
	form1.StartDate.value="";
	form1.EndDate.value="";
	form1.budget.value="";

}
</script>
</html>