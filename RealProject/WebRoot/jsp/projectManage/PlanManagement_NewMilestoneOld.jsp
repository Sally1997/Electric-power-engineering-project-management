<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/projectManage/AddUser.jsp"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>PlanManagement_NewMilestone</title>

 </head>
 <body> 
   <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
	
		<%-- div下拉菜单 --%>
	<div id="fozza1" class="fozza2"></div>
	<%-- 这是我写的啦 --%>
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
							<button type="submit"class="btn btn-primary" ><a href="PlanManagement_Newed" style="color:white;">结束新建</a></button>
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
    <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
    <submit type="submit" class="btn btn-primary" onclick="Dlt()">删除</button><!-- 我写了三个函数来做这个delete都失败了（在下面注释掉了）不过丁杰也说了可以不用js实现这个删除我就不继续试了。。。 -->
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
<script type="text/javascript">
/*function Dlt()
{
	var table = document.getElementById("form3");
    for (var i = 0; i < table.rows.length; i++) {    //遍历Table的所有Row
        var dlt = document.getElementById("delete"); //获取对象
		if ( dlt.checked == true){
			var td=input[i].parentNode;
            //获取tr节点
            var tr=td.parentNode;
            //获取table
            var tablea=tr.parentNode;
            //移除子节点
            tablea.removeChild(tr);
		}
    }
    return false;

}*/
/*function Dlt()
{
	var table = document.getElementById("form3");
    for (var i = 0; i < table.rows.length; i++) {    //遍历Table的所有Row
        var dlt = document.getElementById("delete"); //获取对象
		if ( dlt.checked == true){
			table.deleteRow(i);
		}
    }
    return false;
}*/
/*function Dlt(){
            var input=document.getElementById("delete");
            for(var i=input.length-1; i>=0;i--){
                   if(input[i].checked==true){
                       //获取td节点
                       var td=input[i].parentNode;
                      //获取tr节点
                      var tr=td.parentNode;
                      //获取table
                      var table=tr.parentNode;
                      //移除子节点
                      table.removeChild(tr);
                 }
                
                }
        
            }*/

function addGoal()
{
	var goal = document.createTextNode(form2.goal.value);
	
    var dlt = document.createElement("input");
	dlt.setAttribute("id","delete");
	dlt.setAttribute("type","checkbox");
	dlt.setAttribute("value","指标一");/*这里的value应该是你指标的名字*/

	var sth = document.createElement("input");
	sth.setAttribute("name","指标一");/*这里的name应该是你指标的名字*/
	sth.setAttribute("type","radio");
	sth.setAttribute("value","has");
	var sthw = document.createElement("span");
	sthw.innerHTML = "Yes";
	var nth = document.createElement("input");
	nth.setAttribute("name","指标一");/*这里的name应该是你指标的名字*/
	nth.setAttribute("type","radio");
	nth.setAttribute("value","hasnt");
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

	var tComment = document.getElementById("goals"); //获取table对象

	tComment.appendChild(tbody); //将节点tbody加入节点尾部
	
	form2.goal.value="";
	return false;

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
	
	form1.msname.value="";
	form1.mngname.value="";
	form1.StartDate.value="";
	form1.EndDate.value="";
	form1.budget.value="";
	

	return false;

}
</script>
</html>