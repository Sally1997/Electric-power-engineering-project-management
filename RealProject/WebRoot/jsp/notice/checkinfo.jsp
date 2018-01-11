<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>${noticetitle }</title>
<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
<style type="text/css">
	.noticeTop{
		text-align: center;
		font-family: 微软雅黑;
		font-weight: 700;
		font-size: 18px;
	}
</style>
</head>
<body>
	
	
	<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		
    		
    		
    		<div class="col-lg-8" style="float:none; margin: 20px auto">
   	        <div class="panel panel-primary" style="margin: 20px auto">
    	        <div class="panel-heading">项目相关</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- style="margin-top: 20px;margin-left: 5%" -->
 
						<div id="responsible_per" class="block"><!--这里我就不给你把缩进改到后面了。。。太难改了。。。你反正晓得下面都是一块的-->
						<div id="first_left">
						<font>项目类型:</font>
						</div>
						<div id="first_right">
						<font>${map.ptype }</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >项目名称:</font>
						</div>
						<div id="first_right">
						<font >${map.pname }</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >申请人:</font>
						</div>
						<div id="first_right">
						<font >${map.name }</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >相关附件:</font>
						</div>
						<div id="first_right">
						<font ><a href="${pageContext.request.contextPath }/web/servlet/downLoadMessage?dno=${map.dno }">${map.dtitle }</a></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >预算:</font>
						</div>
						<div id="first_right">
						<font >${map.pbudget }</font>
						</div>
						<div class="clear"></div>
						</div>
                        
                        <div id="responsible_per" class="block">
						<div id="first_left">
						<font >开始时间:</font>
						</div>
						<div id="first_right">
						<font >${map.stime }</font>
						</div>
						<div class="clear"></div>
						</div>
						
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >结束时间:</font>
						</div>
						<div id="first_right">
						<font >${map.etime }</font>
						</div>
						<div class="clear"></div>
						</div>
                        
                        <div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc">审核相关</button>
						<br/><br/>
						</div>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>
    		
    		<!-- 如果申请人id为当前用户编号，则不显示，不同则说明当前用户是审核人，其他人没有消息提醒 -->
    		<c:if test="${staff.staffno!=map.staffno}">
			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">项目审批</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
						<!-- 同意 -->
					<form id="fozza_form" action="${pageContext.request.contextPath }/web/servlet/projectAuditServlet?mno=${map.mno}" method="post">
						<div id="responsible_per" class="block">
						<div>
						<div id="first_left">
						<input type="radio" name="agree" checked="checked" value="agree">同意
						</div>
						<div id="first_right">
						<input type="radio" name="agree" value="disagree">不同意
						</div>
						</div> 
						<div class="clear"></div>
						</div>

						<!-- 审批意见 -->
						<div id="start_date" class="block">
						<div id="first_left">
						<font class="text">审批意见：</font>
						</div>
						<div id="first_right">
						<input type="text" name="auditinfo" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 是否继续 -->
						<div id="responsible_per" class="block">
						<div>
						<div id="first_left">
						<input type="radio" name="audit" value="next" checked="checked" onclick="option(this)">继续审批
						</div>
						<div id="first_right">
						<input type="radio" name="audit" value="end" onclick="option(this)">结束审批
						</div>
						</div> 
						<div class="clear"></div>
						</div>

						<!-- 审批人 -->
						<div id="fozza_charp" class="block" style="display:block">
						<div id="first_left">
						<font class="text">审批人:</font>
						</div>
						<div id="first_right">
						<input type="text" id="checkman" name="PersonInCharge" size="40px" readonly="readonly" style="display:none">
						<button type = "button" class = "btn btn-primary" data-toggle = "modal" data-target= "#search" onclick="search_member()">查找</button>
						</div>
						<div class="clear"></div>
						</div>
						
						<!-- block -->
						<div id="fozza_block" class="block" style="display:none">
						<div id="first_left">
						</div>
						<div id="first_right">
						</div>
						<div class="clear"></div>
						</div>
						
						<div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;" onclick="submitAudit()">确定</button>
						</div>
                    </form>
                </div>
                </div>
            </div> 
    		</div>
		</c:if>
		
    		</main>
	    </div>
	</div>
 </section>
 <!--      默认隐藏的内容:审批意见-->
 <div class="modal fade" id="handupAc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">审批意见</h4>
    </div>
    <div class="modal-body">
		  <table class="table table-striped table-condensed" style="font-size: 15px">
		  
		  
 		    <tr>
			    <th >审批人</th>
			    <th>审批意见</th>
			    <th>是否审批</th>
			    <th>是否同意</th>
			    <th>日期</th>
		    </tr>
		  
		  <c:forEach items="${map.list }" var="l">
		    <tr>
			    <td align="center">${l.name }</td>
			    <td align="center">${l.auditadv }</td>
			    <td align="center">${l.auditstate }</td>
			    <td align="center">${l.ifpassed }</td>
			    <td align="center">${l.audittime }</td>
			</tr>
		  </c:forEach>
		    <!-- <tr>
			    <td align="center">审批人b</td>
			    <td align="center">有较大风险</td>
			    <td align="center">否</td>
			    <td align="center">否</td>
			    <td align="center">A年B月D日</td>
			</tr>
		    <tr>
			    <td align="center">审批人c</td>
			    <td align="center">利润高</td>
			    <td align="center">否</td>
			    <td align="center">是</td>
			    <td align="center">A年B月E日</td>
			</tr>
		    <tr>
			    <td align="center">审批人d</td>
			    <td align="center">总体来说还是很有希望</td>
			    <td align="center">是</td>
			    <td align="center">是</td>
			    <td align="center">A年B月G日</td>
			</tr> -->
	        </table> 
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
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
    	<div id="others" class="block">
			<div class="hehe_left">
			<span class="text">输入:</span>
			</div>
			<div class="hehe_right">
			<input type="text" id="getme" value="请输入关键字" name="goal" size="20px;">&nbsp;&nbsp;
			<input type = "button" name = "ok" class="btn btn-primary" value = "查找" onClick="search_staff()">
			</div>
			</div>
			<div class="clear"></div>
			<br/>
			<table id = "member_table" class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th>选择</th>
			    <th>标号</th>
			    <th>姓名</th>
			    <th>联系方式</th>
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
		   
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="give_option()">选择</button>
    </div>
	</div>
