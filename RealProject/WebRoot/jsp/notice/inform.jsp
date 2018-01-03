<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PlanManagement_NewMilestone</title>
	<%@include file="/head.jsp" %>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fozza.css" type="text/css">
   
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
 </head>
 <body> 
    
   	<!--主要内容-->
    <section style="min-height: 100%">
       <div class="container-fluid">
       <div class="row">
       <div class="col-lg-10 xumode">
					 <!-- Nav tabs -->
		  <ul class="nav nav-tabs" role="tablist" id="myTab">
			<li role="presentation"><a href="#taskinform" aria-controls="taskinform" role="tab" data-toggle="tab">任务消息&nbsp;<span class="badge">4</span></a></li>
			<li role="presentation"><a href="#sysinform" aria-controls="sysinform" role="tab" data-toggle="tab">系统信息&nbsp;<span class="badge">4</span></a></li>
			<li role="presentation"><a href="#checkinform" aria-controls="checkinform" role="tab" data-toggle="tab">审批消息&nbsp;<span class="badge">2</span></a></li>
		  </ul>

		  <!-- Tab panes -->
		  <div class="tab-content">
			<div role="tabpanel" class="tab-pane" id="taskinform">
				<div class="list-group">
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item">您有<strong>新的任务</strong><span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small">>>阶段名字可能短一些</span><span class="small"><a>&nbsp;>查看</a></span></button>
				</div>
			</div>
			<div role="tabpanel" class="tab-pane" id="sysinform">				
			  <div class="list-group">
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉出项目组<strong>进入项目A的名字特别特别特别长</strong></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				  <button type="button" class="list-group-item list-group-item-warning">您已经被<strong>用户A</strong>拉出项目组<strong>进入项目A的名字特别特别特别长</strong></button>
				  <button type="button" class="list-group-item">您已经被<strong>用户A</strong>拉入项目组<strong>进入项目A的名字特别特别特别长</strong><span class="small"><a>&nbsp;>进入项目</a></span></button>
				</div>
				</div>
				
				
			<!-- 在下要处理的审批信息 -->
			<div role="tabpanel" class="tab-pane" id="checkinform">
				<div class="list-group">
				  <button type="button" class="list-group-item list-group-item-success">您的项目<strong>项目A的名字特别特别特别长</strong>已通过审批<span class="small">&nbsp;>项目A的名字特别特别特别长</span><span class="small"><a>&nbsp;>查看</a></span></button>
				  <button type="button" class="list-group-item list-group-item-danger">您的报账<strong>任务三：报账理由</strong>未通过审批</button>
				  <button type="button" class="list-group-item">您的报账<strong>任务二：报账理由</strong>未通过审批</button>
				  <button type="button" class="list-group-item">您的报账<strong>任务一：报账理由</strong>通过审批</button>
				</div>
			</div>
		  </div>
       </div>
       </div>
       </div>
    </section>
    <script>
	$(function () {
		$('#myTab li:eq(0) a').tab('show');
	});
		
		
	/*注明：导航栏那个下拉菜单被我多加了个id叫navinform*/
	$(function () {
		var i;
		if(i == 0)
		{
		  $('#myTab li:eq(0) a').tab('show')
		}
		else if(i == 1)
		{
		  $('#myTab li:eq(1) a').tab('show')
		}
		else if(i == 2)
		{
		  $('#myTab li:eq(2) a').tab('show')
		}
		else{
		/*	随便写个什么错误提示
			*/
		}
	});
	</script>
    <footer class="copyright">
    <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
	</div>
	</footer>
</body>
</html>
    