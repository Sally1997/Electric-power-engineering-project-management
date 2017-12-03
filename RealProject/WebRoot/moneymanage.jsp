<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>资金管理</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/yqz.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
   	<script type="text/javascript">
   		//ajax请求
   		function getProjectBudgetDetails(cur){
   			var req = new XMLHttpRequest();
   			req.onreadystatechange=function(){
   				if(req.readyState==4){
   					if(req.status==200){
   						var res=req.responseText;
   						//数据刷新
   						var data=eval('('+res+')');
   						dataJson=data.budgets;
   						currentPage=data.currentPage;
					 	pageSize=data.pageSize;
					    pageNum=data.pageNum;  
					 	totalNum=data.totalNum; 
   						projectNum=data.projectNum;	
   						refreshData();	
   					}
   				}
   			};
   			
   			req.open("post", "${pageContext.request.contextPath}/web/servlet/showbudgetpage?currentPage="+cur+"&pageSize=3");
   			req.send(null);
   		}
   		
   		//刷新数据
   		function refreshData(){
   			var chart1=document.getElementById("chart1");
   			var chart2=document.getElementById("chart2");
   			var chart3=document.getElementById("chart3");
   			if(projectNum>=1){
   				//显示输出
   				chart1.style.display="block";
   				chart2.style.display="none";
   				chart3.style.display="none";
   				var myChart1 = echarts.init(document.getElementById('chart1'));

				// 指定图表的配置项和数据

				var option1 = {
					textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[0].pname,
							backgroundColor:'#e8e8e8',
							link:'login.html',
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15]
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'3%',
						left:'20%',
						itemGap:15
					},


					grid: {
						left: '20%',
						right: '20%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[0].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[0].hasaudit,
							barMaxWidth:40

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[0].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[0].over
							

						}
						]

				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart1.setOption(option1);		
   			}
   			if(projectNum>=2){
   				chart2.style.display="block"
   				var myChart2 = echarts.init(document.getElementById('chart2'));

				// 指定图表的配置项和数据

				var option2 = {
					textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[1].pname,
							backgroundColor:'#e8e8e8',
							link:'login.html',
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15]
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'3%',
						left:'20%',
						itemGap:15
					},


					grid: {
						left: '20%',
						right: '20%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[1].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[1].hasaudit,
							barMaxWidth:40

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[1].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[1].over
							

						}
						]

				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart2.setOption(option2);
   			}
   			if(projectNum>=3){
   				chart3.style.display="block";
   				var myChart3 = echarts.init(document.getElementById('chart3'));

				// 指定图表的配置项和数据

				var option3 = {
					textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[2].pname,
							backgroundColor:'#e8e8e8',
							link:'login.html',
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15]
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'3%',
						left:'20%',
						itemGap:15
					},


					grid: {
						left: '20%',
						right: '20%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[2].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[2].hasaudit,
							barMaxWidth:40

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[2].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[2].over
							

						}
						]

				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart3.setOption(option3);
   			}		
   		}
   	</script>

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

    <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
              <li><a href="../moneymanage1130_03/01-projectmanagerfirst 01.html">项目管理</a></li>
              <li><a href="#">文档管理</a></li>
              <li class="active nav-current" role="presentation"><a href="#">资金管理<span class="sr-only">(current)</span></a></li>
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
    		<div id="digram" class="col-lg-8">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">相关项目资金状况</div>
      	        <div class="panel-body">
       	        <div class="col-lg-12">
       	            <span style="float: left;margin-left: 30px;color:#52658f">正在进行的项目</span>
        	         <a href="#" class="selfbutton"style="margin-right: 15px" onclick = "document.getElementById('searchto').style.display='block';document.getElementById('fade').style.display='block'">查找..</a>
                    </span>
                </div>
                <div class="col-lg-12" style="margin-top: 20px;margin-left: 5%"> 
                    <div class="row">
					<div class="col-lg-12">
						<!-- 3张表格 -->
						<div class="digramchart" id="chart1" style="margin-bottom: 20px"></div>
						<div class="digramchart" id="chart2" style="margin-bottom: 20px"></div>
						<div class="digramchart" id="chart3" style="margin-bottom: 20px"></div>
						
					<!-- 获取json对象 -->
						 <script type="text/javascript">
						 	var dataJson=eval('('+'${projects["budgets"]}'+')');
						 
						 	var currentPage=${projects['currentPage']};
						 	var pageSize=${projects['pageSize']};
						   	var pageNum=${projects['pageNum']};  
						 	var totalNum=${projects['totalNum']};
						 	var projectNum=${projects['projectNum']};
						 	refreshData(); 
						 </script>
					
		 
					</div> 
					 
                    </div>
                </div>
                </div>
                <!--  分页栏-->
				<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination" id="showpage">
				  	<script type="text/javascript">
				  		var showpage=document.getElementById("showpage");
				  	</script>
					<li>
					  <a href="javascript:getPreviousOnBudget(showpage);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li class="active"><a href="javascript:jmpPage(1)">1</a></li>
					<script type="text/javascript">
						if(pageNum<5){
							for(var i=2;i<=pageNum;i++){
								var node=document.createElement("li");
								node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
								showpage.appendChild(node);
							}
						}else{
							for(var i=2;i<6;i++){
								var node=document.createElement("li");
								node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
								showpage.appendChild(node);
							}
						}
					</script>
					<li>
					  <a href="javascript:getNextOnBudget(showpage);" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				  </ul>
				</nav>	
            </div> 		
    		</div>

	<!--	报账-->
    		<div id="account" class="col-lg-4" style="padding-left: 30px">
	        <div class="panel panel-primary">
		        <div class="panel-heading">相关项目报销信息</div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th>项目名称</th>
			    <th>报销人</th>
			    <th>报账时间</th>
			    <th>状态</th>
			    <th> </th>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
			    </td>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			   <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		    </tr>

	        </table>
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
                <div>
                <button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc">报账</button>
                <br><br>
            </div>
                </div>
            </div>
    	    </div>
    	    
    	    <!--审批-->
    	    <div id="accountPass" class="col-lg-4" style="padding-left: 30px">
	        <div class="panel panel-primary">
		        <div class="panel-heading">相关项目审批信息</div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th>项目名称</th>
			    <th>报销人</th>
			    <th>报账时间</th>
			    <th>状态</th>
			    <th> </th>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
			    </td>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			   <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  style="color:red">未审批</td>
			    <td >			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
		    </tr>

	        </table>
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
                <div>
                <button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc">审批</button>
                <br><br>
            </div>
                </div>
            </div>
    	    </div>
    	    
    	</main>
    </div>
  </section>
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
				<label for="inputEmail3" class="col-sm-2 control-label">报账项目</label>
				<div class="col-sm-8">
			    <select class="form-control">
				  <option>项目A</option>
				  <option>项目B</option>
				  <option>项目C</option>
				</select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">项目阶段</label>
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
				<label for="inputPassword3" class="col-sm-2 control-label">报账金额</label>
				<div class="col-sm-8">
		          <div class="input-group">
			      <div class="input-group-addon">￥</div>
				  <input type="password" class="form-control" id="inputPassword3">
				  <div class="input-group-addon">（元）</div>
				  </div>
				</div>
			  </div>
             <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">超标原因</label>
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
 <!--      默认隐藏的内容:报账详细信息-->
  <div class="modal fade bs-example-modal-sm" id="acInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">详细信息</h4>
      </div>
      <div>
        <table class="table table-striped table-condensed">
        	<tr><td>报账项目</td><td>项目A</td></tr>       	
        	<tr><td>项目阶段</td><td>阶段一</td></tr>
			<tr><td>报账人</td><td>甲</td></tr>
        	<tr><td>报账时间</td><td>2017-10-11</td></tr>        	
        	<tr><td>报账金额</td><td>￥50.00元</td></tr>
            <tr><td>当前状态</td>
            <td class="nopassing">未审核</td></tr>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
      </div>
    </div>
  </div>
</div>
  <!--      默认隐藏的内容:报账详细信息（审批）-->
  <div class="modal fade bs-example-modal-sm" id="acInfoPass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">详细信息</h4>
      </div>
      <div>
        <table class="table table-striped table-condensed">
        	<tr><td>报账项目</td><td>项目A</td></tr>       	
        	<tr><td>项目阶段</td><td>阶段一</td></tr>
			<tr><td>报账人</td><td>甲</td></tr>
        	<tr><td>报账时间</td><td>2017-10-11</td></tr>        	
        	<tr><td>报账金额</td><td>￥50.00元</td></tr>
            <tr><td>当前状态</td>
            <td class="nopassing">未审核</td></tr>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary">审批</button>
      </div>
    </div>
  </div>
</div>
  <footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
  </div>
  </footer>
  </body>
</html>