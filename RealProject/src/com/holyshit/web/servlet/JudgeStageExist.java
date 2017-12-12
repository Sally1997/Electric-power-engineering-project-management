package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.ProjectService;
import com.holyshit.service.impl.ProjectServiceImpl;

public class JudgeStageExist extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pno=request.getParameter("pno");
		if(pno==null){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		//判断是否新建了阶段
		ProjectService ps=new ProjectServiceImpl();
		boolean res = ps.ifIsEmptyProject(pno);
		if(res){
			System.out.println("新建阶段啦");
			request.setAttribute("pno", pno);
			request.getRequestDispatcher("/jsp/projectManage/PlanManagement_NewMilestone.jsp").forward(request, response);
		}else{
			System.out.println("跳转树状图啦");
			response.sendRedirect("/RealProject/servlet/DTreeNodeServlet?pno="+pno);
		}
		
	}

}
