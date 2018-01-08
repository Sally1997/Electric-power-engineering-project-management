package com.holyshit.web.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.holyshit.domain.Staff;
import com.holyshit.domain.StaffDuty;

public class HrMainJumpaddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pno = request.getParameter("pno");
		Staff staff = new Staff();
		String lastSearchStaffNo = "";
		String error = "";
		request.setAttribute("pno", pno);
		request.setAttribute("hrstaff", staff);
		request.setAttribute("lastSearchStaffNo", lastSearchStaffNo);
		request.setAttribute("error", error);
		
		request.getRequestDispatcher("/jsp/projectManage/hr_add.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
