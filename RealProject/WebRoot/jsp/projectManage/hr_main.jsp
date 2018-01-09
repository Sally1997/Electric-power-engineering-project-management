<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>项目人员管理</title>
    <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
	<script type="text/javascript">
		
		function checkAll(){
			var flag=document.getElementById("ckAll").checked;
			var ids=document.getElementsByName("ids");
			for(var i=0;i<ids.length;i++){
				ids[i].checked=flag;
			}
		}
		function delAllStaffs(){
			var p=document.getElementsByName("stafflist")[0];
			var ids = document.getElementsByName("ids");
			var str="";
			for(var i=0;i<ids.length;i++)
			{
				if(ids[i].checked)
				{
					str+="ids="+ids[i].value+"&";
				}
			}
			str=str.substring(0,str.length-1);
			alert("确定将以下员工删除出项目组吗？删除后，这些员工将无权查看项目组中全部文件");
			if(str!="")
				p.action ="${pageContext.request.contextPath}/web/servlet/delAllStaffsServlet?pno=${pno }";
		}
		function updatenote(a,b){
			var p=document.getElementsByName("stafflist")[0];
			p.action = "${pageContext.request.contextPath}/web/servlet/updateNoteServlet?staffno="+a+"&pno=${pno}&notesofnow="+b;
		}
		function showPno(){
			alert(${pno});
		}
		function lookQuali(){
			var ids = document.getElementsByName("ids");
		}
	</script>
  </head>
  <body> 
<!--  主要内容-->
  <section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<!--图表-->
    		<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">当前项目已参与人员</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
					<div>
						<a href="${pageContext.request.contextPath}/servlet/hrMainJumpaddServlet?pno=${pno }" style="color:white;"><button type="button" class="btn btn-primary" style="float: right;" >增加</button></a>
						<br/><br/>
					</div>
				<form method="post" name="stafflist" >
					<table class="table table-striped table-condensed" style="font-size: 15px">
						<tr>
							<c:if test="${not empty deleteAndAddStaff }">
								<th><input type="checkbox" id="ckAll" onclick="checkAll()" /></th>
							</c:if>
							<th>员工编号</th>
							<th>员工姓名</th>
							<th>联系方式</th>
							<th>职责</th>
							<th>备注</th>
							<!--  <th>发送信息</th>-->
							<th>资格证</th>
						</tr>
					<c:forEach items="${pb.staffs}" var="s" varStatus="staffs" >
						<tr>
							<c:if test="${not empty deleteAndAddStaff }">
								<td align="center"><input type="checkbox" name="ids" value="${s.staffno }" /></td>
							</c:if>
							<td align="center">${s.staffno }</td>
							<td align="center">${s.name }</td>
							<td align="center">${s.te }</td>
							<td align="center">${s.duty }</td>
							<td align="center">
								<div class="dropdown"><span id="managername">${pb.notes[staffs.index] }</span>
            					<span class="glyphicon glyphicon-pencil" style="cursor: pointer;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
              						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                						<!--  <li><input type="text" name=${s.staffno } size="15px;" /></li>
                						<li><input type = "submit" style="float:right;" name = "submit" class="btn btn-primary" value = "修改" onclick="updatenote('${s.staffno }','${pb.notes[staffs.index] }')"  /></li>
                						 --><li><div class="row">
					  						<div class="col-lg-11 xumode">
											<div class="input-group">
						  						<input type="text" class="form-control" placeholder="修改备注" name=${s.staffno } maxlength="10" >
						 						<span class="input-group-btn">
												<button class="btn btn-default" type="submit" onclick="updatenote('${s.staffno }','${pb.notes[staffs.index] }')" >修改</button>
						  						</span>
												</div><!-- /input-group -->
					                            </div>
                                                </div>
                                            </li>
             						</ul><!-- 纪丽！这里样式要改一下！ -->
          						</div>	
							</td>
							<!--<td align="center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#handupAc">发送</button></td>-->
							<td align="center"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#handupBc" value="${s.staffno }"  onclick="showqua('${s.staffno}')" >查看</button></td>
						</tr>
					</c:forEach>
					<script>
					function showqua(str)
					{
			  			var xmlhttp;    
			 			 if (window.XMLHttpRequest)
			  			{
			    			// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
			    			xmlhttp=new XMLHttpRequest();
			  			}
			  			else
			  			{
			    			// IE6, IE5 浏览器执行代码
			    			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  			}
			  			xmlhttp.onreadystatechange=function()
			  			{
			    			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			    			{
			      				
			            		 document.getElementById("qualif").innerHTML=xmlhttp.responseText;
			            		
			    			}
			  			}
			  			xmlhttp.open("POST","${pageContext.request.contextPath}/web/servlet/qualificationListServlet?staffno="+str,true);
			  			xmlhttp.send();
					}
					</script>
					</table>

					<!--  分页栏-->
					
					<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination">
					<li>
					  <a href="${pageContext.request.contextPath }/web/servlet/staffListServlet?currPage=${pb.currentPage==1?1:pb.currentPage-1}&pno=${pno}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<!--   <li class="active">第${pb.currentPage}页/共${pb.totalPage}页</li>-->
					<li>
					  <a href="${pageContext.request.contextPath }/web/servlet/staffListServlet?currPage=${pb.currentPage==pb.totalPage?pb.currentPage:pb.currentPage+1}&pno=${pno}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				  </ul>
				</nav>
				<div>
				<!-- 权限认证 -->
				<c:if test="${not empty deleteAndAddStaff }">
					<button type="submit" class="btn btn-primary" style="float: right;" data-toggle="modal" onclick="delAllStaffs()">删除</button>
				</c:if>
                <br/><br/>
                </div>
            </form>		
                </div>
                </div>
            </div> 
				<a href="${pageContext.request.contextPath}/servlet/ShowProjectServlet" style="color:white;"><button type="button" class="btn btn-primary" style="float: right;" >返回</button></a>
    		</div>
    		</main>
    	</div>
    </div>
