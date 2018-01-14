<%@ page language="java" contentType="text/html; charset=UTF-8"    
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--底边栏没改-->
<!--还有一堆冗余没搞懂-->
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.ProjectInfo" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>项目管理首页</title>
    <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
	
      <!-- bootstrap-datetimepicker -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/locales.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
  
  </head>
  <body> 
 <section>
 	<script type="text/javascript">
	 	var dataJson;
	 
	 	var currentPage=${info_map['current_page'] };
	 	var pageSize=${info_map['page_size'] };
	 	
	  	var pageNum=${info_map['total_page'] };
	 	var totalNum=${info_map['count'] };
	 	var projectNum=${fn:length(info_map['pi_list']) };
	 	var currentGroup=1;
	 	var groupSize=5;
	 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1; 
	</script>
 	<script type="text/javascript">
 		//更新数据
 		function refreshData(){
 			var pnamenodes=document.getElementsByName("pro_pname");
 			
			//新版本
			var trs=showtable.getElementsByTagName("tr");
 			for(var i=0;i<dataJson.length;i++){
 				var nodes=trs[i+1].getElementsByTagName("td");
 				nodes[0].innerHTML='<a href="javascript:window.location.href=&apos;/RealProject/web/servlet/judgeStageExist?pno='+dataJson[i].pno+'&apos;" name="pro_no">'+dataJson[i].pno+'</a>';
 				//刷新值0
 				
 			
 				nodes[1].innerHTML=nodes[1].innerHTML='<div class="dropdown"><span name="pro_pname">'+dataJson[i].pname+'</span><span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span><ul class="dropdown-menu" aria-labelledby="dropdownMenu1"><li><a href="/RealProject/web/servlet/staffListServlet?pno='+dataJson[i].pno+'">人员管理</a></li><li><a href="/RealProject/web/servlet/judgeStageExist?pno='+dataJson[i].pno+'">计划管理</a></li></ul></div>';
 				var spans=nodes[1].getElementsByTagName("span");
 				spans[0].title=dataJson[i].pname;
 				if(dataJson[i].pname.length>10)
 					spans[0].innerHTML=spans[0].innerHTML.substr(0,10)+"...";
 				
 				nodes[2].innerHTML=dataJson[i].name;
 				nodes[3].innerHTML=dataJson[i].duty;
 				if(nodes[3].innerHTML.length>6){
 					nodes[3].innerHTML=nodes[3].innerHTML.substr(0,6)+"...";
 				}
 				nodes[4].innerHTML=dataJson[i].ptype;
 				nodes[5].innerHTML=dataJson[i].pstate;
 			
 			}
 			//刷新横线
 			for(var i=dataJson.length;i<5;i++){
 				var nodes=trs[i+1].getElementsByTagName("td");
 				nodes[0].innerHTML='-';
 				nodes[1].innerHTML='-';
 				nodes[2].innerHTML='-';
 				nodes[3].innerHTML='-';
 				nodes[4].innerHTML='-';
 				nodes[5].innerHTML='-';
 			}
 			
 		}
 	</script>
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
		<table class="table table-striped table-condensed" style="font-size: 15px" id="showtable">
 		    <tr>
			    <th align="center">项目编号</th>
			    <th align="center">项目名称</th>
			    <th align="center">项目经理</th>
			    <th align="center">职责</th>
			    <th align="center">项目类型</th>
			    <th align="center">状态</th>
		    </tr>
		    
		    <!-- display:""的原因是block会引起错位 -->
		    <c:forEach items="${info_map['pi_list'] }" var="pl">
		    <tr name="fozza_tr" style="display:''">
			    <td align="left"><a href="javascript:window.location.href='/RealProject/web/servlet/judgeStageExist?pno=${pl.pno }'" name="pro_no">${pl.pno }</a></td>
			    <td align="left">
			    	<div class="dropdown"><span name="pro_pname" title="${pl.pname }">${pl.pname }</span>
  						<span class="glyphicon glyphicon-paperclip" style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="/RealProject/web/servlet/staffListServlet?pno=${pl.pno }">人员管理</a></li>
    						<li><a href="/RealProject/web/servlet/judgeStageExist?pno=${pl.pno }">计划管理</a></li>
  						</ul>
					</div>
				</td>

			    <td align="left">${pl.name }</td>
			    <td align="left" name="pro_duty" title="${pl.duty }">${pl.duty }</td>
			    <td align="left" >${pl.ptype }</td>
			    <td align="left">${pl.pstate }</td>
		    </tr>

			</c:forEach>
			<c:forEach begin="${fn:length(info_map['pi_list'])}" end="4" step="1">
		    <tr name="fozza_tr" style="display:''">
			    <td align="left"><a href="#" name="pro_no">-</a></td>
			    <td align="left">
			    	<div class="dropdown"><span name="pro_pname" title="-">-</span>
  						<span  style="cursor: pointer;float:right;" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<li><a href="#">人员管理</a></li>
    						<li><a href="#">计划管理</a></li>
  						</ul>
					</div>
				</td>

			    <td align="left">-</td>
			    <td align="left" name="pro_duty" title="${pl.duty }">-</td>
			    <td align="left" >-</td>
			    <td align="left">-</td>
		    </tr>

			</c:forEach>
	        </table> 
	        <script type="text/javascript">
	        	//对于项目长度进行控制
	        	var names=document.getElementsByName("pro_pname");
	        	var duties=document.getElementsByName("pro_duty");
	        	for(var i=0;i<names.length;i++){
	        		if(names[i].innerHTML.length>10)
	        			names[i].innerHTML=names[i].innerHTML.substr(0,10)+"...";
	        		if(duties[i].innerHTML.length>6)
	        			duties[i].innerHTML=duties[i].innerHTML.substr(0,6)+"...";
	        	}
	        </script>
					</div> 
                    </div>
                </div>
                </div>
                <!--  分页栏-->
				
				<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination" id="showpage">
				  	<script type="text/javascript">
				  		var showtable=document.getElementById("showtable");
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
	 <form class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return submitProject();" action="${pageContext.request.contextPath }/servlet/NewProjectServlet">
		  		<div class="form-group">
				<label for="projectname" class="col-sm-2 control-label">项目名称<span style="color:red">&nbsp;*</span></label> 
				<div class="col-sm-8">
		            <input class="form-control" id="projectname" name="ProjectName">
				</div>
				</div>
				
				<div class="form-group">
				<label for="projecttype" class="col-sm-2 control-label">项目类型<span style="color:red">&nbsp;*</span></label>
				<div class="col-sm-8">
			    <select class="form-control" name="ProjectType" id="projecttype">
				  <option>工程类</option>
				  <option>设计类</option>
				 </select>
				</div>
			  	</div>
				
				<div class="form-group">
				<label for="checkman" class="col-sm-2 control-label">审批人<span style="color:red">&nbsp;*</span></label>
				<div class="col-sm-8">
				    <div class="input-group">
		            <input class="form-control" id="checkman" name="PersonInCharge" style="display:none" readonly="readonly">
		            <span class="input-group-btn"><button type = "button" class = "btn btn-primary" data-toggle = "modal" data-target= "#search" onclick="search_member()">查找</button>
				    </span>
				    </div>
				</div>
			  	</div>
			  	
			  	<div class="form-group">
				<label for="what" class="col-sm-2 control-label">预算金额<span style="color:red">&nbsp;*</span></label> 
				<div class="col-sm-8">
		            <input class="form-control" id="projectbudget" type="number" name="ProjectBudget">
				</div>
				</div>
			  	
			  	<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">相关附件<span style="color:red">&nbsp;*</span></label>
				<div class="col-sm-8">
		            <input type ="file" id="file" name="worinima">
				</div>
			  </div>
            
             <!-- <div class="form-group">
				<label for="others" class="col-sm-2 control-label">其他备注&nbsp;&nbsp;</label>
				<div class="col-lg-8">
				  <textarea class="form-control" rows="4" name="OtherRemark" id="others"></textarea>
				</div>
			  </div> -->
			  
			 <div class="form-group">
			    <label for="addfile" class="col-sm-2 control-label">开始时间<span style="color:red">&nbsp;*</span></label>
				<div class="col-sm-8">	
					<input name="stime" type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker1'/>
				</div>
			 </div>
			  
			
			<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">结束时间<span style="color:red">&nbsp;*</span></label>
				<div class="col-sm-8">	
					<input name="etime" type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker2'/>
				</div>
			</div>
			
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"">返回</button>
        <input type="submit" class="btn btn-primary" value="提交">
      </div>
     </form>
      </div>
      
      <script type="text/javascript">
      		//发送ajax请求
      		function submitProject(){
      			var projectname=document.getElementById("projectname");
      			var projecttype=document.getElementById("projecttype");
      			var projectbudget=document.getElementById("projectbudget");
      			var checkman=document.getElementById("checkman");
      			var file=document.getElementById("file");
      			var stime = document.getElementsByName("stime")[0];
      			var etime = document.getElementsByName("etime")[0];
      			
      			var others=document.getElementById("others");
      			
      			var x=true;
      			var p = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
      			x = p.test(projectbudget.value);
      			
      			//对于时间进行验证
      			var myDate=new Date().getTime();
      			var startTime=Date.parse(document.getElementById("datetimepicker1").value);
      			if(startTime<myDate){
      				alert("项目的开始时间应在今天之后");
      				return false;
      			}
      			//进行验证
      			if(projectname.value==""){
      				alert("请输入项目名称!");
      				return false;
      			}
      			else if(checkman.value==""){
      				alert("请选择审批人!");
      				return false;
      			}
      			else if(checkman.value.length<15){
      				alert("请选择正确的审批人!");
      				return false;
      			}
      			else if(!x){
      				alert("预算金额非法输入格式!");
      				return false;
      			}
      			else if(projectbudget.value.length>8){
      				alert("预算金额非法输入格式!");
      				return false;
      			}
      			else if(file.value==""){
      				alert("请上传项目相关文件!");
      				return false;
      			}
      			else if(stime.value==null||etime.value==null||stime.value==""||etime.value==""){
      				alert("请选择时间!");
      				return false;
      			}
      			
      			alert("数据提交中……请等待服务器结果");
      		}
      	
      </script>
    </div>
  </div>
  <div id="fozza1" class="fozza3"></div> 
