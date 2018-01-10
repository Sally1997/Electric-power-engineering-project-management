<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.holyshit.domain.DTree" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>项目详情</title>
    <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";
	</script>	
    <style type="text/css">
    * {
    padding: 0;
    margin: 0;
    font-family: "microsoft yahei";
  }
  ul li {
    list-style-type: none;
  }
  .box {
    width: 200px;
    /*border: 1px solid red;*/
  }
  ul {
    margin-left: 20px;
    /*border: 1px solid blue;*/
  }
  .menuUl li {
    margin: 10px 0;
  }
  .menuUl li span:hover {
    text-decoration: underline;
    cursor: pointer;
  }
  .menuUl li i { margin-right: 10px; top: 0px; cursor: pointer; color: #161616;       }
</style>
 </head>
 <body> 
 <!--   导航栏-->
  	   
	
<% 
	if(request.getParameter("pno")==null){
  		response.sendRedirect("/servlet/ShowProjectServlet");
  	} 
  	request.setAttribute("pno",request.getParameter("pno"));
  	request.setAttribute("ptn", "");
 %>
<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-14 main-content">
    		
    		<div class="col-lg-6" >
   	        <div class="panel panel-primary" >
    	        <div class="panel-heading">项目相关</div><!-- 这里是这个项目的名字 -->
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 
                 <div class="innerUl"></div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/proTree.js" ></script>
<script type="text/javascript">
//后台传入的 标题列表
var arr=${s};

$(".innerUl").ProTree({
  arr: arr,
  simIcon: "glyphicon glyphicon-file",//单个标题字体图标
  mouIconOpen: "glyphicon glyphicon-folder-open",//含多个标题的打开字体图标 
  mouIconClose:"glyphicon glyphicon-folder-close",//含多个标题的关闭的字体图标
  callback: function(id) {
    //alert("你选择的id是" + id + "，名字是" + name);
    var tb = document.getElementById("thisBlock");
    var bitch = document.getElementById("bitch");
    
    var fozza_dj_l = id.toString();
    if(fozza_dj_l.length==5){
    	tb.style.display = "none";
    	bitch.style.display = "";
    }
    else{
    	tb.style.display = "";
    	bitch.style.display = "none";
    }
    
    var aja = new XMLHttpRequest();
    aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var str = aja.responseText;
				var ss = eval("("+str+")");
				var p = document.getElementById("fozza_where");
				p.innerHTML = "节点";
				p = document.getElementById("task_name");
				p.innerHTML = ss.no;
				p = document.getElementById("TaskName");
				p.innerHTML = ss.name;
				p = document.getElementById("CharP");
				p.innerHTML = ss.charpname+"("+ss.staffno+")";
				p = document.getElementById("new_s_time");
				p.innerHTML = ss.stime;
				p = document.getElementById("new_e_time");
				p.innerHTML = ss.etime;
				p = document.getElementById("new_budget");
				p.innerHTML = ss.budget;
				if (ss.indexinfo == "") {
					p = document.getElementsByName("new_fl")[0];
					p.style.display = "none";
					p = document.getElementById("new_index");
					p.style.display = "none";
				} else {
					p = document.getElementsByName("new_fl")[0];
					p.style.display = "block";
					p = document.getElementById("new_index");
					p.style.display = "block";
					//获取到ul
					var nii = document.getElementById("new_indexinfo");
					//获取到指标数组
					var ii = ss.indexinfo;
					var aq = ss.achreq;
					
					var ih = "";
					for(var i=0;i<ii.length;i++){
						ih += "<li name='createli' value="+aq[i]+">"+ii[i]+"</li>";
					}
					nii.innerHTML = ih;
				}
			}
		}
		//创建连接
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+id+"&time="+new Date().getTime());
		//发送请求
		aja.send(null);
  }
})
</script>
                 </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>

			<div id="account" class="col-lg-6" style="padding-left: 10px">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading"><span id="fozza_where">任务节点</span><span id="task_name">Child2.2.2</span>详细信息</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
					
					<div id="responsible_per" class="block">
						<div id="first_left">
						<font>任务名称:</font>
						</div>
						<div id="first_right">
						<font id="TaskName"></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >负责人:</font>
						</div>
						<div id="first_right">
						<div class="dropdown"><font id="CharP"></font>
						<input type="text" style="display:none" id="fozza_text" onblur="resetecho()">
            <!-- <span onclick="altercharp()" class="glyphicon glyphicon-pencil" style="cursor: pointer;" id="dropdownMenu1" data-toggle="dropdown"></span>
             -->
            <span onclick="search_member()" class="glyphicon glyphicon-pencil" style="cursor: pointer;" id="dropdownMenu1" data-toggle = "modal"></span>
            
              <!-- <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><input type="text" name="fozza_change" size="15px;"/></li>
                <li><input type = "button" style="float:right;" name = "altername" class="btn btn-primary" value = "修改" onclick="changename()"/></li>
              </ul>纪丽！这里样式要改一下！ -->
          </div>
						</div>
						<div class="clear"></div>
						</div>
          <!-- 我虽然写了修改的js，但它蜜汁不成功，我也没时间调试了。。。谁帮忙改一下。。。 -->

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >开始日期:</font>
						</div>
						<div id="first_right">
						<font id="new_s_time"></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >截止日期：</font>
						</div>
						<div id="first_right">
						<font id="new_e_time"></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >预算：</font>
						</div>
						<div id="first_right">
						<font id="new_budget"></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left" name="new_fl">
						<font >指标：</font>
						</div>
						<div id="first_right">
						<font id="new_index">
							<ul id="new_indexinfo"></ul> 
						</font>
						</div>
						</div>
                        
            <div class="clear"></div>
            <div id="responsible_per" class="block">
            <div style="text-align: right;display:none"  id="thisBlock">
              <button id="tijiao" type="button" class="btn btn-primary"data-toggle="modal" onclick="popup()">提交</button>
              <button type="button" class="btn btn-primary" data-toggle="modal" onclick="newChildTask()">新建子任务</button>
            </div>
            <div id="bitch" style="height:34px"></div>
            
            <div class="clear"></div>
            </div>

                </div>
                </div>
            </div> 
    		</div>
    		
    		</main>
	    </div>
	</div>
 </section>




	<!-- 我是一个好萌好萌的分割线嘞 -->
	<!-- 因为这里实在是太长太长了-->
	<!-- 太难翻到了-->
	<!-- 所以去吃屎吧-->
  <div class="modal fade" id="handupDc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">提交</h4>
      </div>
      <div class="modal-body">
      
      <!-- 表单名字 -->
      <form id="popform" class="form-upload" method="post" enctype="multipart/form-data">
		<!-- 建立一个隐藏域来保存表单值 -->
          <div class="form-group">
        <label for="projectname" class="col-sm-2 control-label">任务编号:</label>
        <div class="col-sm-8">
          <span id="pop_taskno"></span>
          <input type="hidden" name="ftask_no" value="">
        </div>
        </div>
        <div class="clear"></div>

        <div class="form-group">
        <label for="projecttype" class="col-sm-2 control-label">任务名称:</label>
        <div class="col-sm-8">
          <span id="pop_taskname"></span>
          <input type="hidden" name="ftask_name" value="">
        </div>
        </div>
        <div class="clear"></div>

        <div class="form-group">
        <label for="projecttype" class="col-sm-2 control-label">负责人:</label>
        <div class="col-sm-8">
         	<span id="pop_charpname"></span>
         	<input type="hidden" name="fchar_per" value="">
        </div>
        </div>
        <div class="clear"></div>

          <div class="form-group" id="bigindex">
        <label for="addfile" class="col-sm-2 control-label">任务指标:</label>
        <div class="col-sm-8">
          <font>
              <ul id="pop_index"></ul>
            </font>
        </div>
        </div>
        <div class="clear"></div>
        <!-- 以上是form表单的内容，我是一个萌萌的分割线 -->
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary" onclick="goServlet1()">提交</button>
      </div>
    </div>
  </div>
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
			<div id="first_left">
			<font class="text">输入:</font>
			</div>
			<div id="first_right">
			<input type="text" id="getme" name="goal" size="20px;">&nbsp;&nbsp;
			<input type = "button" name = "ok" class="btn btn-primary" value = "查找" onClick="search_staff()">
			<input name = "where" type = "radio" value = "in" checked="checked" onclick="choosepoc(this)"><span>项目内</span>
			<input name = "where" type = "radio" value = "out" onclick="choosepoc(this)"><span>公司内</span>
			</div>
			</div>
			<div class="clear"></div>
			<br/>
		</form>
		<form action="" method="post" name="form3">
			<table id = "member_table" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th>选择</th>
			    <th>标号</th>
			    <th>姓名</th>
			    <th>联系方式</th>
			    <th>职责</th>
			    <th>备注</th>
			    <!-- 编号，名字，电话号，职责，备注 -->
		    </tr>
		    <tbody id="iamtbody"></tbody>
		    <!-- <tr>
		    	<td>
		    		<input name = "choose_char_per" type= "radio" value = "'开发人员'+'('+'201526010001'+')'" />
		    	</td>
			    <td>201526010001</td>
			    <td>OO</td>
			    <td>12222222221</td>
			    <td>开发人员</td>
			    <td>老大</td>
		    </tr> -->
		    
	        </table>
		</form>
		   
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
//新建子任务跳转
function newChildTask(){
	//提交和新建子任务是负责人的权限
	var djp = document.getElementById("CharP");

	var judge = "${staff.name}(${staff.staffno})";
	
	if(judge!=djp.innerHTML){
		alert("只有负责人才可以新建子任务!");
		return;
	}
	
    var links_ti = document.getElementById("task_name").innerHTML;
    window.location.href = "${pageContext.request.contextPath }/jsp/projectManage/PlanManagement_NewTask.jsp?pno=${pno}&ptn="+links_ti;
}

