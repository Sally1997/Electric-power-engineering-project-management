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
	<style type="text/css">
		.loadpagediv{  
		    width:160px;  
		    height:56px;  
		    position: absolute;  
		    top:50%; 
			margin-left:-80px;
			margin-top:-28px;
		    left:50%;  
		    background: url(https://m.baidu.com/static/search/ico_loading.gif) no-repeat;  
		    z-index:9999;  
		}  
	</style>

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
                       <button type="button" class="btn btn-default" style="float: right;" data-toggle="modal" data-target="#handupFile" onclick="clearInfo();">上传文件</button>
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
							<span class="glyphicon glyphicon-time"></span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-download"></span><span>1</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>KB
							<button class="glyphicon glyphicon-save" style="font-size: 20px;float: right;" title="下载" onclick="" value="111"></button>
						</p>
						
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-time"></span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-download"></span><span>1</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>KB
							<button class="glyphicon glyphicon-save" style="font-size: 20px;float: right;" title="下载" onclick=""></button>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-time"></span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-download"></span><span>1</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>KB
							<button class="glyphicon glyphicon-save" style="font-size: 20px;float: right;" title="下载" onclick=""></button>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-time"></span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-download"></span><span>1</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>KB
							<button class="glyphicon glyphicon-save" style="font-size: 20px;float: right;" title="下载" onclick=""></button>
						</p>
					  </a>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><span class="glyphicon glyphicon-file"></span>文件一的名字其实很长很长很长很长</h4>
						<p class="list-group-item-text">
						    <span>项目A的名字其实特别特别特别的长</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-time"></span><span>>2015-11-1 23:58</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;</span><span>201526010001</span>&nbsp;&nbsp;&nbsp;
							<span>文件类型：</span><span>docx</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-download"></span><span>1</span>&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>KB
							<button class="glyphicon glyphicon-save" style="font-size: 20px;float: right;" title="下载" onclick=""></button>
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
		            <input class="form-control" type = "text" id="newstitle">
				</div>
			  </div>
		  		<!-- 文件类型 -->
		  	<div class="form-group">
				<label class="col-sm-2 control-label">文档类型</label>
				<div class="col-sm-8">
			    <select class="form-control" id="document_type">
				  <option>请选择</option>
				  <option>学习资料</option>
				  <option>实用文档</option>
				</select>
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
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submitFile();">上传</button>
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
 	var ptype
 	var dType="";
 	var dateFrom;
 	var dateTo;
 	var keywords;
 	var fType;
 	//上传等待
 	var loadPageFlag;
 	//上传文件
 	function submitFile(){
 		var document_type=document.getElementById("document_type").value;
 		var hehe_type="0";
 		if(document_type=="请选择"){
 			alert("请选择文档类型");
 			return;
 		}else if(document_type=="学习资料"){
 			hehe_type="2";
 		}else if(document_type=="实用文档"){
 			hehe_type="3";
 		}
 		
 		var file=document.getElementById("newfile").files[0];
 		var formdata=new FormData();
 		if(document.getElementById("newstitle").value==""){
 			alert("文件标题不能为空！");
 			return;
 		}
 		var hehe=document.getElementById("newfile").value;
		if(hehe.lastIndexOf(".")==-1){
			alert("请上传格式正确的文件!");
			return ;
		}
 		formdata.append("dtitle",document.getElementById("newstitle").value);
 		formdata.append("dtype",hehe_type);
 		formdata.append("uploadfile",file);
 		
 		var req=new XMLHttpRequest();
 		req.onreadystatechange=function(){
 			if(req.readyState==4){
 				clearLoadPage();
 				if(req.status==200){
 					
 					if(req.responseText=="ok"){
 						alert("文件上传成功");
 						location.reload(); 
 					}
 					else if(req.responseText=="outOfSize"){
 						alert("请上传");
 					}
 				}
 			}
 		};
 		req.open("post", "${pageContext.request.contextPath}/web/servlet/uploadDocument");
 		req.send(formdata);
 		loadPageFlag=setTimeout('loadPage()',100);
 	}
 	//点击上传文件按钮时，清除模态框信息
 	function clearInfo(){
 		var newstitle=document.getElementById("newstitle");
 		var newfile=document.getElementById("newfile");
 		var document_type=document.getElementById("document_type");
 		//清除
 		newstitle.value="";
 		newfile.value="";
 		document_type.value="请选择";
 	}
 	//下载
 	function download(dno){
 		var res=confirm("当前文件暂不支持预览，是否进行下载?");
 		if(res)
 			window.location.href="${pageContext.request.contextPath}/web/servlet/downLoadMessage?dno="+dno;
 	}
 	
 	//刷新数据0
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
 			spans[10].innerHTML=documentData[i].fsize;
 			//download
 			var btn=nodes[i].getElementsByTagName("p")[0].getElementsByTagName("button")[0];
 			btn.value=documentData[i].dno;
 			btn.onclick=function(){
 				window.location.href="${pageContext.request.contextPath}/web/servlet/downLoadMessage?dno="+this.value;
 				return false;
 			};
 			
 			//判断是否可以进行预览
 			var t=documentData[i].ftype;
 			if(t=="docx"||t=="doc"||t=="ppt"||t=="pdf"||t=="xls"){
 				//使用office预览
 				nodes[i].href="javascript:window.open('/RealProject/jsp/documentManage/preview.jsp?dno="+documentData[i].dno+"')";
 				
 			}else{
 				//直接下载 询问
 				nodes[i].href="javascript:download('"+documentData[i].dno+"')";
 			}
 		}
 		//隐藏
 		for(var i=documentData.length;i<5;i++){
 			nodes[i].style.display="none";
 		}
 	}
 	function findDocument(){
 		//数据获取校验
    	ptype=document.getElementById("documentType").value;
    	if(ptype=="工程类")
    		ptype="0";
    	else
    		ptype="1";
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
    	req.open("post","/RealProject/web/servlet/findDocument?dtype="+dType+"&ptype="+ptype+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&keywords="+keywords+"&ftype="+fType+"&currentPage="+1+"&pageSize=5");
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
    	req.open("post","/RealProject/web/servlet/findDocument?dtype="+dType+"&ptype="+ptype+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&keywords="+keywords+"&ftype="+fType+"&currentPage="+cur+"&pageSize=5");
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
	<!-- 等待 -->
	<div id="loadpagediv" class="loadpagediv" style="display: none;"></div>
	<div id="shadow_hehe" style="width: 100%;height:100%;position: fixed;z-index: 888;opacity:0.8;background-color: black;left: 0;top: 0;display: none;"></div>
	<script type="text/javascript">
		function loadPage() {  
			
            document.getElementById('loadpagediv').style.display =  "block";
            document.getElementById("shadow_hehe").style.display="block";
            loadPageFlag= setTimeout('loadPage()',100);  
	
	    }
		function clearLoadPage(){
			document.getElementById('loadpagediv').style.display =  "none";
            document.getElementById("shadow_hehe").style.display="none";
            clearTimeout(loadPageFlag);
		}
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
