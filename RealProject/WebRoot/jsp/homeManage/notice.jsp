<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>${noticetitle }</title>
<style type="text/css">
	.noticeTop{
		text-align: center;
		font-family: 微软雅黑;
		font-weight: 700;
		font-size: 18px;
	}
</style>
</head>
<body>
	<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
	
	<div style="width: 50%;position: relative;left: 25%;border: 1px #c3c3c3 solid;">
		<h1 class="noticeTop">${noticetitle }</h1>
		
		<span style="line-height:1.8em;padding-bottom:5px;width: 100%;padding-left: 60%">创建于: <fmt:formatDate value="${pubtime }" type="both"/> &nbsp;&nbsp; 来源:管理员</span>
		<hr>
		<div id="noticeContent" style="width: 100%;background-color: #FCFCFC;padding: 10px;">${noticecontent }</div>
	</div>
	
	 <%@include file="/footer.jsp" %>
</body>
</html>