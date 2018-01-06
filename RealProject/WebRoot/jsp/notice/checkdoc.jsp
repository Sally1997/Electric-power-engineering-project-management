<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>${noticetitle }</title>
<%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[0].className="active nav-current";
		menus[0].role="presentation";	
	</script>
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
	
	
	<!--  主要内容-->
<section>
    <div class=container-fluid>
    	<div class="row">
    		<main class="col-lg-12 main-content">
    		
    		
    		
    		<div class="col-lg-8" style="float:none; margin: 20px auto">
   	        <div class="panel panel-primary" style="margin: 20px auto">
    	        <div class="panel-heading">项目相关</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
                 <!-- style="margin-top: 20px;margin-left: 5%" -->
 
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >文档标题:</font>
						</div>
						<div id="first_right">
						<font >${map.DTitle }</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >上传人:</font>
						</div>
						<div id="first_right">
						<font >${map.name }</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >相关附件:</font>
						</div>
						<div id="first_right">
						<font ><a href="${pageContext.request.contextPath }/web/servlet/downLoadMessage?dno=${map.dno }">${map.dtitle }.${map.ftype }</a></font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >文档大小:</font>
						</div>
						<div id="first_right">
						<font >${map.FSize }<font color="purple">&nbsp;bytes</font></font>
						</div>
						<div class="clear"></div>
						</div>
                        
                        <div id="responsible_per" class="block">
						<div id="first_left">
						<font >上传时间:</font>
						</div>
						<div id="first_right">
						<font >${map.UploadTime }</font>
						</div>
						<div class="clear"></div>
						</div>
						
                        <div id="responsible_per" class="block">
						<div id="first_left">
						<font >文档格式:</font>
						</div>
						<div id="first_right">
						<font >${map.ftype }</font>
						</div>
						<div class="clear"></div>
						</div>
						
						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >文档类型:</font>
						</div>
						<div id="first_right">
						<font >${map.dtype }</font>
						</div>
						<div class="clear"></div>
						</div>
                        
                        <div class="clear"></div>
						<div>
						<br/><br/>
						</div>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>
    		
    		<br>
    		<!-- 如果申请人id为当前用户编号，则不显示，不同则说明当前用户是审核人，其他人没有消息提醒 -->
    		<c:if test="${staff.staffno!=map.staffno}">
			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">文档审批</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
						<!-- 同意 -->
					<form>
						<div id="responsible_per" class="block">
						<div>
						<div id="first_left">
						<input type="radio" name="agree" checked="checked" value="agree">同意
						</div>
						<div id="first_right">
						<input type="radio" name="agree" value="disagree">不同意
						</div>
						</div> 
						<div class="clear"></div>
						</div>

						<!-- 审批意见 -->
						<div id="start_date" class="block">
						<div id="first_left">
						<font class="text">审批意见：</font>
						</div>
						<div id="first_right">
						<input type="text" name="auditinfo" size="40px;">
						</div>
						<div class="clear"></div>
						</div>
						
						<div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;" onclick="submitAudit()">确定</button>
						</div>
                    </form>
                </div>
                </div>
            </div> 
    		</div>
		</c:if>
		
    		</main>
	    </div>
	</div>
 </section>
		   
</div>
</div>
	<br><br><br>
	 <%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
function submitAudit(){
	alert("提交成功");
	var fm = document.forms[0];
	fm.action="${pageContext.request.contextPath }/web/servlet/docAuditServlet?dno=${map.dno }";
	fm.method="post";
	fm.submit();
}

</script>
</html>