</div>
</div>

	<br><br><br><br><br>
	 <%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
function option(opt){
	var fcp = document.getElementById("fozza_charp");
	var fb = document.getElementById("fozza_block");
	if(opt.value=="next"){
		fcp.style.display = "";
		fb.style.display = "none"
	}
	else{
		fcp.style.display = "none";
		fb.style.display = "block";
	}
}

//以下都是选择用户弹窗功能
function give_option(){
	var ccp = document.getElementsByName("choose_char_per");
	//这个是弹窗的id
	var ser = document.getElementsByName("search")[0];
	var mng = document.getElementsByName("PersonInCharge")[0];  
	for(var i=0;i<ccp.length;i++){
		if(ccp[i].checked==true){
			mng.value = ccp[i].value;
			mng.style.display = "";
			break;
		}
	}
}

//以下是选择用户功能
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
	
	aja.open("get", "${pageContext.request.contextPath}/web/servlet/showStaffInfoServlet?type=nptype&time="+new Date().getTime());
	
	aja.send(null);
}

function search_staff(){
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

function submitAudit(){
	var v_agree = document.getElementsByName("agree");
	var v_ai = document.getElementsByName("auditinfo")[0];
	var v_audit = document.getElementsByName("audit");
	var v_pc = document.getElementsByName("PersonInCharge")[0];
	
	if(v_ai.value==""){
		alert("请填写审核意见!");
		return;
	}
	else if(v_audit[0].checked){
		if(v_pc.value==""){
			alert("请选择审核人!");
			return;
		}
	}
	alert("数据提交中……请等待服务器结果");
	var fm = document.getElementById("fozza_form");
	
	fm.submit();
}

</script>
</html>