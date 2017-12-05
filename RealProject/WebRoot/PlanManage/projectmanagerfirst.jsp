<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--底边栏没改-->
<!--还有一堆冗余没搞懂-->
<%@ include file="/PlanManage/AddUser.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>01-projectmanagerfirst</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css">
   

  </head>
  <body> 
   <!-- 页眉-->   
     <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><img src="${pageContext.request.contextPath }/src/logo.png" width="100px">面向电力工程项目管理</span>
                    
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

    <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
              <li class="active nav-current" role="presentation"><a href="#">项目管理<span class="sr-only">(current)</span></a></li>
              <li><a href="#">文档管理</a></li>
              <li><a href="moneymanage.html">资金管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">用户XXX</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"  aria-haspopup="true" aria-expanded="false">通知<span class="badge">10</span> <span class="caret"></span></a>
				  <ul class="dropdown-menu">
					<li><a href="#">聊天消息<span class="badge" style="float: right">4</span></a></li>
					<li><a href="#">审核信息<span class="badge" style="float: right">4</span></a></li>
		            <li><a href="#">任务<span class="badge" style="float: right">2</span></a></li>
			      </ul>
              </li>
            </ul>
         </div><!-- /.navbar-collapse -->
       </div><!-- /.container-fluid -->
     </nav>
  </div>
<!--  主要内容-->
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
		    <tr>
			    <td align="left" id="pro1_1">1111111111</td>
			    <td align="left">
			    	<div class="dropdown"><span id="pro1_2"></span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
				</td>
			    <td align="left" id="pro1_1">OO</td>
			    <td align="left" id="pro1_1">开发人员</td>
			    <td align="left" id="pro1_1">设计类</td>
			    <td align="left" id="pro1_1">进行中</td>
		    </tr>
		    <tr>
			    <td align="left">1111111112</td>
			    <td align="left">
			    	<div class="dropdown">test02
			    	<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
			    </td>
			    <td align="left">yy</td>
			    <td align="left">开发人员</td>
			    <td align="left">工程类</td>
			    <td align="left">进行中</td>
		    </tr>
		    <tr>
			    <td align="left">1111111113</td>
			    <td align="left">
			    	<div class="dropdown">test03
			    	<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
			    </td>
			    <td align="left">xx</td>
			    <td align="left">开发人员</td>
			    <td align="left">设计类</td>
			    <td align="left">进行中</td>
		    </tr>
		    <tr>
			    <td align="left">1111111114</td>
			    <td align="left">
			    	<div class="dropdown">test04
			    	<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
			    </td>
			    <td align="left">OO</td>
			    <td align="left">开发人员</td>
			    <td align="left">设计类</td>
			    <td align="left">进行中</td>
		    </tr>
		    <tr>
			    <td align="left">1111111115</td>
			    <td align="left">
			    	<div class="dropdown">test05
			    	<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
			    </td>
			    <td align="left">Ox</td>
			    <td align="left">开发人员</td>
			    <td align="left">设计类</td>
			    <td align="left">进行中</td>
		    </tr>

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
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
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
        </form>
      </div>
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
	window.onload = function(){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var ss = eval("("+aja.responseText+")");
				
			}
		}	
	}
	//创建链接
	aja.open("get", "${pageContext.request.contextPath }/servlet/ShowProjectServlet");
	//
	aja.send(null);
</script>
</html>