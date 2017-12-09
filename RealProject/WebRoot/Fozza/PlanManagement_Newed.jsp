<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>项目管理</title>
<meta name="keywords" content="电力工程项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
    
    <style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		}
		#top_fixed{
			top: 0px;
			width: 100%;
		}
		#top{
			height: 130px;
			width: 100%;
			color: white;
			overflow: hidden;
            background-image: url(topbk.png);
			background-size: cover;
			position: relative;
		}
        #copyright{
			width:100%;
			height: 80px;	
			color: white;
			text-align: center; 
			font-family: "微软雅黑";
			font-size: 20px;
			line-height: 70px;
			background-image:url(bottombk.png);
			background-size: cover;
			 
		}
		#top_left{
			float:left;
			height: 100px;
			width:600px;
			margin-top:25px;
			margin-left: 80px; 
		}
		#top_right{
			float:right;
			height: 100px;
			margin-top:20px;
			margin-right: 100px;
		}
		#top-bottom{
			
		}
		.top_font{
			font-family:微软雅黑;
			font-size: 19px;
			color: #cccccc;
			letter-spacing: 2px;
		}
		.top_font a{
			text-decoration: none;
			color: #cccccc;
			font-family: "微软雅黑";
		}		
		.top_font a:hover{
			text-decoration: none;
			color: white;
			font-family: "微软雅黑";
		}
		
		#menu{
			<!--background-color: #333A56;-->
			width: 100%;
			height: 40px;
			<!--overflow: hidden;-->
			font-family:微软雅黑;
			vertical-align: text-bottom;
			position:absolute;
			bottom: 0;
		}
		 


		.menu_1 {
			float:left;
			height: 40px;
			width: 200px;
			text-align: center;
			color: white;
			font-size: 17px;
			letter-spacing: 2px;
			border-radius: 5px;
			cursor: pointer;
			
	
		}
		.menu_1 a{
			color: #cccccc;
			position: relative;
			top: 5px;
			text-decoration: none;
		}
		.menu_1 a:hover{
			color: white;
			position: relative;
			top: 5px;
			text-decoration: none;
		}
		.menu_on{
			background-color: rgba(255,255,255,0.3);
			color: white;
		}
/*'	<!--这里往下是隐藏的消息栏-->*/
		.hiddenms{
			background-color:white;
			display:none; 
			overflow: hidden;
			width: 150px;
			height: auto;
			position: fixed;
			top: 60px;
			border-radius:5px;
			border-color: #cccccc;
			box-shadow:0 0 1px 1px #787878;
		}
		.triangle{
			display: inline-block;
            border-bottom: 6px solid #787878;
            border-right: 6px solid transparent;
            border-left: 6px solid transparent;
			background-color: white;
			margin: 0 50%;
		}
		.uf_font{
			display:inline-block;
			color: #787878;
			font-size: 15px;
			width: 100%;
			height: 25px;
			text-align: center;
			line-height: 30px;
		}

		.counter{
			border-radius:20px;
			width:20px;
			height: 20px;
			line-height:20px;
			text-align:center;
			font-size:12px;
			display:inline-block;
			background-color: #84A1E1;
			color: white;
		}
		.clear{
			clear: both;
		}
		.user_photo{
			display: inline-block;
			width: 50px;
			height: 50px;
			border-radius:50px;
			overflow: hidden;
			cursor: pointer;
		}
		.user_photo img {
			width: 50px;
			height: 50px;
		}

		
		ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {display: inline;}

        ul.pagination li a {
           color: black;
           float: left;
           padding: 8px 16px;
           text-decoration: none;
        }

        ul.pagination li a.active {
           background-color: #909090;
           color: white;
        }

        ul.pagination li a:hover:not(.active) {background-color: #ddd;}
 
		body{
  
			background-color: #f7f5e6;
			
		}
		 
		
		a{
			text-decoration: none;
		}
		a{
			color: #cccccc;
		}
		a:hover{
			color:white;
		}
		section{
	        width:100%;
	        color:#333A56;
	        height:400px;
}

 

#ProjectTree{
	width:40%;
    margin:2% 10% 2% 10%;
    padding:5px 0% 2% 0%;
	background-color: #e8e8e8;
	text-align: center;
	border-radius: 5%;
}
#TaskDetails{
	float:right;
	background-color: white;
	margin:0px 90px 40px 50px;
	border:dotted 3px #e8e8e8;
	padding: 0px 5px 5px 20px;

}
#TaskNote{
	margin:0px -5px 10px -19px;
	background-color:  #e8e8e8;
	padding:15px 5px;
	text-align: center;
	color:black;

}
#TaskName{
	font-family: sans-serif;
	font-style: italic;
	font-weight: bold;
	color: blue;
}
 
form{
	display: table;
}

form#MileStone textarea{
	width:200px;
	height:120px;
}

