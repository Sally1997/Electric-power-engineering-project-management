<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>文档管理</title>
	<%@include file="/head.jsp" %>
    <script type="text/javascript">
	    menus[2].className="active nav-current";
		menus[2].role="presentation";	
    </script>
    <!--下拉菜单插件bootstrap-select-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/css/bootstrap-select.min.css"> 
    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
      <!-- bootstrap-datetimepicker -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/locales.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />

</head>

<body>
	
   
    <section>
       <div class="container-fluid">
       <div class="row">
           <div class="col-lg-9 col-sm-9 xumode">
           <form>
           <div class="container-fluid" id="search">
           <div class="row">
              <div class="col-lg-2 col-sm-2">
			  <div class="form-group">
				<select class="selectpicker" data-width="100%" id="documentType">
				  <option>设计类</option>
				  <option>工程类</option>
				</select>
			  </div>
			  </div> 
			  <div class='col-lg-3 col-lg-offset-4 col-sm-3 col-sm-offset-4'>
				<div class="form-group">
					<input type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker1'/>
				</div>
			  </div>
			  <div class='col-lg-3 col-sm-3'>
					<div class="form-group">
						<input type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker2'/>
						</div>
			  </div>
              <div class="col-lg-12">
                   <div class="form-group">
                   <div class="input-group">
                       <input type="text" class="form-control" placeholder="请输入关键字" id="keywords">
                       <span class="input-group-btn">
                       <button class="btn btn-primary" type="button" onclick="findDocument();">搜索</button>
                       </span>
                       <span class="input-group-btn">
                       <button type="button" class="btn btn-default" style="float: right;" data-toggle="modal" data-target="#handupFile">上传文件</button>
                       </span>
                   </div>
                   </div>
              </div>
              <div class="col-lg-12" id="checkboxrow" style="margin-top:-2%">
                  <div class="checkbox">
                  <label class="checkbox-inline"><input type="checkbox" name="selectAll">全部</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="docx">DOCX</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="ppt">PPT</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="pdf">PDF</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="xls">XLS</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="video">视频（*.FLV，*.MP4）</label>
                  <label class="checkbox-inline"><input type="checkbox" name="fileType" value="other">其他</label>
                  </div>
              </div>
           </div>
           </div>
           </form>
           
           <!-- 查询结果为空 -->
           <div style="text-align: center;color: red;" id="noRes">
           		<h2>您的查询结果为空</h2>
           </div>
           
            <!--文件详细内容显示-->
           <div class="container-fluid" id="showtable">
			   <div class="row">
					<div class="list-group">
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span>上传时间：</span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span>上传者：</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span>下载次数：</span><span>1</span>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span>上传时间：</span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span>上传者：</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span>下载次数：</span><span>1</span>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span>上传时间：</span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span>上传者：</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span>下载次数：</span><span>1</span>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span>上传时间：</span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span>上传者：</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span>下载次数：</span><span>1</span>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span>上传时间：</span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span>上传者：</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span>下载次数：</span><span>1</span>
						</p>
					  </a>
					</div>	  
					 <!--  分页栏-->
				<nav aria-label="Page navigation" style="text-align: center" id="fenye">
				  <ul class="pagination" id="showpage">
				  	
					<li>
					  <a href="javascript:getPrevious(showpage);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li class="active"><a href="javascript:jmpPage(1)">1</a></li>
					
				  </ul>
				</nav> 
				<script type="text/javascript">
				  		var showpage=document.getElementById("showpage");
				  	</script>             	 
			   </div>
			   </div>
                      <!--不是搜索栏的模块部分-->
           <div class="container-fluid" id="detail_enter">
           <div class="row">
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-list-alt docTypeIcon"></span>项目资料</h2>
                   <a class="noRight" href="documentPDoc.html" style="text-decoration: none;"><h4>点击进入>></h4></a>
                   <p>这里放着的是项目资料，由项目管理页面上传</p>
                   </div>
               </div>
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-education docTypeIcon"></span>学习资料</h2>
                   <a class="noRight" href="studyDoc.html" style="text-decoration: none;"><h4>点击进入>></h4></a>
                   <p>这里放着的是学习资料，由文档管理页面上传</p>
                   </div>
               </div>
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-book docTypeIcon"></span>实用文档</h2>
                   <a class="noRight" href="praticalDoc.html" style="text-decoration: none;"><h4>点击进入>></h4></a>
                   <p>这里放着的是实用文档，由文档管理页面上传</p>
                   </div>
               </div>
           </div>
           </div>
       </div>
       </div>
    </section>
    
    <!--  默认隐藏的内容:上传文件-->
  <div class="modal fade" id="handupFile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">上传文件</h4>
      </div>
      <div class="modal-body">
		  <form class="form-horizontal">
		  		<div class="form-group">
				<label for="newsname" class="col-sm-2 control-label">文件主题</label>
				<div class="col-sm-8">
		            <input type = "text" id="newstitle">
				</div>
			  </div>
		  
			  	<div class="form-group">
				<label for="addfile" class="col-sm-2 control-label">上传文件</label>
				<div class="col-sm-8">
		            <input type = "file" id="newfile" multiple="multiple">
				</div>
			  </div>
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary" onclick="submitFile();">上传</button>
      </div>
    </div>
  </div>
