<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>相关项目报账信息</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="echarts.min.js"></script>
    <link href="public.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- 页眉-->   
    <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <!-- start logo -->
                    <span class="blanding"><img src="src/logo.png" width="100px">面向电力工程项目管理</span>
                    
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
            <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
              <li><a href="../moneymanage1130_03/01-projectmanagerfirst 01.html">项目管理</a></li>
              <li><a href="#">文档管理</a></li>
              <li class="active nav-current" role="presentation"><a href="#">资金管理<span class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a class="glyphicon glyphicon-off" title="注销" style="cursor: pointer"></a></li>
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
    <section>
        <div class="container-fluid">
            <div class="row">
              <div class="col-lg-10 xumode">
              <div class="panel panel-primary">
		        <div class="panel-heading"><span>相关项目报账信息</span><span class="noRight"  data-toggle="modal" data-target="#handupAc">报账</span></div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px">
					<tr>
						<th>项目名称</th>
						<th>项目阶段</th>
						<th>任务阶段</th>
						<th>报销人</th>
						<th>报账时间</th>
						<th>报账金额</th>
						<th>状态</th>
						<th> </th>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text_danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text_danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text_danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text_danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text_danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目B</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text_success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目B</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text_success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目B</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text_success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目B</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text_success">已审批</td>
						<td ></td>
					</tr>
	                <tr>
						<td >项目C</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥200.00元</td>
						<td  class="text_warning">未通过</td>
						<td class="text-danger">超标</td>
					</tr>
	

	        </table>
                                <!--  分页栏-->
				<nav aria-label="Page navigation" style="text-align: right">
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
              </div>
              </div>
            </div>
        </div>
                <!--      默认隐藏的内容:报账-->
	    <div class="modal fade" id="handupAc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h4 class="modal-title" id="myModalLabel">报账</h4>
		  </div>
		  <div class="modal-body">
			  <form class="form-horizontal">
				  <div class="form-group">
					<label class="col-sm-2 control-label">报账项目</label>
					<div class="col-sm-8">
					<select class="form-control">
					  <option>项目A</option>
					  <option>项目B</option>
					  <option>项目C</option>
					</select>
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-sm-2 control-label">项目阶段</label>
					<div class="col-sm-8">
					<select class="form-control">
					  <option>阶段一</option>
					  <option>阶段二</option>
					  <option>阶段三</option>
					  <option>阶段四</option>
					  <option>阶段五</option>
					  <option>阶段六</option>
					  <option>阶段七</option>
					  <option>阶段八</option>
					</select>
					</div>
				  </div>
				  <div class="form-group">
					<label class="col-sm-2 control-label">报账任务</label>
					<div class="col-sm-8">
					<select class="form-control">
					  <option>任务一</option>
					  <option>任务二</option>
					  <option>任务三</option>
					  <option>任务四</option>
					  <option>任务五</option>
					  <option>任务六</option>
					  <option>任务七</option>
					  <option>任务八</option>
					</select>
					</div>
				  </div>			  
				  <div class="form-group">
					<label class="col-sm-2 control-label">报账金额</label>
					<div class="col-sm-8">
					  <div class="input-group">
					  <div class="input-group-addon">￥</div>
					  <input type="password" class="form-control" id="inputPassword3">
					  <div class="input-group-addon">（元）</div>
					  </div>
					</div>
				  </div>
				 <div class="form-group">
					<label  class="col-sm-2 control-label">超标原因</label>
					<div class="col-lg-8">
					  <textarea class="form-control" rows="4"></textarea>
					</div>
				  </div>
			  </form>
		  </div>
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
			<button type="button" class="btn btn-primary">报账</button>
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
</body>
</html>
