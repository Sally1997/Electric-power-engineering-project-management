<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>员工登陆</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/image/1.ico" type="image/x-icon" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath}/js/yqz.js"></script>
   <!--jsp-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" type="text/css">
   
    <meta charset=UTF-8>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
    <script type="text/javascript">
  			function sign_in_check(e){
   				return false;
  			}
  			 //更新验证码
  			function updateCode(){
  				var img=document.getElementById("img");
  				img.src="${pageContext.request.contextPath}/web/servlet/validatecode?"+new Date();
  			}
  			window.onload=function(){
  				if("${account.staffno}"!=""){
  					//获取用户头像
  					getUserLogo();
  				}
  			}	
    	</script>
  
	<style type="text/css">
		body{
			background-image: url(${pageContext.request.contextPath}/image/indexbk.jpg);
			font-family: "微软雅黑";
			
		}
		main{
			margin-top: 80px;
		}
		form{
			margin-top: 20px;
		}
		form small{
			font-weight: lighter;
		}
		.round-img{
			width:60px; 
			height:60px; 
			border-radius:50%;
			line-height:60px; 
			display:block; 
			color:#585858; 
		}
		.jumbotron h1{
			color: white;
			font-weight: lighter;
			letter-spacing: 5px;
		}
		.jumbotron p{
			color: white;
			font-weight: lighter;
		}
		#img {
        border-radius: 2px;
        cursor: pointer;
        position: absolute;
        z-index: 3;
        left: 0;
        top: 0;
        }

        #validateCode {
        padding-left: 110px;
        }

  </style>
  </head>

  <body>
  <section>
      <div class="container-fluid">
          <div class="row">
              <main>
              <div class="col-lg-8">
              	  <div class="jumbotron" style="background-color: transparent;text-align:right">
              	  	<h1>面向电力项目工程管理</h1>
              	  	<p>一个快捷，方便的项目管理网站，专门为电力工程设计</p>
              	  </div>
              </div>
              <div class="col-lg-3">
              	  <div class="panel panel-primary" style="margin-top: 10px;background-color: rgba(255,255,255,0.80);border-radius: 5%">
                      <div class="panel-body" style="margin-top: 20px;margin-bottom: 10px">
                      <div class="col-lg-12">
                      <span>
              	      <c:if test="${empty uri}">
 	  				  <form action="${pageContext.request.contextPath }/web/servlet/login" method="post">
 	  			      </c:if>
 	  			      <c:if test="${not empty uri }">
 	  				  <form action="${pageContext.request.contextPath }/web/servlet/login?uri=${uri}" method="post">
 	  			      </c:if>
              	          <div class="form-group">
                          <label for="account" id=ui_label>账号</label>
                         
                          
                          <c:if test="${empty staffno }">
                          	<input type="text" class="form-control" id="user-id" name="staffno" value="${account.staffno }"  onblur="getUserLogo();" placeholder="请输入账号">
                          </c:if>
                          <c:if test="${not empty staffno }">
                          	<input type="text" class="form-control" id="user-id" name="staffno" value="${staffno }"  onblur="getUserLogo();">
                          </c:if>
                          
                          </div>
                          <div class="form-group">
                          <label for="password">密码</label>
                          
                          <c:if test="${empty password }">
                          	<input type="password" class="form-control" id="passwd" name="password"  placeholder="请输入密码">
                          </c:if>
                          <c:if test="${not empty password }">
                          	<input type="password" class="form-control" id="passwd" name="password" value="${password }">
                          </c:if>
                          
                          </div>
                          <div class="form-group">
                          <label for="validate">验证码
                          <small>&nbsp;&nbsp;点击图片刷新验证码</small>
                          </label>
                         
						  <div class="input-group" >
							  <span class="input-group-addon" style="z-index: 3"><img alt="验证码" id="img" src="${pageContext.request.contextPath }/web/servlet/validatecode"  onclick="updateCode();"></span>
							  <input type="text" style="z-index: 0" class="form-control" id="validateCode" placeholder="四位字符验证码" name="validatecode">
                          </div>
                          </div>
                          <div class="checkbox">
                          <label>
                          	
                          	<c:if test="${empty staffno }">
                          		<input type="checkbox" name="remember" value="remember"> 记住密码
                          	</c:if>
                          	<c:if test="${not empty staffno }">
                          		<input type="checkbox" name="remember" value="remember" checked="checked"> 记住密码
                          	</c:if>
                          </label></span>
                          <!--显示错误信息-->
                          <div>
                          <p style="color:red"> ${error['username'] } ${error['validatecode'] }${locError } </p>
                          </div>
                          <div style="text-align: right;margin-top: 30px">
                          <a href="javascript:putAdmin()" rel="联系管理员" class="btn btn-link" data-toggle="modal" data-target="#forget">忘记密码？</a>
                          <button type="submit" class="btn btn-primary">登录</button>
                          </div>
              	      </form>
              	      </div>
              	      </div>
              	  </div>
              </div>
              </main>
          </div>
      </div>
  </section>
  <!--默认隐藏的内容-->
  <div class="modal fade bs-example-modal-sm" id="forget" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">联系管理员</h4>
      </div>
      <div class="modal-body">
          <dl>
		  <dt>电话</dt><dd class="detail_right">15823145263</dd>
		  <dt>邮箱</dt><dd class="detail_right">fuck@gmail.com</dd>
		  <dt>QQ</dt><dd class="detail_right">952412532</dd>
          </dl>
      </div>
    </div>
  </div>
  </div>
  </body>
  <script type="text/javascript">
    var username=document.getElementById("userid");
  	username.style.color="gray";
  	function updateCode(){
  		var img=document.getElementById("img");
  		img.src="${pageContext.request.contextPath }/web/servlet/validatecode?"+new Date();
  	}
  	function putAdmin(){
  		var ele=document.getElementById("admin_detail");
  		var ele_2=document.getElementById("find_passwd");
  		ele.style.display="block";
  		ele_2.style.display="none";
  	}
  </script>
</html>
