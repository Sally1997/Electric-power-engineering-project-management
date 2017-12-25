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
 		req.open("post", "/RealProject/web/servlet/uploadDocument");
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
 			window.location.href="/RealProject/web/servlet/downLoadMessage?dno="+dno;
 	}
 	
 	//刷新数据0
 	function refreshData(){
 		var nodes=showtable.getElementsByTagName("a");
 		//刷新数据并且显示
 		for(var i=0;i<documentData.length;i++){
 			nodes[i].style.display="block";
 			//ico以及链接以及项目
 			var hehe=nodes[i].getElementsByTagName("h4")[0];
 			var videoType=documentData[i].ftype;
 			if(videoType=="mp4"||videoType=="avi"||videoType=="3gp"||videoType=="wmv"||videoType=="rmvb"||videoType=="mov"||videoType=="flv"){
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
 			var hehe_size=documentData[i].fsize;
 			if(hehe_size<1024)
 				spans[10].innerHTML=hehe_size+"B";
 			else if(hehe_size<1024*1024){
 				spans[10].innerHTML=(hehe_size/1024).toFixed(2)+"K";
 			}else if(hehe_size<1024*1024*1024){
 				spans[10].innerHTML=(hehe_size/(1024*1024)).toFixed(2)+"M";
 			}else if(hehe_size<1024*1024*1024){
 				spans[10].innerHTML=(hehe_size/(1024*1024*1024)).toFixed(2)+"G";
 			}
 			//download
 			var btn=nodes[i].getElementsByTagName("p")[0].getElementsByTagName("button")[0];
 			btn.value=documentData[i].dno;
 			btn.onclick=function(){
 				window.location.href="/RealProject/web/servlet/downLoadMessage?dno="+this.value;
 				return false;
 			};
 			
 			//判断是否可以进行预览
 			var t=documentData[i].ftype;
 			if(t=="docx"||t=="doc"||t=="docm"||t=="dotm"||t=="dotx"||t=="xlsx"||t=="xlsb"||t=="xls"||t=="xlsm"||t=="pptx"||t=="ppsx"||t=="ppt"||t=="pps"||t=="pptm"||t=="potm"||t=="ppam"||t=="potx"||t=="posm"){
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
    	if(ptype=="工程类"){
    		ptype="1";
    		dType="";
    	}
    	else if(ptype=="设计类"){
    		ptype="0";
    		dType="";
    	}else if(ptype=="学习资料"){
    		ptype="";
    		dType="2";
    	}else if(ptype=="实用文档"){
    		ptype="";
    		dType="3";
    	}
    		
    	dateFrom=document.getElementById("datetimepicker1").value;
    	
    	dateTo=document.getElementById("datetimepicker2").value;
    	keywords=document.getElementById("keywords").value;
    	fType="";
    	var nodes=document.getElementsByName("fileType");
    	if(document.getElementsByName("selectAll")[0].checked)
    		fType="all";
    	else
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
 	
 	
 	