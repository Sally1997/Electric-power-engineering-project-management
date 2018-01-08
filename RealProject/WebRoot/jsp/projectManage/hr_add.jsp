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
						<form method="post" name = "search" style="margin-bottom: 20px" class="form-inline">
						<div align = "center">
							<div class="form-group">
							    <input class="form-control" name="SearchStaffNo" maxlength="12" type="text" size = "70%" placeholder="请输入员工编号，长度为12位" value="${lastSearchStaffNo}"/>
							</div><!--搜索框-->
							<div class="form-group">
							    <a ><button type="submit" id="b2" class="btn btn-primary" onclick="gosearchstaff()" >查看信息</button></a>
							</div><!--搜索按钮-->
							<div>
                         		 <p style="color:red">${error}</p>
                            </div>
						</div>
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">员工编号:</font>
						</div>
						<div class = "hehe_right">
						<span id="sorry1"><font class="text" >${hrstaff.staffno}</font></span>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">员工姓名:</font>
						</div>
						<div class = "hehe_right">
						<span id="sorry2" ><font class="text">${hrstaff.name }</font></span>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">邮箱地址:</font>
						</div>
						<div class = "hehe_right">
						<font class="text"><span id="sorry3" >${hrstaff.email }</span></font>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">联系方式:</font>
						</div>
						<div class = "hehe_right">
						<font class="text"><span id="sorry4" >${hrstaff.te }</span></font>
						</div>
						<div class="clear"></div>
						</div>
	
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">生日:</font>
						</div>
						<div class = "hehe_right">
						<font class="text"><span id="sorry5" >${hrstaff.birthday }</span></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">职业资格:</font>
						</div>
						<div class = "hehe_right">
						<font class="text"><span id="sorry6">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#handupBc" onclick="showPno()" >查看</button>
							</span>
						</font>
						</div>
						<div class="clear"></div>
						</div>
						
						<span id="sorry7" >
						<div id="responsible_per" class="block">
						<div class = "hehe_left">
						<font class="text">职责:</font>
						</div>
						<div class = "hehe_right">
						<span><select name="duty" length = "40">
								<option value="需求调研人员">需求调研人员</option>
								<option value="设计师">设计师</option>
								<option value="施工人员">施工人员</option>
								<option value="项目经理">项目经理（测试用）</option>
						</select></span>
						</div>
						<div class="clear"></div>
						</div>
						</span>
						
						<div id="responsible_per" class="block">
						
						<div style="text-align: right">
						    <a ><button type="submit" id="b1" class="btn btn-primary" onclick="goaddstaff()" >添加</button></a>
							<a ><button type="submit" class="btn btn-primary" onclick="goback()" >返回</button></a>
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
		<c:forEach items="${Qualifications}" var="Q" >
		<tr>
			<td><abbr title="大学时获得">${Q.qualifdesc }</abbr></td>
		</tr>
		</c:forEach>
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
  <script type="text/javascript">
  	function goaddstaff(){
  		var p = document.getElementsByName("search")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/addAStaff?pno=${pno}";
  		
  	}
  	function goback(){
  		var p = document.getElementsByName("search")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/staffListServlet?pno=${pno}";
  		
  	}
  	function gosearchstaff(){
  		var p = document.getElementsByName("search")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/findAStaffServlet?pno=${pno}";
  		
  	}
  </script>
</html>