</div>
 
 
 <!--      默认隐藏的内容:查找人員-->
 <div class="modal fade" id="search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">人员查找</h4>
    </div>
    <div class="modal-body">
    	<form action="" method="post" name="form2">
    	<div id="others" class="block">
			<div class="hehe_left">
			<span class="text">输入:</span>
			</div>
			<div class="hehe_right">
			<input type="text" id="getme" onfocus="cleartext()" value="请输入关键字" name="goal" size="20px;">&nbsp;&nbsp;
			<input type = "button" name = "ok" class="btn btn-primary" value = "查找" onClick="search_staff()">
			</div>
			</div>
			<div class="clear"></div>
			<br/>
		</form>
		<form action="" method="post" name="form3">
			<table id = "member_table" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th>选择</th>
			    <th>编号</th>
			    <th>姓名</th>
			    <th>联系方式</th>
			    <!-- 编号，名字，电话号，职责，备注 -->
		    </tr>
		    <tbody id="iamtbody"></tbody>
	        </table>
		</form>
		   
		  <div style="text-align: center" id="#">
		           <ul class="pagination">
					<li>
						<span aria-hidden="true" onclick="pagedec()">&laquo;</span>
					</li>
					  <li class="active"><a>第<span id="fozza_page">1</span>页/共<span id="fozza_count">1</span>页</a></li>
					<li>
						<span aria-hidden="true" onclick="pageinr()">&raquo;</span>
					</li>
				    </ul>
    	</div>
		   
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="give_option()">选择</button>
    </div>
	</div>
