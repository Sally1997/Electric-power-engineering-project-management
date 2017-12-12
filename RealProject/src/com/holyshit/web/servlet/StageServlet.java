package com.holyshit.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.PSPlan;
import com.holyshit.domain.Staff;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.service.ProjectStageSercvice;
import com.holyshit.service.impl.ProjectStageServiceImpl;
import com.holyshit.utils.AutoNumber;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet({ "/StageServlet", "web/servlet/stageServlet" })
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
