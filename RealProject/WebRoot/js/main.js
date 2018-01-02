//获取下一页
function getNextTaskPage(){
	if(task_cur==1){
		var page=document.getElementById("task_page");
		var node1=page.getElementsByTagName("a")[0];
		node1.className="";
	}
	task_cur++;
	
	//进行数据获取
	task_getTaskData();
	//数据刷新
	task_refreshData();
}


//获取下一页  项目
function getNextProjectPage(){
	if(project_cur==1){
		var page=document.getElementById("project_page");
		var node1=page.getElementsByTagName("a")[0];
		node1.className="";
	}
	project_cur++;
	
	//进行数据获取
	project_getProjectData();
	//数据刷新
	project_refreshData();
}