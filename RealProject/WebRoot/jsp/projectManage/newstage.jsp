<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新建阶段</title>
	 <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>
 </head>
 <body> 
  
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
            <form action="">
            <table id = "newms" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th align="center">阶段名称</th>
			    <th align="center">负责人</th>
			    <th align="center">开始日期</th>
			    <th align="center">截止日期</th>
			    <th align="center">预算(元)</th>
		    </tr>
	        </table>
	        </form>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>

			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">阶段新建</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
						<!-- 同意 -->
					<form action="" method="post" name="form1">
						<!-- 阶段名称 -->
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


						<!-- 指标 -->
						<div id="others" class="block">
						<div id="first_left">
						<font class="text">指标:</font>
						</div>
						<div id="first_right">
						<input type="text" name="" size="40px;">
						<div style="height:2px"></div>
						<input type="file" name="IndexFile">
						</div>
						</div>
						<div class="clear"></div>
						<div>
						
						</div>
                    

                    <div id="responsible_per" class="block">
						<div style="text-align: right">
						    <input type = "submit" name = "submit" class="btn btn-primary" value = "新建阶段" onClick="return addElement();">	
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
 
  
<%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
function addElement()
{
	var msname = document.createTextNode(form1.msname.value);
	var mngname = document.createTextNode(form1.mngname.value);
	var StartDate = document.createTextNode(form1.StartDate.value);
	var EndDate = document.createTextNode(form1.EndDate.value);
	var budget = document.createTextNode(form1.budget.value);

	var td_msname = document.createElement("td");
	td_msname.setAttribute("width","20%");
	td_msname.setAttribute("height","27");
	var td_mngname = document.createElement("td");
	td_mngname.setAttribute("width","20%");
	td_mngname.setAttribute("height","27");
	var td_StartDate = document.createElement("td");
	td_StartDate.setAttribute("width","20%");
	td_StartDate.setAttribute("height","27");
	var td_EndDate = document.createElement("td");
	td_EndDate.setAttribute("width","20%");
	td_EndDate.setAttribute("height","27");
	var td_budget = document.createElement("td");
	td_budget.setAttribute("width","20%");
	td_budget.setAttribute("height","27");
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
	//将td类型的节点添加到tr节点中
	tr.appendChild(td_msname);
	tr.appendChild(td_mngname);	
	tr.appendChild(td_StartDate);	
	tr.appendChild(td_EndDate);	
	tr.appendChild(td_budget);	
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