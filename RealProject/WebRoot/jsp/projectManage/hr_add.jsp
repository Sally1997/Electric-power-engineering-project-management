<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>02-hradd</title>

    <!-- Bootstrap -->
    
    
	<script type="text/javascript">


	window.onload=function(){
		var searchElement = document.getElementById("SearchStaffNo");
		var div = document.getElementById("context1");
		
		searchElement.onkeyup=function(){
			var SearchStaffNo = this.value;//啊啊啊啊啊，获取到的是姓名，不再是编号了！！！！
			
			if(SearchStaffNo==none){
				div.style.display = "none";
				return;
			}
			var xhr = getXMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4){
					if(xhr.status==200)
					{
						var str = xhr.responseText;
						var ss = str.split(",");
						var childDivs = "";
						for(int i = 0;i<ss.length;i++)
						{
							childDivs+="<div onclick='writeText(this)' onmouseover='changebackground_over(this)' onmouseout='changebackground_out(this)'>"+ss[i]+"</div>";
						}
						
						div.innerHTML = childDivs;
						div.style.display = "block";
					}
				}
			}
			
			xhr.open("get","${pageContext.request.contextPath}/servlet/searchStaffAJAXServlet?SearchStaffNo="+SearchStaffNo+"&time="+new Date().getTime());
			xhr.send(null);
		}
	}
	
	function changebackground_over(div){
		div.style.background = "grey";l
	}
	
	
	function changebackground_out(div){
		div.style.background = "white";l
	}
	
	function writeText(div){
		var searchElement = document.getElementById("SearchStaffNo");
		searchElement.value = div.innerHTML;
		div.parentNode.style.display = "none";
	}
	function showPno(){
		alert("axibabababbab");
	}
</script>

 </head>
 <body> 

   <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";	
	</script>

<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">人员添加</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- style="margin-top: 20px;margin-left: 5%" -->
                   <!--
				   为了方便在编辑器里看我下面就不把缩进改到后面了。。。
				   你知道下面都是一块的就够了 -->
						<form action="${pageContext.request.contextPath}/web/servlet/addAStaff" method="post" name = "search" style="margin-bottom: 20px" class="form-inline">
						<div align = "center">
							<div class="form-group">
							    <input class="form-control" id="SearchStaffNo" type="text" size = "70%"/>
							</div><!--搜索框-->
							<div class="form-group">
							    <input  name="" type="button" class="btn btn-primary" value="查看信息" onclick = "show();return false;" herf="${pageContext.request.contextPath}/servlet/FindAStaffServlet"/>
							</div><!--搜索按钮-->
						</div>
						<div id="context1" style = "display:block;border:1px solid red;background-color:white;width:510px;position:absolute;left:245px;top:35px;">
						</div><!-- 搜索提示框 -->
						</form>
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">员工编号:</font>
						</div>
						<div id="first_right">
						<span id="sorry1" style="display:none"><font class="text">${Staff.staffno }</font></span>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">员工姓名:</font>
						</div>
						<div id="first_right">
						<span id="sorry2" style="display:none"><font class="text">${Staff.name }</font></span>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">邮箱地址:</font>
						</div>
						<div id="first_right">
						<font class="text"><span id="sorry3" style="display:none">${Staff.email }</span></font>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">联系方式:</font>
						</div>
						<div id="first_right">
						<font class="text"><span id="sorry4" style="display:none">${Staff.te }</span></font>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">工龄:</font>
						</div>
						<div id="first_right">
						<font class="text"><span id="sorry5" style="display:none">${Staff.birthday }</span></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">职业资格:</font>
						</div>
						<div id="first_right">
						<font class="text"><span id="sorry6">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#handupBc" onclick="showPno()" >查看</button>
							</span>
						</font>
						</div>
						<div class="clear"></div>
						</div>
						
						<span id="sorry7" >
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font class="text">职责:</font>
						</div>
						<div id="first_right">
						<span><select name="duty" length = "40">
								<option value="duty1">职责1</option>
								<option value="duty2">职责2</option>
								<option value="duty3">职责3</option>
						</select></span>
						</div>
						<div class="clear"></div>
						</div>
						</span>
						
						<div id="responsible_per" class="block">
						<form>
						<div style="text-align: right">
						    <a ><button type="submit" class="btn btn-primary" onclick="window.open('${pageContext.request.contextPath}/web/servlet/addAStaff?pno=${pno}')">添加</button></a>
							<a href="${pageContext.request.contextPath}/web/servlet/staffListServlet?pno=${pno}" style="color:white;" ><button type="submit"class="btn btn-primary" onclick="showPno()" >返回aaa</button></a>
						</div>
						</form>
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

<!--资格证-->

<div class="modal fade" id="handupBc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">资格证查看</h4>
    </div>
    <div class="modal-body"><!-- 这里缩进同上 -->
		  <table class="table table-striped table-condensed" style="font-size: 15px">
		<tr>
			<th>职业资格证</th>
		</tr>
		<tr>
			<td><abbr title="大学时获得">四级证书</abbr></td>
		</tr>
		<tr>
			<td><abbr title="大学时获得">六级证书</abbr></td>
		</tr>
		<tr>
			<td><abbr title="大学时获得，但没车">驾照</abbr></td>
		</tr>
		<tr>
			<td><abbr title="初中时获得，现在已基本忘掉了">钢琴十级</abbr></td>
		</tr>
		<tr>
			<td><abbr title="大学时获得">计算机二级证书</abbr></td>
		</tr>
		<tr>
			<td><abbr title="大学时获得">计算机四级证书</abbr></td>
		</tr>
	      </table>
        
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
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