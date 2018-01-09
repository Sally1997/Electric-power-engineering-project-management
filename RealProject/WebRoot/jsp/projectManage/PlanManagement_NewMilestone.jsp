<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新建阶段</title>
	<%@include file="/head.jsp" %>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fozza.css" type="text/css">
   
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
 </head>
 <body> 
   <% 
		if(request.getParameter("pno")==null){
	  		response.sendRedirect("/servlet/ShowProjectServlet");
	  	} 
	  	request.setAttribute("pno",request.getParameter("pno"));
 	%>
	
	
<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		
    		<div class="col-lg-8" style="float:none; margin: 20px auto">
   	        <div class="panel panel-primary" style="margin: 20px auto">
    	        <div class="panel-heading">新建阶段内容</div><!-- 这里是这个项目的名字 -->
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <table id = "newms" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th align="center">阶段名称</th>
			    <th align="center">负责人</th>
			    <th align="center">开始日期</th>
			    <th align="center">截止日期</th>
			    <th align="center">预算(元)</th>
			    <th align="center">指标</th>

		    </tr>
	        </table>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>

			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">阶段新建</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
					<form action="" method="post" name="form1">
						<!--阶段名称 -->
						<div id="milestone_name" class="block">
						<div class="hehe_left">
						<font class="text">阶段名称:</font><span style="color:red">&nbsp;*</span>
						</div>
						<div class="hehe_right">
						<input type="text" name="msname" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 负责人： -->
						<div id="manager_name" class="block">
						<div class="hehe_left">
						<font class="text">负责人：</font><span style="color:red">&nbsp;*</span>
						</div>
						<div class="hehe_right">
						<input type="text" name="mngname" size="40px" disabled="disabled" style="display:none">
						<button type = "button" class = "btn btn-primary" data-toggle = "modal" data-target= "#search" onclick="search_member()">查找</button>
						</div>
						<div class="clear"></div>
						</div>

						<!-- 开始日期 -->
						<div id="start_time" class="block">
						<div class="hehe_left">
						<font class="text">开始日期：</font><span style="color:red">&nbsp;*</span>
						</div>
						<div class="hehe_right">
						<input type="date" name="StartDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>


						<!-- 截止日期 -->
						<div id="end_time" class="block">
						<div class="hehe_left">
						<font class="text">截止日期：</font><span style="color:red">&nbsp;*</span>
						</div>
						<div class="hehe_right">
						<input type="date" name="EndDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 预算 -->
						<div id="budget" class="block">
						<div class="hehe_left">
						<font class="text">预算：</font><span style="color:red">&nbsp;*</span>
						</div>
						<div class="hehe_right">
						<input type="number" name="budget" size="40px;"><span>&nbsp;&nbsp;元</span>
						</div>
						<div class="clear"></div>
						</div>

                    <div id="responsible_per" class="block">
						<div style="text-align: right">
						    <input type = "button" name = "submit" class="btn btn-primary" value = "新建阶段" onClick="return addElement();">	
							<button type="button" class="btn btn-primary" onclick="dsubmit()">结束新建</button>
						</div>
						<div class="clear"></div>
						</div>
                    </form>
                </div>
                </div>
            </div> 
    		</div>
    		</main>
	    </div>
	</div>
 </section>
 
 
<%-- 我是一个隐藏表单域 --%>
	<form method="post" name="postform" action = "${pageContext.request.contextPath}/web/servlet/stageServlet?pno=${pno }">
	<div id="hiddenarea"></div>
	</form>
 <!--      默认隐藏的内容:审批意见-->
 
 <div class="modal fade" id="handupCc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">指标详情</h4>
    </div>
    <div class="modal-body">
    	<form action="" method="post" name="form2">
    	<div id="others" class="block">
			<div class="hehe_left">
			<font class="text">指标:</font>
			</div>
			<div class="hehe_right">
			<input type="text" name="goal" size="20px;">&nbsp;&nbsp;&nbsp;&nbsp;<input type = "button" name = "ok" class="btn btn-primary" value = "新建指标" onClick="return addGoal();">
			</div>
			</div>
			<div class="clear"></div>
			<br/>
		</form>
		<form action="" method="post" name="form3">
			<table id = "goals" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th >删除</th>
			    <th>指标详情</th>
			    <th>附件需求</th>
			    
		    </tr>
		    
	        </table>
		</form>
		   
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="confirmIndex()">确认</button>
    <submit type="submit" class="btn btn-primary" onclick="removeIndex()">删除</button><!-- 我写了三个函数来做这个delete都失败了（在下面注释掉了）不过丁杰也说了可以不用js实现这个删除我就不继续试了。。。 -->
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
			<div class="hehe_left">
			<font class="text">输入:</font>
			</div>
			<div class="hehe_right">
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
  

  
 <div>
	<input type="hidden" value="开发人员测试" onclick="root()" style="position:fixed;top:40%;right:5%;z-index:999">
 </div>
  
