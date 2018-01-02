<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>资金管理</title>
	<!-- 包含头部内容 -->
   <%@ include file="/head.jsp"%>
   <script type="text/javascript">
		menus[3].className="active nav-current";
		menus[3].role="presentation";	
	</script>
    <!-- Bootstrap -->
    
	
	
    <script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/money.js"></script>

  </head>
  <body> 
   
	
 <!--      默认隐藏的内容:报账详细信息-->
  <div class="modal fade bs-example-modal-sm" id="acInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document" style="width: 500px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">详细信息</h4>
      </div>
      <div>
        <table class="table table-striped table-condensed">
        	<tr><td>报账项目</td><td id="fee_pname">项目A</td></tr>       	
        	<tr><td>项目阶段</td><td id="fee_sname">阶段一</td></tr>
        	<tr><td>项目任务</td><td id="fee_taskname">任务一</td></tr>
			<tr><td>报账人</td><td id="fee_appname">甲</td></tr>
        	<tr><td>报账时间</td><td id="fee_stime">2017-10-11</td></tr>        	
        	<tr><td>报账金额</td><td id="fee_fee">￥50.00元</td></tr>
            <tr><td>当前状态</td>
            <td class="text_danger"  id="fee_auditstate">未审批</td></tr>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
      </div>
    </div>
  </div>
</div>
 	
<!--  主要内容-->
<!-- 计划模块 -->
  <section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<div class="col-lg-12 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">test01</div><!-- 这里的是项目的名称 -->
      	        <div class="panel-body">
                <div class="col-lg-12" >
                    <div class="row">
					<div class="col-lg-14">
	
		<table class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th align="center">编号</th>
			    <th align="center">名称</th>
			    <th align="center">类型</th>
			    <th align="center">负责人</th>
			    <th align="center">参与人数</th>
			    <th align="center">开始时间</th>
			    <th align="center">结束时间</th>
			    <th align="center">计划工期</th>
			    <th align="center">逾期天数</th>
			    <th align="center">状态</th>
			    <th align="center">预算</th>
			    <th align="center">超出预算</th>
			    <th align="center">超出原因</th>
		    </tr>
		    <tr>
			    <td align="center">1111111111</td>
			    <td align="center">test01</td>
			    <td align="center">项目</td>
			    <td align="center">OO</td>
			    <td align="center">200人</td>
			    <td align="center">2017-01-01</td>
			    <td align="center">2017-12-31</td>
			    <td align="center">365天</td>
			    <td align="center">未</td>
			    <td align="center">进行中</td>
			    <td align="center">￥200000</td>
			    <td align="center">未</td>
			    <td align="center">无</td>
			    
		    </tr>
		    
		</table>
		    </div> 
    		</div>
			</main>
    	</div>
    </div>
</section>
<script type="text/javascript">
	function show1()
{
	if (document.getElementById('sorry1.1').style.display == 'table-row')
       {
           	document.getElementById('sorry1.1').style.display = 'none';
			document.getElementById('sorry1.2').style.display = 'none';
        }
    else
       {
            document.getElementById('sorry1.1').style.display = 'table-row';
			document.getElementById('sorry1.2').style.display = 'table-row';
        }
};
	function show2()
{
	if (document.getElementById('sorry2.1').style.display == 'table-row')
       {
           	document.getElementById('sorry2.1').style.display = 'none';
			document.getElementById('sorry2.2').style.display = 'none';
			if (document.getElementById('sorry2.1.1').style.display == 'table-row')
       		{
           		document.getElementById('sorry2.1.1').style.display = 'none';
				document.getElementById('sorry2.1.2').style.display = 'none';
        	}
        }
    else
       {
            document.getElementById('sorry2.1').style.display = 'table-row';
			document.getElementById('sorry2.2').style.display = 'table-row';
        }
};
function show2n1()
{
	if (document.getElementById('sorry2.1.1').style.display == 'table-row')
       {
           	document.getElementById('sorry2.1.1').style.display = 'none';
			document.getElementById('sorry2.1.2').style.display = 'none';
        }
    else
       {
            document.getElementById('sorry2.1.1').style.display = 'table-row';
			document.getElementById('sorry2.1.2').style.display = 'table-row';
        }
};
</script>


<!-- 资金模块 -->
<main class="col-lg-12 main-content">
<div class="col-lg-12 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">资金状况</div>
      	        <div class="panel-body">
      	        	<div class="col-lg-8 xumode">
      	        		
                 <div class="digramchart" id="chart1" style="margin-bottom: 20px" >
								<script type="text/javascript">
				// 基于准备好的dom，初始化echarts实例

				var myChart = echarts.init(document.getElementById('chart1'));

				// 指定图表的配置项和数据

				var option = {
					textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:'test01',
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
							data : ['阶段一','阶段二','阶段三','阶段四','阶段五','阶段六','阶段七','阶段八']
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
							data:[120, 132, 101, 134, 0, 0, 0, 0],
							barMaxWidth:40,

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:[0, 182, 152, 0, 522, 348, 421, 255],
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:[150, 0, 0, 154, 0, 0, 0, 0],
							

						}
						]

				};

				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
				</script>
				</div>
			</div>

			<div class="col-lg-8 xumode">
				<table class="table table-striped table-condensed" style="font-size: 15px;">
					<tr>
						<th>项目阶段</th>
						<th>任务阶段</th>
						<th>报销人</th>
						<th>报账时间</th>
						<th>报账金额</th>
						<th>状态</th>
						<th> </th>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务1</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text-danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务1</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text-danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务2</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text-danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务2</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text-danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务2</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td  class="text-danger">未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务3</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text-success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务3</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text-success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务4</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text-success">已审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >阶段一</td>
						<td >任务4</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥50.00元</td>
						<td  class="text-success">已审批</td>
						<td ></td>
					</tr>
	                <tr>
						<td >阶段一</td>
						<td >任务4</td>
						<td >乙</td>
						<td >2017-10-03</td>
						<td >￥200.00元</td>
						<td  class="text-warning">未通过</td>
						<td class="text-danger">超标</td>
					</tr>
	        	</table> 
			</div> 

				
                </div>
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