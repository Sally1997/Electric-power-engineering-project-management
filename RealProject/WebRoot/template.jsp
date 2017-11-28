<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/PlanDTree.css">                                    
<title>项目管理</title>
<meta name="keywords" content="电力工程项目管理,PM2">
    <meta name="description" content="这是一个项目工程管理软件">
    <meta name="content-type" content="text/html; charset=gb2312">
    
</head>
<script type="text/javascript">
  		/* function change_1(ele){
  			ele.style.backgroundColor="#333a56";
  			//ele.style.fontSize="25px";
  		
  		}
  		function change_2(ele){
  			ele.style.backgroundColor="";
  			//ele.style.fontSize="17px";
  		
  		} */
	//此处是一个没法用的当前页面高亮，因为没有引入jq文件
	    function change_3(){
			var navLi=$('menu_1') //此处填写你的导航html对象
            var windowUrl=window.location.href; //获取当前url链接
            navLi.each(function(){
                var t=$(this).find('a').attr('href');
                if(t==windowUrl){
                    $(this).addClass('menu_on');  //添加当前位置样式 
                } 
		    })
	    }
	    
	function upload(){
		/* method = "post";
		action = "/servlet/StageServlet"; */
		document.getElementById("addMileStone").action="${pageContext.request.contextPath}/servlet/StageServlet";
		document.getElementById("addMileStone").submit();
	}
</script>
<body>
    <div id="top_fixed">
		  <!-- 顶端-->
		  	<div id="top">
		  		<div id="top_left">
		  			<span class="top_font">  <a href="main.html">首页</a>  >> <a href="01-projectmanagerfirst.html"> 项目管理</a> >> XXX项目>>计划管理>>新建阶段</span>
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
		
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br>
		

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
