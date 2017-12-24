<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
  </head>
  <body> 
   
	
 <section>
 	<script type="text/javascript">
	 	var dataJson;
	 
	 	var currentPage=${info_map['current_page'] };
	 	var pageSize=${info_map['page_size'] };
	 	
	  	var pageNum=${info_map['total_page'] };
	 	var totalNum=${info_map['count'] };
	 	var projectNum=${fn:length(info_map['pi_list']) };
	 	var currentGroup=1;
	 	var groupSize=5;
	 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1; 
	</script>
 	<script type="text/javascript">
 		//更新数据
 		function refreshData(){
 			var pnamenodes=document.getElementsByName("pro_pname");
 			
			//新版本
			var trs=showtable.getElementsByTagName("tr");
 			for(var i=0;i<dataJson.length;i++){
 				var nodes=trs[i+1].getElementsByTagName("td");
 				nodes[0].innerHTML='<a href="javascript:window.location.href=&apos;/RealProject/web/servlet/judgeStageExist?pno='+dataJson[i].pno+'&apos;" name="pro_no">'+dataJson[i].pno+'</a>';
 				//刷新值0
 				
 			
 				nodes[1].innerHTML=nodes[1].innerHTML='<div class="dropdown"><span name="pro_pname">'+dataJson[i].pname+'</span><span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span><ul class="dropdown-menu" aria-labelledby="dropdownMenu1"><li><a href="/RealProject/web/servlet/staffListServlet?pno='+dataJson[i].pno+'">人员管理</a></li><li><a href="/RealProject/web/servlet/judgeStageExist?pno='+dataJson[i].pno+'">计划管理</a></li></ul></div>';
 				nodes[2].innerHTML=dataJson[i].name;
 				nodes[3].innerHTML=dataJson[i].duty;
 				nodes[4].innerHTML=dataJson[i].ptype;
 				nodes[5].innerHTML=dataJson[i].pstate;
 			
 			}
 			//刷新横线
 			for(var i=dataJson.length;i<5;i++){
 				var nodes=trs[i+1].getElementsByTagName("td");
 				nodes[0].innerHTML='-';
 				nodes[1].innerHTML='-';
 				nodes[2].innerHTML='-';
 				nodes[3].innerHTML='-';
 				nodes[4].innerHTML='-';
 				nodes[5].innerHTML='-';
 			}
 			
 		}
 	</script>
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
		<table class="table table-striped table-condensed" style="font-size: 15px" id="showtable">
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
			    <td align="left"><a href="javascript:window.location.href='/RealProject/web/servlet/judgeStageExist?pno=${pl.pno }'" name="pro_no">${pl.pno }</a></td>
			    <td align="left">
			    	<div class="dropdown"><span name="pro_pname">${pl.pname }</span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="/RealProject/web/servlet/staffListServlet?pno=${pl.pno }">人员管理</a></li>
    						<li><a href="/RealProject/web/servlet/judgeStageExist?pno=${pl.pno }">计划管理</a></li>
  						</ul>
					</div>
				</td>

			    <td align="left">${pl.name }</td>
			    <td align="left">${pl.duty }</td>
			    <td align="left" >${pl.ptype }</td>
			    <td align="left">${pl.pstate }</td>
		    </tr>

			</c:forEach>
			<c:forEach begin="${fn:length(info_map['pi_list']) }" end="4" step="1">
		    <tr name="fozza_tr" style="display:''">
			    <td align="left"><a href="#" name="pro_no">-</a></td>
			    <td align="left">
			    	<div class="dropdown"><span name="pro_pname">-</span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
				</td>

			    <td align="left">-</td>
			    <td align="left">-</td>
			    <td align="left" >-</td>
			    <td align="left">-</td>
		    </tr>

			</c:forEach>
	        </table> 
					</div> 
                    </div>
                </div>
                </div>
                <!--  分页栏-->
				
				<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination" id="showpage">
				  	<script type="text/javascript">
				  		var showtable=document.getElementById("showtable");
				  		var showpage=document.getElementById("showpage");
				  	</script>
					<li>
					  <a href="javascript:getPrevious(showpage);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li class="active"><a href="javascript:jmpPage(1)">1</a></li>
					<script type="text/javascript">
						if(pageNum<5){
							for(var i=2;i<=pageNum;i++){
								var node=document.createElement("li");
								node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
								showpage.appendChild(node);
							}
						}else{
							for(var i=2;i<6;i++){
								var node=document.createElement("li");
								node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
								showpage.appendChild(node);
							}
						}
					</script>
					<li>
					  <a href="javascript:getNext(showpage);" aria-label="Next">
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
			    <select class="form-control" name="ProjectType" id="projecttype">
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
		            <input type = "file" multiple="multiple" id="file">
				</div>
			  </div>
             <div class="form-group">
				<label for="others" class="col-sm-2 control-label">其他备注</label>
				<div class="col-lg-8">
				  <textarea class="form-control" rows="4" name="OtherRemark" id="others"></textarea>
				</div>
			  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <input type="button" class="btn btn-primary" value="提交" onclick="submitProject();">
      </div>
      </form>
      <script type="text/javascript">
      		//发送ajax请求
      		function submitProject(){
      			var projectname=document.getElementById("projectname");
      			var projecttype=document.getElementById("projecttype");
      			var checkman=document.getElementById("checkman");
      			var file=document.getElementById("file").files[0];
      			var others=document.getElementById("others");
      			
      			//进行验证
      			if(projectname.value==""){
      				alert("请输入项目名称");
      				return;
      			}
      			
      		}
      	
      </script>
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
	function getFunction(cur){
			var req = new XMLHttpRequest();
			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						var res=req.responseText;
						//数据刷新
						var data=eval('('+res+')');
						dataJson=data.pi_list;
						currentPage=data.current_page;
					 	pageSize=data.page_size;
					    pageNum=data.total_page;  
					 	totalNum=data.count; 
						projectNum=dataJson.length;	
						
						refreshData();	
					}
				}
			};
			
			req.open("get", "/RealProject/servlet/ShowProjectServlet2?current_page="+cur);
			req.send(null);
		}

</script>
</html>

  
</html>