//提交表单
function goServlet1(){
	var file = document.getElementsByName("indexfile");
	for(var i=0;i<file.length;i++){
		if(file[i].value==""){
			alert("请确认需要上传文件的指标信息!");
			return;
		}
	}

	 var form = document.getElementById("popform");
	 alert("数据提交中……请等待服务器结果");
	 form.action = "${pageContext.request.contextPath }/web/servlet/submitTaskServlet?pno=${pno}";
	 form.submit();
}

//弹窗显示
function popup(){
	//提交和新建子任务是负责人的权限
	var djp = document.getElementById("CharP");

	var judge = "${staff.name}(${staff.staffno})";
	var tj = document.getElementById("tijiao");//data-target="#handupDc"
	
	if(judge!=djp.innerHTML){
		tj.setAttribute("data-target", "");
		alert("只有负责人才可以提交任务!");
		return;
	}
	else{
		tj.setAttribute("data-target", "#handupDc");
	}
	//权限部分

	//dg=dpcument.get 弹出的窗口
	var dg = document.getElementById("pop_taskno");
	//p代表获取值
	var p = document.getElementById("task_name");
	//隐藏域的值
	var hiddenvalue = document.getElementsByName("ftask_no")[0];
	dg.innerHTML = p.innerHTML;
	hiddenvalue.value = p.innerHTML;
	
	
	dg = document.getElementById("pop_taskname");
	p = document.getElementById("TaskName");
	hiddenvalue = document.getElementsByName("ftask_name")[0];
	dg.innerHTML = p.innerHTML;
	hiddenvalue.value = p.innerHTML;
	
	
	dg = document.getElementById("pop_charpname");
	hiddenvalue = document.getElementsByName("fchar_per")[0];
	p = document.getElementById("CharP");
	dg.innerHTML = p.innerHTML;
	hiddenvalue.value = p.innerHTML;
	
	//根据指标数量动态生成上传文件按钮
	p = document.getElementsByName("createli");
	dg = document.getElementById("pop_index");
	dg.innerHTML = "";
	var bi = document.getElementById("bigindex");
	var len = p.length;
	//如果指标数量为0贼无需上传文件块
	if(len==0){
		bi.style.display = "none";
	}
	else{
		bi.style.display = "";
		for(var i=0; i<len; i++){
			if(p[i].value=="1"){
				dg.innerHTML += "<li>"+p[i].innerHTML+"<input type='file' name='indexfile'>"+
					"<input type='hidden' value="+p[i].innerHTML+" name='index'></li>";
			}
			else{
				dg.innerHTML += "<li>"+p[i].innerHTML+"<div style='height:20px'></div>";
			}
		}
	}
}

