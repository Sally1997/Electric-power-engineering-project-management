package com.holyshit.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.holyshit.domain.ProjectStage;
import com.holyshit.domain.Staff;
import com.holyshit.domain.TaskIndexs;
import com.holyshit.utils.AutoNumber;

/**
 * Servlet implementation class StageServlet
 */
@WebServlet({ "/StageServlet", "/servlet/StageServlet" })
public class StageServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("text/html", "charset=UTF-8");
		
		ProjectStage pro_stage = new ProjectStage();
		TaskIndexs task_index = new TaskIndexs();
		
		try {
			/**
			 * 获取表单数据
			 */
			//getParameterMap用不了
			pro_stage.setStageName(request.getParameter("StageName"));
			//日期转换
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			pro_stage.setStartDate(sdf.parse(request.getParameter("StartDate")));
			pro_stage.setEndDate(sdf.parse(request.getParameter("EndDate")));
			
			//ss.getAttribute
			HttpSession session = request.getSession();
			Staff staff = (Staff)session.getAttribute("staff");
			//发布人是当前用户
			pro_stage.setPublisherNo(staff.getStaffno());
			
			//指标
			task_index.setIndexInfo(request.getParameter("IndexInfo"));
			
			//阶段编号（7），发布（12），负责人（12）null
			//指标编号（11），任务编号（10）null
			String pn="10001";
			AutoNumber an = new AutoNumber();
			pro_stage.setStageNo(an.PNtoSN(pn));
			
			System.out.println(pro_stage);
			System.out.println(task_index);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向新建成功！
//		response.getWriter().print("<script></script>");
//		response.setHeader("refresh", "0.5;url="+request.getContextPath()+"/PlanManagement_NewMilestone.jsp");
////	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
