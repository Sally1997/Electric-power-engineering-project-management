<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--底边栏没改-->
<!--还有一堆冗余没搞懂-->
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.ProjectInfo" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ include file="/jsp/projectManage/AddUser.jsp"%>
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
		    
		    <!-- display:""的原因是block会引起错位 -->
		    <c:forEach items="${info_map['pi_list'] }" var="pl">
		    <tr name="fozza_tr" style="display:''">
			    <td align="left"><a href="javascript:goPlanManage(pno)" name="pro_no">${pl.pno }</a></td>
			    <td align="left">
			    	<div class="dropdown"><span name="pro_pname">${pl.pname }</span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="${pageContext.request.contextPath }/jsp/projectManage/PlanManagement_NewMilestone.jsp">计划管理</a></li>
  						</ul>
					</div>
				</td>
			    <td align="left" name="pro_name">${pl.name }</td>
			    <td align="left" name="pro_duty">${pl.duty }</td>
			    <td align="left" name="pro_ptype">${pl.ptype }</td>
			    <td align="left" name="pro_pstate">${pl.pstate }</td>
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
					<li name="fozza_li"><a onclick="ifclick(this)">1</a></li>
					<li name="fozza_li"><a onclick="ifclick(this)">2</a></li>
					<li name="fozza_li"><a onclick="ifclick(this)">3</a></li>
					<li name="fozza_li"><a onclick="ifclick(this)">4</a></li>
					<li name="fozza_li"><a onclick="ifclick(this)">5</a></li>
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
	var aja = new XMLHttpRequest();
	var curr_page = 1;
	var i=0;
	
	function ifclick(a){
		curr_page = a.innerHTML;
		/* var pos = curr_page%5;
		var fozza_li = document.getElementsByName("fozza_li");
		fozza_li[pos].className = "active"; */
		aja.onreadystatechange = function() {
		
			if (aja.readyState == 4 && aja.status == 200) {
			alert(curr_page);
			var str = eval("(" + aja.responseText + ")");
			alert(aja.responseText);
			var plist = str.pi_list;//获取链表
			//设置tr的block和none display属性
			var fozza_tr = document.getElementsByName("fozza_tr");
			
			//内容
			var pro_no = document.getElementsByName("pro_no");
			var pro_pname = document.getElementsByName("pro_pname");
			var pro_name = document.getElementsByName("pro_name");
			var pro_duty = document.getElementsByName("pro_duty");
			var pro_ptype = document.getElementsByName("pro_ptype");
			var pro_pstate = document.getElementsByName("pro_pstate");

			for (i = 0; i < 5; i++) {
				if (plist[i] != null) {
					pro_no[i].innerHTML = plist[i].pno;
					pro_pname[i].innerHTML = plist[i].pname;
					pro_name[i].innerHTML = plist[i].name;
					pro_duty[i].innerHTML = plist[i].duty;
					pro_ptype[i].innerHTML = plist[i].ptype;
					pro_pstate[i].innerHTML = plist[i].pstate;
				} else {
					fozza_tr[i].style.display = "none";
				} 
			}
		}
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowProjectServlet2?current_page="+curr_page);
		aja.send(null);
	}
	}
	
	
</script>
</html>