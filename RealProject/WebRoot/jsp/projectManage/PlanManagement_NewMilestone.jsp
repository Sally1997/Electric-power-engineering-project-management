<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PlanManagement_NewMilestone</title>

 </head>
 <body> 
   <%@include file="/head.jsp" %>
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fozza.css" type="text/css">
   
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
	
	<%-- div下拉菜单 --%>
	<div id="fozza1" class="fozza2"></div>
	<%-- 我是一个隐藏表单域 --%>
	<form method="post" name="postform">
	<div id="hiddenarea"></div>
	</form>
	
<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		
    		<div class="col-lg-8" style="float:none; margin: 20px auto">
   	        <div class="panel panel-primary" style="margin: 20px auto">
    	        <div class="panel-heading">test01</div><!-- 这里是这个项目的名字 -->
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
						<div id="first_left">
						<font class="text">阶段名称:</font>
						</div>
						<div id="first_right">
						<input type="text" name="msname" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 负责人： -->
						<div id="manager_name" class="block">
						<div id="first_left">
						<font class="text">负责人：</font>
						</div>
						<div id="first_right">
						<input type="text" name="mngname" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 开始日期 -->
						<div id="start_time" class="block">
						<div id="first_left">
						<font class="text">开始日期：</font>
						</div>
						<div id="first_right">
						<input type="date" name="StartDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>


						<!-- 截止日期 -->
						<div id="end_time" class="block">
						<div id="first_left">
						<font class="text">截止日期：</font>
						</div>
						<div id="first_right">
						<input type="date" name="EndDate" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 预算 -->
						<div id="budget" class="block">
						<div id="first_left">
						<font class="text">预算：</font>
						</div>
						<div id="first_right">
						<input type="number" name="budget" size="40px;"><span>&nbsp;&nbsp;元</span>
						</div>
						<div class="clear"></div>
						</div>

                    <div id="responsible_per" class="block">
						<div style="text-align: right">
						    <input type = "submit" name = "submit" class="btn btn-primary" value = "新建任务" onClick="return addElement();">	
							<button type="button" class="btn btn-primary" ><a href="javascript:dsubmit()" style="color:white;">结束新建</a></button>
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
			<div id="first_left">
			<font class="text">指标:</font>
			</div>
			<div id="first_right">
			<input type="text" name="goal" size="20px;">&nbsp;&nbsp;&nbsp;&nbsp;<input type = "submit" name = "ok" class="btn btn-primary" value = "新建指标" onClick="return addGoal();">
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

  
 <div>
	<input type="button" value="开发人员测试" onclick="root()" style="position:fixed;top:40%;right:5%;z-index:999">
 </div>
  
<footer class="copyright">
  <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
  </div>
  </footer>
</body>
<script type="text/javascript">
//全局的大阶段名称
var bigsn = "";
var bigar = new Array();//存放对象的数组big array
var i,j;

function Index(){
	var dj_sn;//阶段名称
	var dj_ii;//indexinfo
	var dj_up;//new upload?
}

var dxi = new Index();//新建一个对象i
dxi.dj_ii = new Array();
dxi.dj_up = new Array();