<%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
function addElement()
{
	var vname = form1.msname.value;
	var vcharp = form1.mngname.value;
	var vstartdate = form1.StartDate.value;
	var venddate = form1.EndDate.value;
	var vbudget = form1.budget.value;
	
	var xxx=true;
	var pppp = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
	xxx = pppp.test(vbudget);
	
	var hyt = true;
	var vs = vstartdate.split("-");
	var ve = venddate.split("-");
	
	var myDate = new Date();
	if(vs.length!=3||ve.length!=3){
		hyt = false;
	}
	if(vs[0]<ve[0]){
		yyy = false;
	}
	else if(vs[1]<ve[1]){
		yyy = false;
	}
	else if(vs[2]<ve[2]){
		yyy = false;
	}
	
	if(vname==""){
		alert("请输入任务名称!");
		return;
	}
	else if(vcharp==""){
		alert("请选择负责人!");
		return;
	}
	else if(vstartdate==""||venddate==""){
		alert("请选择时间!");
		return;
	}
	else if(vbudget==""){
		alert("请输入预算金额!");
		return;
	}
	else if(!xxx){
		alert("预算金额非法输入格式!");
		return;
	}
	else if(vbudget.length>8){
		alert("预算金额非法输入格式!");
		return;
	}
	else if(yyy){
		alert("日期格式错误!请重新检查!");
		return;
	}
	
	var comfirm_sn = document.getElementsByName("fozza_sn");
	for(var dj=0;dj<comfirm_sn.length;dj++){
		if(vname==comfirm_sn[dj].value){
			alert("重复的阶段名称");
		}
	}
	
	var msname = document.createTextNode(vname);
	var mngname = document.createTextNode(vcharp);
	var StartDate = document.createTextNode(vstartdate);
	var EndDate = document.createTextNode(venddate);
	var budget = document.createTextNode(vbudget);

    var aa = document.createElement("button");
	aa.setAttribute("type","button");
	aa.setAttribute("class","btn btn-primary");
	aa.setAttribute("data-toggle","modal");
	aa.setAttribute("data-target","#handupCc");
	aa.innerHTML = "指标详情";
	
	var td_msname = document.createElement("td");
	td_msname.setAttribute("width","18%");
	td_msname.setAttribute("height","27");
	var td_mngname = document.createElement("td");
	td_mngname.setAttribute("width","30%");
	td_mngname.setAttribute("height","27");
	var td_StartDate = document.createElement("td");
	td_StartDate.setAttribute("width","18%");
	td_StartDate.setAttribute("height","27");
	var td_EndDate = document.createElement("td");
	td_EndDate.setAttribute("width","18%");
	td_EndDate.setAttribute("height","27");
	var td_budget = document.createElement("td");
	td_budget.setAttribute("width","18%");
	td_budget.setAttribute("height","27");
	var td_goal = document.createElement("td");
	td_goal.setAttribute("width","10%");
	td_goal.setAttribute("height","27");
	var tr = document.createElement("tr"); 
	//创建一个tr类型的Element节点
	var tbody = document.createElement("tbody"); 
	//创建一个tbody类型的Element节点
	//将TextNode节点加入到td类型的节点中
	td_msname.appendChild(msname);
	td_mngname.appendChild(mngname);
	td_StartDate.appendChild(StartDate);
	td_EndDate.appendChild(EndDate);
	td_budget.appendChild(budget);
	td_goal.appendChild(aa);

	//将td类型的节点添加到tr节点中
	tr.appendChild(td_msname);
	tr.appendChild(td_mngname);	
	tr.appendChild(td_StartDate);	
	tr.appendChild(td_EndDate);	
	tr.appendChild(td_budget);	
	tr.appendChild(td_goal);	
	tbody.appendChild(tr); //将tr节点加入tbody中

	var tComment = document.getElementById("newms"); //获取table对象

	tComment.appendChild(tbody); //将节点tbody加入节点尾部
	
	//将提交的表单值保存到隐藏域 隐藏表单传值
	var ha = document.getElementById("hiddenarea");
	var cf = document.createElement("div");
	var ci = document.createElement("input");
	
	//阶段名称
	ci.setAttribute("name", "fozza_sn");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value", form1.msname.value);
	cf.appendChild(ci);
	
	//给指标详情按钮添加事件
	aa.setAttribute("onclick","javascript:ifclick('"+ci.value+"')");
	
	//审核人
	ci = document.createElement("input");
	ci.setAttribute("name","fozza_cp");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value",form1.mngname.value);
	cf.appendChild(ci);
	
	//开始日期
	ci = document.createElement("input");
	ci.setAttribute("name","fozza_st");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value",form1.StartDate.value);
	cf.appendChild(ci);
	
	//结束日期
	ci = document.createElement("input");
	ci.setAttribute("name","fozza_et");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value",form1.EndDate.value);
	cf.appendChild(ci);
	
	//预算
	ci = document.createElement("input");
	ci.setAttribute("name","fozza_bg");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value",form1.budget.value);
	cf.appendChild(ci);
	
	//指标内容
	ci = document.createElement("input");
	ci.setAttribute("name", "indexcontent")
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value", "");
	cf.appendChild(ci);
	
	//是否需要指标附件	
	ci = document.createElement("input");
	ci.setAttribute("name", "attachmentneed");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("value", "");
	cf.appendChild(ci);
	
	//添加到表单
	ha.appendChild(cf);
	
	form1.msname.value="";
	form1.mngname.value="";
	form1.StartDate.value="";
	form1.EndDate.value="";
	form1.budget.value="";
	
	return false;
}