div.tableRow{
	display: table-row;
}
div.tableRow p{
	display: table-cell;
	vertical-align: top;
	padding:3px;
}
div.tableRow p:first-child{
	text-align: right;
}
/*代用
.tableAttribute{
	font-family: SimHei;

}
.tableContent{
	font-family: SimHei;
*/
#addSubTask{
	
	background-color: #333A56;
	padding:4px 0px;
	margin:3px 30px 5px 180px;
	text-align: center;
	border-radius: 15%;
	color:white;
}
		 
		 

		</style>
</head>
<script type="text/javascript">
  		function change_1(ele){
  			ele.style.color="white";
  			//ele.style.fontSize="25px";
		    ele.style.fontWeight="bold";
  		
  		}
  		function change_2(ele){
  			ele.style.backgroundColor="#333a56";
  			//ele.style.fontSize="17px";
			ele.style.fontWeight="normal";
  		
  		}
</script>
<body>
    <div id="top_fixed">
		  <!-- 顶端-->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font"> <a href="main.html">首页</a> >><a href="01-projectmanagerfirst.html">项目管理</a> >> XXX项目 >>计划管理 >> 查看计划图</span>
		  		</div>
		  	 	<div id="top_right">
		  			<span class="user_photo"><img  src="1.png"></span>
		  			<span class="top_font" style="position: relative;top:-20px;font-size: 16px; margin-left:10px;"  >
		  			<a onmouseover="user_info_ap()" onmouseout="user_info_dis()" href="#" >用户XXX</a> | 
		  			<a href="#" onmouseover="ms_info_ap()"onmouseout="ms_info_dis()">通知</a>
		  			<span class="counter" >10</span></span>
		  		</div>
		  			        
		  	<!-- 菜单栏-->
		  	<div id="menu">
				<div class="menu_1"><span ><a href="main.html">首页</a></span></div>
				<div class="menu_1"><span ><a  href="01-projectmanagerfirst.html">项目管理</a></span></div>
			    <div class="menu_1"><span ><a  href="money.html">资金管理</a></span></div>
			    <div class="menu_1"><span ><a  href="document2.html">文档管理</a></span></div>
				<div class="clear"></div>
		  	</div>
		  		<div class="clear"></div>
		  	</div>  

    </div>
		
	<section>
            <div id="TaskDetails">
			<p id="TaskNote"> 您当前处于任务节点<span id="TaskName">Child2.2.2</span>,详细信息如下：</p>
			<form id="MileStone">
				<div class="tableRow">
				<p class="tableAttribute">	任务名称: </p>
				<p class="tableContent"><input type="text" name="MileStone" value="Child2.2.2"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">负责人：</p>
				<p class="tableContent">	<input type="text" name="PersonInCharge" value="李维"></p>
				</div>


				<div class="tableRow">
				<p class="tableAttribute">	开始日期：</p>
				<p class="tableContent"><input type="date" name="StartDate" value="2017-10-26"></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute">截止日期：</p>
				<p class="tableContent"><input type="date" name="EndDate" value="2018-02-24"></p>
                </div>

                <div class="tableRow">
				<p class="tableAttribute">预算：</p>
				<p class="tableContent"><input type="number" name="budget" value="3000"><span>元</span></p>
				</div>

				<div class="tableRow">
				<p class="tableAttribute"><!--记得改成列表-->
				指标：
				</p>
				<p class="tableContent">
					<textarea> 
				    1.上传施工现场勘查报告 
				    2.上传施工图纸 
				    3.购买施工材料
					</textarea>
				</p>
				</div>
			</form>
				<p id="addSubTask">
					<a href="PlanManagement_NewTask.html" id="A">新建子任务</a>
				</p>
	        </div>

			<div id="ProjectTree">
			<p> 计划树状图</p>
			<p><img src="计划树状图.png" alt="这是你的计划图，以树状图的形式展示"></p>
			</div>

		
		</section>
		
 
	  
		

	<!-- 版权声明 -->
  	<div id="copyright">
  		<span>版权声明</span>
  	</div>
  	
  	<!-- 默认隐藏内容 -->
  	<div id="uf" class="hiddenms" style="right: 140px">
        <div class="triangle"></div>
  		<div class="uf_font">
   		<span>账户</span> :<span>王尼玛</span> <br>
   		<span>项目数量</span> :<span>5</span> <br>
   		<span>任务数量</span> :<span>10</span> <br>
   		<span>上次登录</span> :<br><span>2017-10-18 22:25:20</span> <br><br>
   		</div>
   	</div>
   	
  	<div id="ms" class="hiddenms" style="right:70px">
        <div class="triangle"></div>
        <div class="uf_font">反正这里有通知</div>
   	</div>


</body>
<script type="text/javascript">
		function user_info_ap(){
			
			var kz=document.getElementById("uf");
			kz.style.display="block";
		}
		function user_info_dis(){
			var kz=document.getElementById("uf");
			kz.style.display="none";
		}
		function ms_info_ap(){
			
			var kz=document.getElementById("ms");
			kz.style.display="block";
		}
		function ms_info_dis(){
			var kz=document.getElementById("ms");
			kz.style.display="none";
		}
</script>
</html>
