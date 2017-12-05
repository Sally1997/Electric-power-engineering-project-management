<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--底边栏没改-->
<!--还有一堆冗余没搞懂-->
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.ProjectInfo" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ include file="/PlanManage/AddUser.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>projectmanagerfirst</title>
  </head>
  <body> 
   
<!--  主要内容-->
	<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
 <section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<!--图表-->
    		<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">已经参与的项目</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- style="margin-top: 20px;margin-left: 5%" -->
                    <div class="row">
					<div class="col-lg-12">
	<div>
        <button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc">新建</button>
        <br/><br/>
    </div>
		<table class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th align="center">项目编号</th>
			    <th align="center">项目名称</th>
			    <th align="center">项目经理</th>
			    <th align="center">职责</th>
			    <th align="center">项目类型</th>
			    <th align="center">状态</th>
		    </tr>
		    <c:forEach items="${list }" var="i">
		    <tr>
			    <td align="left" id="pro1">${i.Pno }</td>
			    <td align="left">
			    	<div class="dropdown"><span id="pro2">${i.PName }</span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="${pageContext.request.contextPath }/jsp/projectManage/PlanManagement_NewMilestone.jsp">计划管理</a></li>
  						</ul>
					</div>
				</td>
			    <td align="left" id="pro3">${i.Name }</td>
			    <td align="left" id="pro4">${i.PMDuty }</td>
			    <td align="left" id="pro5">${i.PType }</td>
			    <td align="left" id="pro6">${i.pState }</td>
		    </tr>
		    </c:forEach>
	        </table> 
					</div> 
                    </div>
                </div>
                </div>
                <!--  分页栏-->
				<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination">
					<li>
					  <a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li>
					  <a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				  </ul>
				</nav>

            </div> 
				<button type="button" class="btn btn-primary" style="float: right;"><a href="main.html"></a>返回</button>	
    		</div>
			</main>
    	</div>
    </div>
</section>
<!--  默认隐藏的内容:新建-->
  <div class="modal fade" id="handupAc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新建项目</h4>
      </div>
      <div class="modal-body">
	 <form class="form-horizontal" action="${pageContext.request.contextPath }/servlet/NewProjectServlet" method="post">
		  		<div class="form-group">
				<label for="projectname" class="col-sm-2 control-label">项目名称</label>
				<div class="col-sm-8">
		            <input class="form-control" id="projectname" name="ProjectName">
				</div>
				</div>
				<div class="form-group">
				<label for="projecttype" class="col-sm-2 control-label">项目类型</label>
				<div class="col-sm-8">
			    <select class="form-control" name="ProjectType">
				  <option>工程类</option>
				  <option>设计类</option>
				 </select>
				</div>
			  	</div>
				<div class="form-group">
				<label for="checkman" class="col-sm-2 control-label">审批人</label>
				<div class="col-sm-8">
		            <input class="form-control" id="checkman" name="PersonInCharge">
				</div>
			  	</div>
			  	<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">相关附件</label>
				<div class="col-sm-8">
		            <input type = "file" id="checkman">
				</div>
			  </div>
             <div class="form-group">
				<label for="others" class="col-sm-2 control-label">其他备注</label>
				<div class="col-lg-8">
				  <textarea class="form-control" rows="4" name="OtherRemark"></textarea>
				</div>
			  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <!-- <button type="submit" class="btn btn-primary">提交</button> -->
        <input type="submit" class="btn btn-primary" value="提交">
      </div>
      </form>
    </div>
  </div>
  <div id="fozza1" class="fozza3"></div> 
</div>
 

 
 <footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
  </div>
  </footer>
  </body>
<script type="text/javascript">
	/* var aja = new XMLHttpRequest();
	window.onload = function(){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var ss = eval("("+aja.responseText+")")
				var p = document.getElementById("pro1");
				p.innerHTML = ss[0].pno;
				var p = document.getElementById("pro2");
				p.innerHTML = ss[0].PName;
				var p = document.getElementById("pro3");
				p.innerHTML = ss[0].name;
				var p = document.getElementById("pro4");
				p.innerHTML = ss[0].PMDuty;
				var p = document.getElementById("pro5");
				p.innerHTML = ss[0].PType;
				var p = document.getElementById("pro6");
				p.innerHTML = ss[0].pState;
				
				var p = document.getElementById("pro1_1");
				p.innerHTML = ss[1].pno;
				var p = document.getElementById("pro1_2");
				p.innerHTML = ss[1].PName;
				var p = document.getElementById("pro1_3");
				p.innerHTML = ss[1].name;
				var p = document.getElementById("pro1_4");
				p.innerHTML = ss[1].PMDuty;
				var p = document.getElementById("pro1_5");
				p.innerHTML = ss[1].PType;
				var p = document.getElementById("pro1_6");
				p.innerHTML = ss[1].pState;
				
				var p = document.getElementById("pro2_1");
				p.innerHTML = ss[2].pno;
				var p = document.getElementById("pro2_2");
				p.innerHTML = ss[2].PName;
				var p = document.getElementById("pro2_3");
				p.innerHTML = ss[2].name;
				var p = document.getElementById("pro2_4");
				p.innerHTML = ss[2].PMDuty;
				var p = document.getElementById("pro2_5");
				p.innerHTML = ss[2].PType;
				var p = document.getElementById("pro2_6");
				p.innerHTML = ss[2].pState;
				
				var p = document.getElementById("pro3_1");
				p.innerHTML = ss[3].pno;
				var p = document.getElementById("pro3_2");
				p.innerHTML = ss[3].PName;
				var p = document.getElementById("pro3_3");
				p.innerHTML = ss[3].name;
				var p = document.getElementById("pro3_4");
				p.innerHTML = ss[3].PMDuty;
				var p = document.getElementById("pro3_5");
				p.innerHTML = ss[3].PType;
				var p = document.getElementById("pro3_6");
				p.innerHTML = ss[3].pState;
				
				var p = document.getElementById("pro4_1");
				p.innerHTML = ss[4].pno;
				var p = document.getElementById("pro4_2");
				p.innerHTML = ss[4].PName;
				var p = document.getElementById("pro4_3");
				p.innerHTML = ss[4].name;
				var p = document.getElementById("pro4_4");
				p.innerHTML = ss[4].PMDuty;
				var p = document.getElementById("pro4_5");
				p.innerHTML = ss[4].PType;
				var p = document.getElementById("pro4_6");
				p.innerHTML = ss[4].pState;
			}
		}	
		//创建连接
	aja.open("get", "${pageContext.request.contextPath}/servlet/ShowProjectServlet");
	//发送请求
	aja.send(null);
	}
	 */
</script>
  
</html>