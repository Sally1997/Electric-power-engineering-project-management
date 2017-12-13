package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.Staff;
import com.holyshit.domain.StageTask;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.StageTasksService;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.service.impl.StageTasksServiceImpl;
import com.holyshit.utils.AutoNumber;

public class TaskServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		
		String ptn = "100010";
		
		StageTask stage_task = new StageTask();
		TaskIndexs task_index = new TaskIndexs();
		
		PrintWriter out = response.getWriter();
		Enumeration e = request.getParameterNames();
		
		String pn = ptn.substring(0, 5);
    	stage_task.setPno(pn);//6
    	String sn = ptn.substring(0, 6);
    	stage_task.setStageno(sn);//7
		
		//日期转换
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		int x7 = 7;
		String[] icArray = null;
		String[] anArray = null;
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value=request.getParameter(name);
			out.write(name+"="+value);
		    if(name.equals("fozza_sn")){
		    	stage_task.setTaskname(value);//1
		    }
		    if(name.equals("fozza_cp")){
		    	//审批人
				String rcpn = value;
				String cpn = "";
				for(int i=0;i<12;i++){
					cpn+=rcpn.charAt(rcpn.length()-13+i);
				}
				stage_task.setCharpno(cpn);//2
		    }
		    if(name.equals("fozza_st")){
		    	try {
		    		java.util.Date d = sdf.parse(value);
		    		java.sql.Date date = new java.sql.Date(d.getTime());
		    		stage_task.setStime(date);//3
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name.equals("fozza_et")){
		    	try {
		    		java.util.Date d = sdf.parse(value);
		    		java.sql.Date date = new java.sql.Date(d.getTime());
		    		stage_task.setEtime(date);//4
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name.equals("fozza_bg")){
		    	stage_task.setBudget(value);//5
		    }
		    if(name.equals("indexcontent")){
		    	icArray = value.split(",");
		    }
		    if(name.equals("attachmentneed")){
		    	anArray = value.split(",");
		    }
		    
		  //x自减为0时
		    x7--;
		    if(x7==0){
		    	x7=7;
		    	//从表单里面获取到的阶段信息有阶段名称，审批人编号，开始结束日期，预算
		    	//获取到项目编号，状态置为0，生成阶段编号
		    	//获取到指标内容数组，是否需要上传文件数组
		    	
		    	stage_task.setTstate("0");//8
		    	
		    	//生成阶段编号
		    	AutoNumber an = new AutoNumber();
		    	String tn = "";
				try {
					tn = an.TrueNewTaskNo(ptn);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stage_task.setTaskno(tn);//9
				
				stage_task.setPtaskno(ptn);//10
				//11设置父节点类型
				if(ptn.length()==6){
					stage_task.setPtasktype("0");
				}
				else{
					stage_task.setPtasktype("1");
				}
				
		    	System.out.println(stage_task);
		    	StageTasksService sts = new StageTasksServiceImpl();
		    	sts.addTask(stage_task);
		    	
		    	//指标的新建
		    	int len = icArray.length;
		    	for(int i=0;i<len;i++){
		    		System.out.println(icArray[i]);
		    		task_index = new TaskIndexs();
		    		task_index.setTaskno(stage_task.getTaskno());
		    		task_index.setIndexinfo(icArray[i]);
		    		task_index.setAchreq(anArray[i]);
		    		task_index.setIndexstate("0");
		    		sts.addIndexInfo(task_index);
		    	}
		    	
		    	stage_task = new StageTask();
		    }
		}
		//分发转向
		response.setHeader("refresh", "0.5;url=/RealProject/servlet/DTreeNodeServlet?pno="+pn);	
		//response.sendRedirect("/RealProject/servlet/DTreeNodeServlet?pno="+pno);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