</div>
</div>
 
 

 
 <%@include file="/footer.jsp" %>
  </body>
<script type="text/javascript">
	function getFunction(cur){
			var req = new XMLHttpRequest();
			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						var res=req.responseText;
						//数据刷新
						var data=eval('('+res+')');
						dataJson=data.pi_list;
						currentPage=data.current_page;
					 	pageSize=data.page_size;
					    pageNum=data.total_page;  
					 	totalNum=data.count; 
						projectNum=dataJson.length;	
						
						refreshData();	
					}
				}
			};
			
			req.open("get", "/RealProject/servlet/ShowProjectServlet2?current_page="+cur+"&time="+new Date().getTime());
			req.send(null);
		}
		
		
</script>

<script type="text/javascript">
var big_fp;

//以下应该都是选择用户弹窗功能
function give_option(){
	var ccp = document.getElementsByName("choose_char_per");
	//这个是弹窗的id
	var ser = document.getElementsByName("search")[0];
	var mng = document.getElementsByName("PersonInCharge")[0];  
	for(var i=0;i<ccp.length;i++){
		if(ccp[i].checked==true){
			var fozza_cp = ccp[i].value;
			var shabi = "${staff.name}(${staff.staffno})";
			if(fozza_cp==shabi){
				alert("您必须选取其他人为项目审核人!");
				return;
			}
		
			mng.value = ccp[i].value;
			mng.style.display = "";
			break;
		}
	}
}

