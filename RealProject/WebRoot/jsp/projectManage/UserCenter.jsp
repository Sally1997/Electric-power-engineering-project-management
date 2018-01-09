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
						<div class="hehe_right"><font color=red >${error1 }</font></div>
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
           				<div class="hehe_right"><font color=red >${error2 }</font></div>
           				<div class="clear"></div>
           				 <span style="cursor: pointer;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" >
            			   <button type="button" class="btn btn-primary" onclick = "showchoice();return false;" >添加新的资格证</button></span>
                			<span id = "showthechoice" style = "display:none;"><br/>
                				<select name="qua" length = "40">
                					<option value="教师资格证" >教师资格证</option>
									<option value="英语六级" >英语六级</option>
									<option value="建筑师二级" >建筑师二级</option>
								</select>
								<button type="submit" class="btn btn-primary" style="cursor: pointer;" onclick="addqua()">添加</button>
                			</span>
                			<script type="text/javascript">
                			function showchoice()
							{
  								if(document.getElementById('showthechoice').style.display == 'none')
  								{
   									document.getElementById('showthechoice').style.display = 'block';
  								}
  								else
  								{
    								document.getElementById('showthechoice').style.display = 'none';
  								}
}
							</script>
          				
          				</div>
						<div class="clear"></div>
						</div>
						
						
						
						<div id="budget" class="block">
						<div class="hehe_left">
						<font class="text">拥有的权限：</font>
						</div>
						<div class="hehe_right">
						<ul class="list-unstyled">
						<li>${defaultauth}</li>
						<c:forEach items="${aList}" var="a" >
							<li>${a.pername}</li>
						</c:forEach>
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
  		var p = document.getElementsByName("usercenter")[0];
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