<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>相关项目报账信息</title>
<!-- 包含头部 -->
	<%@ include file="/head.jsp"%>
   <script type="text/javascript">
		menus[3].className="active nav-current";
		menus[3].role="presentation";	
	</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/money.js"></script>
</head>

<body>
	
	
	<script type="text/javascript">
		var taskinfo="";
		function getFunction(cur){
			var req = new XMLHttpRequest();
   			req.onreadystatechange=function(){
   				if(req.readyState==4){
   					if(req.status==200){
   						var res=req.responseText;
   						//数据刷新
   						var data=eval('('+res+')');
   					
   						dataJson=eval(data.feeaudits);
   					
   						currentPage=data.currentPage;
					 	pageSize=data.pageSize;
					    pageNum=data.pageNum;  
					 	totalNum=data.totalNum; 
   						feeauditNum=data.feeauditNum;	
   						refreshData();	
   					}
   				}
   			};
   			
   			req.open("post", "${pageContext.request.contextPath}/web/servlet/showPageFee?currentPage="+cur+"&pageSize=5&time="+new Date().getTime());
   			req.send(null);
		}
		function refreshData(){
			
			var nodes=document.getElementById("maintable").getElementsByTagName("tr");
			for(var i=0;i<dataJson.length;i++){
				
				var tds=nodes[i+1].getElementsByTagName("td");
				//项目长度
				var hehe_pname=dataJson[i].pname;
				if(hehe_pname.length>20)
					hehe_pname=hehe_pname.substr(0,20)+"...";
				tds[0].innerHTML=hehe_pname;
				tds[0].title=dataJson[i].pname;
				
				var hehe_sname=dataJson[i].sname;
				if(hehe_sname.length>6)
					hehe_sname=hehe_sname.substr(0,6)+"...";
				tds[1].innerHTML=hehe_sname;
				tds[1].title=dataJson[i].sname;
				
				var hehe_taskname=dataJson[i].taskname;
				if(hehe_taskname.length>6)
					hehe_taskname=hehe_taskname.substr(0,6)+"...";
				tds[2].innerHTML=hehe_taskname;
				tds[2].title=dataJson[i].taskname;
				
				var hehe_appname=dataJson[i].appname;
				if(hehe_appname.length>6)
					hehe_appname=hehe_appname.substr(0,6)+"...";
				tds[3].innerHTML=hehe_appname;
				tds[3].title=dataJson[i].appname;
				
				tds[4].innerHTML=dataJson[i].stime;
				tds[5].innerHTML="￥"+dataJson[i].fee;
				var state=dataJson[i].auditstate;
				
				if(state=="0"){
					tds[6].innerHTML="未审批";
					tds[6].style.color="blue";
				}
				else if(state=="2"){
					tds[6].innerHTML="审批通过";
					tds[6].style.color="green";
				}else{
					tds[6].innerHTML="不通过";
					tds[6].style.color="red";
				}
			} 
			for(var i=dataJson.length;i<5;i++){	
				var tds=nodes[i+1].getElementsByTagName("td");
				tds[0].innerHTML="-";
				tds[1].innerHTML="-";
				tds[2].innerHTML="-";
				tds[3].innerHTML="-";
				tds[4].innerHTML="-";
				tds[5].innerHTML="-";
				tds[6].innerHTML="-";
			} 
			
			
		}
	</script>
	
    <section>
        <div class="container-fluid">
            <div class="row">
              <div class="col-lg-10 xumode">
              <div class="panel panel-primary">
		        <div class="panel-heading"><span>相关项目报账信息</span><span class="noRight"  data-toggle="modal" data-target="#handupAc" onclick="getTaskInfo(${staff.staffno})">报账</span></div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px" id="maintable">
					<tr>
						<th>项目名称</th>
						<th>项目阶段</th>
						<th>任务名称</th>
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
						<td >未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td >未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td >未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td >未审批</td>
						<td ></td>
					</tr>
					<tr>
						<td >项目A</td>
						<td >阶段一</td>
						<td >任务一</td>
						<td >甲</td>
						<td >2017-10-11</td>
						<td >￥50.00元</td>
						<td >未审批</td>
						<td ></td>
					</tr>
					
				</table>
					<!-- 复用前面的代码 -->
					<script type="text/javascript">
							var maintable=document.getElementById("maintable");
						 	var dataJson=eval('('+'${fee["feeaudits"]}'+')');
						 	var currentPage=${fee['currentPage']};
						 	var pageSize=${fee['pageSize']};
						   	var pageNum=${fee['pageNum']};  
						 	var totalNum=${fee['totalNum']};
						 	var feeauditNum=${fee['feeauditNum']};
						 	var currentGroup=1;
						 	var groupSize=5;
						 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1;
						 	refreshData(); 
					</script>
	

	        
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

    </section>
    <%@include file="/footer.jsp" %>
</body>
</html>
