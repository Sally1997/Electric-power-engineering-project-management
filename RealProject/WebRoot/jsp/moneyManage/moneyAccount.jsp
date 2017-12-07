<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>相关项目报账信息</title>
    
</head>

<body>
	<!-- 包含头部 -->
	<%@ include file="/head.jsp"%>
   <script type="text/javascript">
		menus[3].className="active nav-current";
		menus[3].role="presentation";	
	</script>
	
	<script type="text/javascript">
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
   			
   			req.open("post", "${pageContext.request.contextPath}/web/servlet/showPageFee?currentPage="+cur+"&pageSize=5");
   			req.send(null);
		}
		function refreshData(){
			//删除所有节点
			maintable.innerHTML="";
			
			//新建表头
			var tr=document.createElement("tr");
			tr.innerHTML="<th>项目名称</th><th>项目阶段</th><th>任务阶段</th><th>报销人</th><th>报账时间</th><th>报账金额</th><th>状态</th><th> </th>";
			maintable.appendChild(tr);
			//插入数据
			for(var i=0;i<feeauditNum;i++){
				var tr=document.createElement("tr");
				
				var td1=document.createElement("td");
				td1.innerHTML=dataJson[i].pname;
				
				var td2=document.createElement("td");
				td2.innerHTML=dataJson[i].sname;
				
				var td3=document.createElement("td");
				td3.innerHTML=dataJson[i].taskname;
				
				var td4=document.createElement("td");
				td4.innerHTML=dataJson[i].appname;
				
				var td5=document.createElement("td");
				td5.innerHTML=dataJson[i].stime;
				
				var td6=document.createElement("td");
				td6.innerHTML="￥"+dataJson[i].fee;
				
				var td7=document.createElement("td");
				if(dataJson[i].auditstate=="0"){
   					td7.className="text-danger";
   					td7.innerHTML="未审批";
   				}else if(dataJson[i].auditstate=="1"){
   					td7.className="text-danger";
   					td7.innerHTML="未通过";
   				}else{
   					td7.className="text-success";
   					td7.innerHTML="通过审批";
   				}
   				var hr=document.createElement("hr");
   				tr.appendChild(td1);
   				tr.appendChild(td2);
   				tr.appendChild(td3);
   				tr.appendChild(td4);
   				tr.appendChild(td5);
   				tr.appendChild(td6);
   				tr.appendChild(td7);
   				maintable.appendChild(hr);
   				maintable.appendChild(tr);
			}
		}
	</script>
	
    <section>
        <div class="container-fluid">
            <div class="row">
              <div class="col-lg-10 xumode">
              <div class="panel panel-primary">
		        <div class="panel-heading"><span>相关项目报账信息</span><span class="noRight"  data-toggle="modal" data-target="#handupAc">报账</span></div>
		        <div class="panel-body">
		        <table class="table table-striped table-condensed" style="font-size: 15px" id="maintable">
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
