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
    <title>PlanManagement_Newed</title>
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
  	   <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[1].className="active nav-current";
		menus[1].role="presentation";
	</script>	
<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-14 main-content">
    		
    		<div class="col-lg-6" >
   	        <div class="panel panel-primary" >
    	        <div class="panel-heading">test01</div><!-- 这里是这个项目的名字 -->
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
				p.innerHTML = ss.charpname;
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
					var ih = "";
					for(var i=0;i<ii.length;i++){
						 ih += "<li name='createli'>"+ii[i]+"</li>";
					}
					nii.innerHTML = ih;
				}
			}
		}
		//创建连接
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+id);
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

            <form action="" method="post" name="changename">
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >负责人:</font>
						</div>
						<div id="first_right">
						<div class="dropdown"><font id="CharP"></font>
						<input type="text" style="display:none;width:60px" id="fozza_text" onblur="resetecho()">
            <span onclick="altercharp()" class="glyphicon glyphicon-pencil" style="cursor: pointer;" id="dropdownMenu1" data-toggle="dropdown"></span>
              <!-- <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><input type="text" name="fozza_change" size="15px;"/></li>
                <li><input type = "button" style="float:right;" name = "altername" class="btn btn-primary" value = "修改" onclick="changename()"/></li>
              </ul>纪丽！这里样式要改一下！ -->
          </div>
						</div>
						<div class="clear"></div>
						</div>
          </form><!-- 我虽然写了修改的js，但它蜜汁不成功，我也没时间调试了。。。谁帮忙改一下。。。 -->

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
            <div style="text-align: right">
              <button type="button" class="btn btn-primary"data-toggle="modal" data-target="#handupDc" onclick="popup()">提交</button>
              <button type="submit"class="btn btn-primary" ><a href="PlanManagement_NewMilestone.html" style="color:white">新建子任务</a></button>
            </div>
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


  <div class="modal fade" id="handupDc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">提交</h4>
      </div>
      <div class="modal-body">
      <form class="form-upload">

          <div class="form-group">
        <label for="projectname" class="col-sm-2 control-label">任务编号:</label>
        <div class="col-sm-8">
          2345678901
        </div>
        </div>
        <div class="clear"></div>

        <div class="form-group">
        <label for="projecttype" class="col-sm-2 control-label">任务名称:</label>
        <div class="col-sm-8">
          Child2.2.2
        </div>
        </div>
        <div class="clear"></div>

        <div class="form-group">
        <label for="projecttype" class="col-sm-2 control-label">负责人:</label>
        <div class="col-sm-8">
          李维
        </div>
        </div>
        <div class="clear"></div>

          <div class="form-group">
        <label for="addfile" class="col-sm-2 control-label">任务指标:</label>
        <div class="col-sm-8">
          <font >
              <ul>
                <li>上传施工现场勘查报告</li><input type = "file" id="checkman">
                <li>上传施工图纸</li><input type = "file" id="checkman"><!-- 当然这里没有没这个上传的按钮是根据你们后台那里显示的需不需要上传而定的 -->
                <li>购买施工材料</li><input type = "file" id="checkman"><!-- 如果有需要上传的话，就会出现这个上传附件的按钮 -->
              </ul>
            </font>
        </div>
        </div>
        <div class="clear"></div>
        
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary">提交</button>
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
function altercharp()
{
	var txt = document.getElementById("fozza_text");
	var p = document.getElementById("CharP");
	
	p.style.display = "none";
	txt.value = p.innerHTML;
	txt.style.display = "";
}

function resetecho(){
	var txt = document.getElementById("fozza_text");
	var p = document.getElementById("CharP");
	p.innerHTML = txt.value;
	txt.style.display = "none";
	p.style.display = "";
}

function popup(){
	
}

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
				p.innerHTML = ss.charpname;
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
		aja.open("get", "${pageContext.request.contextPath}/servlet/ShowNodeServlet?NodeNo="+${s}[0].id);
		//发送请求
		aja.send(null);
	}
</script>
</html>