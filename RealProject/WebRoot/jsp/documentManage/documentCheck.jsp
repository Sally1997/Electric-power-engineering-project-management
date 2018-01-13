<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	double d=Math.random();
	String flag = Double.toString(d);
	session.setAttribute("flag", flag);
 %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>项目资料</title>
	<%@include file="/head.jsp" %>
   <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
    <link href="public.css" rel="stylesheet" type="text/css">
</head>

<body>  
    <section>
       <div class="container-fluid">
       <div class="row">
           <div class="col-lg-10 col-sm-9 xumode">
           
			   <div class="container-fluid">
			   <div class="row">	
			   <form method="post" name="documentcheck">
			   		<input type="hidden" name=aflag value="<%=flag%>">
					<ul class="list-group">
					
					<c:forEach items="${documents}" var="document">
					  <li class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>${document.dtitle}</h4><br>
						  <p class="list-group-item-text">
					        <div class="row">
					            <div class="col-lg-9">
									<span>上传时间：</span><span>>${document.uploadtime}&nbsp;&nbsp;&nbsp;</span>
									<span>上传者：</span><span>${document.uloadpno}&nbsp;&nbsp;&nbsp;</span>
									<span>文件类型：</span><span>${document.ftype}&nbsp;&nbsp;&nbsp;</span>
								</div>
								<div class="col-lg-3">
								    <button type="submit" class="btn btn-default" onclick="downloadfile('${document.dno}')" >下载查看</button>
									<button type="submit" class="btn btn-primary" onclick="auditpass('${document.dno}','${document.uloadpno }')" >通过</button>
									<button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#noPassInfo" onclick="auditfail('${document.dno}','${document.uloadpno }')">不通过</button>
								</div>
                            </div>		                       
						   </p>
					  </li>
					  </c:forEach>
					</ul>
					</form>
					</div>	                	 
			   </div>
			   </div>
	       </div>
       </div>
       </div>
    </section>
	
	<!--      默认隐藏的内容:不通过理由-->
	<div class="modal fade bs-example-modal-lg" id="noPassInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
	    
      <div class="modal-body">
         <form class="form-horizontal">
		     <div class="form-group">
		     <label class="col-sm-2 control-label">不通过理由</label>
			 <div class="col-sm-8"><textarea class="form-control" rows=5 placeholder="审批意见可以为空"></textarea></div>
			 </div>
		 </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary">确认</button>
      </div>
    </div>
  </div>
</div>
    <%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
  	function auditpass(a,b){
  		
  		var p = document.getElementsByName("documentcheck")[0];
  		
  		p.action="${pageContext.request.contextPath}/web/servlet/auditGeneralFileServlet?type=true&dno="+a+"&who="+b;
  	}
  	function auditfail(a,b){
  		
  		var p = document.getElementsByName("documentcheck")[0];
  		p.action="${pageContext.request.contextPath}/web/servlet/auditGeneralFileServlet?type=&dno="+a+"&who="+b;
  		
  	}
  	function downloadfile(a){
  		var p = document.getElementsByName("documentcheck")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/downLoadMessage?dno="+a;
  		
  	}
  </script>
</html>

					