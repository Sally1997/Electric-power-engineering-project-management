<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>01-projectmanagerfirst</title>
<meta name="keywords" content="电力工程项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
    
    <style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
			font-family: "微软雅黑";
		}
		table{
        	width:800px;/*定宽*/
    		margin:20px auto;/* margin-left 与 margin-right 设置为 auto  用于居中*/
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
			width:200px;
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

/*	<!--	这两个class是弹出窗口用的-->*/
	    .black_overlay{ 
            display: none; 
            position: absolute; 
            top: 0%; 
            left: 0%; 
            width: 100%; 
            height: 220%; 
            background-color: black; 
            z-index:1001; 
            -moz-opacity: 0.8; 
            opacity:.80; 
            filter: alpha(opacity=88); 
        } 
	    .white_content { 
            display: none; 
            position: absolute; 
            top: 25%; 
            left: 25%; 
            width: 30%; 
            height: 35%;  
            background-color: white; 
            z-index:1002; 
            overflow: auto; 
			border-radius: 10px;
		}
		.windowtop{
			height: 50px;
			width: 100%;
		    background-image: url(topbk.png);
			color: white;
			overflow: hidden;
			font-family: "微软雅黑";
			font-size: 19px;
			letter-spacing: 3px;
			text-align: center;
			padding-top: 17px;
		}
		.infohead{
            background-image: url(infobk.png);
			color:white;
			font-size:15px;
			letter-spacing: 3px;
			font-family: "微软雅黑";
			width: 180px;
			text-align: center;
			overflow: hidden;
			padding: 3px;
			border-bottom-right-radius: 5px;		
		}
		.info{
			font-size: 17px;
			letter-spacing:2px;
			width: 100%;
			overflow: hidden;
			padding: 0 5 0 5;
			font-family: "微软雅黑";
		}
		#comment{
			padding-top: 30px;
			padding-bottom:30px; 
			background-color: #d8d8d8;
		}
		
		.selfbutton{
			padding: 5px 10px 5px 10px;
			background-color: #52658f;
			color: white;
			border-radius: 10%;
			border-style: none;
			font-family: "微软雅黑";
			cursor: pointer;
		}
		.project{
			width: 100%;
			height: auto;
			margin-bottom: 50px;
			
		}
		.round{
			width:60px; 
			height:60px; 
			background-color:#cccccc; 
			border-radius:50%;
			line-height:60px; 
			display:block; 
			color:#585858; 
			text-align:center;
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
	//此处是一个没法用的当前页面高亮，因为没有引入jq文件
	    function(){
			var navLi=$('menu_1') //此处填写你的导航html对象
            var windowUrl=window.location.href; //获取当前url链接
            navLi.each(function(){
                var t=$(this).find('a').attr('href');
                if(t==windowUrl){
                    $(this).addClass('menu_on');  //添加当前位置样式 
                } 
		    })
	    }
</script>
<body>
    <div id="top_fixed" style="background-color: #e8e8e8;">
		  <!-- 顶端-->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font"><a href="main.html">首页</a>>>项目管理</span>
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
		
	  
	<!--表格部分-->
    <div>
    <table>
	 <tr>
	 <td>  
	   <div class="info">
    	<button type="submit" class="selfbutton" style="float: right;margin-right: 0px" onclick = "document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block'">新建</button>
    <br/>
    </div>
	</td>
	</tr>
	</table>
	 <table border="1px solid #333a56"  cellpadding="2" cellspacing="0" bordercolor="#333a56" ><!--头后台：就是这里！该怎么和后台接轨-->
		<tr>
			<th width="15%" height="37" align="center" bgcolor="#333a56"><font color = "white" >项目编号</font></th>
			<th width="25%" align="center" bgcolor="#333a56"><font color = "white">项目名称</font></th>
			<th width="15%" align="center" bgcolor="#333a56"><font color = "white">项目经理</font></th>
			<th width="15%" align="center" bgcolor="#333a56"><font color = "white">职责</font></th>
			<th width="15%" align="center" bgcolor="#333a56"><font color = "white">项目类型</font></th>
			<th width="15%" align="center" bgcolor="#333a56"><font color = "white">状态</font></th>
		</tr>
		<tr>
			<td><a href="PlanManagement_NewMilestone.jsp" align="center">10001</a></td>
			<td align="center">test01</td>
			<td align="center">OO</td>
			<td align="center">开发人员</td>
			<td align="center">设计类</td>
			<td align="center">进行中</td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
		<tr>
			<td></td><td></td><td></td><td></td><td></td>
			<td>&nbsp </td>
		</tr>
	 </table>
	    <table>
	 <tr>
	 <td>  
	   <div class="info">
    	<div style="float: right"><a href="main.html" class="selfbutton"style="margin-right:0px;">返回</a></div>
	</td>
	</tr>
	</table>
    </div>


     <!--立项相关-->
    <div id="light" class="white_content" style="width: 50%;height: 65%">
             <div class="windowtop">申请立项</div>
             <br/><br/>
             <form style="margin-left: 20%">
                 项目名称&nbsp;&nbsp;&nbsp;<input style="width: 40%"type="text"> 
                 <br><br>
                 项目类型&nbsp;&nbsp;&nbsp;<input style="width: 40%"type="text"> 
                 <br><br>
                 审批人员&nbsp;&nbsp;&nbsp;<input style="width: 40%"type="text">
                 <br><br>
                 相关附件:&nbsp;&nbsp;&nbsp;
                 <input type="file">

                 <br><br>
                 其他备注&nbsp;&nbsp;&nbsp;<textarea rows="4%" cols="40%"></textarea>
                 <br/><br/>
                 <div style="float: right;margin-right: 25%">
                     <input type="submit" class="selfbutton" value="提交">
                     <input type="button" class="selfbutton" value="返回" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
                 </div>
                 <br/><br/><br/><br/>
             </form>
            
        </div>	
    <br> <br> <br> 
		

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