function ifclick(v){
	var clear_goal = document.getElementsByName("goal")[0];
	clear_goal.value = "";
	
	var tComment = document.getElementById("goals");
	while(tComment.hasChildNodes()){
		tComment.removeChild(tComment.firstChild);
	}
	
	//bigsn
	bigsn = v;
	
	//用来获取input的value值
	var indexinfo = "";
	var indexneed = "";
	
	var sn_name = document.getElementsByName("fozza_sn");
	
	for(i=0;i<sn_name.length;i++){
		if(sn_name[i].value==v){
			indexinfo = document.getElementsByName("indexcontent")[i].value;
			if(indexinfo==""){
				return;
			}
			indexneed = document.getElementsByName("attachmentneed")[i].value;
			break;
		}
	}
	
	var array_ii = indexinfo.split(",");
	var array_in = indexneed.split(",");
	
	for(i=0;i<array_ii.length;i++){
			//<!-- 我这么重要当然要输出啦-->
			//alert(bigar[i].dj_ii[j]);
			
			//创建一个文本节点
			var goal = document.createTextNode(array_ii[i]);
			
			//创建一个复选框
			var dlt = document.createElement("input");
			dlt.setAttribute("name","deletenode");//复选框name为deletenode
			dlt.setAttribute("type","checkbox");
			
			//创建单选
			
			var sth = document.createElement("input");
			sth.setAttribute("name",array_ii[i]);
			sth.setAttribute("type","radio");
			var sthw = document.createElement("span");
			sthw.innerHTML = "Yes";
			var nth = document.createElement("input");
			nth.setAttribute("type","radio");
			nth.setAttribute("name",array_ii[i]);
			var nthw = document.createElement("span");
			nthw.innerHTML = "No";
			//设置单选框默认值
			if(array_in[i]==0){
				nth.setAttribute("checked","true");
			}
			else{
				sth.setAttribute("checked","true");
			}
			var td_goal = document.createElement("td");
			td_goal.setAttribute("width","50%");
			td_goal.setAttribute("height","27");
			var td_dlt = document.createElement("td");
			td_dlt.setAttribute("width","20%");
			td_dlt.setAttribute("height","27");
			var td_sth = document.createElement("td");
			td_sth.setAttribute("width","30%");
			td_sth.setAttribute("height","27");
			var tr = document.createElement("tr"); 
			
			//创建一个tr类型的Element节点
			var tbody = document.createElement("tbody"); 
			//创建一个tbody类型的Element节点
			//将TextNode节点加入到td类型的节点中
			td_dlt.appendChild(dlt);
			td_goal.appendChild(goal);
			td_sth.appendChild(sth);
			td_sth.appendChild(sthw);
			td_sth.appendChild(nth);
			td_sth.appendChild(nthw);
			
			//将td类型的节点添加到tr节点中
			tr.appendChild(td_dlt);
			tr.appendChild(td_goal);	
			tr.appendChild(td_sth);	
			
			tbody.appendChild(tr); //将tr节点加入tbody中
			tbody.setAttribute("name","iambody");//获取到节点的方式方便之后进行删除

			var tComment = document.getElementById("goals"); //获取table对象

			tComment.appendChild(tbody); //将节点tbody加入节点尾部
	}
}

