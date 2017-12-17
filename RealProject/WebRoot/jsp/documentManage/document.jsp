<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>文档管理</title>
 <!--下拉菜单插件bootstrap-select-->
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/css/bootstrap-select.min.css"> 
  <!-- Latest compiled and minified JavaScript -->
  <script src="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
  <!-- (Optional) Latest compiled and minified JavaScript translation files -->
  <script src="${pageContext.request.contextPath }/bootstrap-select/bootstrap-select/js/i18n/defaults-*.js"></script>
  
    <!-- bootstrap-datetimepicker -->
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/moment.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/moment/min/locales.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/bootstrap/dist/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-datetimepicker/bootstrap/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-datetimepicker/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />
</head>
<body>
 <%@include file="/head.jsp" %>
	<script type="text/javascript">
		menus[2].className="active nav-current";
		menus[2].role="presentation";	
	</script>
<section>
       <div class="container-fluid">
       <div class="row">
           <div class="col-lg-9 col-sm-9 xumode">
           <form>
           <div class="container-fluid" id="search">
           <div class="row">
              <div class="col-lg-2 col-sm-2">
			  <div class="form-group">
				<select class="selectpicker" data-width="100%">
				  <option>工程类</option>
				  <option>设计类</option>
				</select>
			  </div>
			  </div> 
			  <div class='col-lg-3 col-lg-offset-4 col-sm-3 col-sm-offset-4'>
				<div class="form-group">
					<input type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker1'/>
				</div>
			  </div>
			  <div class='col-lg-3 col-sm-3'>
					<div class="form-group">
						<input type='text' class="form-control" placeholder="选择时间范围" id='datetimepicker2'/>
						</div>
			  </div>
              <div class="col-lg-12">
                   <div class="form-group">
                   <div class="input-group">
                       <input type="text" class="form-control" placeholder="请输入关键字">
                       <span class="input-group-btn">
                       <button class="btn btn-primary" type="button">搜索</button>
                       </span>
                       <span class="input-group-btn">
                       <button class="btn btn-default" type="button">上传文件</button>
                       </span>
                   </div>
                   </div>
              </div>
              <div class="col-lg-12" id="checkboxrow" style="margin-top:-2%">
                  <div class="checkbox">
                  <label class="checkbox-inline"><input type="checkbox">全部</label>
                  <label class="checkbox-inline"><input type="checkbox">DOC</label>
                  <label class="checkbox-inline"><input type="checkbox">PPT</label>
                  <label class="checkbox-inline"><input type="checkbox">PDF</label>
                  <label class="checkbox-inline"><input type="checkbox">XLS</label>
                  <label class="checkbox-inline"><input type="checkbox">视频（*.FLV，*.MP4）</label>
                  <label class="checkbox-inline"><input type="checkbox">其他</label>
                  </div>
              </div>
           </div>
           </div>
           </form>
                      <!--不是搜索栏的模块部分-->
           <div class="container-fluid">
           <div class="row">
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-list-alt docTypeIcon"></span>项目资料</h2>
                   <a class="noRight" href="documentPDoc.html"><h4>点击进入>></h4></a>
                   <p>这里放着的是项目资料，由项目管理页面上传</p>
                   </div>
               </div>
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-education docTypeIcon"></span>学习资料</h2>
                   <a class="noRight" href="studyDoc.html"><h4>点击进入>></h4></a>
                   <p>这里放着的是学习资料，由文档管理页面上传</p>
                   </div>
               </div>
               <div class="col-lg-4">
                   <div class="docType">
                   <h2><span class="glyphicon glyphicon-book docTypeIcon"></span>实用文档</h2>
                   <a class="noRight" href="praticalDoc.html"><h4>点击进入>></h4></a>
                   <p>这里放着的是实用文档，由文档管理页面上传</p>
                   </div>
               </div>
           </div>
           </div>
       </div>
       </div>
    </section>
    <script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY/MM/DD'
		});
        $('#datetimepicker2').datetimepicker({
            useCurrent: false,
			locale:'zh-cn',
			viewMode:'days',
			format:'YYYY/MM/DD'
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker2").on("dp.change", function (e) {
            $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
        });
    });
</script>
    <footer class="copyright">
    <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
	</div>
	</footer>
</body>
</html>
	