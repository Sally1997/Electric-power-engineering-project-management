<%@page import="java.util.Map"%>
<%@page import="com.holyshit.service.impl.InformServiceImpl"%>
<%@page import="com.holyshit.service.InformService"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.holyshit.domain.Staff" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/yqz.js"></script>
<!-- 项目logo -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" type="image/x-icon" />

<!-- 页眉-->   
     <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><img src="${pageContext.request.contextPath }/image/logo.png" width="100px">面向电力工程项目管理</span>
                    
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

    <!-- 导航栏-->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav" id="head_menu">
              <li><a href="${pageContext.request.contextPath}/web/servlet/mainServlet">首页</a></li>
              <li><a href="${pageContext.request.contextPath}/servlet/ShowProjectServlet">项目管理</a></li>
              <li><a href="${pageContext.request.contextPath}/jsp/documentManage/document.jsp">文档管理</a></li>
              <li><a href="${pageContext.request.contextPath}/web/servlet/showbudgetpage?currentPage=1&pageSize=3">资金管理</a></li>
            </ul>
            <script type="text/javascript">
				var head=document.getElementById("head_menu");
				var menus=head.getElementsByTagName("li");
			</script>
            <ul class="nav navbar-nav navbar-right">
              <li><a class="glyphicon glyphicon-off" title="注销" style="cursor: pointer" href="${pageContext.request.contextPath}/web/servlet/logout"></a></li>
              <li><a href="${pageContext.request.contextPath }/web/showUserCenterServlet">${staff.name }</a></li>
              <li><a href="${pageContext.request.contextPath }/web/servlet/shouInformServlet?type=1">通知<span class="badge">${all_num }</span></a></li>
              <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"  aria-haspopup="true" aria-expanded="false"><span class="caret"></span></a>
              		 
              		<!--  通知<span class="badge">10</span> -->
				  <ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath }/web/servlet/shouInformServlet?type=1">任务消息<span class="badge" style="float: right">${task_num }</span></a></li>
					<li><a href="${pageContext.request.contextPath }/web/servlet/shouInformServlet?type=2">系统信息<span class="badge" style="float: right">${system_num }</span></a></li>
		            <li><a href="${pageContext.request.contextPath }/web/servlet/shouInformServlet?type=3">审批消息<span class="badge" style="float: right">${audit_num }</span></a></li>
			     	<c:if test="${not empty enableCheckDocument }">
              			<li><a href="${pageContext.request.contextPath }/web/servlet/showDocumentCheckServlet">文档审核&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-tag"></span></a></li>
              		</c:if>
              		<c:if test="${not empty enablePublicNotice }">
              			<li><a href="javascript:$('#handupNews').modal('show')">发布公告&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="	glyphicon glyphicon-list-alt"></span></a></li>
              		</c:if>
			      </ul>
              </li>
              
            </ul>
         </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
     </nav>
  </div>
  
  
  			<!-- 全局模块 -->
    <!--  默认隐藏的内容:发布公告-->
  <div class="modal fade" id="handupNews" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">发布公告</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
			  <div class="form-group">
					<span style="color: red;position: relative;left: 10%;">提示：请上传正确的html文件</span>
			  </div>
		  		<div class="form-group">
				<label for="newsname" class="col-sm-2 control-label">公告主题</label>
				<div class="col-sm-8">
		            <input type = "text" id="newstitle">
				</div>
			  </div>
		  
			  	<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">公告文件</label>
				<div class="col-sm-8">
		            <input type = "file" id="newsfile" multiple="multiple">
				</div>
			  </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary" onclick="submitNotice();">发布</button>
      </div>
    </div>
  </div>
</div>
<script>
//ajax请求上传文件
function submitNotice(){
	
	var formdata=new FormData();
	var file=document.getElementById("newsfile").files;
	var filename=document.getElementById("newsfile").value;
	//数据校验
	if(document.getElementById("newstitle").value==""){
		alert("请输入公告标题");
		return;
	}
	if(filename==""){
		alert("请选择上传公告文件");
		return;
	}
	var houzhui=filename.substring(filename.indexOf(".")+1,filename.length);
	if(houzhui!="html"){
		alert("请上传html文件");
		return;
	}
	formdata.append("file_1",file[0]);
	formdata.append("noticetitle",document.getElementById("newstitle").value);
	var req=new XMLHttpRequest();
	req.onreadystatechange=function(){
		if(req.readyState==4){
			clearLoadPage();
			if(req.status==200){
				if(req.responseText=="ok"){
					alert("公告发布成功");
					location.reload(true);
				}else{  //显示报错信息
					alert(req.responseText);	
				}
			}
		}
	};
	
	req.open("post", "${pageContext.request.contextPath}/web/servlet/uploadNotice");
	req.send(formdata);
	loadPageFlag=setTimeout('loadPage()',100);
}
</script>