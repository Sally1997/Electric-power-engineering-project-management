<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.holyshit.domain.Authority"%>
<%@page import="java.util.List"%>
<%@page import="com.holyshit.service.impl.AuthorityServiceImpl"%>
<%@page import="com.holyshit.service.AuthorityService"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<%@include file="/head.jsp"%>
<script type="text/javascript">
	menus[0].className = "active nav-current";
	menus[0].role = "presentation";
</script>

<!--下拉菜单插件bootstrap-select-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/css/bootstrap-select.min.css"> 
    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/locales.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap-table/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="${pageContext.request.contextPath}/bootstrap-table/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script
	src="${pageContext.request.contextPath}/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>

<script
	src="${pageContext.request.contextPath}/bootstrap-table/bootstrap-table-editable.min.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap-table/bootstrap-table-editable.js"></script>
<script
	src="${pageContext.request.contextPath}/js/bootstrap-editable.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
</head>

<style>
	.inputpad{
		padding-bottom: 10px;
	}
</style>



<body>
	<div class="panel-body" style="padding-bottom:0px;">
		<div class="panel panel-default">
			<div class="panel-heading">员工查询</div>
			<div class="panel-body">
					<div class="form-group" style="margin-top:15px;padding: 10px;">
					    <div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4"
								for="search_staffno">编号</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" placeholder="编号关键字"
									id="search_staffno">
							</div>
						</div>
						<div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4" for="search_name">姓名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="search_name"  placeholder="姓名关键字">
							</div>
						</div>
						<div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4" for="search_sex">性别</label>
							<div class="col-sm-8">
								<select class="selectpicker" data-width="100%" id="search_sex">
								  <option>请选择</option>	
								  <option>男</option>
								  <option>女</option>
								</select>
							</div>
						</div>
						<div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4" for="search_birthday">出生日期</label>
							<div class="col-sm-8">
								<input type='text' class="form-control" placeholder="选择时间" id='search_birthday'/>
							</div>
						</div>
						<div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4" for="search_te">电话号码</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="search_te"  placeholder="电话号码关键字">
							</div>
						</div>
						<div class="inputpad col-lg-4 col-md-6 col-sm-6">
							<label class="control-label col-sm-4" for="search_email">电子邮箱</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="search_email"  placeholder="邮箱关键字">
							</div> 
						</div>
		

					<div class="col-sm-4">
							<button type="button" id="search"
								class="btn btn-primary">查询</button>
					</div>
			</div>
		</div>
