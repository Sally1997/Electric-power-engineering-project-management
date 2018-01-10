<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更多消息</title>
<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
</head>
<body>
	
	<script type="text/javascript">
		var documentData;
		function getFunction(cur){
			var req = new XMLHttpRequest();
				req.onreadystatechange=function(){
					if(req.readyState==4){
						if(req.status==200){
							var res=req.responseText;
							//数据刷新
							var data=eval('('+res+')');
						
							documentData=data.documentlist;
						
							currentPage=data.currentPage;
						 	pageSize=data.pageSize;
						    pageNum=data.pageNum;  
						 	totalNum=data.totalNum; 
							refreshData();	
						}
					}
				};
			
			req.open("get", "${pageContext.request.contextPath}/web/servlet/showDocumentPage?currentPage="+cur+"&pageSize=5&time="+new Date().getTime());
			req.send(null);
		}
		
		function getFirstFunction(){
			var req = new XMLHttpRequest();
			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						var res=req.responseText;
						//数据刷新
						var data=eval('('+res+')');
					
						documentData=data.documentlist;
					
						currentPage=data.currentPage;
					 	pageSize=data.pageSize;
					    pageNum=data.pageNum;  
					 	totalNum=data.totalNum; 
					 	//刷新分页栏
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
					}
				}
			};
		
		req.open("get", "${pageContext.request.contextPath}/web/servlet/showDocumentPage?currentPage=1&pageSize=5&time="+new Date().getTime());
		req.send(null);
			
		}
		//刷新数据
		function refreshData(){
			
			var nodes=document.getElementById("documenttable").getElementsByTagName("tr");
			for(var i=0;i<documentData.length;i++){
				var tds=nodes[i+1].getElementsByTagName("td");
				tds[0].innerHTML='<a href="${pageContext.request.contextPath}/web/servlet/downLoadMessage?dno='+documentData[i].dno+'"><span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span><abbr title="'+documentData[i].dtitle+'">'+documentData[i].dtitle+'</abbr></a>';
				tds[1].innerHTML='<span class="glyphicon glyphicon-time"  id="basic-addon1"></span>'+documentData[i].uploadtime;
				tds[2].innerHTML=documentData[i].uloadpno;
				tds[3].innerHTML=documentData[i].fsize+"kb";
				tds[4].innerHTML=documentData[i].ftype;
				
			} 
			for(var i=documentData.length;i<5;i++){	
				var tds=nodes[i+1].getElementsByTagName("td");
				tds[0].innerHTML="-";
				tds[1].innerHTML="-";
				tds[2].innerHTML="-";
				tds[3].innerHTML="-";
				tds[4].innerHTML="-";
				
			} 
		}
	</script>
	<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		<!--图表-->
    		<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">最新消息</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- style="margin-top: 20px;margin-left: 5%" -->
                    <div class="row">
					<div class="col-lg-12">
	
		<table class="table table-striped table-condensed" style="font-size: 15px" id="documenttable">
				<tr>
					<th width="25%">文件名称</th>
					<th align="right">上传时间</th>
					<th align="right">上传人</th>
					<th>大小</th>
					<th>类型</th>
				</tr>
		
 		    	<tr>
			    <td width="25%"> <a href="#">
            <span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span>
            <abbr title="消息一">消息一
          </abbr></a></td>
			    <td align="right"><span class="glyphicon glyphicon-time"  id="basic-addon1"></span>2017-12-03 18:14:03</td>
  		    <td >20152601001</td>
          <td >100kb</td>
          <td >doxc</td>
        </tr>
		    <tr>
			    <td><a href="#">
            <span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span>
            <abbr title="消息二">消息二
        </abbr></a></td>
			    <td align="right"><span class="glyphicon glyphicon-time"  id="basic-addon1"></span>2017-12-03 18:14:11</td>
  	 	    <td >20152601001</td>
          <td >100kb</td>
          <td >doxc</td>
        </tr>
		    <tr>
			    <td><a href="#">
            <span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span>
            <abbr title="消息三">消息三
        </abbr></a></td>
			    <td align="right"><span class="glyphicon glyphicon-time"  id="basic-addon1"></span>2017-12-03 18:14:17</td>
  		    <td >20152601001</td>
          <td >100kb</td>
          <td >doxc</td>
        </tr>
		    <tr>
			    <td><a href="#">
            <span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span>
            <abbr title="消息四">消息四
        </abbr></a></td>
			    <td align="right"><span class="glyphicon glyphicon-time"  id="basic-addon1"></span>2017-12-03 18:14:22</td>
  		    <td >20152601001</td>
          <td >100kb</td>
          <td >doxc</td>
        </tr>
 		    <tr>
			    <td><a href="#">
            <span class="glyphicon glyphicon-download-alt"  id="basic-addon1" style="cursor: pointer"></span>
            <abbr title="消息四">消息五
        </abbr></a></td>
			    <td align="right"><span class="glyphicon glyphicon-time"  id="basic-addon1"></span>2017-12-03 18:14:22</td>
  		    <td >20152601001</td>
          <td >100kb</td>
          <td >doxc</td>
        </tr>
 		    
	        </table> 
	        <script type="text/javascript">
	        	
	        	window.onload=function(){
	        		getFirstFunction(); 
	        	};
        		var noticetable=document.getElementById("noticetable");
			 	var currentPage=1;
			 	var pageSize=5;
			   	var pageNum;  
			 	var totalNum;
			 	var currentGroup=1;
			 	var groupSize=5;
			 	var groupNum=pageNum%groupSize==0?parseInt(pageNum/groupSize):parseInt(pageNum/groupSize)+1;
			</script>
                      
					
                    </div>
                </div>
                </div>
                          <!--  分页栏-->
				<nav aria-label="Page navigation" style="text-align: center">
				  <ul class="pagination" id="showpage">
				  	<script type="text/javascript">
				  		var showpage=document.getElementById("showpage");
				  	</script>
					<li>
					  <a href="javascript:getPrevious(showpage);" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li class="active"><a href="javascript:jmpPage(1)">1</a></li>
					
				  </ul>
				</nav>

            </div> 
				<button type="button" class="btn btn-primary" style="float: right;" onclick="window.location.href='${pageContext.request.contextPath}/web/servlet/mainServlet'">返回</button>	
    		</div>
			</main>
    	</div>
    </div>
	</section>
	<%@include file="/footer.jsp" %>
</body>
</html>