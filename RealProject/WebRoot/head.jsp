<%@ page language="java" pageEncoding="UTF-8"%>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/yqz.js"></script>

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
              <li><a href="#">用户XXX</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"  aria-haspopup="true" aria-expanded="false">通知<span class="badge">10</span> <span class="caret"></span></a>
				  <ul class="dropdown-menu">
					<li><a href="#">任务消息<span class="badge" style="float: right">4</span></a></li>
					<li><a href="#">系统信息<span class="badge" style="float: right">4</span></a></li>
		            <li><a href="#">审批消息<span class="badge" style="float: right">2</span></a></li>
			      </ul>
              </li>
            </ul>
         </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
     </nav>
  </div>