function addGoal()
{
	//alert(bigsn); 通过点击指标详情，获取到你正在查看的阶段名称
	
	//用来获取input的value值
	var indexinfo = "";
	
	var sn_name = document.getElementsByName("fozza_sn");
	
	for(i=0;i<sn_name.length;i++){
		if(sn_name[i].value==bigsn){
			indexinfo = document.getElementsByName("indexcontent")[i].value;
			break;
		}
	}
	
	var clear_goal = document.getElementsByName("goal")[0];
	var goal_value = clear_goal.value;
	
	if(goal_value==""){
		alert("请输入指标内容!");
		return;
	}
	
	//检测输入指标内容是否重复
	var array_ii = indexinfo.split(",");
	for(j=0;j<array_ii.length;j++){
		if(goal_value==array_ii[j]){
			alert("重复的指标内容!请重新输入!");
			return;
		}
	}
	
	var goal = document.createTextNode(goal_value);
	
	//<!-- 我是分割线啊，你是谁啊-->
	
    var dlt = document.createElement("input");
	dlt.setAttribute("name","deletenode");//复选框name为deletenode
	dlt.setAttribute("type","checkbox");
	dlt.setAttribute("value","指标一");/*这里的value应该是你指标的名字*/

	var sth = document.createElement("input");
	sth.setAttribute("name",goal_value);/*这里的name应该是你指标的名字*/
	sth.setAttribute("type","radio");
	//sth.setAttribute("onClick","javascript:cursor_up=1;alert(cursor_up);");//被选定的时候置为1
	var sthw = document.createElement("span");
	sthw.innerHTML = "Yes";
	var nth = document.createElement("input");
	nth.setAttribute("type","radio");
	nth.setAttribute("name",goal_value);/*这里的name应该是你指标的名字*/
	nth.setAttribute("checked","true");//默认
	//nth.setAttribute("onClick","javascript:cursor_up=0;alert(cursor_up);");
	//这是一个很失败的想法，我希望通过改变单标签状态的时候改变cursor_up的值，但这个函数执行的时候就已经把我赋给它的初值push进数组了
	var nthw = document.createElement("span");
	nthw.innerHTML = "No";

	var td_goal = document.createElement("td");
	td_goal.setAttribute("width","50%");
	td_goal.setAttribute("height","27");
	var td_dlt = document.createElement("td");
	td_dlt.setAttribute("width","20%");
	td_dlt.setAttribute("height","27");
	var td_sth = document.createElement("td");
	td_sth.setAttribute("width","30%");
	td_sth.setAttribute("height","27");
	var tr = document.createElement("tr"); 
	
	//创建一个tr类型的Element节点
	var tbody = document.createElement("tbody"); 
	//创建一个tbody类型的Element节点
	//将TextNode节点加入到td类型的节点中
	td_dlt.appendChild(dlt);
	td_goal.appendChild(goal);
	td_sth.appendChild(sth);
	td_sth.appendChild(sthw);
	td_sth.appendChild(nth);
	td_sth.appendChild(nthw);

	//将td类型的节点添加到tr节点中
	tr.appendChild(td_dlt);
	tr.appendChild(td_goal);	
	tr.appendChild(td_sth);	
	
	tbody.appendChild(tr); //将tr节点加入tbody中
	tbody.setAttribute("name","iambody");//获取到节点的方式方便之后进行删除

	var tComment = document.getElementById("goals"); //获取table对象

	tComment.appendChild(tbody); //将节点tbody加入节点尾部
	
	clear_goal.value="";
	//<!-- 将index content 和 if need upload 加入数组中 -->
	
	if(indexinfo==""){
		indexinfo += goal_value;
	}
	else{
		indexinfo += "," + goal_value;
	}
	
	document.getElementsByName("indexcontent")[i].value = indexinfo;
	return false;
}