//以下是选择用户功能
function search_member(){
	document.getElementById("fozza_page").innerHTML = 1;
	
	var tbody_t = document.getElementById("iamtbody");
	
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			//消除闪屏
			tbody_t.innerHTML="";
			
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				if(i==str.length-1){
					var fc = document.getElementById("fozza_count");
					fc.innerHTML = str[i].pagesize;
					big_fp = fc.innerHTML;
					break;
				}
			
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?type=nptype&time="+new Date().getTime()+"fp="+document.getElementById("fozza_page").innerHTML);
	
	aja.send(null);
}

function search_staff(){
	document.getElementById("fozza_page").innerHTML = 1;
	var g = document.getElementById("getme");
	var keyword = g.value;
	
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var tbody_t = document.getElementById("iamtbody");
			tbody_t.innerHTML="";
	
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				if(i==str.length-1){
					var fc = document.getElementById("fozza_count");
					fc.innerHTML = str[i].pagesize;
					big_fp = fc.innerHTML;
					break;
				}
				
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/staffInfoFindServlet?type=nptype&keyword="+window.encodeURI(keyword)+"&time="+new Date().getTime());
	
	aja.send(null);
}
//操此位置

$(function () {
        $('#datetimepicker1').datetimepicker({
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY-MM-DD'
		});
        $('#datetimepicker2').datetimepicker({
            useCurrent: false,
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY-MM-DD'
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker2").on("dp.change", function (e) {
            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        });
    });
    
function cleartext(){
	var cm = document.getElementById("getme");
	if(cm.value=="请输入关键字"){
		cm.value = "";
	}
}

function pageinr(){
	var fp = document.getElementById("fozza_page").innerHTML;
	if(fp==big_fp){
		return;
	}
	fp = parseInt(fp);
	fp += 1;
	
	document.getElementById("fozza_page").innerHTML = fp;

	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var tbody_t = document.getElementById("iamtbody");
			tbody_t.innerHTML="";
	
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				if(i==str.length-1){
					break;
				}
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?type=nptype&fp="+fp);
	aja.send(null);
}

function pagedec(){
	var fp = document.getElementById("fozza_page").innerHTML;
	if(fp=="1"){
		return;
	}
	fp = parseInt(fp);
	fp -= 1;
	document.getElementById("fozza_page").innerHTML = fp;

	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var tbody_t = document.getElementById("iamtbody");
			tbody_t.innerHTML="";
			
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				if(i==str.length-1){
					break;
				}
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?type=nptype&fp="+fp);
	
	aja.send(null);
}

function test(){
	alert(${map.pagesize});
}
</script>
</html>
