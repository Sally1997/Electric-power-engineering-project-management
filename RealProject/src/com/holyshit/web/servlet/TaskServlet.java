package com.holyshit.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.PsPlan;
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
		
		StageTask stage_task = new StageTask();
		TaskIndexs task_index = new TaskIndexs();
		
		try {
			/**
			 * 获取表单数据
			 */
			//getParameterMap用不了
			stage_task.setTaskname(request.getParameter("TaskName"));
			
			//预算
			stage_task.setBudget(request.getParameter("budget"));
			//日期转换
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			stage_task.setStime(sdf.parse(request.getParameter("StartDate")));
			stage_task.setEtime(sdf.parse(request.getParameter("EndDate")));
			
			//pro_stage.setPublisherNo("201526010429");//测试用
			HttpSession session = request.getSession();//ss.getAttribute
			Staff staff = (Staff)session.getAttribute("staff");
			stage_task.setPubno(staff.getStaffno());
			
			String tno = "";
			//点击新建子任务，阶段任务的编号会setAttribute转发到NewTask.jsp页面
			//tno = (String) request.getAttribute("taskno");
			tno = "1000110001";//测试用
			
			//父节点
			stage_task.setPtaskno(tno);
			
			//生成新节点便号
			AutoNumber an = new AutoNumber();
			String ntn = an.TrueNewTaskNo(tno);
			stage_task.setTaskno(ntn);
			
			//审批人
			String rcpn = request.getParameter("PersonInCharge");
			String cpn = "";
			for(int i=0;i<12;i++){
				cpn+=rcpn.charAt(rcpn.length()-13+i);
			}
			stage_task.setCharpno(cpn);
			stage_task.setTstate(0);
			
			//任务指标表
			task_index.setTaskNo(ntn);
			task_index.setIndexNo(an.TNtoIN(ntn));
			
			//指标内容
			task_index.setIndexInfo(request.getParameter("IndexInfo"));
			System.out.println(task_index);
			
			//插入
			StageTasksService sts = new StageTasksServiceImpl();
			sts.AddTaskandIndex(stage_task, task_index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向新建成功！
		//response.getWriter().print("<script></script>");
		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/PlanManagement_NewTask.jsp");	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