function confirmIndex(){
	//点完确认以后将对象push进数组
	//用来获取input的value值
	var indexinfo = "";
	var indexneed = "";
	
	var sn_name = document.getElementsByName("fozza_sn");
	
	for(i=0;i<sn_name.length;i++){
		if(sn_name[i].value==bigsn){
			indexinfo = document.getElementsByName("indexcontent")[i].value;
			break;
		}
	}
	
	if(indexinfo==""){
		return;
	}
	
	//将该阶段下指标内容分割
	var array_ii = indexinfo.split(",");
	
	var k = "";
	for(i=0;i<array_ii.length;i++){
		var tmp = document.getElementsByName(array_ii[i])[0];
		if(tmp.checked==true){
			k = "1";			
		}
		else{
			k = "0";
		}
		
		if(indexneed==""){
			indexneed += k;
		}
		else{
			indexneed += "," + k;
		}
	}	
	
	for(i=0;i<sn_name.length;i++){
		if(sn_name[i].value==bigsn){
			document.getElementsByName("attachmentneed")[i].value = indexneed;
			break;
		}
	}
}

function removeIndex(){
	//分割一下 删除节点的时候，因为点确认才会给是否选中附件输入框赋值，所以这里要删除指标内容
	var indexinfo = "";
	var new_indexinfo = "";
	
	var delete_indexinfo = "";
	
	var sn_name = document.getElementsByName("fozza_sn");
	
	var cursor;
	
	for(cursor=0;cursor<sn_name.length;cursor++){
		if(sn_name[cursor].value==bigsn){
			indexinfo = document.getElementsByName("indexcontent")[cursor].value;
			break;
		}
	}
	
	var array_ii = indexinfo.split(",");//切割指标内容
	//分割一下

	var p = document.getElementsByName("deletenode");
	var getn = document.getElementsByName("iambody");
	var len = p.length;
	
	for(i=0;i<len;i++){
		if(p[i].checked==false){
			if(new_indexinfo==""){
				new_indexinfo += array_ii[i];
			}
			else{
				new_indexinfo += "," + array_ii[i];
			}
		}
		else{
			if(delete_indexinfo==""){
				delete_indexinfo += array_ii[i];
			}
			else{
				delete_indexinfo += "," + array_ii[i];
			}
		}
	}
	
	alert("您删除的指标内容为:"+delete_indexinfo);
	
	for(i=len-1;i>=0;i--){
		if(p[i].checked==true){
			//直接remove索引值会改变……所以倒着删除
			getn[i].parentNode.removeChild(getn[i]);
		}
	}
	
	document.getElementsByName("indexcontent")[cursor].value = new_indexinfo;
}


function dsubmit(){
	var confirm_sn = document.getElementsByName("fozza_sn")[0];
	if(confirm_sn==null){
		alert("请至少创建一个阶段!")
		return;
	}
	
	var confirm_index = document.getElementsByName("indexcontent");
	for(var i=0;i<confirm_index.length;i++){
		if(confirm_index[i].value==""){
			alert("请为阶段填写至少一个指标内容!");
			return;
		}
	}
	
	alert("数据提交中……请等待服务器结果");
	var pf = document.getElementsByName("postform")[0];
	pf.submit();
}


//分割线
function give_option(){
	var ccp = document.getElementsByName("choose_char_per");
	//这个是弹窗的id
	var ser = document.getElementsByName("search")[0];
	var mng = document.getElementsByName("mngname")[0];  
	for(var i=0;i<ccp.length;i++){
		if(ccp[i].checked==true){
			mng.value = ccp[i].value;
			mng.style.display = "";
			break;
		}
	}
}

function search_member(){
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
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ptype");
	
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
		aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ptype");
	}
	else{
		aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?pno=${pno}&type=ctype");
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
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/staffInfoFindServlet?pno=${pno}&type=ptype&keyword="+window.encodeURI(keyword));
	
	aja.send(null);
}
</script>
</html>
