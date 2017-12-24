<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>项目文档</title>
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
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/document.js"></script>
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
				  <option>工程类</option>
				  <option>设计类</option>	  
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
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>
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
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>
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
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>
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
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>
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
							<span class="glyphicon glyphicon-hdd"></span><span>1</span>
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
           <div id="detail_enter">
           
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
    	findDocument();
    };
</script>
	<%@include file="/footer.jsp" %>
</body>
</html>