</section>
<!--默认隐藏的内容:发送消息-->
  <div class="modal fade" id="handupAc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">发送消息</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
		  		<div class="form-group">
				<label for="projectname" class="col-sm-2 control-label">消息主题</label>
				<div class="col-sm-8">
		            <input class="form-control" id="projectname">
				</div>
				</div>
				<div class="form-group">
				<label for="projecttype" class="col-sm-2 control-label">发件地址</label>
				<div class="col-sm-8">
			    wangnima@gmail.com
				</div>
			  	</div>
				<div class="form-group">
				<label for="projecttype" class="col-sm-2 control-label">收件地址</label>
				<div class="col-sm-8">
			    12345677@gmail.com
				</div>
			  	</div>
			  	<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">相关附件</label>
				<div class="col-sm-8">
		            <input type = "file" id="checkman">
				</div>
			  </div>
             <div class="form-group">
				<label for="others" class="col-sm-2 control-label">主要内容</label>
				<div class="col-lg-8">
				  <textarea class="form-control" rows="4"></textarea>
				</div>
			  </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary">发送</button>
      </div>
    </div>
  </div>
</div>
<!-- 资格证-->
<div class="modal fade" id="handupBc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">资格证查看</h4>
      </div>
      <div class="modal-body">
	 <table class="table table-striped table-condensed" style="font-size: 15px">
		<tr>
			<th>职业资格证</th>
		</tr>
		<tbody id="qualif">
		<tr>
			<td><a abbr="大学时获得" id="txtHint"></a></td>
		</tr>
		</tbody>
	 </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
      </div>
    </div>
  </div>
</div>
<!-- 确认删除 -->
<div class="modal fade" id="handupCc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">确定删除</h4>
      </div>
      <div class="modal-body">
		  <div>您确定要删除以下人员吗？</div>
		  <table class="table table-striped table-condensed" style="font-size: 15px">
		<tr>
			<th>人员名单</th>
		</tr>
		<tr>
			<td><abbr title="员工编号：xyz11111119">yy</abbr></td>
		</tr>
		<tr>
			<td><abbr title="员工编号：xyz22221111">rr</abbr></td>
		</tr>
		<tr>
			<td><abbr title="员工编号：xyz33211111">kk</abbr></td>
		</tr>
	 </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
  <%@include file="/footer.jsp" %>
  </body>
</html>