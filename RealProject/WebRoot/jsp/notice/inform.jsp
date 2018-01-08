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
				<div class="list-group" id="taskTable">
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="sysinform">				
			  <div class="list-group" id="systemTable">
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉出项目组<strong>进入项目A的名字特别特别特别长</strong></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉出项目组<strong>进入项目A的名字特别特别特别长</strong></button>
				  <button type="button" class="list-group-item">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				</div>
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
    					var msg="任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>";
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
    					node.innerHTML="您的报账任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>,审批意见:<strong>"+jsonData[i].auditadv+"</strong>未通过审核!";
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
    					node.innerHTML="您的报账任务：<strong>"+jsonData[i].taskname+"</strong>，金额：<strong>"+jsonData[i].fee+"</strong>,审批意见:<strong>"+jsonData[i].auditadv+"</strong>已经通过审核!";
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
    					node.innerHTML="您最近上传的文件：<strong>"+jsonData[i].dtitle+"</strong>已经通过审核!";
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
    					node.innerHTML="您最近上传的文件：<strong>"+jsonData[i].dtitle+"</strong>未通过审核!";
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
    					node.innerHTML="任务指标：<strong>"+jsonData[i].dtitle+"</strong>已经上传，等待您的审核!";
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
    					node.innerHTML="您最近上传的任务指标：<strong>"+jsonData[i].dtitle+"</strong>已经通过审核!";
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
    					node.innerHTML="您最近上传的任务指标：<strong>"+jsonData[i].dtitle+"</strong>没有通过审核!";
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
    					node.innerHTML="阶段指标：<strong>"+jsonData[i].dtitle+"</strong>已经上传，等待您的审核!";
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
    					node.innerHTML="您最近上传的阶段指标：<strong>"+jsonData[i].dtitle+"</strong>已经通过审核!";
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
    					node.innerHTML="您最近上传的阶段指标：<strong>"+jsonData[i].dtitle+"</strong>没有通过审核!";
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
    					node.innerHTML="项目：<strong>"+jsonData[i].pname+"</strong>正在立项，等待您的审批!";
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
    					node.innerHTML="您的项目：<strong>"+jsonData[i].pname+"</strong>立项成功!";
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
    					node.innerHTML="您的项目：<strong>"+jsonData[i].pname+"</strong>立项失败!";
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
    				//跳转到树状图
    				if(jsonData[index].mtype=="A5"||jsonData[index].mtype=="A6"||jsonData[index].mtype=="A7"||jsonData[index].mtype=="A8"||jsonData[index].mtype=="A9"||jsonData[index].mtype=="A10"){
    					location.href="/RealProject/servlet/DTreeNodeServlet?pno="+jsonData[index].pno;
    				}
    				//跳转到项目管理首页
    				if(jsonData[index].mtype=="A11"||jsonData[index].mtype=="A12"||jsonData[index].mtype=="A13"){
    					location.href="/RealProject/servlet/ShowProjectServlet";
    				}
    				
    				
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

    