function ifclick(v){
	var tComment = document.getElementById("goals");
	while(tComment.hasChildNodes()){
		tComment.removeChild(tComment.firstChild);
	}
	bigsn = v;
	for(i=0;i<bigar.length;i++){
		if(bigar[i].dj_sn==bigsn){
			//如果在bigar数组里面找到对象的名字和当前阶段的名字相同的话就循环创建节点
			for(j=0;j<bigar[i].dj_ii.length;j++){
				<!-- 我这么重要当然要输出啦-->
				//alert(bigar[i].dj_ii[j]);
				
				//创建一个文本节点
				var goal = document.createTextNode(bigar[i].dj_ii[j]);
				
				//创建一个复选框
				var dlt = document.createElement("input");
				dlt.setAttribute("name","deletenode");//复选框name为deletenode
				dlt.setAttribute("type","checkbox");
				
				//创建单选
				
				var sth = document.createElement("input");
				sth.setAttribute("name",bigar[i].dj_ii[j]);
				sth.setAttribute("type","radio");
				var sthw = document.createElement("span");
				sthw.innerHTML = "Yes";
				var nth = document.createElement("input");
				nth.setAttribute("type","radio");
				nth.setAttribute("name",bigar[i].dj_ii[j]);
				var nthw = document.createElement("span");
				nthw.innerHTML = "No";
				//设置单选框默认值
				if(bigar[i].dj_up[j]==0){
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
	}
}




function addGoal()
{
	//alert(bigsn); 通过点击指标详情，获取到你正在查看的阶段名称
	dxi.dj_sn = bigsn;
	var cursor_ii = "";//建立一个indexcontent的游标cursor 还是对应名字吧……
	var cursor_up = 0;//if need是否需要附件 变量太多在下记不住啊
	
	var goal = document.createTextNode(form2.goal.value);
	cursor_ii = form2.goal.value;//获取指标内容
	//alert(cursor_ii);
	
	<!-- 我是分割线啊，你是谁啊-->
	
    var dlt = document.createElement("input");
	dlt.setAttribute("name","deletenode");//复选框name为deletenode
	dlt.setAttribute("type","checkbox");
	dlt.setAttribute("value","指标一");/*这里的value应该是你指标的名字*/

	var sth = document.createElement("input");
	sth.setAttribute("name",cursor_ii);/*这里的name应该是你指标的名字*/
	sth.setAttribute("type","radio");
	//sth.setAttribute("onClick","javascript:cursor_up=1;alert(cursor_up);");//被选定的时候置为1
	var sthw = document.createElement("span");
	sthw.innerHTML = "Yes";
	var nth = document.createElement("input");
	nth.setAttribute("type","radio");
	nth.setAttribute("name",cursor_ii);/*这里的name应该是你指标的名字*/
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
	
	form2.goal.value="";
	<!-- 将index content 和 if need upload 加入数组中 -->
	dxi.dj_ii.push(cursor_ii);
	return false;

}
	
function confirmIndex(){
	//点完确认以后将对象push进数组	
	for(i=0;i<dxi.dj_ii.length;i++){
		var tmp = document.getElementsByName(dxi.dj_ii[i])[0];
		if(tmp.checked==true){
			j=1;			
		}
		else{
			j=0;
		}
		dxi.dj_up.push(j);
	}
	
	//把此对象压入大数组
	bigar.push(dxi);
	
	//初始化对象
	dxi = new Index();
	dxi.dj_ii = new Array();
	dxi.dj_up = new Array();
}

function root(){
	//实测可以，给自己奖励个大红花
	for(var m=0;m<bigar.length;m++){
		alert(bigar[m].dj_sn);
		for(n=0;n<bigar[m].dj_ii.length;n++){
			alert(bigar[m].dj_ii[n]+"&&"+bigar[m].dj_up[n]);
		}
	}
}

function removeIndex(){
	var p = document.getElementsByName("deletenode");
	var getn = document.getElementsByName("iambody");
	var len = p.length;
	for(i=len-1;i>=0;i--){
		if(p[i].checked==true){
			//直接remove索引值会改变……所以倒着删除
			getn[i].parentNode.removeChild(getn[i]);
		}
	}
	
	//至于删除的是哪个数组里面的值，之前我设置的那个bigsn真是起了大作用，不愧是大阶段名称
}

function addElement()
{
	var msname = document.createTextNode(form1.msname.value);
	var mngname = document.createTextNode(form1.mngname.value);
	var StartDate = document.createTextNode(form1.StartDate.value);
	var EndDate = document.createTextNode(form1.EndDate.value);
	var budget = document.createTextNode(form1.budget.value);

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
	td_mngname.setAttribute("width","18%");
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
	ci.setAttribute("type", "hidden");
	ci.setAttribute("name","fozza_cp");
	ci.setAttribute("value",form1.mngname.value);
	cf.appendChild(ci);
	
	//开始日期
	ci = document.createElement("input");
	ci.setAttribute("type", button);
	ci.setAttribute("name","fozza_st");
	ci.setAttribute("value",form1.StartDate.value);
	cf.appendChild(ci);
	
	//结束日期
	ci = document.createElement("input");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("name","fozza_et");
	ci.setAttribute("value",form1.EndDate.value);
	cf.appendChild(ci);
	
	//预算
	ci = document.createElement("input");
	ci.setAttribute("type", "hidden");
	ci.setAttribute("name","fozza_bg");
	ci.setAttribute("value",form1.budget.value);
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

function dsubmit(){
	var indexcontent = "";
	var attachmentneed = "";
	var ha = document.getElementById("hiddenarea");
	var ic,an;
	for(i=0;i<bigar.length;i++)
	{
		//将提交的表单值保存到隐藏域 隐藏表单传值
		ic = document.createElement("input");
		an = document.createElement("input");
		for(j=0;j<bigar[i].dj_ii.length;j++){
			if(j>0){
				indexcontent += "," + bigar[i].dj_ii[j];
				attachmentneed += "," + bigar[i].dj_up[j];
			}
			else{
				indexcontent += bigar[i].dj_ii[j];
				attachmentneed += bigar[i].dj_up[j];
			}
		}
		ic.setAttribute("name", "indexcontent")
		ic.setAttribute("value", indexcontent);
		ic.setAttribute("type", "hidden");
		
		an.setAtribute("name", "attachmentneed");
		an.setAttribute("value", attachmentneed);
		an.setAttribute("type", "hidden");
		//添加到表单
		ha.appendChild(ic);
		ha.appendChild(an);
	}
	var pf = document.getElementsByName("postname")[0];
	pf.action = "${pageContext.request.contextPath}/web/servlet/stageServlet";
	pf.submit();
}

function ifclick(div) {
	var InputWord = document.getElementsByName("mngname")[0];
	InputWord.value = div.innerHTML;
	div.parentNode.style.display = "none";
}
function change_1(ele) {
	ele.style.backgroundColor = "#3388FF";
}
function change_2(ele) {
	ele.style.backgroundColor = "";
}
window.onload = function() {
	//输入文本框
	var InputWord = document.getElementsByName("mngname")[0];
	//获得下拉框
	var fozza_handsome = document.getElementById("fozza1");
	//
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function() {
		if (aja.readyState == 4) {
			if (aja.status == 200) {
				var str = aja.responseText; //得到服务器返回数据
				var ss = str.split(","); //分割得到的整串text
				var childDivs = "";
				for (var i = 0; i < ss.length; i++) {
					childDivs += "<div id='fozza2' onclick='ifclick(this)' onmouseover='change_1(this)' onmouseout='change_2(this)'>" + ss[i] + "</div>";
				//将每个元素放进div里面
				}
				fozza_handsome.innerHTML = childDivs;
			}
		}
	}

	InputWord.onkeyup = function() {
		var msg = InputWord.value;
		var fozza_handsome = document.getElementById("fozza1");
		if (msg == "") {
			fozza1.style.display = "none";
			fozza1.style.border = "1px";
		} else {
			fozza1.style.display = "block";
			fozza1.style.border = "1px solid grey";
		}
		//创建链接
		aja.open("get", "${pageContext.request.contextPath }/servlet/ListNameNoServlet?msg=" + msg);
		//发送请求
		aja.send(null);
	}
}
</script>
</html>