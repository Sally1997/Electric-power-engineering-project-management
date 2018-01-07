<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
   <%@include file="/head.jsp" %>
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
</head>

<body style="min-height: 100%">
    <section style="min-height: 100%">
       <div class="container-fluid">
       <div class="row">
       <div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">个人中心</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
					<form method="post" name="usercenter">
					
						<div class="block">
						<div class="hehe_left">
						<font class="text">员工编号：</font>
						</div>
						<div class="hehe_right">
						<font class="text">${me.staffno }</font>
						</div>
						<div class="clear"></div>
						</div>

						
						<div  class="block">
						<div class="hehe_left">
						<font class="text">员工姓名：</font>
						</div>
						<div class="hehe_right">
						<font class="text">${me.name }</font>
						</div>
						<div class="clear"></div>
						</div>

					
						<div id="start_time" class="block">
						<div class="hehe_left">
						<font class="text">联系方式：</font>
						</div>
						<div class="hehe_right">
						<div class="dropdown"><span>${me.te }</span>
            					<span class="glyphicon glyphicon-pencil" style="cursor: pointer;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
              					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="min-width: 300px">
                					<li><div class="row">
										  <div class="col-lg-11 xumode">
											<div class="input-group">
											  <input type="tel" class="form-control" placeholder="修改联系方式" name="te">
											  <span class="input-group-btn">
												<button class="btn btn-default" type="submit" onclick="updatete()" >修改</button>
											  </span>
											</div>
										  </div>
										</div>
								    </li>
             					</ul>
          				</div>	
						</div>
						<div class="clear"></div>
						<div class="clear"></div>
						</div>


			
						<div id="end_time" class="block">
						<div class="hehe_left">
						<font class="text">邮箱：</font>
						</div>
						<div class="hehe_right">
						<div class="dropdown"><span>${me.email }</span>
            					<span class="glyphicon glyphicon-pencil" style="cursor: pointer;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
              					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="min-width: 400px">
                					<li><div class="row">
										  <div class="col-lg-11 xumode">
											<div class="input-group">
											  <input type="tel" class="form-control" placeholder="修改邮箱" name="email">
											  <span class="input-group-btn">
												<button class="btn btn-default" type="submit" onclick="updateemail()" >修改</button>
											  </span>
											</div>
										  </div>
										</div>
								    </li>
             					</ul>
								
          				</div>	
						</div>
						<div class="clear"></div>
						<div class="hehe_left"></div>
						<div class="hehe_right">${error1 }</div>
						<div class="clear"></div>
						</div>

				
						<div id="budget" class="block">
						<div class="hehe_left">
						<font class="text">职业资格：</font>
						</div>
						<div class="hehe_right">
						<ul class="list-unstyled">
						<c:forEach items="${qL}" var="Q" >
							<li>${Q.qualifdesc}</li>
							
						</c:forEach>	
           				</ul>
						<div class="dropup">
            					<span style="cursor: pointer;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            						<button type="button" class="btn btn-primary" >添加新的资格证</button>
            					</span>
              					<ul class="dropdown-menu"  style="min-width: 300px">
                					<li><div class="row">
										  <div class="col-lg-11 xumode">
											<div class="input-group">
											  <input type="tel" class="form-control" placeholder="填写资格证名称" name="qua">
											  <span class="input-group-btn">
												<button class="btn btn-default" type="submit" onclick="addqua()" >添加</button>
											  </span>
											</div>
										  </div>
										</div>
								    </li>
             					</ul>
          				</div>	
						</div>
						<div class="clear"></div>
						</div>
                       
                    </form>
                </div>
                </div>
            </div> 
    		</div>
       </div>
       </div>
    </section>
    <%@include file="/footer.jsp" %>
</body>
<script type="text/javascript">
  	function updatete(){
  		alert("ojbk");
  		var p = document.getElementsByName("usercenter")[0];
  		alert("ojbk2");
  		p.action="${pageContext.request.contextPath}/web/updateTeServlet";
  	}
  	function updateemail(){
  		var p = document.getElementsByName("usercenter")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/updateEmailServlet";
  		
  	}
  	function addqua(){
  		var p = document.getElementsByName("usercenter")[0];
  		p.action = "${pageContext.request.contextPath}/web/servlet/addQualificationServlet";
  		
  	}
  </script>
</html>