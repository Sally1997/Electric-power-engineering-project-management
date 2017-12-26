package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.PermissionService;
import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.PermissionServiceImpl;
import com.holyshit.service.impl.ProjectServiceImpl;

public class JudgeStageExist extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pno=request.getParameter("pno");
		Staff staff=(Staff) request.getSession().getAttribute("staff");
		if(pno==null||staff==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		//判断是否新建了阶段
		ProjectService ps=new ProjectServiceImpl();
		boolean res = ps.ifIsEmptyProject(pno);
		if(res){
			PermissionService permission=new PermissionServiceImpl();
			boolean enableNewStage = permission.enableNewStage(pno, staff.getStaffno());
			if(enableNewStage){
				request.setAttribute("pno", pno);
				request.getRequestDispatcher("/jsp/projectManage/PlanManagement_NewMilestone.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/jsp/projectManage/nothing.jsp").forward(request, response);
			}
		}else{
			response.sendRedirect("/RealProject/servlet/DTreeNodeServlet?pno="+pno);
		}
		
	}

}
