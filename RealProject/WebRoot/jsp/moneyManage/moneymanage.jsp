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
   	<script type="text/javascript">
   		var taskinfo="";
   		var feeData=eval('('+'${fee["feeaudits"]}'+')');
   		var auditData;
   		var fauditno;  //报账表编号 --审核
   		//ajax请求

   		function getFunction(cur){
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
   			
   			req.open("post", "/RealProject/web/servlet/showbudgetpage?currentPage="+cur+"&pageSize=3");
   			req.send(null);
   		}
   	</script>

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
       	            <span style="float: right">
        	         <a href="#" style="margin-right: 15px" onclick = "document.getElementById('searchto').style.display='block';document.getElementById('fade').style.display='block'">查找..</a>
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
						 	var totalNum=${projects['totalNum']};
						 	var projectNum=${projects['projectNum']};
						 	var currentGroup=1;
						 	var groupSize=5;
						 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1;
						 	refreshData(); 
						 	
						 	//获取审核信息
					   		getAuditInfo();
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
					  <a href="javascript:getPrevious(showpage);" aria-label="Previous">
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
					  <a href="javascript:getNext(showpage);" aria-label="Next">
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
		        <div class="panel-heading"><span>相关项目报账信息</span><span class="more" onClick="window.open('${pageContext.request.contextPath}/web/servlet/showPageFee?currentPage=1&pageSize=5')">more..</span></div>
		        <div class="panel-body">
		        <table class="table table-striped " style="font-size: 15px" id="feetable">
 		    <tr>
			    <th>项目名称</th>
			    <th>报销人</th>
			    <th>报账时间</th>
			    <th>状态</th>
			    <th> </th>
		    </tr>
		    <tr>
			    <td align="center">项目A</td>
			    <td align="center">甲</td>
			    <td align="center">2017-10-11</td>
			    <td align="center" style="color:red">未审批</td>
			    <td align="center">
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
			    </td>
		    </tr>
		    <tr>
			    <td align="center">项目A</td>
			    <td align="center">甲</td>
			    <td align="center">2017-10-11</td>
			    <td align="center" style="color:red">未审批</td>
			    <td align="center">			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		   		</td>
		    </tr>
		    <tr>
			    <td align="center">项目A</td>
			    <td align="center">甲</td>
			    <td align="center">2017-10-11</td>
			    <td align="center" style="color:red">未审批</td>
			    <td align="center">			    
			   <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		    	</td>
		    </tr>
		    <tr>
			    <td align="center">项目A</td>
			    <td align="center">甲</td>
			    <td align="center">2017-10-11</td>
			    <td align="center" style="color:red">未审批</td>
			    <td align="center">			    
			    <span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer"></span>
		    	</td>
		    </tr>
			<script type="text/javascript">
			    var nodes=document.getElementById("feetable").getElementsByTagName("tr");
				for(var i=0;i<feeData.length;i++){
					
					var tds=nodes[i+1].getElementsByTagName("td");
					var name1=feeData[i].pname;
					if(name1.length>8)
						name1=name1.substr(0,8)+"...";
					
					var name2=feeData[i].appname;
					
					if(name2.length>4)
						name2=name2.substr(0,4)+"...";
					tds[0].innerHTML=name1;
					tds[1].innerHTML=name2;
					tds[2].innerHTML=feeData[i].stime;
					var state=feeData[i].auditstate;
					
					if(state=="0"){
						tds[3].innerHTML="未审批";
						tds[3].className="text-danger";
					}
					else if(state=="2"){
						tds[3].innerHTML="审批通过";
						tds[3].className="text-success";
					}else{
						tds[3].innerHTML="不通过";
						tds[3].className="text-danger";
					}
					tds[4].innerHTML='<span class="glyphicon glyphicon-info-sign" data-toggle="modal"  data-target="#acInfo" title="详细" style="cursor: pointer" onclick="updateFeeAuditDialog('+i+')"></span>';
				} 
				for(var i=feeData.length;i<4;i++){	
					var tds=nodes[i+1].getElementsByTagName("td");
					tds[0].innerHTML="-";
					tds[1].innerHTML="-";
					tds[2].innerHTML="-";
					tds[3].innerHTML="-";
					tds[4].innerHTML="-";
				} 
			</script>
		    
    		</script> 
	        </table>
				
                <div>
                <button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc" onclick="getTaskInfo(${staff.staffno})">报账</button>
            </div>
                </div>
            </div>
    	    </div>
    	    
    	    <!--审批-->
    	    <div id="accountPass" class="col-lg-4" style="padding-left: 30px">
	        <div class="panel panel-primary">
		        <div class="panel-heading"><span>相关项目审批信息</span><span class="more" onClick="window.open('${pageContext.request.contextPath}/jsp/moneyManage/moneyPass.jsp')">more..</span></div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px" id="audittable">
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
			    <td  class="text_danger">未审批</td>
			    <td >
			    <span class="glyphicon  glyphicon-check" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
			    </td>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  class="text_danger">未审批</td>
			    <td >			    
			    <span class="glyphicon  glyphicon-check" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
			    </td>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  class="text_danger">未审批</td>
			    <td >			    
			   <span class="glyphicon  glyphicon-check" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
		     </td>
		    </tr>
		    <tr>
			    <td >项目A</td>
			    <td >甲</td>
			    <td >2017-10-11</td>
			    <td  class="text_danger">未审批</td>
			    <td >			    
			    <span class="glyphicon  glyphicon-check" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer"></span>
		     </td>
		    </tr>
			<script type="text/javascript">
				var audittable=document.getElementById("audittable");
				
			</script>
	        </table>
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
				<label class="col-sm-2 control-label">报账项目</label>
				<div class="col-sm-8">
			    <select class="form-control" id="project_select">
				  <option>请选择</option>
				</select>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label" >项目阶段</label>
                <div class="col-sm-8">
			    <select class="form-control" disabled="disabled" id="stage_select">
			      <option>请选择</option>
				</select>
				</div>
			  </div>
		      <div class="form-group">
			    <label class="col-sm-2 control-label" >报账任务</label>
			    <div class="col-sm-8">
			    <select class="form-control" disabled="disabled" id="task_select">
			      <option>请选择</option>
			    </select>
			    </div>
			  </div>			  
			  <div class="form-group">
				<label class="col-sm-2 control-label" >报账金额</label>
				<div class="col-sm-8">
		          <div class="input-group">
			      <div class="input-group-addon">￥</div>
				  <input type="text" class="form-control" id="inputPassword3" disabled="disabled">
				  <div class="input-group-addon">（元）</div>
				  </div>
				</div>
			  </div>
			  <div class="form-group" id="warnning_div" style="display: none;">
				<label  class="col-sm-2 control-label" >提示</label>
				<span style="color: red;font-size: 15px;font-weight: bold;" id="warnning">报账金额超出任务预算,请填写超标原因,等待审核</span>
			  </div>
             <div class="form-group" id="over_cause" style="display: none;">
				<label  class="col-sm-2 control-label" >超标原因</label>
				<div class="col-lg-8">
				  <textarea class="form-control" rows="4" id="fee_cause"></textarea>
				</div>
			  </div>
          </form>
          <script type="text/javascript">
          		var project_pos=-1;  //项目位置
          		var stage_pos=-1;   //阶段位置
          		var task_pos=-1;   //任务位置
          		var task_budget=0;
          		var task_feeaudit=0;
          		var project_select=document.getElementById("project_select");
          		var stage_select=document.getElementById("stage_select");
          		var task_select=document.getElementById("task_select");
          		var task_fee=document.getElementById("inputPassword3");
          		var over_cause=document.getElementById("over_cause");
          		var warnning=document.getElementById("warnning");
          		
          		project_select.onchange=function(){
          			if(this.value=="请选择"){
          				//取消禁用
          				stage_select.disabled="disabled";
          				task_select.disabled="disabled";
          				task_fee.disabled="disabled";
          				over_cause.disabled="disabled";
          			}else{
          				for(var i=0;i<taskinfo.length;i++)
          					if(taskinfo[i].pname==project_select.value){
          						project_pos=i;
          						break;
          					}
          				//取消禁止
          				stage_select.removeAttribute("disabled");
          				//刷新阶段
          				showStage();
          				task_select.disabled="disabled";
          				task_fee.disabled="disabled";
          			}
          			
          		};
          	stage_select.onchange=function(){
          		if(this.value=="请选择"){
      				//取消禁用
      				task_select.disabled="disabled";
      				task_fee.disabled="disabled";
      				over_cause.disabled="disabled";
      			}else{
      				for(var i=0;i<taskinfo[project_pos].stagelist.length;i++)
      					if(taskinfo[project_pos].stagelist[i].sname==stage_select.value){
      						stage_pos=i;
      						break;
      					}
      				//取消禁止
      				task_select.removeAttribute("disabled");
      				//刷新阶段
      				showTask();
      				task_fee.disabled="disabled";
      			
      			}
          		
          	};
          	task_select.onchange=function(){
          		if(this.value=="请选择"){
      				//禁用
      				task_fee.disabled="disabled";
      				over_cause.disabled="disabled";
      			}else{
      				
      				for(var i=0;i<taskinfo[project_pos].stagelist[stage_pos].tasklist.length;i++){
      					if(taskinfo[project_pos].stagelist[stage_pos].tasklist[i].taskname==task_select.value){
      						task_pos=i;
      						break;
      					}
      				}
      				//取消禁止
      				task_fee.removeAttribute("disabled");
      			}
          		
          	};
          	task_fee.oninput=function(){
          		var tmp=task_fee.value;
          		var rep=/^\d+((\.)?\d+)?$/;
          		if(!rep.test(tmp)){
          			if(tmp.indexOf(".")!=-1){
          				if(tmp.indexOf(".")!=tmp.length-1){
		          			task_fee.value="";
		          			submit.disabled="disabled";
		          			alert("请输入正确的金额");
          				}
          			}else{
          				task_fee.value="";
          				submit.disabled="disabled";
	          			alert("请输入正确的金额");
          			}
          		}else{
          			task_feeaudit=window.parseFloat(tmp);
          			submit.removeAttribute("disabled");
	          		task_budget=taskinfo[project_pos].stagelist[stage_pos].tasklist[task_pos].budget;
	          		if(task_budget<task_feeaudit){
	          			warnning.innerHTML="当前任务剩余预算为￥"+task_budget+"元,请填写超标原因";
	          			warnning_div.style.display="block";
	          			over_cause.style.display="block";
	          		}else{
	          			submit.removeAttribute("disabled");
	          			warnning_div.style.display="none";
	          			over_cause.style.display="none";
	          		}
          		}
          	};
          	
          </script>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary" onclick="submitFeeInfo();" id="submit">报账</button>
        <script type="text/javascript">
        	var submit=document.getElementById("submit");
        </script>
      </div>
    </div>
  </div>
