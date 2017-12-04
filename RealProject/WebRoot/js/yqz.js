//显示指定页面的内容
function jmpPage(cur){
	//设置新标记
	var pos=currentPage%5;
	if(pos==0)
		pos=5;
	//清除旧标记，建立新标记
	var nodes=showpage.getElementsByTagName("li");
	nodes[pos].className="";
	pos=cur%5;
	if(pos==0)
		pos=5;
	nodes[pos].className="active";
	currentPage=cur;
	//设置禁止
	if(currentPage==1){
		nodes[0].className="disabled";
	}else if(currentPage==pageNum){
		nodes[nodes.length-1].className="disabled";
	}else{
		nodes[0].className="";
		nodes[nodes.length-1].className="";
	}
	
	/**
	 * 自己的请求代码
	 */
	getProjectBudgetDetails(cur);
	
}


//显示前一页==资金管理
function getPreviousOnBudget(e){
	//进行节点回复
	var nodes=e.getElementsByTagName("li");
	nodes[nodes.length-1].className="";
	if(currentPage>1){
		//获取子节点数组
		var nodes=e.getElementsByTagName("li");
		//翻页
		if(currentPage%5==1){
			//删除全部节点
			e.innerHTML="";
			currentPage=currentPage-1;
			//新建节点
			var pre=document.createElement("li");
			pre.innerHTML='<a href="javascript:getPreviousOnBudget(showpage);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>';
			var node1=document.createElement("li");
			node1.innerHTML='<a href="javascript:jmpPage('+(currentPage-4)+')">'+(currentPage-4)+'</a>';
			
			var node2=document.createElement("li");
			node2.innerHTML='<a href="javascript:jmpPage('+(currentPage-3)+')">'+(currentPage-3)+'</a>';
			
			var node3=document.createElement("li");
			node3.innerHTML='<a href="javascript:jmpPage('+(currentPage-2)+')">'+(currentPage-2)+'</a>';
			
			var node4=document.createElement("li");
			node4.innerHTML='<a href="javascript:jmpPage('+(currentPage-1)+')">'+(currentPage-1)+'</a>';
			
			var node5=document.createElement("li");
			node5.className="active";
			node5.innerHTML='<a href="javascript:jmpPage('+currentPage+')">'+(currentPage)+'</a>';
			
			var next=document.createElement("li");
			next.innerHTML='<a href="javascript:getNextOnBudget(showpage);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
			//压入节点
			e.appendChild(pre);
			e.appendChild(node1);
			e.appendChild(node2);
			e.appendChild(node3);
			e.appendChild(node4);
			e.appendChild(node5);
			e.appendChild(next);		
		}else{
			//新标记
			var pos=currentPage%5;
			if(pos==0)
				pos=5;
			//清除旧标记，建立新标记
			nodes[pos].className="";
			nodes[pos-1].className="active";
			currentPage=currentPage-1;	
		}
		//看是否为第一页
		if(currentPage==1){
			var nodes=e.getElementsByTagName("li");
			nodes[0].className="disabled";
		}
		
		/**
		 * 自己的代码执行
		 */
		getProjectBudgetDetails(currentPage);
	}	
}


//显示下一页==资金管理
function getNextOnBudget(e){
	var nodes=e.getElementsByTagName("li");
	nodes[0].className="";
	if(currentPage<pageNum){
		//获取子节点数组
		var nodes=e.getElementsByTagName("li");
		//翻页
		if(currentPage%5==0){
			//删除全部节点
			e.innerHTML="";		
			currentPage=currentPage+1;
			//新建节点
			var pre=document.createElement("li");
			pre.innerHTML='<a href="javascript:getPreviousOnBudget(showpage);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>';
			e.appendChild(pre);
			if(pageNum-currentPage<5){
				
				for(var i=currentPage;i<=pageNum;i++){
					var node=document.createElement("li");
					node.innerHTML='<a href="javascript:jmpPage('+i+')">'+i+'</a>';
					if(i==currentPage)
						node.className="active";
					e.appendChild(node);
				}
				
				var next=document.createElement("li");
				next.innerHTML='<a href="javascript:getNextOnBudget(showpage);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
				e.appendChild(next);
				
			}else{
				
				
				var node1=document.createElement("li");
				node1.innerHTML='<a href="javascript:jmpPage('+(currentPage)+')">'+(currentPage)+'</a>';
				node1.className="active";
				
				var node2=document.createElement("li");
				node2.innerHTML='<a href="javascript:jmpPage('+(currentPage+1)+')">'+(currentPage+1)+'</a>';
				
				var node3=document.createElement("li");
				node3.innerHTML='<a href="javascript:jmpPage('+(currentPage+2)+')">'+(currentPage+2)+'</a>';
				
				var node4=document.createElement("li");
				node4.innerHTML='<a href="javascript:jmpPage('+(currentPage+3)+')">'+(currentPage+3)+'</a>';
				
				var node5=document.createElement("li");
				node5.innerHTML='<a href="javascript:jmpPage('+(currentPage+4)+')">'+(currentPage+4)+'</a>';
				
				var next=document.createElement("li");
				next.innerHTML='<a href="javascript:getNextOnBudget(showpage);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>';
				//压入节点
				e.appendChild(node1);
				e.appendChild(node2);
				e.appendChild(node3);
				e.appendChild(node4);
				e.appendChild(node5);
				e.appendChild(next);
			}
		}else{
			//新标记
			var pos=currentPage%5;

			//清除旧标记，建立新标记
			nodes[pos].className="";
			nodes[pos+1].className="active";
			currentPage=currentPage+1;	
		}
		
		//看是否为最后一页
		if(currentPage==pageNum){
			var nodes=e.getElementsByTagName("li");
			nodes[nodes.length-1].className="disabled";
			
		}
		
		
		/**
		 * 自己的代码执行
		 */
		getProjectBudgetDetails(currentPage);
	}	
}
//关闭当前页面
function closeWebPage(){
	if(navigator.userAgent.indexOf("MSIE") > 0){
        
        if(navigator.userAgent.indexOf("MSIE 6.0") > 0){
           
         window.opener = null;
         window.close();
        }else{
           
         window.open('', '_top');
         window.top.close();
        }
     }
     else if(navigator.userAgent.indexOf("Firefox") > 0){
         
        window.location.href = 'about:blank ';
     }else{
        window.opener = null;
        window.open('','_self','');
        window.close();
     }
}


//获取用户的头像
function getUserLogoUrl(id,img) {
	// 创建请求
	var req = new XMLHttpRequest();
	req.responseType = "blob";
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var res=req.response;
				img.src=window.URL.createObjectURL(res);
			}else if(req.status==404){
				img.src="/RealProject/image/unlogin.jpg";
			}
		}
	};
	// 连接服务器
	req.open("get","/RealProject/web/servlet/getuserlogobyid?id="+id);
	// 发送请求
	req.send(null);
}