</div>

		<div id="toolbar" class="btn-group">
			<button id="btn_add" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			</button>
			<button id="btn_edit" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			</button>
			<button id="btn_delete" type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			</button>
		</div>
		<table id="stafflist"></table>
	</div>
	
	 <!--      默认隐藏的内容:添加人员，然而并不能实现添加，后台爸爸看看还有救吗-->
     
  <div class="modal fade" id="staff_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加人员信息</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工编号<span style="color: red;">*</span></label>
				<div class="col-sm-8">
			    <input type="text" class="form-control" id="addStaff_staffno" placeholder="请输入编号">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工姓名<span style="color: red;">*</span></label>
                <div class="col-sm-8">
			    <input type="text" class="form-control" id="addStaff_name" placeholder="请输入姓名">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工性别<span style="color: red;">*</span></label>
                <div class="col-sm-8">
			    	<select class="selectpicker" data-width="100%" id="addStaff_sex">
			    	  <option>请选择</option>
					  <option>男</option>
					  <option>女</option>
					</select>
				</div>
			  </div>
		      <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期<span style="color: red;">*</span></label>
			   	<div class="col-sm-3">
					<input type='text' class="form-control" placeholder="选择时间" id='addStaff_birthday'>
				</div>
			  </div>			  
			  <div class="form-group">
				<label class="col-sm-2 control-label">电话号码<span style="color: red;">*</span></label>
				<div class="col-sm-8">
		          <input type="text" class="form-control" id="addStaff_te" placeholder="请输入电话">
				</div>
			  </div>
             <div class="form-group">
				<label  class="col-sm-2 control-label">电子邮箱<span style="color: red;">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="addStaff_email" placeholder="请输入邮箱">
				</div>
			  </div>
			 <div class="form-group">
				<label  class="col-sm-2 control-label">设置密码<span style="color: red;">*</span></label>
				<div class="col-lg-8">
				  <input type="password" class="form-control" id="addStaff_password">
				</div>
			  </div>
			  <div class="form-group">
				<label  class="col-sm-2 control-label">确认密码<span style="color: red;">*</span></label>
				<div class="col-lg-8">
				  <input type="password" class="form-control" id="addStaff_confirm">
				</div>
			  </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button2" class="btn btn-primary" onclick="addStaff()">确认添加</button>
      </div>
      <script type="text/javascript">
      		function addStaff(){
      			
      			var addStaff_staffno=$('#addStaff_staffno').val();
      			var addStaff_name=$('#addStaff_name').val();
      			var addStaff_sex=$('#addStaff_sex').val();
      			var addStaff_birthday=$('#addStaff_birthday').val();
      			var addStaff_te=$('#addStaff_te').val();
      			var addStaff_email=$('#addStaff_email').val();
      			var addStaff_password=$('#addStaff_password').val();
      			var addStaff_confirm=$('#addStaff_confirm').val();
      			if(addStaff_staffno==""){
      				alert("员工编号不能为空");
      				return;
      			}
      			if(addStaff_name==""){
      				alert("员工姓名不能为空");
      				return;
      			}
      			if(addStaff_sex=="请选择"){
      				alert("请选择性别");
      				return;
      			}
      			if(addStaff_birthday==""){
      				alert("出生日期不能为空");
      				return;
      			}
      			if(addStaff_te==""){
      				alert("电话号码不能为空");
      				return;
      			}
      			if(addStaff_email==""){
      				alert("电子邮箱不能为空");
      				return;
      			}
      			if(addStaff_password==""){
      				alert("密码不能为空");
      				return;
      			}
      			if(addStaff_confirm!=addStaff_password){
      				alert("输入密码不同");
      				return;
      			}
      			//发送请求
      			var req=new XMLHttpRequest();
      			req.onreadystatechange=function(){
      				if(req.readyState==4&&req.status==200){
      					if(req.responseText=="ok"){
      						alert("人员添加成功");
      						$('#staff_add_modal').modal("hide");
      						location.reload();
      					}else{
      						alert(req.responseText);
      						
      					}
      				}
      			};
      			req.open("get","/RealProject/web/servlet/addStaff?staffno="+addStaff_staffno+"&name="+addStaff_name+"&sex="+addStaff_sex+"&birthday="+addStaff_birthday+"&te="+addStaff_te+"&email="+addStaff_email+"&password="+addStaff_password);
      			req.send(null);
      		}
      </script>
    </div>
  </div>
</div>


	<!--   权限设置模态框-->
     
  <div class="modal fade" id="set_authority_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">设置权限</h4>
      </div>
      <div class="modal-body">
      	<form role="form">
			<div class="checkbox" id="authoritytable">
			</div>
			<script type="text/javascript">
				var global_staff="";
				var global_authority="";
				function refreshAuthority(data){
					var authoritytable=document.getElementById("authoritytable");
					authoritytable.innerHTML="";
					for(var i=0;i<data.length;i++){
						var label=document.createElement("label");
						var br=document.createElement("br");
						label.style.marginLeft="40%";
						if(data[i].has==1){
							label.innerHTML='<input type="checkbox" value="'+data[i].perno+'" name="staffAuthority" checked="checked" >'+data[i].pername;
						}else{
							label.innerHTML='<input type="checkbox" value="'+data[i].perno+'" name="staffAuthority">'+data[i].pername;
						}
						authoritytable.appendChild(label);
						authoritytable.appendChild(br);
					}
				}
				
			</script>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button2" class="btn btn-primary" onclick="setAuthority()">确认</button>
      </div>
      <script type="text/javascript">
      		function setAuthority(){
      			var authoritytable=document.getElementById("authoritytable");
      			var values=document.getElementsByName("staffAuthority");
      			var para="";
      			for(var i=0;i<values.length;i++){
      				//优化算法，保存改变
      				if(values[i].checked&&global_authority[i].has!=1)
      					para+=values[i].value+"-"+1+":";
      				if((!values[i].checked)&&global_authority[i].has==1)
      					para+=values[i].value+"-"+0+":";
      			}
      			if(para==""){
      				var flag=confirm("您尚未做任何改变，是否退出？");
      				if(flag){
      					$('#set_authority_modal').modal("hide");
      					return;
      				}
      			}
      			var req=new XMLHttpRequest();
      			req.onreadystatechange=function(){
      				if(req.readyState==4&&req.status==200){
      					if(req.responseText=="ok"){
      						alert("设置成功");
      						location.reload();
      					}else{
      						alert("设置失败,请稍后再试");
      					}
      				}
      				
      			};
      			req.open("get", "/RealProject/web/servlet/setAuthority?staffno="+global_staff.staffno+"&list="+para);
      			req.send(null);
      			
      		}
      </script>
    </div>
  </div>
