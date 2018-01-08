package com.holyshit.web.servlet;
import com.holyshit.service.*;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.*;
import com.holyshit.service.impl.StaffServiceImpl;
@WebServlet("/web/servlet/delAllStaffsServlet")
public class DelAllStaffsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] staffnos = request.getParameterValues("ids");
		String pno=request.getParameter("pno");
		StaffService ss = new StaffServiceImpl();
		ss.delAllStaffs(staffnos,pno);
		request.setAttribute("pno", pno);
		request.getRequestDispatcher("/web/servlet/staffListServlet?pno="+pno).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
