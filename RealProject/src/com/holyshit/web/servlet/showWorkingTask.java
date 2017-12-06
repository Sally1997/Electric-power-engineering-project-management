package com.holyshit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.service.MoneyManageService;
import com.holyshit.service.impl.MoneyManageServiceImpl;

public class showWorkingTask extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Staff staff=(Staff) request.getSession().getAttribute("staff");
		String staffno=staff.getStaffno();
		
		MoneyManageService ms=new MoneyManageServiceImpl();
		String res = ms.findFeeAbledTask(staffno);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