</div>


  <!--      默认隐藏的内容:报账详细信息（审批）-->
  <div class="modal fade bs-example-modal-sm" id="acInfoPass" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">详细信息</h4>
      </div>
      <div class="modal-body">
		  <div>
				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font>报账项目:</font>
							</div>
							<div class="hehe_right">
							<font id="audit_pname">这个项目的名字实在是特别特别特别的长</font>
							</div>
							<div class="clear"></div>
							</div>

				<div id="responsible_per" class="block">
				<div class="hehe_left">
				<font >项目阶段:</font>
				</div>
				<div class="hehe_right">
				<font  id="audit_sname">阶段一</font>
				</div>
				<div class="clear"></div>
				</div>

				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font >项目任务:</font>
							</div>
							<div class="hehe_right">
							<font  id="audit_taskname">任务一一一一一一</font>
							</div>
							<div class="clear"></div>
							</div>

				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font >报账人:</font>
							</div>
							<div class="hehe_right">
							<font  id="audit_appname">卢仁佳</font>
							</div>
							<div class="clear"></div>
							</div>

				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font>报账时间:</font>
							</div>
							<div class="hehe_right">
							<font  id="audit_stime">2017-12-8</font>
							</div>
							<div class="clear"></div>
							</div>

				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font>报账金额:</font>
							</div>
							<div class="hehe_right">
							<font id="audit_fee" >￥50.00元</font>
							</div>
							<div class="clear"></div>
							</div>

				<div id="responsible_per" class="block">
							<div class="hehe_left">
							<font>当前状态:</font>
							</div>
							<div class="hehe_right">
							<font  id="audit_auditstate">未审批</font>
							</div>
							<div class="clear"></div>
							</div>
		  </div >
		  <div class="panel-middle" id="top_audit">
			 <div class="modal-header"><h4 class="modal-title">审批</h4></div>
		  </div>

		  <form id="middle_audit">
							<div id="responsible_per" class="block">
							<div>
							<div class="hehe_left">
							<input type="radio" name="pass" value="2" checked id="audit_pass">通过
							</div>
							<div class="hehe_right">
							<input type="radio" name="pass" value="1">不通过
							</div>
							</div> 
							<div class="clear"></div>
							</div>

							<!-- 审批人 -->
							<div id="end_date" class="block">
							<div class="hehe_left">
							<font class="text">审批人:</font>
							</div>
							<div class="hehe_right">
							<input type="text" name="" size="40px;" disabled value="${staff.name }">
							</div>
							<div class="clear"></div>
							</div>
							
							<!-- 审批意见 -->
							<div id="start_date" class="block">
							<div class="hehe_left">
							<font class="text">审批意见：</font>
							</div>
							<div class="hehe_right">
							<textarea rows="5" cols="30" id="audit_cause"></textarea>
							</div>
							<div class="clear"></div>
							</div>


						</form>
        <script type="text/javascript">
	   		//刷新审核框内容
	   		
        </script>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary" onclick="submitAuditInfo();" id="submit_audit">审批</button>
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