</div>

	<!-- 修改人员界面 -->
<div class="modal fade" id="staff_edit_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改人员信息</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工编号</label>
				<div class="col-sm-8">
			    <input type="text" class="form-control" id="editStaff_staffno" placeholder="请输入编号" readonly>
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工姓名<span style="color: green;">#</span></label>
                <div class="col-sm-8">
			    <input type="text" class="form-control" id="editStaff_name" placeholder="请输入姓名">
				</div>
			  </div>
			  <div class="form-group">
				<label class="col-sm-2 control-label">员工性别<span style="color: green;">#</span></label>
                <div class="col-sm-8">
			    	<select class="selectpicker" data-width="100%" id="editStaff_sex">
					  <option>男</option>
					  <option>女</option>
					</select>
				</div>
			  </div>
		      <div class="form-group">
			    <label class="col-sm-2 control-label">出生日期<span style="color: green;">#</span></label>
			   	<div class="col-sm-3">
					<input type='text' class="form-control" placeholder="选择时间"  id='editStaff_birthday'>
				</div>
			  </div>			  
			  <div class="form-group">
				<label class="col-sm-2 control-label">电话号码<span style="color: green;">#</span></label>
				<div class="col-sm-8">
		          <input type="text" class="form-control" id="editStaff_te" placeholder="请输入电话">
				</div>
			  </div>
             <div class="form-group">
				<label  class="col-sm-2 control-label">电子邮箱<span style="color: green;">#</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="editStaff_email" placeholder="请输入邮箱">
				</div>
			  </div>
			 <div class="form-group">
				<label  class="col-sm-2 control-label">重置密码<span style="color: green;">#</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="editStaff_password" placeholder="请勿随意重置密码">
				</div>
			  </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button2" class="btn btn-primary" onclick="editStaff()">确认修改</button>
      </div>
      <script type="text/javascript">
      		function editStaff(){
      			
      			var editStaff_staffno=$('#editStaff_staffno').val();
      			var editStaff_name=$('#editStaff_name').val();
      			var editStaff_sex=$('#editStaff_sex').val();
      			var editStaff_birthday=$('#editStaff_birthday').val();
      			var editStaff_te=$('#editStaff_te').val();
      			var editStaff_email=$('#editStaff_email').val();
      			var editStaff_password=$('#editStaff_password').val();
      			var editStaff_confirm=$('#editStaff_confirm').val();
      
      			if(editStaff_name==""){
      				alert("员工姓名不能为空");
      				return;
      			}
      			if(editStaff_birthday==""){
      				alert("出生日期不能为空");
      				return;
      			}
      			if(editStaff_te==""){
      				alert("电话号码不能为空");
      				return;
      			}
      			if(editStaff_email==""){
      				alert("电子邮箱不能为空");
      				return;
      			}
      			if(editStaff_password!=""){
      				var flag=confirm("您确定要重置编号为"+editStaff_staffno+"的密码么？请及时通知相关员工以免造成损失");
      				if(!flag)
      					return;
      			}
      			var warning="您刚才做了如下修改:\n";
      			var data=global_staff;
      			if(data.name!=editStaff_name)
      				warning+="    -- 将员工姓名从 ["+data.name+"] 改变为了 ["+editStaff_name+"] \n";
      			if(data.sex!=editStaff_sex)
      				warning+="    -- 将员工性别从 ["+data.sex+"] 改变为了 ["+editStaff_sex+"] \n";
      			if(data.birthday!=editStaff_birthday)
      				warning+="    -- 将出生日期从 ["+data.birthday+"] 改变为了 ["+editStaff_birthday+"] \n";
      			if(data.te!=editStaff_te)
      				warning+="    -- 将员工电话号码从 ["+data.te+"] 改变为了 ["+editStaff_te+"] \n";
      			if(data.email!=editStaff_email)
      				warning+="    -- 将员工邮箱从 ["+data.email+"] 改变为了 ["+editStaff_email+"] \n";
      			if(editStaff_password!="")
      				warning+="    -- 重置了员工密码 \n";
      			warning+="您确定要进行以上改变吗？";
      			var isSend=confirm(warning);
	
      			//发送请求
      			var req=new XMLHttpRequest();
      			req.onreadystatechange=function(){
      				if(req.readyState==4&&req.status==200){
      					if(req.responseText=="ok"){
      						alert("员工信息修改成功");
      						$('#staff_edit_modal').modal("hide");
      						location.reload();
      					}else{
      						alert(req.responseText);
      					}
      				}
      			};
      			if(isSend){
	      			req.open("get","/RealProject/web/servlet/editStaff?staffno="+editStaff_staffno+"&name="+editStaff_name+"&sex="+editStaff_sex+"&birthday="+editStaff_birthday+"&te="+editStaff_te+"&email="+editStaff_email+"&password="+editStaff_password);
	      			req.send(null);
      			}
      		}
      		
      		//删除单个员工
      		function deleteStaff(id,staffname){
      			var res=confirm("您确定删除一下员工吗？\n    --"+id+":"+staffname);
      			if(!res)
      				return;
      			var req=new XMLHttpRequest();
				req.onreadystatechange=function(){
					if(req.readyState==4&&req.status==200){
						if(req.responseText=="ok"){
							alert("删除成功");
							location.reload();
						}else{
							alert(req.responseText);
						}
					}
				};
				req.open("get", "/RealProject/web/servlet/deleteStaff?ids="+id+":");
				req.send(null);
      		}
      		
      		
      		//刷新修改信息框
      		function showInfo(row){
      			var dataInfo=row;
				$('#editStaff_staffno').val(dataInfo.staffno);
				$('#editStaff_name').val(dataInfo.name);
				//错误设置select的默认值
				/* $('#editStaff_sex').val(data.sex); */
				var options=document.getElementById("editStaff_sex").getElementsByTagName("option");
				
				if(dataInfo.sex=="男"){
					options[0].selected="selected";
				}
				else{
					options[1].selected="selected";
				}
				$('#editStaff_sex').selectpicker('refresh');
				
				$('#editStaff_birthday').val(dataInfo.birthday);
				$('#editStaff_te').val(dataInfo.te);
				$('#editStaff_email').val(dataInfo.email);
				//显示修改模态框
				$('#staff_edit_modal').modal("show");
      		}
      </script>
    </div>
  </div>
