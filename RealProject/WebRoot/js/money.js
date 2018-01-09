function updateAuditDialog(e){
	   			//设置审核id
	   			fauditno=auditData[e].fauditno;
	   			var submit_audit=document.getElementById("submit_audit");
	   			document.getElementById("audit_pname").innerHTML=auditData[e].pname;
	   			document.getElementById("audit_sname").innerHTML=auditData[e].sname;
	   			document.getElementById("audit_taskname").innerHTML=auditData[e].taskname;
	   			document.getElementById("audit_appname").innerHTML=auditData[e].appname;
	   			document.getElementById("audit_stime").innerHTML=auditData[e].stime;
	   			document.getElementById("audit_fee").innerHTML=auditData[e].fee;
	   			document.getElementById("audit_ofeereason").innerHTML=auditData[e].ofeereason;
	   			
	   			if(auditData[e].ofeereason=="")
	   				document.getElementById("overCause").style.display="none";
	   			else
	   				document.getElementById("overCause").style.display="block";
	   			var state=document.getElementById("audit_auditstate");
	   			var tmp=auditData[e].auditstate;
	   			if(tmp=="0"){
	   				state.className="text-danger";
	   				state.innerHTML="未审批";
	   				submit_audit.removeAttribute("disabled");
	   				document.getElementById("top_audit").style.display="block";
	   				document.getElementById("middle_audit").style.display="block";
	   			}else if(tmp="1"){
	   				state.className="text-danger";
	   				state.innerHTML="不通过";
	   				submit_audit.disabled="disabled";
	   				document.getElementById("top_audit").style.display="none";
	   				document.getElementById("middle_audit").style.display="none";
	   			}else{
	   				state.className="text-success";
	   				state.innerHTML="审批通过";
	   				submit_audit.disabled="disabled";
	   				document.getElementById("top_audit").style.display="none";
	   				document.getElementById("middle_audit").style.display="none";
	   			}
	   		}


//ajax
function submitFeeInfo(){
   			if(task_fee.value==""){
   				alert("金额不得为空");
   			}else if(task_feeaudit>task_budget && document.getElementById("fee_cause").value==""){
   				alert("超标原因不得为空");
   			}else{
   				//发送请求
   				var req=new XMLHttpRequest();
   				req.onreadystatechange=function(){
   					if(req.readyState==4){
   						if(req.status==200){
   							if(req.responseText=="ok"){
   								alert("报账成功");
   								location.reload(true);
   							}else{
   								alert("报账失败");
   							}
   						}
   						
   					}
   				};
   				req.open("post", "/RealProject/web/servlet/submitFee?taskno="+taskinfo[project_pos].stagelist[stage_pos].tasklist[task_pos].taskno+"&task_feeaudit="+task_feeaudit+"&fee_cause="+window.encodeURI(document.getElementById("fee_cause").value));
   				req.send(null);
   			}
   		}
		//ajax请求  审核
		function submitAuditInfo(){
			//处理
			var hehe=document.getElementById("audit_pass");
			var cause=document.getElementById("audit_cause").value;
			var audit_auditstate;
			if(hehe.checked){
				audit_auditstate="2";
			}else
				audit_auditstate="1";
			
			if(cause==""){
				
				return;
			}
			var req=new XMLHttpRequest();
			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						//接受信息
						var res=req.responseText;
						if(res=="ok"){
							alert("审核完成");
								location.reload(true);
						}else{
							alert("审核失败");
						}
					}
				}
				
			};
			req.open("get", "/RealProject/web/servlet/submitAudit?fauditno="+fauditno+"&state="+audit_auditstate+"&cause="+window.encodeURI(cause));
			req.send(null); 
		}
   		function showAuditData(){
   			var nodes=audittable.getElementsByTagName("tr");
			for(var i=0;i<auditData.length;i++){
				
				var tds=nodes[i+1].getElementsByTagName("td");
				var name1=auditData[i].pname;
				if(name1.length>5)
					name1=name1.substr(0,5)+"...";
				
				var name2=auditData[i].sname;
				
				if(name2.length>4)
					name2=name2.substr(0,4)+"...";
				
				
				tds[0].innerHTML=name1;
				tds[0].title=auditData[i].pname;
				
				tds[1].innerHTML=name2;
				tds[1].title=auditData[i].sname;
				
				var name3=auditData[i].stime;
				if(name3.length>6)
					name3=name3.substr(0,6)+"...";
				tds[2].innerHTML=name3;
				tds[2].title=auditData[i].stime;
				var state=auditData[i].auditstate;
				
				if(state=="0"){
					tds[3].innerHTML="未审批";
					tds[3].style.color="blue";
				}
				else if(state=="2"){
					tds[3].innerHTML="审批通过";
					tds[3].style.color="green";
				}else{
					tds[3].innerHTML="不通过";
					tds[3].style.color="red";
					
				}
				tds[4].innerHTML='<span class="glyphicon  glyphicon-check" data-toggle="modal"  data-target="#acInfoPass" title="详细" style="cursor: pointer" onclick="updateAuditDialog('+i+')"></span>';
			} 
			for(var i=auditData.length;i<4;i++){
				var tds=nodes[i+1].getElementsByTagName("td");
				tds[0].innerHTML="-";
				tds[1].innerHTML="-";
				tds[2].innerHTML="-";
				tds[3].innerHTML="-";
				tds[4].innerHTML="-";
			} 
		
   		}
   		function getAuditInfo(){
   			var req=new XMLHttpRequest();
   			req.onreadystatechange=function(){
				if(req.readyState==4){
					if(req.status==200){
						var res=req.responseText;
						var hehe=eval('('+res+')');
						auditData=hehe.audits;
						showAuditData();
					}
					
				}
			};
			req.open("get", "/RealProject/web/servlet/showAuditPage?currentPage=1&pageSize=4");
			req.send(null);
  		}
