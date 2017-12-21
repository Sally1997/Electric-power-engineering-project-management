<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>文件预览</title>

<script type="text/javascript">
	var req=new XMLHttpRequest();
	req.onreadystatechange=function(){
		if(req.readyState==4){
			if(req.status==200){
				if(req.responseText=="ok"){
					var base="https://view.officeapps.live.com/op/view.aspx?src=";
		 			var src=encodeURIComponent("http://www.blackstar0412.cn/RealProject/tmp/${previewFile}");
					location.href=base+src;
				}
			}
		}
	};
	req.open("post","${pageContext.request.contextPath}/web/servlet/saveFile?dno=<%=request.getParameter("dno")%>");
	req.send(null);
</script>
</head>
<body>

</body>
</html>