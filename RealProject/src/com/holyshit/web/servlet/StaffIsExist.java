package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class StaffIsExist extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String staffno=request.getParameter("staffno");
		if(staffno==null||staffno.equals("")){
			request.getRequestDispatcher("/jsp/error/error_500.jsp").forward(request, response);
			return;
		}
		
		//调用服务
		StaffService ss=new StaffServiceImpl();
		boolean res = ss.isExist(staffno);
		if(res){
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("error");
		}
	}

}