//ajax获取节点信息
var aja = new XMLHttpRequest();
	window.onload = function(){
		aja.onreadystatechange = function(){
			if(aja.readyState==4&&aja.status==200){
				var str = aja.responseText;
				var ss = eval("("+str+")");
				var p = document.getElementById("fozza_where");
				p.innerHTML = "节点";
				p = document.getElementById("task_name");
				p.innerHTML = ss.no;
				p = document.getElementById("TaskName");
				p.innerHTML = ss.name;
				p = document.getElementById("CharP");
				p.innerHTML = ss.charpname+"("+ss.staffno+")";
				p = document.getElementById("new_s_time");
				p.innerHTML = ss.stime;
				p = document.getElementById("new_e_time");
				p.innerHTML = ss.etime;
				p = document.getElementById("new_budget");
				p.innerHTML = ss.budget;
				p = document.getElementsByName("new_fl")[0];
				p.style.display = "none";
				p = document.getElementById("new_index");
				p.style.display = "none";
			}
		}
		//创建连接
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+${s}[0].id+"&time="+new Date().getTime());
		//发送请求
		aja.send(null);
	}


//以下是选择用户功能
function search_member(){
	var djp = document.getElementById("CharP");

	var judge = "${staff.name}(${staff.staffno})";
	var tj = document.getElementById("dropdownMenu1");//data-target= "#search"
	
	if(judge!=djp.innerHTML){
		tj.setAttribute("data-target", "");
		alert("只有负责人才可以修改负责人!");
		return;
	}
	else{
		tj.setAttribute("data-target", "#search");
	}

	var tbody_t = document.getElementById("iamtbody");
	var childs = tbody_t.childNodes;
	for(var i=childs.length-1;i>=0;i--){
		tbody_t.removeChild(childs[i]);
	}
	
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				var dutytxt = document.createTextNode(str[i].duty);
				var notestxt = document.createTextNode(str[i].notes);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				var td_duty = document.createElement("td");
				var td_notes = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				td_duty.appendChild(dutytxt);
				td_notes.appendChild(notestxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				tr_t.appendChild(td_duty);
				tr_t.appendChild(td_notes);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ptype&time="+new Date().getTime());
	
	aja.send(null);
}

function choosepoc(poc){
	var tbody_t = document.getElementById("iamtbody");
	var childs = tbody_t.childNodes;
	for(var i=childs.length-1;i>=0;i--){
		tbody_t.removeChild(childs[i]);
	}
	
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				var dutytxt = document.createTextNode(str[i].duty);
				var notestxt = document.createTextNode(str[i].notes);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				var td_duty = document.createElement("td");
				var td_notes = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				td_duty.appendChild(dutytxt);
				td_notes.appendChild(notestxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				tr_t.appendChild(td_duty);
				tr_t.appendChild(td_notes);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	if(poc.value=="in"){
		aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ptype&time="+new Date().getTime());
	}
	else{
		aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ctype&time="+new Date().getTime());
	}
	aja.send(null);
}

function search_staff(){
	var wh = document.getElementsByName("where")[1];
	wh.checked = "checked";
	
	var tbody_t = document.getElementById("iamtbody");
	var childs = tbody_t.childNodes;
	for(var i=childs.length-1;i>=0;i--){
		tbody_t.removeChild(childs[i]);
	}
	
	var g = document.getElementById("getme");
	var keyword = g.value;
	
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			var str = eval("("+aja.responseText+")");
			
			for(var i=0;i<str.length;i++){
				//每个radio的value值
				var v = str[i].name+"("+str[i].staffno+")";
				
				//分别创建姓名，编号，联系方式，职责和备注的五个文本节点
				var nametxt = document.createTextNode(str[i].name);
				var staffnotxt = document.createTextNode(str[i].staffno);
				var tetxt = document.createTextNode(str[i].te);
				var dutytxt = document.createTextNode(str[i].duty);
				var notestxt = document.createTextNode(str[i].notes);
				
				//创建td节点
				var td_radio = document.createElement("td");
				var td_input = document.createElement("input");
				td_input.setAttribute("name", "choose_char_per");
				td_input.setAttribute("value", v);
				td_input.setAttribute("type", "radio");
				
				var td_staffno = document.createElement("td");
				var td_name = document.createElement("td");
				var td_te = document.createElement("td");
				var td_duty = document.createElement("td");
				var td_notes = document.createElement("td");
				
				//插入节点
				td_radio.appendChild(td_input);
				td_staffno.appendChild(staffnotxt);
				td_name.appendChild(nametxt);
				td_te.appendChild(tetxt);
				td_duty.appendChild(dutytxt);
				td_notes.appendChild(notestxt);
				
				//装在tr里面
				var tr_t = document.createElement("tr");
				tr_t.appendChild(td_radio);
				tr_t.appendChild(td_staffno);
				tr_t.appendChild(td_name);
				tr_t.appendChild(td_te);
				tr_t.appendChild(td_duty);
				tr_t.appendChild(td_notes);
				
				//把创建的tr都保存在tbody里面，方便每次删除
				//tbody_t = document.getElementById("iamtbody");
				tbody_t.appendChild(tr_t);
				
				//获取tableID
				var table_t = document.getElementById("member_table");
				table_t.appendChild(tbody_t);
			}
		}
	}
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/staffInfoFindServlet?pno=${pno}&type=ptype&keyword="+window.encodeURI(keyword)+"&time="+new Date().getTime());
	
	aja.send(null);
}


//选择按钮事件
function give_option(){
	var aja = new XMLHttpRequest();
	var node = document.getElementById("task_name").innerHTML;
	var rcpn = null;
	
	var ccp = document.getElementsByName("choose_char_per");
	//这个是弹窗的id
	var ser = document.getElementsByName("search")[0];
	var p = document.getElementById("CharP");  
	for(var i=0;i<ccp.length;i++){
		if(ccp[i].checked==true){
			p.innerHTML = ccp[i].value;
			rcpn = ccp[i].value;
			break;
		}
	}
	
	aja.onreadystatechange = function(){
		if(aja.readyState==4&&aja.status==200){
			alert(aja.responseText);
		}
	}
	
	alert("您将修改负责人为"+rcpn);
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/changeTaskCharP?rcpn="+rcpn+"&node="+node);
	aja.send(null);
}

</script>
</html>