</div>
	<script type="text/javascript">
		$(function() {
			//日期插件的初始化
	        $('#search_birthday').datetimepicker({
				locale:'zh-cn',
				viewMode:'days',
				format:'YYYY-MM-DD'
			});
	        $('#addStaff_birthday').datetimepicker({
				locale:'zh-cn',
				viewMode:'days',
				format:'YYYY-MM-DD'
			});
	        $('#editStaff_birthday').datetimepicker({
				locale:'zh-cn',
				viewMode:'days',
				format:'YYYY-MM-DD'
			});
	        
			//初始化添加按钮
			$('#btn_add').bind("click",function(){
				//清空输入框
      			$('#addStaff_staffno').val("");
      			$('#addStaff_name').val("");
      			$('#addStaff_birthday').val("");
      			$('#addStaff_te').val("");
      			$('#addStaff_email').val("");
      			$('#addStaff_password').val("");
				//显示模态框
				$("#staff_add_modal").modal("show");
			});
			
			//初始化删除按钮
			$('#btn_delete').bind("click",function(){
				//获取用户的id
				var res=$('#stafflist').bootstrapTable('getSelections');
				if(res.length==0){
					alert("请选择需要删除的员工");
					return;
				}
				var ids="";
				var warning="您确定要删除一下员工么?\n";
				for(var i=0;i<res.length;i++){
					ids+=res[i].staffno+":";
					warning+="    --"+res[i].staffno+":"+res[i].name+"\n";
				}
				var flag=confirm(warning);
				if(!flag)
					return;
				var req=new XMLHttpRequest();
				req.onreadystatechange=function(){
					if(req.readyState==4&&req.status==200){
						if(req.responseText=="ok"){
							alert("删除成功");
							location.reload();
						}else{
							alert(req.responseText);
						}
					}
				};
				req.open("get", "/RealProject/web/servlet/deleteStaff?ids="+ids);
				req.send(null);
			});
			//初始化修改按钮
			$('#btn_edit').bind("click",function(){
				//清空密码框
				$('#editStaff_password').val("");
				var res=$('#stafflist').bootstrapTable('getSelections');
				if(res.length==0){
					alert("请选择需要修改的记录");
					return;
				}
				if(res.length!=1){
					alert("您一次只能修改一条记录");
					return;
				}
				//显示当前人员信息
				var data=res[0];
				$('#editStaff_staffno').val(data.staffno);
				$('#editStaff_name').val(data.name);
				//错误设置select的默认值
				/* $('#editStaff_sex').val(data.sex); */
				var options=document.getElementById("editStaff_sex").getElementsByTagName("option");
				
				if(data.sex=="男"){
					options[0].selected="selected";
				}
				else{
					options[1].selected="selected";
				}
				$('#editStaff_sex').selectpicker('refresh');
				
				$('#editStaff_birthday').val(data.birthday);
				$('#editStaff_te').val(data.te);
				$('#editStaff_email').val(data.email);
				//显示修改模态框
				$('#staff_edit_modal').modal("show");
			});
			//1.初始化Table
			var oTable = new TableInit();
			oTable.Init();

			//2.初始化Button的点击事件
			var oButtonInit = new ButtonInit();
			oButtonInit.Init();

		});

		var TableInit = function() {
			var oTableInit = new Object();
			//初始化Table
			oTableInit.Init = function() {
				$('#stafflist').bootstrapTable({
					url : '/RealProject/web/servlet/showStaffByPage', //请求后台的URL（*）
					method : 'get', //请求方式（*）
					toolbar : '#toolbar', //工具按钮用哪个容器
					striped : true, //是否显示行间隔色
					cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, //是否显示分页（*）
					sortable : false, //是否启用排序
					sortOrder : "asc", //排序方式
					queryParams : oTableInit.queryParams,//传递参数（*）
					sidePagination : "server" , //分页方式：client客户端分页，server服务端分页（*）
					queryParamsType : "undefined",
					pageNumber : 1, //初始化加载第一页，默认第一页
					pageSize : 8, //每页的记录行数（*）
					strictSearch : true,
					showColumns : true, //是否显示所有的列
					showRefresh : true, //是否显示刷新按钮
					minimumCountColumns : 2, //最少允许的列数
					height : 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId : "staffno", //每一行的唯一标识，一般为主键列
					columns : [ {
						checkbox : true
					}, {
						field : 'staffno',
						title : '员工编号'
					}, {
						field : 'name',
						title : '姓名'
					},{
						field : 'sex',
						title : '性别'
					}, {
						field : 'birthday',
						title : '出生日期'
					},{
						field : 'te',
						title : '电话号码'
					},{
						field : 'email',
						title : '电子邮箱'
					},{
                         field: 'operate',
                         title: '操作',
                         formatter: function(value,row,index){
                        	 var a1='<span class="authority_staff	glyphicon glyphicon-wrench" title="权限分配" style="cursor: pointer" ></span>&nbsp;&nbsp;&nbsp;';
                        	 var p1='<span class="edit_staff	glyphicon glyphicon-pencil" title="修改" style="cursor: pointer" ></span>&nbsp;&nbsp;&nbsp;';
                        	 var p2='<span class="delete_staff	glyphicon glyphicon-trash" title="删除" style="cursor: pointer"></span>';
                         	 return a1+p1+p2;
                         },
                         events: {
                             'click .edit_staff': function(e, value, row, index) {  
                            	//初始化全局变量staffno
               				  	 global_staff=row;
                                 showInfo(row);
                                 
                            },
                         	'click .delete_staff': function(e, value, row, index) {  
                         		//初始化全局变量staffno
              				 global_staff=row;
                             deleteStaff(row.staffno,row.name);
                             
                        },
                        'click .authority_staff': function(e, value, row, index) { 
                        		
                        	  //获取权限列表
                        	  var req=new XMLHttpRequest();
                        	  req.onreadystatechange=function(){
                        		  if(req.readyState==4){
                        			  if(req.status==200){
                        				  var res=eval('('+req.responseText+')');
                        				  //初始化全局变量staffno
                        				  global_staff=row;
                        				  global_authority=res;
                        				  refreshAuthority(res);
                        			  }else{
                        				  alert("获取权限列表失败");
                        			  }
                        		  }
                        	  };
                        	  req.open("get", "/RealProject/web/servlet/getAuthorityList?staffno="+row.staffno);
                        	  req.send(null);
                              $('#set_authority_modal').modal("show");
                        }
                          }
                  }
					]
				});
			};
			
			
			//得到查询的参数
			oTableInit.queryParams = function(params) {
				var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					pageNumber: params.pageNumber,    
	                pageSize: params.pageSize, 
					staffno: $('#search_staffno').val(),
					name: $("#search_name").val(),
					sex: $("#search_sex").val(),
					birthday: $("#search_birthday").val(),
					te: $("#search_te").val(),
					email: $("#search_email").val()
				};
				return temp;
			};
			return oTableInit;
		};
		var ButtonInit = function() {
			var oInit = new Object();
			var postdata = {};

			oInit.Init = function() {
				//初始化页面上面的按钮事件
				$("#search").bind("click", function(){
					
					//先销毁表格  
			        $('#stafflist').bootstrapTable('destroy'); 
			      //1.初始化Table
					var oTable = new TableInit();
					oTable.Init();
				}); 
			};

			return oInit;
		};
	</script>

	<%@include file="/footer.jsp"%>
</body>
</html>