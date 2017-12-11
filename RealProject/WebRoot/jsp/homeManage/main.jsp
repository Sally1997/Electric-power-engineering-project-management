<%@page import="java.util.HashMap"%>
<%@page import="com.holyshit.domain.Document"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
    <!-- Bootstrap -->
  
</head>

<body>
	<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
    <section>
    	<div class="container-fluid">
    	  <div class="row">
    	    <div class="col-lg-12">  
			  <div class="col-lg-8"> 
    	        <div class="panel panel-primary">
    	            <div class="panel-heading">项目任务列表<span class="more">more..</span></div>
    	            <div class="panel-body">
    	              <div class="row">
					    <div class="col-lg-12">
							<span>当前任务数量：</span><span>${fn:length(tasks)}</span>
							<span class="more">
							 <a href="#" style="margin-right: 15px" onclick = "">按时间排序</a>
							</span>
						</div>
   	                  <div class="col-lg-10 jimode">
    	              <table class="table table-striped">
    	                <tr>
    	                <th>项目名称</th>
    	                <th>任务</th>
    	                <th>开始时间</th>
    	                <th>截止时间</th>
    	                <th>状态</th>
    	                </tr>
						<c:forEach items="${tasks }" var="task" varStatus="hehe" begin="0" end="4" step="1">
						  <c:choose>
  							<c:when test="${task.tstate=='1' }">
    	                      <tr>
							  <td onClick="window.open(${pageContext.request.contextPath})" title="${projectNames[hehe.index] }" name="myabbr" >${projectNames[hehe.index] }<span class="badge">new</td>
							  <td title="${task.taskname }" name="myabbr" >${task.taskname }</td>
							  <td>${task.stime }</td>
							  <td>${task.etime }</td>	
							  <td class="text-success">正常进行中</td>	
							  </tr>
							</c:when>
							<c:when test="${task.tstate=='2' }">
							  <tr>
						      <td onClick="window.open()" title="${projectNames[hehe.index] }" name="myabbr" >${projectNames[hehe.index] }<span class="badge">new</td>
							  <td title="${task.taskname }" name="myabbr" >${task.taskname }</td>
							  <td>${task.stime }</td>
							  <td>${task.etime }</td>	
							  <td class="text-danger">逾期进行中</td>	
							  </tr>
							  </c:when>
  						  </c:choose>
  						</c:forEach>
    	              </table>
    	              </div>
    	            </div>
    	        </div>
    	      </div>
    	        <div class="panel panel-primary">
						<div class="panel-heading">项目进度列表<span class="more">more..</span></div>
						<div class="panel-body">
						  <div class="row">
						  <div class="col-lg-12">
								<span>当前参与的项目数量：</span><span>${fn:length(projects) }</span>
								<span class="more">
								 <a href="#" style="margin-right: 15px" onclick = "">按时间排序</a>
								</span>
							</div>
						  <div class="col-lg-10 jimode">
					<!--	  进度条的占比需要修改标签内的style:width属性-->
						  <table class="table table-striped">
							<tr>
							<th>项目名称</th>
							<th>项目进度</th>
							<th>开始时间</th>
							<th>截止时间</th>
							<th>状态</th>
							</tr>
							<c:forEach items="${projects }" var="project" begin="0" end="4">
							
							<c:choose>
	  							<c:when test="${project.pstate=='1' }">
								<tr>
							    <td onClick="window.open()" title="${project.pname }" name="myabbr" >${project.pname }</td>
							    <td><div class="progress">
							    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: ${project.pstage*100}%;min-width: 2em;">
							    ${project.pstage*100}%
							    </div>
							    </div></td>
							    <td>${project.stime }</td>
							    <td>${project.etime }</td>
								<td class="text-success">正在进行中</td>
								</c:when>
	  						</c:choose>
	  						<c:choose>
	  							<c:when test="${project.pstate=='2' }">
								<tr>
							    <td onClick="window.open()" title="${project.pname }" name="myabbr" >${project.pname }</td>
							    <td><div class="progress">
							    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: ${project.pstage*100}%;min-width: 2em;">
							    ${project.pstage*100}%
							    </div>
							    </div></td>
							    <td>${project.stime }</td>
							    <td>${project.etime }</td>
								<td class="text-danger">逾期进行中</td>
								</c:when>
	  						</c:choose>
	  						
						  </c:forEach>   	          
						  </table>
						  </div>
						</div>
					</div>
				  </div>
    	      </div>
    	      <div class="col-lg-4">
    	        <div class="panel panel-primary">
    	        	<div class="panel panel-heading">公告中心<span class="more">more..</span></div>
						<div class="list-group">
						  <a href="#" class="list-group-item">第五次会议通知<br><span class="uptime small">2017/10/24</span></a>
						  <a href="#" class="list-group-item">第四次会议通知<br><span class="uptime small">2017/10/24</span></a>
						  <a href="#" class="list-group-item">第三次会议通知<br><span class="uptime small">2017/10/24</span></a>
						  <a href="#" class="list-group-item">第二次会议通知<br><span class="uptime small">2017/10/24</span></a>
						  <a href="#" class="list-group-item">第一次会议通知<br><span class="uptime small">2017/10/24</span></a>
						</div>
    	        </div>
    	    <!--    你们先做成这个地方点击就能直接下载文件吧……-->
    	        <div class="panel panel-primary">
    	        	<div class="panel panel-heading">最新消息<span class="more">more..</span></div>
						<div class="list-group">
  						    <c:forEach items="${staffDoc['docs'] }" begin="0" end="7" step="1" var="doc">
						      <a href="${pageContext.request.contextPath}/web/servlet/downLoadMessage?dno=${doc.dno}" class="list-group-item"><span class="glyphicon glyphicon-file"></span>${doc.dtitle }<br><div class="small"><span class="uptime">><fmt:formatDate value="${doc.uploadtime }" type="both"/></</span>&nbsp;&nbsp;&nbsp;<span>上传者：${doc.uloadpno }</span>&nbsp;&nbsp;&nbsp;<span>文件类型：${doc.ftype }</span></div></a>
						    </c:forEach>
						</div>
    	        </div>
    	        </div>
    	      </div>
    	    </div>
    	  </div>
    	</div>
    </section>
    <footer class="copyright">
    <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
	</div>
	</footer>
	<!--实现文本缩略-->
	<script type="text/javascript"> 
    var mylist = document.getElementsByName("myabbr");
	for (var i = 0; i < mylist.length; i++){
		mylist[i].innerHTML = mylist[i].innerHTML.substring(0, 8)+"...";
	}
	</script>
</body>
</html>
