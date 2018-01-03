package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.service.StaffService;
import com.holyshit.service.impl.StaffServiceImpl;

public class DeleteStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ids=request.getParameter("ids");
		String[] idArray = ids.split(":");
		
		StaffService ss=new StaffServiceImpl();
		boolean res = ss.deleteStaffInfo(idArray);
		if(res==true)
			response.getWriter().write("ok");
		else{
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("删除失败");
		}
	}

}
