package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.AutoNumber;

/**
 * Servlet implementation class StageServlet
 */
public class StageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		/*
		PSPlan pro_stage = new PSPlan();
		TaskIndexs task_index = new TaskIndexs();
		
		try {
			System.out.println(pro_stage);
			System.out.println(task_index);
			
			//getParameterMap用不了
			pro_stage.setSname(request.getParameter("StageName"));
			//日期转换
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			pro_stage.setStime((Date) sdf.parse(request.getParameter("StartDate")));
			pro_stage.setEtime((Date) sdf.parse(request.getParameter("EndDate")));
			
			//pro_stage.setPublisherNo("201526010429");//测试用
			HttpSession session = request.getSession();//ss.getAttribute
			Staff staff = (Staff)session.getAttribute("staff");
			
			//最开始状态都是0
			pro_stage.setSstate("0");
			
			
			//预算
			String bg = request.getParameter("budget");
			pro_stage.setBudget(bg);
			
			//指标
			task_index.setIndexInfo(request.getParameter("IndexInfo"));
			
			//阶段编号（7），发布（12），负责人（12）null
			//指标编号（11），任务编号（10）null
			
			Project project = (Project) request.getAttribute("project");
			String pn1 = project.getPno();
			//暂时还未商榷项目编号的获取方式先用10001暂时代替使用
			String pn="10001";
			
			pro_stage.setPno(pn);
			AutoNumber an = new AutoNumber();
			String sn = an.PNtoSN(pn);
			pro_stage.setStageno(sn);
			
			//审批人
			String rcpn = request.getParameter("PersonInCharge");
			String cpn = "";
			for(int i=0;i<12;i++){
				cpn+=rcpn.charAt(rcpn.length()-13+i);
			}
			pro_stage.setCharpno(cpn);
			
			String tn = an.CreateNewTaskNo(sn);
			task_index.setTaskNo(tn);
			String in1 = an.TNtoIN(tn);
			task_index.setIndexNo(in1);
			task_index.setIndexState("0");
			
			//添加新阶段以及新的任务指标
			ProjectStageSercvice pss = new ProjectStageServiceImpl();
			pss.AddStageandTask(pro_stage, task_index);
			
			System.out.println(pro_stage);
			System.out.println(task_index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向新建成功！
		response.getWriter().print("<script></script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/jsp/projectManage/PlanManagement_NewMilestone.jsp");*/	
		
		//Project project = (Project) request.getParameter("project");
		String pn = "10001";
		
		PSPlan pro_stage = new PSPlan();
		TaskIndexs task_index = new TaskIndexs();
		
		List<PSPlan> plist = new ArrayList<PSPlan>();
		List<TaskIndexs> tlist = new ArrayList<TaskIndexs>();
		
		PrintWriter out = response.getWriter();
		Enumeration e = request.getParameterNames();
		
		//日期转换
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		int x7 = 7;
		String[] icArray = null;
		String[] anArray = null;
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value=request.getParameter(name);
		    if(name=="fozza_sn"){
		    	pro_stage.setSname(value);
		    }
		    if(name=="fozza_cp"){
		    	//审批人
				String rcpn = value;
				String cpn = "";
				for(int i=0;i<12;i++){
					cpn+=rcpn.charAt(rcpn.length()-13+i);
				}
				pro_stage.setCharpno(cpn);
		    }
		    if(name=="fozza_st"){
		    	try {
					pro_stage.setStime((Date) sdf.parse(value));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name=="fozza_et"){
		    	try {
					pro_stage.setEtime((Date) sdf.parse(value));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		    if(name=="fozza_bg"){
		    	pro_stage.setBudget(value);
		    }
		    if(name=="indexcontent"){
		    	icArray = value.split(",");
		    }
		    if(name=="attachmentneed"){
		    	anArray = value.split(",");
		    }
		    
		  //x自减为0时
		    x7--;
		    if(x7==0){
		    	//从表单里面获取到的阶段信息有阶段名称，审批人编号，开始结束日期，预算
		    	//获取到项目编号，状态置为0，生成阶段编号
		    	//获取到指标内容数组，是否需要上传文件数组
		    	pro_stage.setPno(pn);
		    	pro_stage.setSstate("0");
		    	//生成阶段编号
		    	AutoNumber an = new AutoNumber();
				try {
					String sn = an.PNtoSN(pn);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    }
		}
		
		
			
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