/**
   		
   		
   		/**
   		* ajax获取任务信息
   		*/
   		function getTaskInfo(staffno){
   			var req = new XMLHttpRequest();
   			req.onreadystatechange=function(){
   				if(req.readyState==4){
   					if(req.status==200){
   						var res=req.responseText;
   						//数据刷新
   						taskinfo=eval('('+res+')');
   						showProject();
   					}
   				}
   			};
   			
   			req.open("post", "/RealProject/web/servlet/showWorkingTask?staffno="+staffno);
   			req.send(null);
   			
   		}
   		
   		/**
   		* ajax递交报账申请
   		*/

   		//刷新数据
   		function refreshData(){
   			var chart1=document.getElementById("chart1");
   			var chart2=document.getElementById("chart2");
   			var chart3=document.getElementById("chart3");
   			if(projectNum>=1){
   				//显示输出
   				chart1.style.display="block";
   				chart2.style.display="none";
   				chart3.style.display="none";
   				var myChart1 = echarts.init(document.getElementById('chart1'));

				// 指定图表的配置项和数据

				var option1 = {
					textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[0].pname,
							backgroundColor:'#e8e8e8',
							link:'/RealProject/servlet/DTreeNodeServlet?pno='+dataJson[0].pno,
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15,
								align:'center'
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15],
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'10%',
						left:'2%',
						orient:'vertical',
						itemGap:15
					},


					grid: {
						left: '25%',
						right: '15%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[0].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[0].hasaudit,
							barMaxWidth:40,

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[0].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[0].over,
							

						}
						]
				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart1.setOption(option1);		
   			}
   			if(projectNum>=2){
   				chart2.style.display="block"
   				var myChart2 = echarts.init(document.getElementById('chart2'));

				// 指定图表的配置项和数据

				var option2 = {
						textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[1].pname,
							backgroundColor:'#e8e8e8',
							link:'/RealProject/servlet/DTreeNodeServlet?pno='+dataJson[0].pno,
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15,
								align:'center'
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15],
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'10%',
						left:'2%',
						orient:'vertical',
						itemGap:15
					},


					grid: {
						left: '25%',
						right: '15%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[1].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[1].hasaudit,
							barMaxWidth:40,

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[1].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[1].over,
							

						}
						]

				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart2.setOption(option2);
   			}
   			if(projectNum>=3){
   				chart3.style.display="block";
   				var myChart3 = echarts.init(document.getElementById('chart3'));

				// 指定图表的配置项和数据

				var option3 = {
						textStyle: {
						fontFamily:'微软雅黑',
						fontSize:15
					},
                    title: {text:dataJson[2].pname,
							backgroundColor:'#e8e8e8',
							link:'/RealProject/servlet/DTreeNodeServlet?pno='+dataJson[0].pno,
							textStyle:{
								fontWeight:'lighter',
								fontSize: 15,
								align:'center'
							},
							padding:[10,10,10,10],
							borderRadius:[15,15,15,15],
						   },
					tooltip : {
					},
					toolbox: {
						feature: {
							magicType: {
								type: ['stack', 'tiled']
							},
							dataView: {
								show:true,
								readOnly:true,
								buttonColor:'#52658f',
								backgroundColor:'#dddddd',
								textareaBorderColor:'#c8c8c8'
							}
						},
	                    top:'3%',
						right:'10%'
					},
					legend: {
						data:['已报账','剩余预算','超标金额'],
						top:'10%',
						left:'2%',
						orient:'vertical',
						itemGap:15
					},


					grid: {
						left: '25%',
						right: '15%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data : dataJson[2].stages
						}
					],
					yAxis : [
						{
							type : 'value'
						}
					],
					color:['#52658f','#c8c8c8','#e34953'],
					dataZoom:[
						{
							id:'dataZoomX',
							type:'slider',
							handleIcon: 'M10.7,11.9H9.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4h1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7v-1.2h6.6z M13.3,22H6.7v-1.2h6.6z M13.3,19.6H6.7v-1.2h6.6z', // jshint ignore:line
                            handleSize: 20,
							handleStyle: {
								shadowBlur: 6,
								shadowOffsetX: 1,
								shadowOffsetY: 2,
								shadowColor: '#aaa'
							},
							xAxisIndex:[0],
							filterMode:'filter',
							start:0,
							end:60
						}
					],

					series: [
						{
							name:'已报账',
							type:'bar',
							stack: '金额',
							data:dataJson[2].hasaudit,
							barMaxWidth:40,

						},
						{
							name:'剩余预算',
							type:'bar',
							stack: '金额',
							data:dataJson[2].surplus,
							itemStyle: {
								normal:'#e8e8e8',
								emphasis:'#a8a8a8'
							}
						},
						{
							name:'超标金额',
							type:'bar',
							stack: '金额',
							data:dataJson[2].over,
							

						}
						]
				};

				// 使用刚指定的配置项和数据显示图表。
				 myChart3.setOption(option3);
   			}		
   		}
   		
   		function updateFeeAuditDialog(index){
   			document.getElementById("fee_pname").innerHTML=feeData[index].pname;
   			document.getElementById("fee_sname").innerHTML=feeData[index].sname;
   			document.getElementById("fee_taskname").innerHTML=feeData[index].taskname;
   			document.getElementById("fee_appname").innerHTML=feeData[index].appname;
   			document.getElementById("fee_stime").innerHTML=feeData[index].stime;
   			document.getElementById("fee_fee").innerHTML="￥"+feeData[index].fee;
   			var code=feeData[index].auditstate;
   			if(code=="0"){
   				document.getElementById("fee_auditstate").innerHTML="未审核";
   				document.getElementById("fee_auditstate").className="text-danger";
   			}else if(code=="1"){
   				document.getElementById("fee_auditstate").innerHTML="未通过";
   				document.getElementById("fee_auditstate").className="text-danger";
   			}else{
   				document.getElementById("fee_auditstate").innerHTML="通过审核";
   				document.getElementById("fee_auditstate").className="text-success";
   			}
   		}
   		
   		function showProject(){
      		//关闭报账按钮
      		submit.disabled="disabled";

      		//删除以前的
      		project_select.innerHTML="<option>请选择</option>";
      		stage_select.innerHTML="<option>请选择</option>";
      		task_select.innerHTML="<option>请选择</option>";
      		task_fee.value="";
      		over_cause.value="";
      		warnning_div.style.display="none";
      		over_cause.style.display="none";
      		//禁用
      		stage_select.disabled="disabled";
      		task_select.disabled="disabled";
      		task_fee.disabled="disabled";
      		
      		for(var i=0;i<taskinfo.length;i++){
      			var node=document.createElement("option");
      			node.innerHTML=taskinfo[i].pname;
      			project_select.appendChild(node);
      		}	
      	}
      	function showStage(){
      		//删除以前的
      		stage_select.innerHTML="<option>请选择</option>";
      		for(var i=0;i<taskinfo[project_pos].stagelist.length;i++){
      			var node=document.createElement("option");
      			node.innerHTML=taskinfo[project_pos].stagelist[i].sname;
      			stage_select.appendChild(node);
      		}	
      		
      	}
      	function showTask(){
      		//删除以前的
      		task_select.innerHTML="<option>请选择</option>";
      	
      		for(var i=0;i<taskinfo[project_pos].stagelist[stage_pos].tasklist.length;i++){
      			
      			var node=document.createElement("option");
      			node.innerHTML=taskinfo[project_pos].stagelist[stage_pos].tasklist[i].taskname;
      			task_select.appendChild(node);
      		}	
      		
      	}