</div>
    <script type="text/javascript">
    var isFirst=0;
    var showtable=document.getElementById("showtable");
    var noRes=document.getElementById("noRes");
    var fenye=document.getElementById("fenye");
    var documentData;
 	var currentPage=1;
 	var pageSize=5;
   	var pageNum;  
 	var totalNum;
 	var currentGroup=1;
 	var groupSize=5;
 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1;
 	//条件
 	var dType;
 	var dateFrom;
 	var dateTo;
 	var keywords;
 	var fType;
 	//刷新数据
 	function refreshData(){
 		var nodes=showtable.getElementsByTagName("a");
 		//刷新数据并且显示
 		for(var i=0;i<documentData.length;i++){
 			nodes[i].style.display="block";
 			//ico以及链接以及项目
 			var hehe=nodes[i].getElementsByTagName("h4")[0];
 			if(documentData[i].ftype=="video"){
 				hehe.innerHTML='<span class="glyphicon glyphicon-film"></span>'+documentData[i].dtitle;
 			}else{
 				hehe.innerHTML='<span class="glyphicon glyphicon-file"></span>'+documentData[i].dtitle;
 			}
 			//detail
 			var spans=nodes[i].getElementsByTagName("p")[0].getElementsByTagName("span");
 			spans[0].innerHTML=documentData[i].pname;
 			spans[2].innerHTML=documentData[i].uploadtime;
 			spans[4].innerHTML=documentData[i].uloadpno;
 			spans[6].innerHTML=documentData[i].ftype;
 			spans[8].innerHTML=documentData[i].dloadtimes;
 		}
 		//隐藏
 		for(var i=documentData.length;i<5;i++){
 			nodes[i].style.display="none";
 		}
 	}
 	function findDocument(){
 		//数据获取校验
    	dType=document.getElementById("documentType").value;
    	if(dType=="工程类")
    		dType="0";
    	else
    		dType="1";
    	dateFrom=document.getElementById("datetimepicker1").value;
    	
    	dateTo=document.getElementById("datetimepicker2").value;
    	keywords=document.getElementById("keywords").value;
    	fType="";
    	var nodes=document.getElementsByName("fileType");
    	for(var i=0;i<nodes.length;i++)
    		if(nodes[i].checked)
    			fType+=nodes[i].value+":";
    	//发送查询
    	var req=new XMLHttpRequest();
    	req.onreadystatechange=function(){
    		if(req.readyState==4)
    			if(req.status==200){
    				//处理数据
    				var res=req.responseText;
    				//alert(res);
    				var data=eval('('+res+')');
					documentData=data.docs;
					//数据显示
					var detailEnter=document.getElementById("detail_enter");
					//隐藏
					detailEnter.style.display="none";
					//刷新数据
					currentPage=data.currentPage;
				 	pageSize=data.pageSize;
				    pageNum=data.pageNum;  
				 	totalNum=data.totalNum; 
				 	//刷新分页栏
				 	showpage.innerHTML='<li><a href="javascript:getPrevious(showpage);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li><li class="active"><a href="javascript:jmpPage(1)">1</a></li>';
				 	if(pageNum<5){
						for(var i=2;i<=pageNum;i++){
							var node=document.createElement("li");
							node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
							showpage.appendChild(node);
						}
					}else{
						for(var i=2;i<6;i++){
							var node=document.createElement("li");
							node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
							showpage.appendChild(node);
						}
					}
				 	var node1=document.createElement("li");
				 	node1.innerHTML=' <a href="javascript:getNext(showpage);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
					showpage.appendChild(node1);
					refreshData();
					//show
					if(totalNum==0){
						noRes.style.display="block";//未找到
						fenye.style.display="none";
						showtable.style.display="none";
					}else if(totalNum<=5){
						noRes.style.display="none";
						fenye.style.display="none";
						showtable.style.display="block";
					}else{
						noRes.style.display="none";
						fenye.style.display="block";
						showtable.style.display="block";
					}
    			}
    	};
    	req.open("get","/RealProject/web/servlet/findDocument?dtype="+dType+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&keywords="+keywords+"&ftype="+fType+"&currentPage="+1+"&pageSize=5");
    	req.send(null);
 	}
    function getFunction(cur){
    	//发送查询
    	var req=new XMLHttpRequest();
    	req.onreadystatechange=function(){
    		if(req.readyState==4)
    			if(req.status==200){
    				//处理数据
    				var res=req.responseText;
    				//alert(res);
    				var data=eval('('+res+')');
					documentData=data.docs;
					//刷新数据
					currentPage=data.currentPage;
				 	pageSize=data.pageSize;
				    pageNum=data.pageNum;  
				 	totalNum=data.totalNum; 
				 
					refreshData();
					//show
					if(totalNum==0){
						noRes.style.display="block";//未找到
						fenye.style.display="none";
						showtable.style.display="none";
					}else if(totalNum<=5){
						noRes.style.display="none";
						fenye.style.display="none";
						showtable.style.display="block";
					}else{
						noRes.style.display="none";
						fenye.style.display="block";
						showtable.style.display="block";
					}
    			}
    	};
    	req.open("get","/RealProject/web/servlet/findDocument?dtype="+dType+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&keywords="+keywords+"&ftype="+fType+"&currentPage="+cur+"&pageSize=5");
    	req.send(null);
    }
    $(function () {
        $('#datetimepicker1').datetimepicker({
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY-MM-DD'
		});
        $('#datetimepicker2').datetimepicker({
            useCurrent: false,
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY-MM-DD'
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker2").on("dp.change", function (e) {
            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        });
    });
    //页面加载完毕执行
    window.onload=function(){
    	//全选框
    	var selectAll=document.getElementsByName("selectAll")[0];
    	selectAll.onclick=function(){
    		var nodes=document.getElementsByName("fileType");
    		if(this.checked){
    			for(var i=0;i<nodes.length;i++){
    				nodes[i].checked="checked";
    			}
    		}else{
    			for(var i=0;i<nodes.length;i++){
    				nodes[i].checked="";
    			}
    		}
    	};
    	//隐藏
    	document.getElementById("showtable").style.display="none";
    	document.getElementById("noRes").style.display="none";
    	document.getElementById("fenye").style.display="none";
    };
</script>
	<!-- 占位 -->
	<div style="height: 50px"></div>
    <footer class="copyright atLow" style="z-index: 5">
    <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
	</div>
	</footer>
</body>
</html>
