package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.PermissionService;
import com.holyshit.service.impl.PermissionServiceImpl;

public class EnableChangeCharge extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Staff staff=(Staff) request.getSession().getAttribute("staff");
		PermissionService ps=new PermissionServiceImpl();
		boolean res = ps.enableChangeCharge(staff.getStaffno(), id);
		if(res){
			response.getWriter().write("ok");
			return;
		}else{
			response.getWriter().write("error");
		}
		
	}

}
