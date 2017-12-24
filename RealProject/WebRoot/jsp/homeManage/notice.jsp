<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
 
						<div id="responsible_per" class="block"><!--这里我就不给你把缩进改到后面了。。。太难改了。。。你反正晓得下面都是一块的-->
						<div id="first_left">
						<font>项目类型:</font>
						</div>
						<div id="first_right">
						<font>工程类</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >项目名称:</font>
						</div>
						<div id="first_right">
						<font >Test02</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >申请人:</font>
						</div>
						<div id="first_right">
						<font >XX</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >相关附件:</font>
						</div>
						<div id="first_right">
						<font >Test02</font>
						</div>
						<div class="clear"></div>
						</div>

						<div id="responsible_per" class="block">
						<div id="first_left">
						<font >备注:</font>
						</div>
						<div id="first_right">
						<font >项目已线下立项。</font>
						</div>
						</div>
                        
                        <div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;" data-toggle="modal" data-target="#handupAc">审核相关</button>
						<br/><br/>
						</div>

                </div><!-- 剩下的你依次对齐吧。。。 -->
                </div>
            </div> 
    		</div>






			<div class="col-lg-8 xumode">
   	        <div class="panel panel-primary">
    	        <div class="panel-heading">项目审批</div>
      	        <div class="panel-body">
                <div class="col-lg-12" >
						<!-- 同意 -->
					<form>
						<div id="responsible_per" class="block">
						<div>
						<div id="first_left">
						<input type="radio" name="是否同意" value="同意" checked >同意
						</div>
						<div id="first_right">
						<input type="radio" name="是否同意" value="不同意">不同意
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
						<input type="text" name="" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 是否继续 -->
						<div id="responsible_per" class="block">
						<div>
						<div id="first_left">
						<input type="radio" name="sex" value="male" checked>继续审批
						</div>
						<div id="first_right">
						<input type="radio" name="sex" value="female">结束审批
						</div>
						</div> 
						<div class="clear"></div>
						</div>

						<!-- 审批人 -->
						<div id="end_date" class="block">
						<div id="first_left">
						<font class="text">审批人:</font>
						</div>
						<div id="first_right">
						<input type="text" name="" size="40px;">
						</div>
						<div class="clear"></div>
						</div>

						<!-- 备注 -->
						<div id="budget" class="block">
						<div id="first_left">
						<font class="text">备注:</font>
						</div>
						<div id="first_right">
						<input type="text" name="" size="40px;">
						</div>
						</div>
						<div class="clear"></div>
						<div>
						<button type="button" class="btn btn-primary" style="float: right;">确定</button>
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
 <!--      默认隐藏的内容:审批意见-->
 <div class="modal fade" id="handupAc" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
 <div class="modal-dialog" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">审批意见</h4>
    </div>
    <div class="modal-body">
		  <table class="table table-striped table-condensed" style="font-size: 15px">
 		    <tr>
			    <th >审批人</th>
			    <th>审批意见</th>
			    <th>是否结束</th>
			    <th>是否同意</th>
			    <th>日期</th>
		    </tr>
		    <tr>
			    <td align="center">审批人a</td>
			    <td align="center">可行度较高</td>
			    <td align="center">否</td>
			    <td align="center">是</td>
			    <td align="center">A年B月C日</td>
			</tr>
		    <tr>
			    <td align="center">审批人b</td>
			    <td align="center">有较大风险</td>
			    <td align="center">否</td>
			    <td align="center">否</td>
			    <td align="center">A年B月D日</td>
			</tr>
		    <tr>
			    <td align="center">审批人c</td>
			    <td align="center">利润高</td>
			    <td align="center">否</td>
			    <td align="center">是</td>
			    <td align="center">A年B月E日</td>
			</tr>
		    <tr>
			    <td align="center">审批人d</td>
			    <td align="center">总体来说还是很有希望</td>
			    <td align="center">是</td>
			    <td align="center">是</td>
			    <td align="center">A年B月G日</td>
			</tr>
	        </table> 
    </div>
    <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
    </div>
	</div>
</div>
</div>
	
	 <footer class="copyright">
    <div class="container-fluid">
      	<p>©版权归谭莹小组所有</p>
   
	</div>
	</footer>
</body>
</html>