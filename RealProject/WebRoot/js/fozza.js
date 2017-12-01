window.onload = function(){
	var aja = XMLHttpRequest();
	aja.onreadystatechange = function(){
		if(aja.readyState==4)
			if(aja.status==200)
				alert("尼玛！");
	}
	
	//创建链接
	aja.open("get","${pageContext.request.contextPath }");
	//发送请求
	aja.send(null);
}