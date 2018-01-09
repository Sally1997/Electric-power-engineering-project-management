<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>消息管理</title>
	<%@include file="/head.jsp" %>
 </head>
 <script type="text/javascript">
 	var jsonData="";
 	function updateSystem(a,b,c){
  		var p = document.getElementsByName("sysinfomation")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/jumpSystemInfoServlet?type="+a+"&pno="+b+"&mno="+c;
  		
  	}
 </script>
 <body> 
    
   	<!--主要内容-->
    <section style="min-height: 100%">
       <div class="container-fluid">
       <div class="row">
       <div class="col-lg-10 xumode">
					 <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist" id="myTab">
			<li role="presentation"><a href="#taskinform" aria-controls="taskinform" role="tab" data-toggle="tab">任务消息&nbsp;<span class="badge">${task_num }</span></a></li>
			<li role="presentation"><a href="#sysinform" aria-controls="sysinform" role="tab" data-toggle="tab">系统信息&nbsp;<span class="badge">${system_num }</span></a></li>
			<li role="presentation"><a href="#checkinform" aria-controls="checkinform" role="tab" data-toggle="tab">审批消息&nbsp;<span class="badge">${audit_num }</span></a></li>
		  </ul>

		  <!-- Tab panes -->
		  <div class="tab-content">
			<div role="tabpanel" class="tab-pane" id="taskinform">
				<form method="post" name="taskinfomation">
				<div class="list-group">
				<c:forEach items="${tasksinfo }" var="t">
				<c:choose>
				  <c:when test="${t.mtype=='T2'&&t.hasread=='0' }">
				  <button type="button" class="list-group-item">您有<strong>新的任务</strong><span class="small">&nbsp;>${t.pname}</span><span class="small">>>${t.sname}</span></span><span class="small">>>${t.taskname}></span><span class="small"><a onclick="window.open('${pageContext.request.contextPath }/web/servlet/canJumpProServlet?pno=${t.pno}&mno=${t.mno }')" >&nbsp;查看</a></span><span class="list-group-item-text" style="float:right">${t.mdate}</span></button>
				  </c:when>
				  <c:when test="${t.mtype=='T0'&&t.hasread=='0' }">
				  <button type="button" class="list-group-item">您有<strong>新的阶段任务</strong><span class="small">&nbsp;>${t.pname}</span><span class="small">>>${t.sname}></span></span><span class="small"><a onclick="window.open('${pageContext.request.contextPath }/web/servlet/canJumpProServlet?pno=${t.pno}&mno=${t.mno }')">&nbsp;查看</a></span><span class="list-group-item-text" style="float:right">${t.mdate}</span></button>
				  </c:when>
				  <c:when test="${t.mtype=='T3'&&t.hasread=='0' }">
				  <button type="button" class="list-group-item" >您有<strong>新的任务(成为负责人)</strong><span class="small">&nbsp;>${t.pname}</span><span class="small">>>${t.sname}</span></span><span class="small">>>${t.taskname}</span><span class="small"><a onclick="window.open('${pageContext.request.contextPath }/web/servlet/canJumpProServlet?pno=${t.pno}&mno=${t.mno }')">&nbsp;>查看</a></span><span class="list-group-item-text" style="float:right">${t.mdate}</span></button>
				  </c:when>
				  <c:when test="${t.mtype=='T1'&&t.hasread=='0' }">
				  <button type="button" class="list-group-item" >您有<strong>新的阶段任务(成为负责人)</strong><span class="small">&nbsp;>${t.pname}</span><span class="small">>>${t.sname}</span><span class="small"><a onclick="window.open('${pageContext.request.contextPath }/web/servlet/canJumpProServlet?pno=${t.pno}&mno=${t.mno }')">&nbsp;>查看</a></span><span class="list-group-item-text" style="float:right">${t.mdate}</span></button>
				  </c:when>
				</c:choose>
				</c:forEach>
				</div>
				
				</form>
			</div>
			<div role="tabpanel" class="tab-pane" id="sysinform">
			   <form method="post" name="sysinfomation">			
			    <div class="list-group">
			    <c:forEach items="${systemsinfo}" var="s">
			    <c:choose>
			     <c:when test="${s.mtype=='S0'&&s.hasread=='0' }">
				  <button type="submit" class="list-group-item" onclick="updateSystem('1','${s.pno}','${s.mno }')">您已经被拉入项目组<strong>${s.pname}</strong><span class="small">><a onclick="window.open('${pageContext.request.contextPath }/web/servlet/canJumpProServlet?pno=${s.pno}')">&nbsp;进入项目</a></span><span class="list-group-item-text" style="float:right">${s.mdate}</span></button>
				 </c:when>
				  
				 <c:when test="${s.mtype=='S1'&&s.hasread=='0' }">
				  <button type="submit" class="list-group-item" onclick="updateSystem('2','${s.pno}','${s.mno }')">您已经被拉出项目组<strong>${s.pname}</strong><span class="list-group-item-text" style="float:right">${s.mdate}</span></button>
				 </c:when> 
				 
				 <c:when test="${s.mtype=='S2'&&s.hasread=='0' }">
				  <button type="submit" class="list-group-item" onclick="updateSystem('3','${s.pno}','${s.mno }')">您的信息已被管理员修改><span class="small"><a onclick="window.open('${pageContext.request.contextPath }/web/showUserCenterServlet')">&nbsp;进入个人中心查看</a></span><span class="list-group-item-text" style="float:right">${s.mdate}</span></button>
				 </c:when>
				  
				 <c:when test="${s.mtype=='S3'&&s.hasread=='0' }">
				  <button type="submit" class="list-group-item" onclick="updateSystem('4','${s.pno}','${s.mno }')">您的密码已被管理员修改<span class="list-group-item-text" style="float:right">${s.mdate}</span></button>
				 </c:when> 
				 
				 <c:when test="${s.mtype=='S4'&&s.hasread=='0' }">
				  <button type="submit" class="list-group-item" onclick="updateSystem('5','${s.pno}','${s.mno }')">您的权限已被管理员修改<span class="small"></span><span class="list-group-item-text" style="float:right">${s.mdate}</span></button>
				 </c:when> 
				  
			   </c:choose>
			   </c:forEach>
			  </div>
			 </form>

			</div>
				
				
			<!-- 在下要处理的审批信息 -->
			<div role="tabpanel" class="tab-pane" id="checkinform">
				<div class="list-group" id="auditTable">
				 
				</div>
			</div>
		  </div>
       </div>
       </div>
       </div>
    </section>
    <script>
    //发送请求获取数据
    function getData(type,e){
    	var req=new XMLHttpRequest();
    	req.onreadystatechange=function(){
    		if(req.readyState==4&&req.status==200){
    			jsonData=eval('('+req.responseText+')');
    			
    			//对表格进行刷新
    			for(var i=0;i<jsonData.length;i++){
    				if(jsonData[i].mtype=="A0"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					var msg="任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					if(jsonData[i].ofeereason!="")
    						msg+=",超标原因：<strong>"+jsonData[i].ofeereason+"</strong>";
    					msg+="报账需要您审核！";
    					node.innerHTML=msg;
    					node.value=i;
    					
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A1"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您的报账任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>,审批意见:<strong>"+jsonData[i].auditadv+"</strong>未通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A2"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您的报账任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>,审批意见:<strong>"+jsonData[i].auditadv+"</strong>已经通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A3"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近上传的文件：<strong>"+jsonData[i].dtitle+"</strong>已经通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A4"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近上传的文件：<strong>"+jsonData[i].dtitle+"</strong>未通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A5"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="任务：<strong>"+jsonData[i].taskname+"</strong>已经提交，等待您的审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A6"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近提交的任务：<strong>"+jsonData[i].taskname+"</strong>已经通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A7"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近提交的任务：<strong>"+jsonData[i].taskname+"</strong>没有通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A8"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="阶段：<strong>"+jsonData[i].sname+"</strong>已经提交，等待您的审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A9"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近提交的阶段：<strong>"+jsonData[i].sname+"</strong>已经通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A10"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您最近提交的阶段：<strong>"+jsonData[i].sname+"</strong>没有通过审核!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A11"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="项目：<strong>"+jsonData[i].pname+"</strong>正在立项，等待您的审批!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A12"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您的项目：<strong>"+jsonData[i].pname+"</strong>立项成功!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    				if(jsonData[i].mtype=="A13"){
    					var node=document.createElement("button");
    					node.type="button";
    					node.className="list-group-item";
    					node.innerHTML="您的项目：<strong>"+jsonData[i].pname+"</strong>立项失败!"+'<span class="list-group-item-text" style="float:right">'+jsonData[i].mdate+'</span>';
    					node.value=i;
    					//test
    					
    					node.onclick=function(){
    						var i=window.parseInt(this.value);
   							hasRead(i);
    					};
    					e.appendChild(node);
    				}
    			}
    		}
    	};
    	req.open("get", "/RealProject/web/servlet/getInformList?type="+type);
    	req.send(null);
    }
    
    //读取消息
    function hasRead(index){
    	var req=new XMLHttpRequest();
    	req.onreadystatechange=function(){
    		if(req.readyState==4&&req.status==200){
    			if(req.responseText=="ok"){
    				//进行跳转
    				//跳转到资金管理界面
    				if(jsonData[index].mtype=="A0"||jsonData[index].mtype=="A1"||jsonData[index].mtype=="A2"){
    					location.href="/RealProject/web/servlet/showbudgetpage?currentPage=1&pageSize=3";
    				}
    				//跳转到文档管理界面
    				if(jsonData[index].mtype=="A3"||jsonData[index].mtype=="A4"){
    					location.href="/RealProject/jsp/documentManage/document.jsp";
    				}
    				//任务指标审批
    				if(jsonData[index].mtype=="A5"||jsonData[index].mtype=="A6"||jsonData[index].mtype=="A7"){
    					location.href="/RealProject/web/servlet/showIndexAudit?mno="+jsonData[index].mno;
    				}
    				//阶段指标审核
    				if(jsonData[index].mtype=="A8"||jsonData[index].mtype=="A9"||jsonData[index].mtype=="A10"){
    					location.href="/RealProject/web/servlet/showIndexAudit?mno="+jsonData[index].mno;
    				}
    				//跳转到项目管理首页
    				if(jsonData[index].mtype=="A11"){
    					location.href="/RealProject/web/servlet/showProAuditServlet?mno="+jsonData[index].mno;
    				}
    				if(jsonData[index].mtype=="A12"){
    					location.href="/RealProject/web/servlet/judgeStageExist?pno="+jsonData[index].pno;
    				}
    				if(jsonData[index].mtype=="A13"){
    					location.href="/RealProject/servlet/ShowProjectServlet";
    				}
    				//跳转
    				
    				
    				
    			}else{
    				alert("服务器繁忙，请稍后重试！");
    			}
    		}
    	};
    	req.open("get", "/RealProject/web/servlet/readInform?mno="+jsonData[index].mno);
    	req.send(null); 
    }
    
	$(function () {
		$('#myTab li:eq(${cur}) a').tab('show');
		getData("A",document.getElementById("auditTable"));
	});
	</script>
    
    <%@include file="/footer.jsp" %>
</body>
</html>

    