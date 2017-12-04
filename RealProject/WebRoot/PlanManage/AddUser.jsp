<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/fozza.css" type="text/css">
<script type="text/javascript">
  		//如果下拉信息被点击
	function ifclick(div){
		var InputWord = document.getElementsByName("PersonInCharge")[0];
		InputWord.value = div.innerHTML;
		div.parentNode.style.display = "none";
	}
  	function change_1(ele){
  			ele.style.backgroundColor="#3388FF";
  		}
  		function change_2(ele){
  			ele.style.backgroundColor="";
  		}
	window.onload = function(){
	//输入文本框
	var InputWord = document.getElementsByName("PersonInCharge")[0];
	//获得下拉框
	var fozza_handsome = document.getElementById("fozza1");
	//
	var aja = new XMLHttpRequest();
	aja.onreadystatechange = function(){
			if(aja.readyState==4){
				if(aja.status==200){
					var str = aja.responseText;//得到服务器返回数据
					var ss = str.split(",");//分割得到的整串text
					var childDivs = "";
					for(var i=0;i<ss.length;i++){
						childDivs+="<div id='fozza2' onclick='ifclick(this)' onmouseover='change_1(this)' onmouseout='change_2(this)'>"+ss[i]+"</div>";
						//将每个元素放进div里面
					}
					fozza_handsome.innerHTML= childDivs;
				}		
			}
		}
	
	InputWord.onkeyup = function(){
		var msg = InputWord.value;
		var fozza_handsome = document.getElementById("fozza1");
		if(msg==""){
			fozza1.style.display = "none";
			fozza1.style.border = "1px";
		}
		else{
			fozza1.style.display = "block";
			fozza1.style.border = "1px solid grey";
		}
		//创建链接
		aja.open("get","${pageContext.request.contextPath }/servlet/ListNameNoServlet?msg="+msg);
		//发送请求
		aja.send(null);
	}
}
</script>
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>